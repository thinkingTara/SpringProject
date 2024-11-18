package com.example.memberboard.controller;

import com.example.memberboard.dto.SignUpRequestDto;
import com.example.memberboard.dto.SignUpResponseDto;
import com.example.memberboard.dto.UpdatePasswordRequestDto;
import com.example.memberboard.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto requestDto) {

        SignUpResponseDto responseDto = memberService.create(requestDto.getUsername(), requestDto.getPassword(), requestDto.getAge());
        return new ResponseEntity<>(responseDto,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SignUpResponseDto> searchMember(@PathVariable Long id) {

        SignUpResponseDto responseDto = memberService.searchMember(id);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updatePassword(
            @PathVariable Long id, @RequestBody UpdatePasswordRequestDto requestDto) {
        String oldPassword = requestDto.getOldPassword();
        String newPassword = requestDto.getNewPassword();
        memberService.updatePassword(id, oldPassword, newPassword);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
