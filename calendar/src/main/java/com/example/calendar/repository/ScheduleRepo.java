package com.example.calendar.repository;

import com.example.calendar.dto.ScheduleResponseDto;
import com.example.calendar.entity.Schedule;

import java.util.List;

public interface ScheduleRepo {
    Schedule create(String title, String content, String time);

    List<ScheduleResponseDto> read();

    Schedule readOne(Long id);

    Schedule updateTotal(Long id, String title, String content, String editTime);

    void delete(Long id);
}
