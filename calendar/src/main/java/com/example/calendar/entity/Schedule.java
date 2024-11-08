package com.example.calendar.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Schedule {

    @Setter
    private Long id;
    private String title;
    private String content;
    private String time;
    private String editTime;

    public Schedule(String t, String c) {
        this.title = t;
        this.content = c;
    }

    public Schedule(String t, String c, String time) {
        this.title = t;
        this.content = c;
        this.time = time;
    }

    public Schedule(String t, String c, String time, String e) {
        this.title = t;
        this.content = c;
        this.time = time;
        this.editTime = e;
    }

    public void update(String title, String content, String editTime){
        this.title = title;
        this.content = content;
        this.editTime = editTime;
    }
}
