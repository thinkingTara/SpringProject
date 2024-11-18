package com.example.memberboard.dto;

import com.example.memberboard.entity.Member;
import lombok.Getter;

@Getter
public class SignUpResponseDto {

    private final Long id;
    private final String username;
    private final Integer age;


    public SignUpResponseDto(Long id, String username, Integer age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }

    public SignUpResponseDto(Member member) {
        this.id = member.getId();
        this.username = member.getUsername();
        this.age = member.getAge();
    }
}
