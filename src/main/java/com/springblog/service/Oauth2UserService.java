package com.springblog.service;

import com.springblog.config.CustomOauth2UserDetails;
import com.springblog.config.NaverMemberInfo;
import com.springblog.domain.Member;
import com.springblog.domain.OAuth2UserInfo;
import com.springblog.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class Oauth2UserService extends DefaultOAuth2UserService {

    private final MemberMapper mapper;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        System.out.println("userRequest.getAccessToken().getTokenValue() = " + userRequest.getAccessToken().getTokenValue());
        System.out.println("userRequest.getClientRegistration() = " + userRequest.getClientRegistration());
        System.out.println("userRequest.getClientRegistration().getRegistrationId() = " + userRequest.getClientRegistration().getRegistrationId());

        OAuth2User oAuth2User = super.loadUser(userRequest); //네이버 사용자 정보 로드
        System.out.println("oAuth2User = " + oAuth2User.getAttributes());

        String platfrom = userRequest.getClientRegistration().getRegistrationId(); //로그인한 클라이언트의 등록 ID

        OAuth2UserInfo response = null;
        if (platfrom.equals("naver")) {
            System.out.println("네이버 로그인 요청");
            response = new NaverMemberInfo((Map) oAuth2User.getAttributes().get("response")); //네이버에 있는 사용자 정보 추출
            System.out.println(response);
        }

        // DB에 저장
        Member member = mapper.selectByEmail(response.getEmail());
        Member userInfoDto;
        if (member == null) {
            userInfoDto = Member
                    .builder()
                    .email(response.getEmail())
                    .nickName(response.getNickName())
                    .password(userRequest.getAccessToken().getTokenValue())
                    .build();

            // 네이버에서 받은 이메일 조회 후 해당 이메일이 없는 경우 insert
            System.out.println("최초");
            mapper.insert(userInfoDto);
        } else {
            userInfoDto = member;
        }

        return new CustomOauth2UserDetails(userInfoDto, oAuth2User.getAttributes());
    }


}
