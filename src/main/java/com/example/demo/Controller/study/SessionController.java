package com.example.demo.Controller.study;

import com.example.demo.entity.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.Date;

@Controller
public class SessionController {
    private User user;
    private HttpSession session;

    @GetMapping("/login")
    public String login(HttpSession session) {
        return "login";
    }
    // 서버에서 생성되는 세션은 JS 에서 통제 불가능
    // HTTP Only
    @PostMapping("/login") // 별도의 user dto 를 사용
    public String loginPost(User user, HttpSession session) { // 일반적인 인자로 주어지는것 함수 내부에서 사용하겠다?!
        Date date = new Date(); // 코드 실행 시간 발행
        session.setAttribute("user",user);
        session.setAttribute("dates",date); // 마지막 접속 일시 저장
        return "redirect:/main";
    }
    @GetMapping("/main")
    public String main() {
        return "main";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        //세선 제거 코드
        session.invalidate(); // 메모리 관리상 깔끔한 방법
        // session.removeAttribute("user");// (서버 세션은 그대로 존재 하지만 로그아웃되는 효과)
        return "redirect:/login";
    }
}
