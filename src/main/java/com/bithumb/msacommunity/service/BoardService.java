package com.bithumb.msacommunity.service;

import com.bithumb.msacommunity.domain.Board;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface BoardService {

    // 게시글 조회
    Mono<Board> findById(Integer id);

    // 게시글 작성
    Mono<Board> saveBoard(Board board);


}
