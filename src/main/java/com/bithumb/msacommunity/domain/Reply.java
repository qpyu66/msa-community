package com.bithumb.msacommunity.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@Table
@ToString
public class Reply {
    @Id
    private String replyId;
    private String boardId;
    private String memberId;
    private String commentContent;
    private int commentShowYN;
    private Date insertDt;
    private Date updateDt;

}