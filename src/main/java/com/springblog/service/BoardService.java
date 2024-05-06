package com.springblog.service;

import com.springblog.domain.Board;
import com.springblog.domain.Member;
import com.springblog.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper mapper;

    public void insert(Board board) {
        mapper.insert(board);
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
}
