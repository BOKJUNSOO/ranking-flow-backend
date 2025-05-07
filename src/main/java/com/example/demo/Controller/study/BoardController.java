package com.example.demo.Controller.study;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
    @GetMapping("/escape")
    public String escape (Model model) {
        String data = "<div><h1>제목</h1><h3>내용</h3></div>";
        model.addAttribute("data",data);
        return "escape";
    }

    @GetMapping("/unescape")
    public String unescape(Model model) {
        String data = "<div><h1>제목</h1><h3>내용</h3></div>";
        model.addAttribute("data", data);
        return "unescape";
    }
}
