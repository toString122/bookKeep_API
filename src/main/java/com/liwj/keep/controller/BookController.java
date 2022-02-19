package com.liwj.keep.controller;


import com.liwj.keep.entity.*;
import com.liwj.keep.service.BookClassService;
import com.liwj.keep.service.BookService;
import com.liwj.keep.service.UserInfoService;
import com.liwj.keep.vo.BookVo;
import com.liwj.keep.vo.SearchDateVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private BookClassService bookClassService;
    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/deleteBook")
    public RetMessage deleteBook(@RequestBody BookVo bookVo) {
        bookService.removeById(bookVo.getId());
        return RetMessage.ok();
    }

    @PostMapping("/save")
    public RetMessage save(@RequestBody BookVo bookVo, HttpServletRequest request) {
        UserInfo userInfoSession = userInfoService.getUserInfoByRequest(request);
        BookClass bookClass = bookClassService.getById(bookVo.getClassId());
        Book book = new Book();
        book.setClassName(bookClass.getName());
        book.setRemark(bookVo.getRemark());
        book.setClassIcon(bookClass.getIconName());
        book.setClassBg(bookClass.getBgColor());
        book.setAmountOfMoney(bookVo.getMoney());
        book.setBillType(bookVo.getBillType());
        book.setCreateDate(new Date());
        book.setUserId(userInfoSession.getId());
        bookService.save(book);
        return RetMessage.ok();
    }

    @PostMapping("/getBookList")
    public RetMessage getBookList(@RequestBody SearchDateVo searchDateVo, HttpServletRequest request) throws ParseException {
        UserInfo userInfoSession = userInfoService.getUserInfoByRequest(request);
        RetMessage retMessage = new RetMessage();
        String yearMonth = searchDateVo.getYearMonth();
        if (StringUtils.isBlank(yearMonth)) {
            Date now = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(now);
            yearMonth = calendar.get(Calendar.YEAR) + "年" + (calendar.get(Calendar.MONTH) + 1) + "月";
        }
        List<Book> bookListAll = getBookListStatic(yearMonth,userInfoSession.getId());
        BookInfoTotal bookInfoTotal = new BookInfoTotal();

        //根据日期聚合查询
        List<DayBookInfo> dayBookInfos = new ArrayList<>();
        //遍历当前月份的每一天
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月");
        Date dateStart = simpleDateFormat.parse(yearMonth);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateStart);
        int startMonth = calendar.get(Calendar.MONTH);
        while (true) {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            Date currentDate = calendar.getTime();
            DayBookInfo dayBookInfo = getBookListDay(bookListAll, currentDate);
            if (null != dayBookInfo) {
                dayBookInfos.add(dayBookInfo);
            }
            if (calendar.get(Calendar.MONTH) != startMonth) {
                break;
            }
        }
        bookInfoTotal.setDayBookList(dayBookInfos);
        Double totalExpend = getTotalExpend(dayBookInfos);
        Double totalIncome = getTotalIncome(dayBookInfos);
        bookInfoTotal.setBalance(totalIncome - totalExpend);
        bookInfoTotal.setTotalExpend(totalExpend);
        bookInfoTotal.setTotalIncome(totalIncome);
        retMessage.setData(bookInfoTotal);
        retMessage.setResult(true);
        return retMessage;
    }

    private Double getTotalExpend(List<DayBookInfo> dayBookInfos) {
        Double balance = 0.00D;
        for (DayBookInfo dayBookInfo : dayBookInfos) {
            balance += dayBookInfo.getExpend();
        }
        return balance;
    }

    private Double getTotalIncome(List<DayBookInfo> dayBookInfos) {
        Double balance = 0.00D;
        for (DayBookInfo dayBookInfo : dayBookInfos) {
            balance += dayBookInfo.getIncome();
        }
        return balance;
    }

    private DayBookInfo getBookListDay(List<Book> bookListAll, Date currentDate) {
        SimpleDateFormat simpleDateFormatDay = new SimpleDateFormat("yyyy-MM-dd");
        DayBookInfo dayBookInfo = new DayBookInfo();
        dayBookInfo.setDay(simpleDateFormatDay.format(currentDate));
        double Expend = 0.00;
        double Income = 0.00;
        List<Book> bookListAdd = new ArrayList<>();
        for (Book book : bookListAll) {
            if (book.getCreateDate().getTime() >= currentDate.getTime() && book.getCreateDate().getTime() < currentDate.getTime() + 24 * 60 * 60 * 1000) {
                bookListAdd.add(book);
                if (book.getBillType().intValue() == 1) {
                    Expend += book.getAmountOfMoney();
                } else {
                    Income += book.getAmountOfMoney();
                }
            }
        }
        dayBookInfo.setBookList(bookListAdd);
        dayBookInfo.setExpend(Expend);
        dayBookInfo.setIncome(Income);
        return bookListAdd.size() == 0 ? null : dayBookInfo;
    }

    private List<Book> getBookListStatic(String yearAndMonth,Long userId) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月");
        Date dateStart = simpleDateFormat.parse(yearAndMonth);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateStart);
        calendar.add(Calendar.MONTH, 1);
        Date endTime = calendar.getTime();
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("create_date", dateStart);
        queryWrapper.lt("create_date", endTime);
        queryWrapper.eq("user_id",userId);
        List<Book> list1 = bookService.list(queryWrapper);
        return list1;
    }
}
