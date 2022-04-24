package com.bithumb.msacommunity.handler;

import ch.qos.logback.classic.LoggerContext;
import com.bithumb.msacommunity.domain.Board;

import com.bithumb.msacommunity.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.h2.message.Trace;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
@RequiredArgsConstructor
public class BoardHandler {

    private final BoardService boardService;

    //게시글 목록
    public Mono<ServerResponse> getBoardList(ServerRequest request) {
        return (Mono<ServerResponse>) ServerResponse.ok()
                .contentType(APPLICATION_JSON);
    }

    // 게시글 작성
    public Mono<ServerResponse> writeBoard(ServerRequest request) {
        Mono<Board> boardMono = request.bodyToMono(Board.class)
                .flatMap(board -> boardService.saveBoard(board))
                .log("boardMono is : ");

        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(boardMono, Board.class).log("writeBoard is : ")
                .onErrorResume(error -> ServerResponse.badRequest().build());
    }
//    public Mono<ServerResponse> writeBoard(ServerRequest request) {
//        return request.bodyToMono(Board.class)
//                .flatMap(board -> boardService.saveBoard(board))
//                .flatMap(board -> ServerResponse.created(URI.create("/community/" + board.getId()))
//                        .contentType(APPLICATION_JSON).body(BodyInserters.fromValue(board))).log("writeBoard is : ");
//    }
//


    public Mono<ServerResponse> offArticle(ServerRequest req) {
        return null;
    }


}
