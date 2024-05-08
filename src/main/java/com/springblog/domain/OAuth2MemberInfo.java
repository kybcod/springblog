package com.springblog.domain;

// OAuth2 제공업체로부터 받은 사용자 정보
public interface OAuth2MemberInfo {
    String getEmail();

    String getProvider();

    String getProviderId();

    String getNickName();

}
