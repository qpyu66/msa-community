package com.bithumb.msacommunity.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Table(value = "reply")
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Reply {
    @Id
    private Integer replyId;
    private Integer boardId;
    private Integer memberId;
    private String commentContent;
    private Integer commentShowYN;
    private Date insertDt;
    private Date updateDt;

}