package com.springblog.domain;

import lombok.Getter;
import org.springframework.security.core.userdetails.User;

import java.util.List;

@Getter
public class CustomerUser extends User {
    private Member member;

    public CustomerUser(Member member) {
        super(member.getEmail(), member.getPassword(), List.of());
//        member.getPassword(), member.getAuthority().stream().map(SimpleGrantedAuthority::new).toList()
        this.member = member;
    }

}
