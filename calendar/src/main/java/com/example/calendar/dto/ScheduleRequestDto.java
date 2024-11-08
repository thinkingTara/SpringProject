package com.example.calendar.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScheduleRequestDto {
    private String title;
    private String content;
    private String time;
    private String editTime;
}
