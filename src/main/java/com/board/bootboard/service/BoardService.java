package com.board.bootboard.service;

import org.springframework.stereotype.Service;

import com.board.bootboard.domain.repository.BoardRepository;
import com.board.bootboard.dto.BoardDto;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BoardService {
    private BoardRepository boardRepository;

    @Transactional
    public Long savePost(BoardDto boardDto){
        return boardRepository.save(boardDto.toEntity()).getId();
    }
}
