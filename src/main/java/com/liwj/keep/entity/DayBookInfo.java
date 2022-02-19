package com.liwj.keep.entity;

import lombok.Data;

import java.util.List;

@Data
public class DayBookInfo {
    private String day;
    private Double income;
    private Double expend;
    private List<Book> bookList;
}
