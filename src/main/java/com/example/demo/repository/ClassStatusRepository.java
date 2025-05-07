package com.example.demo.repository;

import com.example.demo.entity.classStatus;
import com.example.demo.entity.key.classKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassStatusRepository extends JpaRepository<classStatus, classKey> {
}
