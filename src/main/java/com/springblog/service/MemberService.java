package com.springblog.service;

import com.springblog.domain.CustomerUser;
import com.springblog.domain.Member;
import com.springblog.mapper.BoardMapper;
import com.springblog.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class MemberService {
    private final MemberMapper mapper;
    private final BCryptPasswordEncoder encoder;
    private final BoardMapper boardMapper;

    public void join(Member member) {
        member.setPassword(encoder.encode(member.getPassword()));
        mapper.insert(member);
    }

    public List<Member> list() {
        return mapper.selectAll();
    }

    public Member get(Integer id) {
        return mapper.selectById(id);
    }

    public void update(Member member) {
        if (member.getPassword() != null && !member.getPassword().isEmpty()) {
            member.setPassword(encoder.encode(member.getPassword()));
        }else {
            Member old = mapper.selectById(member.getId());
            member.setPassword(old.getPassword());
        }
        mapper.update(member);
    }

    public void delete(Integer id) {
        boardMapper.deleteByMemberId(id);
        mapper.deleteById(id);
    }

    public boolean hasAccess(Integer id, Authentication authentication) {
        if (authentication == null) {
            return false;
        }

        Object principal = authentication.getPrincipal();
        if (principal instanceof CustomerUser user) {
            Member member = user.getMember();
            return member.getId().equals(id);
        }
        return false;
    }
}
