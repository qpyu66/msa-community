package com.bithumb.msacommunity.webclient;

import com.bithumb.msacommunity.domain.Board;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class BoardClient {

    private final WebClient webClient;

    public BoardClient(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("http://localhost:8082/community/admin/board/").build();
    }

    public Mono<Board> getBoard(Integer boardId) {
        return this.webClient.get()
                .uri("{boardId}", boardId)
                .retrieve()
                .bodyToMono(Board.class)
                .onErrorResume(b -> Mono.empty());
    }
}
