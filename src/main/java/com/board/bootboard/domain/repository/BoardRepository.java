package com.board.bootboard.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.board.bootboard.domain.entity.BoardEntity;

import java.util.List;

public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {
    List<BoardEntity> findByTitleContaining(String keyword);
}
