package com.example.memberboard.service;

import com.example.memberboard.dto.BoardResponseDto;
import com.example.memberboard.dto.BoardWithMemberResponseDto;
import com.example.memberboard.entity.Board;
import com.example.memberboard.entity.Member;
import com.example.memberboard.repository.BoardRepository;
import com.example.memberboard.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;
    private final UrlBasedViewResolver urlBasedViewResolver;

    public BoardService(BoardRepository boardRepository, MemberRepository memberRepository, UrlBasedViewResolver urlBasedViewResolver) {
        this.boardRepository = boardRepository;
        this.memberRepository = memberRepository;
        this.urlBasedViewResolver = urlBasedViewResolver;
    }

    public BoardResponseDto create(String title, String contents, String username) {

        Board board = new Board(title, contents);
        Member memberByUsername = memberRepository.findMemberByUsernameOrElseThrow(username);
        board.setMember(memberByUsername);
        Board savedBoard = boardRepository.save(board);
        return new BoardResponseDto(savedBoard.getId(), savedBoard.getTitle(), savedBoard.getContents());
    }

//    public List<BoardResponseDto> searchAll() {
//        List<BoardResponseDto> searchedAll = new ArrayList<>();
//        boardRepository.findAll().stream().forEach((item) -> {
//                    BoardResponseDto boardResponseDto = new BoardResponseDto(item.getId(), item.getTitle(), item.getContents());
//                    searchedAll.add(boardResponseDto);
//                }
//        );
//        return searchedAll;
//    };

        public List<BoardResponseDto> searchAll() {
        List<BoardResponseDto> searchedAll = new ArrayList<>();
            boardRepository.findAll().forEach((Board item)->{
                BoardResponseDto boardResponseDto = new BoardResponseDto(item.getId(), item.getTitle(), item.getContents());
                searchedAll.add(boardResponseDto);
            });

            return searchedAll;
    };

    public void deleteOne(Long id) {
        boardRepository.deleteById(id);
    }


    public BoardWithMemberResponseDto boardWithMember(Long id) {
        Optional<Board> byIdBoard = boardRepository.findById(id);
        Board board = byIdBoard.get();
        Member member = board.getMember();
        return new BoardWithMemberResponseDto(board.getTitle(),board.getContents(), member.getUsername(), member.getAge());
    }
}
