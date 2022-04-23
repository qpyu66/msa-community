package com.bithumb.msacommunity.handler;

import com.bithumb.msacommunity.domain.Board;
import com.bithumb.msacommunity.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

@Component
@RequiredArgsConstructor
public class BoardHandler {

    private final BoardService boardService;

    /**
     * 게시글 목록을 가져오는 메소드
     * @param request ServerRequest
     * @return flux 를 list 에 모은 후 flatmap 하면서 response body 에 넣기
     */
    public Mono<ServerResponse> getBoardList(ServerRequest request) {
        Flux<Board> boardFlux = boardService.findAll();
        return boardFlux.collectList().flatMap(b ->
            b.size() < 1 ?
                ServerResponse.status(404).build()
                :ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(fromObject(b))
        );
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
