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
            BoardDto boardDTO = BoardDto.builder()
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
            boardDtoList.add(boardDTO); 
        }
        return boardDtoList;
    }

    @Transactional
    public BoardDto getPost(int num){

        Optional<BoardEntity> boardEntityWrapper = boardRepository.findById(num);
        BoardEntity boardEntity = boardEntityWrapper.get();

        BoardDto boardDTO = BoardDto.builder()
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

        return boardDTO;
    }

    @Transactional
    public int savePost(BoardDto boardDto){
        return boardRepository.save(boardDto.toEntity()).getNum();
    }

    @Transactional
    public void deletePost(int num){
        boardRepository.deleteById(num);
    }
}
