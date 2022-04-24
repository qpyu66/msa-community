package com.bithumb.msacommunity.service;

import com.bithumb.msacommunity.domain.Reply;
import reactor.core.publisher.Mono;

public interface ReplyService  {

    Mono<Reply> hideReply(Integer id);
}
