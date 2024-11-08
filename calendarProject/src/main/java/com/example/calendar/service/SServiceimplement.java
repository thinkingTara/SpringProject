package com.example.calendar.service;

import com.example.calendar.dto.ScheduleRequestDto;
import com.example.calendar.dto.ScheduleResponseDto;
import com.example.calendar.entity.Schedule;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.example.calendar.repository.ScheduleRepo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SServiceimplement implements ScheduleService {

    private final ScheduleRepo scheduleRepo;

    public SServiceimplement(ScheduleRepo scheduleRepo) {
        this.scheduleRepo = scheduleRepo;
    }


    @Override
    public ScheduleResponseDto create(ScheduleRequestDto requestDto) {
        return scheduleRepo.create(requestDto.getName(), requestDto.getContent());
    }


    @Override
    public List<ScheduleResponseDto> read() {
        List<ScheduleResponseDto> readSchedules = scheduleRepo.read();
        return readSchedules;
    }

    @Override
    public ScheduleResponseDto readOne(Long id) {
        ScheduleResponseDto readOneSchedule = scheduleRepo.readOne(id);
        return readOneSchedule;
    }

    @Override
    public ScheduleResponseDto updateTotal(Long id, ScheduleRequestDto requestDto) {
       int updatedInt= scheduleRepo.updateTotal(id, requestDto.getName(), requestDto.getContent());
       if(updatedInt == 0) {
           throw new ResponseStatusException(HttpStatus.NO_CONTENT);
       }
        return scheduleRepo.readOne(id);
    }

    @Override
    public ScheduleResponseDto updateContent(Long id, ScheduleRequestDto requestDto) {

        int updateContentInt = scheduleRepo.updateContent(id, requestDto.getContent());
        if(updateContentInt == 0) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        return readOne(id);
    }

    @Override
    public void delete(Long id) {
        scheduleRepo.delete(id);
    }
}
