package com.board.bootboard.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "ndboard")
public class BoardEntity extends TimeEntity{
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;

}
