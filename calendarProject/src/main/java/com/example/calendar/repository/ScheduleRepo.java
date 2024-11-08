package com.example.calendar.repository;

import com.example.calendar.dto.ScheduleResponseDto;
import com.example.calendar.entity.Schedule;

import java.util.List;

public interface ScheduleRepo {
    ScheduleResponseDto create(String name, String content);

    List<ScheduleResponseDto> read();

    ScheduleResponseDto readOne(Long id);

    int updateTotal(Long id, String name, String content);

    int updateContent(Long id, String content);

    void delete(Long id);
}
