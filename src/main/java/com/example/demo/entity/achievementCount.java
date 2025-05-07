package com.example.demo.entity;

import com.example.demo.entity.key.classKey;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name="achievement_summary_df")
@Getter
@Setter
public class achievementCount {
    @EmbeddedId
    private classKey class_key;

    @Column(name="status_change")
    private String status_change;

    @Column(name="count")
    private int count; // null 값이 아니라면 참조자료형을 쓰지 않아도 되긴 하다!
}
