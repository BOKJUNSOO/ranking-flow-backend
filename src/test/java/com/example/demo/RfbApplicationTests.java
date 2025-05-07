package com.example.demo;

import com.example.demo.entity.userExp;
import com.example.demo.repository.UserExpRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;
import java.util.Optional;

// JUnit - test !
// 컨트롤러 service 등 내에 작성된 내용을 그냥 작성하면됨!
// 며칠뒤에 써도 작동되어야 한다. -> 의존성 추가에서 문제가 생긴것을 확인!
// 콘솔창에 출력은 안되지만 실행여부만 중요!
// 리턴값이 없음 항상 void!
// 레포에 작성된 "쿼리" 테스트용
// 테스트를 모두 같은 곳에 넣지 말자
@SpringBootTest
class RfbApplicationTests {
	
	@Autowired JdbcTemplate jdbcTemplate;
	private String getValidDate() {
		LocalDate today = LocalDate.now();
		LocalDate yesterday = today.minusDays(1);
		String todayStr = today.toString();
		String checkSql = "SELECT COUNT(*) FROM user_exp_agg_df WHERE date = ?";
		Integer count = jdbcTemplate.queryForObject(checkSql, new Object[]{todayStr}, Integer.class);
		return (count != null && count > 0) ? todayStr : yesterday.toString();
	}

	@Autowired UserExpRepository userExpRepository;
	@Test // main 메서드가 아닌 test 어노테이션을 사용한다.
	void contextLoads() {
		Optional<userExp> opt = userExpRepository.findById("dd"); // test 에도 레포지토리 사용!
		userExp character = null;
		if (opt.isPresent()){
			character = opt.get();
			System.out.println("존재");
		} else {
			character = new userExp();
			System.out.println("없음");
		}
		System.out.println(character);
	}

	@Test void contextLoads2() {
		String targetDate = getValidDate();
        String sql = "WITH today AS (\n" +
                "  SELECT * FROM user_exp_agg_df\n" +
                "  WHERE date = ?\n" +
                ")\n" +
                "SELECT * FROM today\n" +
                "WHERE my_rank BETWEEN 1 AND 5";

        jdbcTemplate.queryForList(sql, targetDate);
	}

	@Test
	void idis() {
		Optional<userExp> opt = userExpRepository.findById("상적분");
		userExp ue = opt.orElse(new userExp());
		String className = ue.getClassName();
		int myRank = ue.getMy_rank();

		System.out.println("닉네임:" + className + "등수 :"+myRank);

	}

}
