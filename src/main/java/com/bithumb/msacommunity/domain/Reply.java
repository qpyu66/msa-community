package com.bithumb.msacommunity.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.Date;

@Table(value = "reply")
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Reply {
    @Id
    private Integer replyid; //댓글 아이디

    private Integer boardid; //게시글 아이디

    private Integer memberid; //작성자

    private String replycontent; //댓글 내용

    private Integer replyvisibleyn; //댓글 노출 여부

    @CreatedDate
    private LocalDateTime insertdt; //생성일

    @LastModifiedDate
    private LocalDateTime updatedt; //수정일

    public Reply() {
    }
}