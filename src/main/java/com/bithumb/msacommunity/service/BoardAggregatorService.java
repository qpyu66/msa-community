package com.bithumb.msacommunity.service;

import com.bithumb.msacommunity.domain.Board;
import com.bithumb.msacommunity.domain.BoardAggregate;
import com.bithumb.msacommunity.domain.Reply;
import com.bithumb.msacommunity.webclient.BoardClient;
import com.bithumb.msacommunity.webclient.ReplyClient;
import lombok.AllArgsConstructor;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.util.List;

@Service
@AllArgsConstructor
/**
 * 게시물 내용과 댓글 리스트를 결합하여 응답하는 서비스
 */
public class BoardAggregatorService {
    private final BoardClient boardClient;
    private final ReplyClient replyClient;

    /**
     * 게시물 내용을 가져오는 메소드
     * @param boardId 게시물 id
     * @return Mono.zip을 사용하여 게시물 내용과 댓글 리스트를 async & non-block 하게 결합
     */
    public Mono<BoardAggregate> getBoard(Integer boardId) {
        return Mono.zip(this.boardClient.getBoard(boardId), this.replyClient.getReplyList(boardId)).map(this::combine);
    }

    /**
     * 튜플 개체에서 response를 결합
     * @param tuple
     * @return
     */
    private BoardAggregate combine(Tuple2<Board, List<Reply>> tuple) {
        return BoardAggregate.create(tuple.getT1(), tuple.getT2());
    }



}
