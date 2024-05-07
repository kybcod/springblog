package com.springblog.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Member {
    private Integer id;
    private String email;
    private String password;
    private String passwordCheck;
    private String nickName;
    private LocalDateTime Inserted;
//    private List<String> authority;

}
