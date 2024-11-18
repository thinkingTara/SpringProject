package com.example.memberboard.dto;

import lombok.Getter;

@Getter
public class BoardWithMemberResponseDto {

    private final String title;
    private final String contents;
    private final String username;
    private final Integer age;

    public BoardWithMemberResponseDto(String title, String contents, String username, Integer age) {
        this.title = title;
        this.contents = contents;
        this.username = username;
        this.age = age;
    }

}
