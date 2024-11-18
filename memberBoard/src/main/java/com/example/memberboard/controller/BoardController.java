package com.example.memberboard.controller;

import com.example.memberboard.dto.BoardRequestDto;
import com.example.memberboard.dto.BoardResponseDto;
import com.example.memberboard.dto.BoardWithMemberResponseDto;
import com.example.memberboard.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping("/write")
    public ResponseEntity<BoardResponseDto> create(@RequestBody BoardRequestDto requestDto){

        BoardResponseDto responseDto = boardService.create(requestDto.getTitle(), requestDto.getContents(), requestDto.getUsername());
        return new ResponseEntity<>(responseDto,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BoardResponseDto>> searchAll(){

        List<BoardResponseDto> responseDtos = boardService.searchAll();
        return new ResponseEntity<>(responseDtos,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardWithMemberResponseDto> boardWithMember(@PathVariable Long id){
        BoardWithMemberResponseDto responseDto = boardService.boardWithMember(id);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable Long id){
        boardService.deleteOne(id);
    }
}
