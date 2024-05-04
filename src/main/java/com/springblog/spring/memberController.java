package com.springblog.spring;

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
    public void method1(Model model) {
        List<memberBean> memberList = mapper.select();
        model.addAttribute("member", memberList);
    }

    @PostMapping("sub1")
    public String join(memberBean bean, RedirectAttributes rttr, String btnPwd) {
        if (bean.getPassword().equals(bean.getPasswordCheck())) {
            rttr.addFlashAttribute("message1", "확인");
        } else {
            rttr.addFlashAttribute("message1", "비밀번호가 옳지않습니다.");
        }

        int rowCount = mapper.insert(bean);
        if (rowCount > 0) {
            rttr.addFlashAttribute("message2", "추가");
        } else {
            rttr.addFlashAttribute("message2", "추가 안됨");
        }
        return "redirect:/main01/sub1";
    }


}