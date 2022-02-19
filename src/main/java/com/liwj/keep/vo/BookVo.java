package com.liwj.keep.vo;

import com.liwj.keep.entity.Book;
import lombok.Data;

/**
 * @author peifengli
 */
@Data
public class BookVo extends Book {
    private Double money;
    private String consumptionTime;
    private Long classId;
}
