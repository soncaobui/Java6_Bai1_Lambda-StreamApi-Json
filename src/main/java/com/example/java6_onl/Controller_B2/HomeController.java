package com.example.java6_onl.Controller_B2;

import com.example.java6_onl.bean.SinhVien;
import com.example.java6_onl.bean.SinhVien2;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.io.IOException;

@Controller
public class HomeController {
    @GetMapping("home/index")
    private String index(Model model) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        SinhVien2 sinhVien = objectMapper.readValue(new File("C:\\Users\\PC\\IdeaProjects\\Java6_Onl\\src\\main\\resources\\data.json"),SinhVien2.class);

        model.addAttribute("mess","Welcome to Thymeleaf");
        model.addAttribute("sv",sinhVien);
        return "home/index";
    }
}
