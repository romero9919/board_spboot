package com.board.bootboard.dto;

import com.board.bootboard.domain.entity.BoardEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDto {
    private Long num;
    private int orNum;
    private int grNum;
    private int grLayer;
    private String writer;
    private String userid;
    private String userpass;
    private String title;
    private String contents;
    private int hit;
    private LocalDateTime wdate;
    private int fileCount;
    private int memoCount;
    private int imnum;

    public BoardEntity toEntity(){
        return BoardEntity.builder()
                .num(num)
                .orNum(orNum)
                .grNum(grNum)
                .grLayer(grLayer)
                .writer(writer)
                .userid(userid)
                .userpass(userpass)
                .title(title)
                .contents(contents)
                .hit(hit)
                .fileCount(fileCount)
                .memoCount(memoCount)
                .imnum(imnum)
                .build();
    }

    @Builder
    public BoardDto(Long num, int orNum, int grNum, int grLayer, String writer, String userid, String userpass, String title, String contents, int hit,LocalDateTime wdate, int fileCount, int memoCount, int imnum){
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
        this.wdate = wdate;
        this.fileCount = fileCount;
        this.memoCount = memoCount;
        this.imnum = imnum;
    }
}
