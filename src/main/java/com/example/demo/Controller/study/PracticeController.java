package com.example.demo.Controller.study;

import com.example.demo.entity.study.HolidayParking;
import com.example.demo.repository.holidayParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class PracticeController {
    @Autowired holidayParkingRepository holidayParkingRepository;

    @GetMapping("/holiday_parking")
    public String holidayParking(
            @RequestParam(defaultValue = "1") int page,
            Model model
    ) {
        Pageable pageable = PageRequest.of(page-1, 10);
        Page<HolidayParking> p =
                holidayParkingRepository.findAll(pageable);

        model.addAttribute("hp", p.getContent());

        return "holiday_parking";
    }
}