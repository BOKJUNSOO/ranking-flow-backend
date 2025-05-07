package com.example.demo.entity.key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

// 복합키는 어지간해서는 쓰지말자..
// 하지만 나는 공부용
@Getter
@Setter
@Embeddable // 엔티티의 내장 객체로 사용됨을 의미
public class classKey implements Serializable {
    @Column(name="date")
    private LocalDate date;

    @Column(name="class")
    private String className;

    public classKey() {}

    public classKey(LocalDate date, String className) {
        this.date = date;
        this.className = className;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if(!(o instanceof classKey)) return false;
        classKey key = (classKey) o;
        return Objects.equals(date, key.date) &&
                Objects.equals(className, key.className);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date,className);
    }
}
