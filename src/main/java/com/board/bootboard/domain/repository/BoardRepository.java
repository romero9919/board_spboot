package com.board.bootboard.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.board.bootboard.domain.entity.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    
}
