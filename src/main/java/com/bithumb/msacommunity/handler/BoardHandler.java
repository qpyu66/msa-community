package com.bithumb.msacommunity.handler;

import com.bithumb.msacommunity.domain.Board;
import com.bithumb.msacommunity.domain.Community;
import com.bithumb.msacommunity.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class BoardHandler {

    private final BoardService boardService;

    //게시글 목록
    public Mono<ServerResponse> getBoardList(ServerRequest request) {
        return (Mono<ServerResponse>) ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON);
    }

    // 게시글 작성
    public Mono<ServerResponse> writeBoard(ServerRequest request) {
        Mono<Board> boardMono = request.bodyToMono(Board.class)
                .flatMap(board -> boardService.saveBoard(board));

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(boardMono, Map.class);
    }

    public Mono<ServerResponse> offArticle(ServerRequest req) {
        return null;
    }


}
