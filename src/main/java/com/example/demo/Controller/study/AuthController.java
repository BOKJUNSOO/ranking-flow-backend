package com.example.demo.Controller.study;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/auth")
public class AuthController {

    // 로그인 메인 화면
    @GetMapping("/main")
    public String main() {
        return "/auth/main";
    }

    // 1) 기본 HTML form 로그인 화면
    @GetMapping("/html/login")
    public String htmlLogin() {
        return "/auth/html-login";
    }

    // 1) 기본 form 로그인 POST
    @PostMapping("/html/login")
    public String htmlLoginPost(
            @RequestParam String username,
            @RequestParam String password,
            HttpSession session) { // 같은 포트는 쿠키를 공유한다?
        // 로그인 성공 가정
        return "redirect:/auth/main";
    }

    // 2) fetch 로그인 화면
    @GetMapping("/fetch/login")
    public String fetchLogin() {
        return "/auth/fetch-login";
    }

    // 2) fetch 로그인 POST
    @PostMapping("/fetch/login")
    @ResponseBody
    public String fetchLoginPost(@RequestParam String username, @RequestParam String password) {
        // 로그인 성공 가정
        // fetch post 요청 확인 가능
        return "success";
    }

    // 3) 크로스 오리진 + form 로그인 POST
    @PostMapping("/cors/html/login")
    public String corsHtmlLoginPost(@RequestParam String username, @RequestParam String password) {
        return "redirect:/auth/main";
    }

    // 4) 크로스 오리진 + fetch 로그인 POST
    @CrossOrigin
    @PostMapping("/cors/fetch/login")
    @ResponseBody
    public String corsFetchLoginPost(
            @RequestParam String username, 
            @RequestParam String password,
            HttpSession session) { // 세션을 건드린다
        return "success";
    }

}
