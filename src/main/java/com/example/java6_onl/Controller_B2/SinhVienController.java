package com.example.java6_onl.Controller_B2;

import com.example.java6_onl.bean.SinhVien2;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.asm.TypeReference;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Indexed;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class SinhVienController {
    @GetMapping("sv")
    private String index(Model model , @RequestParam("index")Optional<Integer> index) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String,SinhVien2>> list = objectMapper.readValue(new File("C:\\Users\\PC\\IdeaProjects\\Java6_Onl\\src\\main\\resources\\data2.json"),List.class);

        int i = index.orElse(0);
        model.addAttribute("n",i);
        model.addAttribute("sv",list.get(i));
        return "scope/sv";
    }
}
