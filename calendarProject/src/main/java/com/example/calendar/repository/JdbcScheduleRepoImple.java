package com.example.calendar.repository;

import com.example.calendar.dto.ScheduleResponseDto;
import com.example.calendar.entity.Schedule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class JdbcScheduleRepoImple implements ScheduleRepo{

    private final JdbcTemplate jdbcTemplate;

    public JdbcScheduleRepoImple(DataSource dataSource) {
        this.jdbcTemplate =new JdbcTemplate(dataSource);
    }


    @Override
    public ScheduleResponseDto create(String name, String content) {

        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("calendar").usingGeneratedKeyColumns("id");

        Map<String, Object> parameter = new HashMap<>();
        parameter.put("name", name);
        parameter.put("content", content);

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameter));
        return new ScheduleResponseDto(key.longValue(), (String) parameter.get("name"), (String) parameter.get("content"));

    }

    @Override
    public List<ScheduleResponseDto> read() {
        List<ScheduleResponseDto> query = jdbcTemplate.query("select * from calendar", scheduleMapper());
        return query;
    }

    @Override
    public ScheduleResponseDto readOne(Long id) {
        List<ScheduleResponseDto> query = jdbcTemplate.query("select * from calendar where id = ?", scheduleMapper(), id);
        ScheduleResponseDto responseDto = query.get(0);
        return responseDto;
    }

    @Override
    public int updateTotal(Long id, String name, String content) {

        int updatedInt = jdbcTemplate.update("update calendar set name = ?, content = ? where id = ?", name, content, id);

        return updatedInt;
    }

    @Override
    public int updateContent(Long id, String content) {
        int updateContentInt = jdbcTemplate.update("update calendar set content = ? where id =? ", content, id);
        return updateContentInt;
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("delete from calendar where id =? ", id);

    }


    private RowMapper<ScheduleResponseDto> scheduleMapper(){

        return new RowMapper<ScheduleResponseDto>() {
            @Override
            public ScheduleResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
               return new ScheduleResponseDto(
                       rs.getLong("id"),
                       rs.getString("name"),
                       rs.getString("content"));
            }
        };
    }



}
