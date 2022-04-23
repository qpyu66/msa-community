package com.bithumb.msacommunity.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Table(value = "boardList")
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoardList {
    private Integer num; // 게시글 번호
    private String title; // 게시글 제목
    private String memberId; // 작성자
    private Date createDt; // 생성 날짜
    private Date updateDt; // 수정 날짜
    private Integer readCount; // 조회수
}
