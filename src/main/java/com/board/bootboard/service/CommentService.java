package com.board.bootboard.service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.board.bootboard.domain.entity.CommentEntity;
import com.board.bootboard.domain.repository.CommentRepository;
import com.board.bootboard.dto.CommentDto;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CommentService {
    
    private CommentRepository commentRepository;

    private CommentDto convertEntityToDto(CommentEntity commentEntity){
        return CommentDto.builder()
            .num(commentEntity.getNum())
            .ndboardNum(commentEntity.getNdboardNum())
            .username(commentEntity.getUsername())
            .userpass(commentEntity.getUserpass())
            .userid(commentEntity.getUserid())
            .comment(commentEntity.getComment())
            .cdate(commentEntity.getCdate())
            .build();
    }

    @Transactional
    public List<CommentDto> getCommentList(Integer ndboardNum){
        List<CommentEntity> commentEntities = commentRepository.findByNdboardNum(ndboardNum);
        List<CommentDto> commentDtoList = new ArrayList<>();

        for(CommentEntity commentEntity : commentEntities){
            commentDtoList.add(this.convertEntityToDto(commentEntity));
        }

        return commentDtoList;
    }

    @Transactional
    public int saveComment(CommentDto commentDto){
        return commentRepository.save(commentDto.toEntity()).getNum();
    }

    @Transactional
    public void deleteComment(int num){
        commentRepository.deleteById(num);
    }
}
