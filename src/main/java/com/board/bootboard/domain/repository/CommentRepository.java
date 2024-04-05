package com.board.bootboard.domain.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import com.board.bootboard.domain.entity.CommentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
    List<CommentEntity> findByNdboardNum(int ndBoardNum);
}
