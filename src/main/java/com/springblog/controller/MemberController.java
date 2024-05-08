package com.springblog.controller;

import com.springblog.domain.Member;
import com.springblog.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    // member/list?page=3
//    @PreAuthorize("hasAnyAuthority('admin')")
    @GetMapping("list")
    public void list(@RequestParam(defaultValue = "1", value = "page") Integer page, Model model) {
        model.addAllAttributes(service.list(page));
    }

    @GetMapping("")
    public String view(@RequestParam(value = "id") Integer id, Model model) {
        model.addAttribute("member", service.get(id));
        return "member/info";
    }

    @GetMapping("modify")
    public String updateForm(@RequestParam(value = "id") Integer id, Model model) {
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
    public String delete(@RequestParam(value = "id") Integer id, Authentication authentication) {
        service.delete(id);
        return "redirect:/logout";
    }

    @GetMapping("login")
    public String login() {
        return "member/login";
    }
}
