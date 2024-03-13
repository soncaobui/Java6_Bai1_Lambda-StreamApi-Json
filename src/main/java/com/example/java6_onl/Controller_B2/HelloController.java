package com.example.java6_onl.Controller_B2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class HelloController {
    @GetMapping("hi")
    private String index(Model model){
        model.addAttribute("lst","FPT <b> ok </b>");
        return "hello";
    }
}
