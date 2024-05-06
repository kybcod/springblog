package com.springblog.service;

import com.springblog.domain.Board;
import com.springblog.domain.CustomerUser;
import com.springblog.domain.Member;
import com.springblog.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper mapper;

    public void insert(Board board, Authentication authentication) {
        Object principal = authentication.getPrincipal();
        if(principal instanceof CustomerUser user){
            Member member = user.getMember();
            board.setMemberId(member.getId());
            mapper.insert(board);
        }
    }

    public List<Board> list() {
        return mapper.selectAll();
    }

    public Board get(Integer id) {
        return mapper.selectById(id);
    }

    public void update(Board board) {
        mapper.update(board);
    }

    public void delete(Integer id) {
        mapper.delete(id);
    }

    public boolean hasAccess(Integer id, Authentication authentication) {
        if (authentication == null){
            return false;
        }
        Board board = mapper.selectById(id);
        Object principal = authentication.getPrincipal();
        if (principal instanceof CustomerUser user){
            Member member = user.getMember();
            return board.getMemberId().equals(member.getId());
        }
        return false;
    }

}
