package com.example.demo.repository;

import com.example.demo.entity.userExp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
// 하나의 JPA 에 여러 테이블 ?? --> no! 하나의 테이블에 하나의 repository
// 하나의 JPA 에 여러 컨트롤러! --> yes!
@Repository
public interface UserExpRepository 
        extends JpaRepository<userExp, String> { // 어떤 테이블,  PK 타입
    @Query(value = """
    SELECT * FROM user_exp_agg_df
    WHERE date = :targetDay AND my_rank BETWEEN 1 AND 10
    """, nativeQuery = true)
    List<userExp> findTop10ByDate(@Param("targetDay") String targetDay);
    // 해당 메서드의 리턴타입은 상관없다?! -> 직렬화 가능한 것만 + 커스텀
    // 가능은하지만 타입 안정성이 떨어지고 for each로 꺼내는 과정이 필요!
    // 보통의 리턴값은 엔티티 클래스를 따라감
    
    // 검색결과를 보여주는 컨트롤러에서 characterName 을 포함하는 모든 값을 리턴
    // List<userExp> findBycharacterNameContaining(String charcterName);
}
