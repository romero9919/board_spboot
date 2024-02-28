package com.board.bootboard.service;

import org.springframework.stereotype.Service;

import com.board.bootboard.domain.entity.BoardEntity;
import com.board.bootboard.domain.repository.BoardRepository;
import com.board.bootboard.dto.BoardDto;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

import java.util.*;

@AllArgsConstructor
@Service
public class BoardService {
    private BoardRepository boardRepository;

    @Transactional
    public List<BoardDto> getBoardlist(){
        List<BoardEntity> boardEntities = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();

        for( BoardEntity boardEntity : boardEntities){
            BoardDto boardDto = BoardDto.builder()
                .num(boardEntity.getNum())
                .orNum(boardEntity.getOrNum())
                .grNum(boardEntity.getGrNum())
                .grLayer(boardEntity.getGrLayer())
                .writer(boardEntity.getWriter())
                .userid(boardEntity.getUserid())
                .userpass(boardEntity.getUserpass())
                .title(boardEntity.getTitle())
                .contents(boardEntity.getContents())
                .hit(boardEntity.getHit())
                .fileCount(boardEntity.getFileCount())
                .memoCount(boardEntity.getMemoCount())
                .imnum(boardEntity.getImnum())
                .build();
            boardDtoList.add(boardDto); 
        }
        return boardDtoList;
    }

    @Transactional
    public Long savePost(BoardDto boardDto){
        return boardRepository.save(boardDto.toEntity()).getNum();
    }
}
