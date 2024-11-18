package com.example.memberboard.service;

import com.example.memberboard.dto.SignUpResponseDto;
import com.example.memberboard.entity.Member;
import com.example.memberboard.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public SignUpResponseDto create(String username, String password, Integer age) {
        Member member = new Member(username, password, age);
        Member savedMember = memberRepository.save(member);

        return new SignUpResponseDto(savedMember.getId(), savedMember.getUsername(), savedMember.getAge());
    }

    public SignUpResponseDto searchMember(Long id) {
        Optional<Member> memberById = memberRepository.findById(id);
        if(memberById.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "조회할 멤버가 없습니다.");
        }
        Member member = memberById.get();
//        return new SignUpResponseDto(member.getId(), member.getUsername(), member.getAge());
        return new SignUpResponseDto(member);
    }

    @Transactional
    public void updatePassword(Long id, String oldPassword, String newPassword) {
        Member memberById = memberRepository.findByIdOrElseThrow(id);
        if(!memberById.getPassword().equals(oldPassword)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "기존의 비밀번호가 일치하지 않습니다.");
        }
        memberById.updatePassword(newPassword);
    }
}
