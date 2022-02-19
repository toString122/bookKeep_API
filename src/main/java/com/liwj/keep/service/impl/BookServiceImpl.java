package com.liwj.keep.service.impl;

import com.liwj.keep.dao.BookMapper;
import com.liwj.keep.entity.Book;
import com.liwj.keep.service.BookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {
}
