package com.board.bootboard.dto;

import com.board.bootboard.domain.entity.CommentEntity;

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
public class CommentDto {
    
    private int num;
    private int ndboardNum;
    private String username;
    private String userpass;
    private String userid;
    private String comment;
    private LocalDateTime cdate;

    public CommentEntity toEntity(){
        return CommentEntity.builder()
            .num(num)
            .ndboardNum(ndboardNum)
            .username(username)
            .userpass(userpass)
            .userid(userid)
            .comment(comment)
            .cdate(cdate)
            .build();
    }

    @Builder
    public CommentDto(int num, int ndboardNum, String username, String userpass, String userid, String comment, LocalDateTime cdate){
        this.num = num;
        this.ndboardNum = ndboardNum;
        this.username = username;
        this.userpass = userpass;
        this.userid = userid;
        this.comment = comment;
        this.cdate = cdate;
    }

}
