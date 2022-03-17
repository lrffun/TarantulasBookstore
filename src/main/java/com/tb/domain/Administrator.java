package com.tb.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class Administrator implements Serializable {
    private String id;
    private String name;
    private String password;
    private String permissions;
}
