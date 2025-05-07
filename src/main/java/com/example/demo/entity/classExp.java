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
@Getter
@Setter
@Entity
@Table(name = "class_exp_df")
public class classExp {
    @EmbeddedId
    private classKey classkey;

    @Column(name="status")
    private String status;

    @Column(name="exp_gained_max")
    private Long exp_gained_max;

    @Column(name="exp_gained_sum")
    private Long exp_gained_sum;

    @Column(name="exp_gained_mean")
    private Long exp_gained_mean;

    @Column(name="hunting_rank")
    private int hunting_rank;

}
