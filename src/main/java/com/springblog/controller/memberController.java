package com.springblog.controller;

import com.springblog.domain.memberBean;
import com.springblog.mapper.mapper01;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("main01")
@RequiredArgsConstructor
public class memberController {

    private final mapper01 mapper;

    @GetMapping("sub1")
    public void method1(Model model){
        List<memberBean> memberList = mapper.select();
        model.addAttribute("member", memberList);
    }

    @PostMapping("sub1")
    public String method2(memberBean bean, RedirectAttributes rttr){
        int rowCount = mapper.insert(bean);
        if(rowCount > 0){
            rttr.addFlashAttribute("message", "추가");
        }
        else{
            rttr.addFlashAttribute("message","추가 안됨");
        }
        return "redirect:/main01/sub1";
    }
}
