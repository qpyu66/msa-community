package com.bithumb.msacommunity.handler;

import com.bithumb.msacommunity.domain.Reply;
import com.bithumb.msacommunity.service.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
@RequiredArgsConstructor
@Slf4j
public class ReplyHandler {
    private final ReplyService replyService;

    // 댓글 작성
    public Mono<ServerResponse> writeReply(ServerRequest request) {
        Mono<Reply> replyMono = request.bodyToMono(Reply.class)
                .flatMap(reply -> replyService.saveReply(reply))
                .log("replyMono is : ");

        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(replyMono, Reply.class).log("writeReply is : ")
                .onErrorResume(error -> ServerResponse.badRequest().build());
    }

    // 댓글 숨김
    public Mono<ServerResponse> hideReply(ServerRequest req) {
        Mono<Reply> mono = req.bodyToMono(Reply.class)
                .flatMap(reply -> replyService.hideReply(reply.getReplyid()))
                .log();

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(mono, Reply.class).log("writeBoard is : ");
    }
}
