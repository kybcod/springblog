package com.springblog.spring;

import lombok.Data;

@Data
public class memberBean {
    private String member_id;
    private String password;
    private String passwordCheck;
    private String email1;
    private String email2;
    private String birth;
    private Integer phone;
}
