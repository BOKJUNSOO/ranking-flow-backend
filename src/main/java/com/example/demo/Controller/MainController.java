package com.example.demo.Controller;

import com.example.demo.entity.userExp;
import com.example.demo.repository.UserExpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;
import java.time.LocalDate;

// 컨트롤러 기준은 --> gnb + lnb 패키지로 만들어서 쓸 수도 있다
@RestController
public class MainController {

    @Autowired JdbcTemplate jdbcTemplate;
    @Autowired UserExpRepository userExpRepository;
    
    // 옛날방식
//    private final UserExpRepository userExpRepository;
//
//    public MainController(UserExpRepository userExpRepository) {
//        this.userExpRepository = userExpRepository;
//    }

    // 오늘 날짜가 테이블에 존재하는지 확인하고 없으면 어제 날짜로
    private String getValidDate() {
        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);
        String todayStr = today.toString();
        String checkSql = "SELECT COUNT(*) FROM user_exp_agg_df WHERE date = ?";
        Integer count = jdbcTemplate.queryForObject(checkSql, new Object[]{todayStr}, Integer.class);
        return (count != null && count > 0) ? todayStr : yesterday.toString();
    }

    @CrossOrigin()
    @GetMapping(value = "/datetopten", produces = "application/json; charset=UTF-8")
    // 직접 엔티티를 멤버변수로 갖는 방식 -> 순환참조의 위험성 -> DTO 사용의 필수!!
    public List<userExp> home() {
        String targetDate = getValidDate();
        // test junit 기록 (1)
        return userExpRepository.findTop10ByDate(targetDate);
    }

    @CrossOrigin()
    @GetMapping(value = "/legend", produces = "application/json; charset=UTF-8")
    public List<userExp> legend() {
        return userExpRepository.findLegend();
    }

    @CrossOrigin()
    @GetMapping(value = "/result/{keyword}", produces = "application/json; charset=UTF-8")
    public List<Map<String, Object>> searchUser(@PathVariable("keyword") String keyword) {
        String targetDate = getValidDate();

        String sql = "SELECT * FROM user_exp_agg_df WHERE character_name = ? AND date = ?";
        return jdbcTemplate.queryForList(sql, keyword, targetDate);
    }
}
