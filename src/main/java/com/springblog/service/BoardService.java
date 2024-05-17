package com.springblog.service;

import com.springblog.config.CustomOauth2MemberDetails;
import com.springblog.domain.Board;
import com.springblog.domain.Member;
import com.springblog.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper mapper;

    public void insert(Board board, Authentication authentication) {
        Object principal = authentication.getPrincipal();
        if (principal instanceof CustomOauth2MemberDetails user) {
            board.setMemberId(user.getMember().getId());
            mapper.insert(board);
        }

    }

    public Map<String, Object> list(Integer page) {
        int offset = (page - 1) * 10;
        int totalBoard = mapper.countAll(); // 전체 게시물
        int lastPage = (totalBoard - 1) / 10 + 1;

        int endPage = ((page - 1) / 10 + 1) * 10;
        int beginPage = endPage - 9;
        endPage = Math.min(endPage, lastPage);

        int prevPage = beginPage - 10;
        int nextPage = beginPage + 10;

        int currentPage = page;

        return Map.of("boardList", mapper.selectAllByPage(offset),
                "pageInfo", Map.of("lastPage", lastPage,
                        "endPage", endPage,
                        "beginPage", beginPage,
                        "prevPage", prevPage,
                        "nextPage", nextPage,
                        "currentPage", currentPage,
                        "totalBoard", totalBoard)
        );
    }


    public Map<String, Object> titleList(String title, Integer page) {
        title = (title == null) ? "" : title;
        int offset = (page - 1) * 10;
        int totalTitleBoard = mapper.countTitleAll(); // 전체 게시물
        int lastPage = (totalTitleBoard - 1) / 10 + 1;

        int endPage = ((page - 1) / 10 + 1) * 10;
        int beginPage = endPage - 9;
        endPage = Math.min(endPage, lastPage);

        int prevPage = beginPage - 10;
        int nextPage = beginPage + 10;

        int currentPage = page;

        return Map.of("searchTitle", mapper.selectByTitle(title, offset),
                "titlePageInfo", Map.of("lastPage", lastPage,
                        "endPage", endPage,
                        "beginPage", beginPage,
                        "prevPage", prevPage,
                        "nextPage", nextPage,
                        "currentPage", currentPage,
                        "totalBoard", totalTitleBoard)
        );
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
        if (authentication == null) {
            return false;
        }
        Board board = mapper.selectById(id);
        Object principal = authentication.getPrincipal();
        if (principal instanceof CustomOauth2MemberDetails user) {
            Member member = user.getMember();
            return board.getMemberId().equals(member.getId());
        }
        return false;
    }


}
