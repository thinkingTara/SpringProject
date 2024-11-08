package com.example.calendar.repository;

import com.example.calendar.dto.ScheduleResponseDto;
import com.example.calendar.entity.Schedule;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class SRepositoryImplement implements ScheduleRepo {

    private final Map <Long,Schedule> scheduleMap = new HashMap<>();

    @Override
    public Schedule create(String title, String content, String time) {

        Schedule schedule = new Schedule(title, content, time);
        Long id = scheduleMap.isEmpty() ? 1 : Collections.max(scheduleMap.keySet()) +1;
        schedule.setId(id);
        scheduleMap.put(id, schedule);

        return schedule;
    }

    @Override
    public List<ScheduleResponseDto> read() {
        List<ScheduleResponseDto> scheduleList = new ArrayList<>();

        for(Schedule s : scheduleMap.values()){
            ScheduleResponseDto oneSchedule = new ScheduleResponseDto(s);
            scheduleList.add(oneSchedule);
        }
        return scheduleList;
    }

    @Override
    public Schedule readOne(Long id) {
        Schedule schedule = scheduleMap.get(id);
        return schedule;
    }

    @Override
    public Schedule updateTotal(Long id, String title, String content, String editTime) {
        Schedule schedule = scheduleMap.get(id);
        schedule.update(title, content, editTime);

        return schedule;
    }

    @Override
    public void delete(Long id) {
        scheduleMap.remove(id);
    }
}
