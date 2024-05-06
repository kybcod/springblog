package com.springblog.controller;

import com.springblog.domain.Member;
import com.springblog.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("modify")
    public String updateForm(Integer id, Model model) {
        model.addAttribute("member", service.get(id));
        return "member/modify";
    }

    @PostMapping("modify")
    public String updatePost(Member member, RedirectAttributes rttr) {
        service.update(member);
        rttr.addAttribute("id", member.getId());
        return "redirect:/member";
    }

    @PostMapping("delete")
    public String delete(Integer id, Authentication authentication) {
        if (service.hasAccess(id, authentication)) {
            service.delete(id);
        }
        return "redirect:/logout";
    }

    @GetMapping("login")
    public String login(){
        return "member/login";
    }
}
