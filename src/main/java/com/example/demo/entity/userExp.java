package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@Table(name="user_exp_agg_df")
public class userExp {
    @Id
    @Column(name = "character_name")
    private String character_name;

    @Column(name ="date")
    private String date;

    @Column(name ="class")
    private String className;

    @Column(name ="character_level")
    private int character_level;

    @Column(name ="status")
    private String status;

    @Column(name="exp_gained_today")
    private Long exp_gained_today;

    @Column(name="exp_remained_for_up")
    private Long exp_remained_for_up;

    @Column(name = "level_up_days_remaining", columnDefinition = "LONGTEXT") // 오타 덕분에 엔티티에 컬럼만 추가됨을 확인!
    private String level_up_days_remaining; // 어지간해서는 타입 맞춰주자

    @Column(name="my_rank")
    private int my_rank;
}
