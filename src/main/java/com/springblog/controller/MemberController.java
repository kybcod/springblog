package com.springblog.controller;

import com.springblog.domain.Member;
import com.springblog.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService service;

    @GetMapping("join")
    public void joinForm() {
    }

    @PostMapping("join")
    public String joinPost(Member member) {
        service.join(member);
        return "redirect:/member/list";
    }

    @GetMapping("list")
    public void list(Model model) {
        model.addAttribute("memberList", service.list());
    }

    @GetMapping("")
    public String view(Integer id, Model model) {
        model.addAttribute("member", service.get(id));
        return "member/info";
    }
}
