package com.springblog.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private Integer id;
    private String email;
    private String password;
    private String passwordCheck;
    private String nickName;
    private LocalDateTime Inserted;
//    private List<String> authority;

}
