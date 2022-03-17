package com.tb.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor     //全参构造器
@NoArgsConstructor      //无参构造器
@Data                   //GetSet方法
@ToString               //toString方法
public class Book implements Serializable {
    private String id;
    private String name;
    private String tag;
    private String img;
    private String author;
    private String press;
    private String date;
    private double price;
    private String Introduction;
    private int num;
    private String place;
}
