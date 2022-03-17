package com.tb.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class Student implements Serializable {
    private String id;
    private String password;
    private String name;
    private String sex;
    private int age;
    private String college;
    private String sclass;
    private Integer blackList;
}
