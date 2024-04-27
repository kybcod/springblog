package com.springblog.domain;

import lombok.Data;

import java.util.Date;

@Data
public class memberBean {
    private String id;
    private String password;
    private String passwordCheck;
    private String email;
    private Date birth;
    private Integer phone;
}
