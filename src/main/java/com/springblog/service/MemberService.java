package com.springblog.service;

import com.springblog.domain.Member;
import com.springblog.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class MemberService {
    private final MemberMapper mapper;

    public void join(Member member) {
        mapper.insert(member);
    }

    public List<Member> list() {
        return mapper.selectAll();
    }
}
