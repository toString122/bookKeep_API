package com.liwj.keep.controller;

import com.liwj.keep.entity.BookClass;
import com.liwj.keep.entity.RetMessage;
import com.liwj.keep.service.BookClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bookClass")
public class BookClassController {

    @Autowired
    private BookClassService bookClassService;

    @PostMapping("/getBookClassList")
    public RetMessage getBookList() {
        RetMessage retMessage = new RetMessage();
        retMessage.setData(getList());
        retMessage.setResult(true);
        return retMessage;
    }

    private List<BookClass> getList() {
        List<BookClass> list = bookClassService.list();
        return list;
    }
}
