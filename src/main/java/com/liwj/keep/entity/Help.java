package com.liwj.keep.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Help implements Serializable {
    private Long id;
    private String title;
    private String content;

}
