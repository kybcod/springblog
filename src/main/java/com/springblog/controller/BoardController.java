package com.springblog.controller;

import com.springblog.domain.Board;
import com.springblog.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService service;


    // 게시글 추가
    @GetMapping("/insert")
    public String insertForm() {
        return "board/insert";
    }

    @PostMapping("/insert")
    public String insertPost(Board board) {
        service.insert(board);
        return "redirect:/";
    }

    // 게시글 조회
    @GetMapping("/")
    public String view(@RequestParam(defaultValue = "1", value = "page") Integer page, Model model) {
        model.addAllAttributes(service.list(page));
        return "board/home";
    }

    // 해당 아이디 게시글 조회
    @GetMapping("/board/view")
    public String viewId(@RequestParam(value = "id") Integer id, Model model) {
        model.addAttribute("board", service.get(id));
        return "board/view";
    }

    // 게시글 수정
    // 게시글 수정 처음 클릭시 update 페이지로 이동
    @GetMapping("/update")
    public String updateForm(@RequestParam(value = "id") Integer id, Model model) {
        model.addAttribute("board", service.get(id));
        return "board/update";
    }

    // 게시글 수정 후 수정된 내용 저장
    @PostMapping("/update")
    public String updatePost(RedirectAttributes rttr, Board board, Authentication authentication) {
        service.update(board);
        rttr.addAttribute("id", board.getId());
        return "redirect:/board/view";
    }

    // 게시글 삭제
    @PostMapping("/delete")
    public String delete(@RequestParam(value = "id") Integer id, Authentication authentication) {
        service.delete(id);
        return "redirect:/";
    }


}
