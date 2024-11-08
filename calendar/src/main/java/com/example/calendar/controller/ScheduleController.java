package com.example.calendar.controller;


import com.example.calendar.dto.ScheduleRequestDto;
import com.example.calendar.dto.ScheduleResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.calendar.service.ScheduleService;

import java.util.List;

@RestController
@RequestMapping("/calendar/schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto requestDto){
        ScheduleResponseDto scheduleResponseDto = scheduleService.create(requestDto);
        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> readSchedule(){
        List<ScheduleResponseDto> readList = scheduleService.read();

        return new ResponseEntity<>(readList,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> readOneSchedule(@PathVariable Long id){
        ScheduleResponseDto scheduleResponseDto = scheduleService.readOne(id);

        return new ResponseEntity<>(scheduleResponseDto,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> updateTotalSchedule(
            @PathVariable Long id,
            @RequestBody ScheduleRequestDto requestDto) {

        ScheduleResponseDto scheduleResponseDto = scheduleService.updateTotal(id, requestDto);
        return new ResponseEntity<>(scheduleResponseDto,HttpStatus.OK);
    }

//    @PatchMapping("/{id}")
//    public ResponseEntity<ScheduleResponseDto> updateSchedule(
//            @PathVariable Long id,
//            @RequestBody ScheduleRequestDto requestDto){
//
//        scheduleService.update(id, requestDto);
//
//        return new ResponseEntity<>(scheduleResponseDto,HttpStatus.OK);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id) {
        scheduleService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
