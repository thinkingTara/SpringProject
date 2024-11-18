package com.example.memberboard.repository;

import com.example.memberboard.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    default Member findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"id로 찾으시는 멤버가 없습니다"));
    }

//    Member findMemberByUsername(String username);
//    default Member findMemberByUsernameOrElseThrow(String userName) {
//        return findMemberByUsername(userName);
//    }

    Optional<Member> findMemberByUsername(String username);
    default Member findMemberByUsernameOrElseThrow(String userName){
        return findMemberByUsername(userName).orElseThrow(()->new ResponseStatusException(HttpStatus.UNAUTHORIZED, "userName :" + userName));
    }
}
