package com.bithumb.msacommunity.handler;

import com.bithumb.msacommunity.domain.Board;
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

    /**
     * 게시글 조회하는 메소드
     * @param request ServerRequest
     * @return boardContent 를 반환 empty 상태라면 Not Found
     */
    public Mono<ServerResponse> getBoardContent(ServerRequest request) {
        Integer boardId = Integer.valueOf(request.pathVariable("id"));
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        Mono<Board> boardMono = request.bodyToMono(Board.class)
                .flatMap(board -> boardService.findById(boardId));

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(boardMono, Map.class)
                .switchIfEmpty(notFound);
    }

    // 게시글 작성
    public Mono<ServerResponse> writeBoard(ServerRequest request) {
        Mono<Board> boardMono = request.bodyToMono(Board.class)
                .flatMap(board -> boardService.saveBoard(board));

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(boardMono, Map.class);
    }



}
