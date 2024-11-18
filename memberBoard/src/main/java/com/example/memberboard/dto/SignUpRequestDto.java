package com.example.memberboard.dto;

import lombok.Getter;

@Getter
public class SignUpRequestDto {

    private final Long id;
    private final String username;
    private final String password;
    private final Integer age;

    public SignUpRequestDto(Long id, String username, String password, Integer age) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
    }
}
