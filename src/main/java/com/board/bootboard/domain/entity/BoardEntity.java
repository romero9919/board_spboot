package com.board.bootboard.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "ndboard")
public class BoardEntity{
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;

    @Column
    private int orNum;
    private int grNum = 1;;
    private int grLayer = 0;
    private String writer;
    private String userid;
    private String userpass;
    private String title;
    private String contents;
    private int hit = 0;
    private int fileCount = 0;
    private int memoCount = 0;
    private int imnum = 0;

    @Builder
    public BoardEntity(Long num, int orNum, int grNum, int grLayer, String writer, String userid, String userpass, String title, String contents, int hit, int fileCount, int memoCount, int imnum) {
        this.num = num;
        this.orNum = orNum;
        this.grNum = grNum;
        this.grLayer = grLayer;
        this.writer = writer;
        this.userid = userid;
        this.userpass = userpass;
        this.title = title;
        this.contents = contents;
        this.hit = hit;
        this.fileCount = fileCount;
        this.memoCount = memoCount;
        this.imnum = imnum;
    }

}
