package com.liwj.keep.service.impl;

import com.liwj.keep.dao.BookClassMapper;
import com.liwj.keep.entity.BookClass;
import com.liwj.keep.service.BookClassService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class BookClassServiceImpl extends ServiceImpl<BookClassMapper, BookClass> implements BookClassService {
}
