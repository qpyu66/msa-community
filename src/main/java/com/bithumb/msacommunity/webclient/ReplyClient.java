package com.bithumb.msacommunity.webclient;

import com.bithumb.msacommunity.domain.Reply;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

@Service
public class ReplyClient {

    private final WebClient webClient;

    public ReplyClient(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("http://localhost:8082/community/board/").build();
    }

    public Mono<List<Reply>> getReplyList(Integer boardId) {
        return this.webClient
                .get()
                .uri(b -> b.queryParam("boardId", boardId).build())
                .retrieve()
                .bodyToFlux(Reply.class)
                .collectList()
                .onErrorReturn(Collections.emptyList());
    }
}
