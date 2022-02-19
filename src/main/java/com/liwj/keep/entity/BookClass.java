package com.liwj.keep.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("book_class_t")
public class BookClass {
    @TableId
    private Long id;
    private String iconName;
    private String bgColor;
    private String name;
    private Integer billType;


}
