package com.bithumb.msacommunity.service;

import com.bithumb.msacommunity.domain.Reply;
import reactor.core.publisher.Mono;

public interface ReplyService  {

    //댓글 작성
    Mono<Reply> saveReply(Reply reply);

    //댓글 숨김
    Mono<Reply> hideReply(Integer id);
}
