package com.springblog.domain;

import lombok.Data;

import java.util.Date;

@Data
public class memberBean {
    private String member_id;
    private String password;
    private String passwordCheck;
    private String btnPwd;
    private String email1;
    private String email2;
    private String birth;
    private Integer phone;
}
