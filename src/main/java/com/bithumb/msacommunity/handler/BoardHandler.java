package com.bithumb.msacommunity.handler;

import ch.qos.logback.classic.LoggerContext;
import com.bithumb.msacommunity.domain.Board;

import com.bithumb.msacommunity.domain.BoardAggregate;
import com.bithumb.msacommunity.repository.BoardAggregateRepository;
import com.bithumb.msacommunity.repository.BoardRepository;
import com.bithumb.msacommunity.domain.Reply;
import com.bithumb.msacommunity.service.BoardAggregatorService;
import com.bithumb.msacommunity.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.h2.message.Trace;
import org.h2.tools.Server;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;

import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromValue;

@Component
@RequiredArgsConstructor
public class BoardHandler {

    private final BoardService boardService;
    private final BoardAggregateRepository boardAggregateRepository;
    private final BoardRepository boardRepository;

    /**
     * 게시글 목록을 가져오는 메소드
     * 첫 번째 페이지는 0번 index, 한 페이지에 보여줄 리스트는 10개, 정렬은 생성시기 내림차순
     * @param request ServerRequest
     * @return flux 를 list 에 모은 후 flatmap 하면서 response body 에 넣기
     */
    public Mono<ServerResponse> getBoardList(ServerRequest request) {
        Integer page =  request.queryParam("page").isPresent() ? Integer.parseInt(request.queryParam("page").get()) - 1 : 0;
        Integer pageSize = request.queryParam("page-size").isPresent() ? Integer.parseInt(request.queryParam("page-size").get()) : 10;
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        return Mono.just(boardRepository.findAllByPage(PageRequest.of(page, pageSize, Sort.by(Sort.Direction.DESC, "insertdt"))))
                .flatMap(board -> ServerResponse.ok().contentType(APPLICATION_JSON).body(board, Board.class).switchIfEmpty(notFound));
    }

    /**
     * 게시글 조회하는 메소드
     * @param request ServerRequest
     * @return boardContent 를 반환 empty 상태라면 Not Found
     */
    public Mono<ServerResponse> getBoard(ServerRequest request) {
        Integer boardId = Integer.valueOf(request.pathVariable("id"));
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        Mono<BoardAggregate> boardContent = this.boardAggregateRepository.getBoard(boardId);
        return boardContent
                .flatMap(boardAgg ->
                        ServerResponse.ok().contentType(APPLICATION_JSON)
                                .body(boardAgg, BoardAggregate.class)
                                .switchIfEmpty(notFound)
                );
        //Mono<Board> boardMono = request.bodyToMono(Board.class)
                //.flatMap(board -> boardRepository.findById(boardId));

        //return ServerResponse.ok()
                //.contentType(MediaType.APPLICATION_JSON)
                //.body(boardMono, Map.class)
                //.switchIfEmpty(notFound);
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


   //게시글 숨기기
    public Mono<ServerResponse> hideArticle(ServerRequest req) {
        Mono<Board> mono = req.bodyToMono(Board.class)
                .flatMap(arti -> boardService.hideBoard(arti.getId())).log();

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(mono, Reply.class).log("writeBoard is : ");
    }


}
