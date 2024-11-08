package com.example.calendar.dto;

import com.example.calendar.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScheduleResponseDto {
    private Long id;
    private String name;
    private String content;
    private String time;
    private String editTime;

    public ScheduleResponseDto(Schedule s){
        this.id = s.getId();
        this.name = s.getName();
        this.content = s.getContent();
        this.time = s.getTime();
        this.editTime = s.getEditTime();
    }

    public ScheduleResponseDto(Long id, String name, String content){
        this.id = id;
        this.name= name;
        this.content = content;
    }


}
