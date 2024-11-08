package com.example.calendar.service;

import com.example.calendar.dto.ScheduleRequestDto;
import com.example.calendar.dto.ScheduleResponseDto;
import com.example.calendar.entity.Schedule;
import org.springframework.stereotype.Service;
import com.example.calendar.repository.ScheduleRepo;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class SServiceimplement implements ScheduleService {

    private final ScheduleRepo scheduleRepo;

    public SServiceimplement(ScheduleRepo scheduleRepo) {
        this.scheduleRepo = scheduleRepo;
    }

    @Override
    public ScheduleResponseDto create(ScheduleRequestDto requestDto) {
        Schedule savedSchedule = scheduleRepo.create(requestDto.getTitle(), requestDto.getContent(), requestDto.getTime());
        return new ScheduleResponseDto(savedSchedule);
    }

    @Override
    public List<ScheduleResponseDto> read() {

        List<ScheduleResponseDto> readSchedules = scheduleRepo.read();
        return readSchedules;
    }

    @Override
    public ScheduleResponseDto readOne(Long id) {
        Schedule readOneSchedule = scheduleRepo.readOne(id);
        return new ScheduleResponseDto(readOneSchedule);
    }

    @Override
    public ScheduleResponseDto updateTotal(Long id, ScheduleRequestDto requestDto) {
       Schedule updateSchedule = scheduleRepo.updateTotal(id, requestDto.getTitle(), requestDto.getContent(), requestDto.getEditTime());
        return new ScheduleResponseDto(updateSchedule);
    }

    @Override
    public ScheduleRequestDto update(Long id, ScheduleRequestDto requestDto) {

        if(requestDto.getTitle() != null) {

        }
//        scheduleRepo.update();
        return null;
    }

    @Override
    public void delete(Long id) {
        scheduleRepo.delete(id);
    }
}
