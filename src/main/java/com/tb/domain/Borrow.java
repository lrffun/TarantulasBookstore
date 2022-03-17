package com.tb.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class Borrow implements Serializable {
    private String stu_id;
    private String book_id;
    private Date borrow_date;
    private Date Sreturn_date;

}

