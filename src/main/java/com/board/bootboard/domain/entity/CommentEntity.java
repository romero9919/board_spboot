package com.board.bootboard.domain.entity;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.*;

@NoArgsConstructor
@Getter
@Table(name = "ndboard_comment")
@Entity
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int num;

    @Column
    private int ndboardNum;

    @Column
    private String username;
    private String userpass;
    private String userid;
    private String comment;

    @Column
    @CreatedDate
    private LocalDateTime cdate;

    @Builder
    public CommentEntity(int num, int ndboardNum, String username, String userpass, String userid, String comment, LocalDateTime cdate){
        this.num = num;
        this.ndboardNum = ndboardNum;
        this.username = username;
        this.userpass = userpass;
        this.userid = userid;
        this.comment = comment;
        this.cdate = cdate;
    }
}
