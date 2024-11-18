package com.example.memberboard.dto;

import lombok.Getter;

@Getter
public class BoardRequestDto {

    private final String title;
    private final String contents;
    private final String username;


    public BoardRequestDto(String title, String contents, String username) {
        this.title = title;
        this.contents = contents;
        this.username = username;
    }

}
