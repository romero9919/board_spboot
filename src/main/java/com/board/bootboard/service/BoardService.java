package com.board.bootboard.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    private static final int BLOCK_PAGE_NUM_COUNT = 5;
    private static final int PAGE_POST_COUNT = 10;

    private BoardDto convertEntityToDto(BoardEntity boardEntity){
        return BoardDto.builder()
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
    }

    @Transactional
    public List<BoardDto> getBoardlist(Integer pageNum){
        Page<BoardEntity> page = boardRepository.findAll(PageRequest.of(pageNum - 1, PAGE_POST_COUNT, Sort.by(Sort.Direction.DESC, "num")));

        List<BoardEntity> boardEntities = page.getContent();
        List<BoardDto> boardDtoList = new ArrayList<>();

        for(BoardEntity boardEntity : boardEntities){
            boardDtoList.add(this.convertEntityToDto(boardEntity));
        }

        return boardDtoList;
    }

    @Transactional
    public Long getBoardCount(){
        return boardRepository.count();
    }

    public Integer[] getPageList(Integer curPageNum){
        Integer[] pageList = new Integer[BLOCK_PAGE_NUM_COUNT];

        Double postsTotalCount = Double.valueOf(this.getBoardCount());

        Integer totalLastPageNum = (int)(Math.ceil((postsTotalCount/PAGE_POST_COUNT)));

        Integer blockLastPageNum = (totalLastPageNum > curPageNum + BLOCK_PAGE_NUM_COUNT)
            ? curPageNum + BLOCK_PAGE_NUM_COUNT
            : totalLastPageNum;
        
        curPageNum = (curPageNum <= 3) ? 1 : curPageNum - 2;

        for(int val = curPageNum, idx = 0; val <= blockLastPageNum; val++, idx++){
            pageList[idx] = val;
        }

        return pageList;
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

    

    @Transactional
    public List<BoardDto> searchPosts(String keyword){
        List<BoardEntity> boardEntities = boardRepository.findByTitleContaining(keyword);
        List<BoardDto> boardDtoList = new ArrayList<>();

        if(boardEntities.isEmpty()) return boardDtoList;

        for(BoardEntity boardEntity : boardEntities){
            boardDtoList.add(this.convertEntityToDto(boardEntity));
        }

        return boardDtoList;
    }
    
}
