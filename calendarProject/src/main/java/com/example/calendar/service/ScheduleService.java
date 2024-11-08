package com.example.calendar.service;

import com.example.calendar.dto.ScheduleRequestDto;
import com.example.calendar.dto.ScheduleResponseDto;

import java.util.List;

public interface ScheduleService {
    ScheduleResponseDto create(ScheduleRequestDto requestDto);

    List<ScheduleResponseDto> read();

    ScheduleResponseDto readOne(Long id);

    ScheduleResponseDto updateTotal(Long id, ScheduleRequestDto requestDto);

    ScheduleResponseDto updateContent(Long id, ScheduleRequestDto requestDto);

    void delete(Long id);
}
