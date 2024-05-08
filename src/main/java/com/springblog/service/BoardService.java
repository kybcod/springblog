package com.springblog.service;

import com.springblog.domain.Board;
import com.springblog.domain.CustomerUser;
import com.springblog.domain.Member;
import com.springblog.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.access.WebInvocationPrivilegeEvaluator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper mapper;
    private final WebInvocationPrivilegeEvaluator privilegeEvaluator;

    public void insert(Board board) {
        mapper.insert(board);

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

    public Board get(Integer id) {
        return mapper.selectById(id);
    }

    public List<Board> getByTitle(String title) {
        return mapper.selectByTitle(title);
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
        if (principal instanceof CustomerUser user) {
            Member member = user.getMember();
            return board.getMemberId().equals(member.getId());
        }
        return false;
    }

}
