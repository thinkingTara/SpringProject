package com.example.calendar.dto;

import com.example.calendar.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScheduleResponseDto {
    private Long id;
    private String title;
    private String content;
    private String time;
    private String editTime;

    public ScheduleResponseDto(Schedule s){
        this.id = s.getId();
        this.title = s.getTitle();
        this.content = s.getContent();
        this.time = s.getTime();
        this.editTime = s.getEditTime();
    }


}
