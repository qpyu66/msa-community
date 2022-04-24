package com.bithumb.msacommunity.service;

import reactor.core.publisher.Mono;

public interface ReplyService  {

    Mono hideReply(Integer id);
}
