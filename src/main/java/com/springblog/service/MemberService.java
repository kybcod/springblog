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

import java.util.Map;

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

    public Map<String, Object> list(Integer page) {
        int offset = (page - 1) * 10;
        int totalMember = mapper.countAll();
        int lastPage = (totalMember - 1) / 10 + 1;
        int endPage = ((page - 1) / 10 + 1) * 10;
        int beginPage = endPage - 9;
        endPage = Math.min(endPage, lastPage);
        int currentPage = page;
        int prevPage = beginPage - 10;
        int nextPage = beginPage + 10;


        return Map.of("memberList", mapper.selectAllByPage(offset),
                "memberInfo", Map.of("totalMember", totalMember,
                        "lastPage", lastPage,
                        "endPage", endPage,
                        "beginPage", beginPage,
                        "currentPage", currentPage,
                        "prevPage", prevPage,
                        "nextPage", nextPage));
    }

    public Member get(Integer id) {
        return mapper.selectById(id);
    }

    public void update(Member member) {
        if (member.getPassword() != null && !member.getPassword().isEmpty()) {
            member.setPassword(encoder.encode(member.getPassword()));
        } else {
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
