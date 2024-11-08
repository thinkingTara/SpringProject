package com.example.calendar.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Schedule {

    private Long id;
    private String name;
    private String content;
    private String time;
    private String editTime;

    public Schedule(String n, String c) {
        this.name = n;
        this.content = c;
    }

//    public Schedule(String n, String c, String time) {
//        this.name = n;
//        this.content = c;
//        this.time = time;
//    }
//
//    public Schedule(String n, String c, String time, String e) {
//        this.name = t;
//        this.content = c;
//        this.time = time;
//        this.editTime = e;
//    }
//
//    public void update(String name, String content, String editTime){
//        this.name = name;
//        this.content = content;
//        this.editTime = editTime;
//    }
}
