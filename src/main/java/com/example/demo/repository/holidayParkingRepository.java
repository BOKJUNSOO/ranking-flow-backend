package com.example.demo.repository;

import com.example.demo.entity.study.HolidayParking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface holidayParkingRepository extends JpaRepository<HolidayParking, Integer> {
    Page<HolidayParking> findByInstitutionContainingOrSidoContainingOrGuContaining(
            String ins,String sido, String gu, Pageable pageable);
}
