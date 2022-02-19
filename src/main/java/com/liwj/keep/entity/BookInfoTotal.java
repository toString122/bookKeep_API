package com.liwj.keep.entity;

import lombok.Data;

import java.util.List;

/**
 * @author peifengli
 */
@Data
public class BookInfoTotal {
    private Double Balance;
    private Double TotalIncome;
    private Double TotalExpend;
    private List<DayBookInfo> DayBookList;
}
