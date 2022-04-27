package com.bithumb.msacommunity.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor(staticName = "create")
/**
 * Board Aggregator dto
 */
public class BoardAggregate {
    private Board board; // 게시물
    private List<Reply> replyList; // 댓글 리스트
}
