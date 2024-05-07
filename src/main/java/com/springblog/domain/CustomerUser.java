package com.springblog.domain;

import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

@Getter
public class CustomerUser extends User {
    private Member member;

    public CustomerUser(Member member) {
        super(member.getEmail(), member.getPassword(), member.getAuthority().stream().map(SimpleGrantedAuthority::new).toList());
        this.member = member;
    }

}
