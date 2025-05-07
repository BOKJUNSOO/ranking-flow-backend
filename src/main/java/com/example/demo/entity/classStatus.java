package com.example.demo.entity;

import com.example.demo.entity.key.classKey;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

// 직업 통계 엔터티
// 복합키는 클래스를 하나 더 정의한다!
@Entity
@Data
@Getter
@Setter
@Table(name="class_status_df")
public class classStatus {
    @EmbeddedId
    private classKey key;

    @Column(name="Arteria")
    private String Arteria;

    @Column(name="Carcion")
    private String Carcion;

    @Column(name="Dowonkyung")
    private String Dowonkyung;

    @Column(name="Odium")
    private String Odium;

    @Column(name="Tallahart")
    private String Tallahart;
}
