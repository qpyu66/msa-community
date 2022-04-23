package com.bithumb.msacommunity.service;

import com.bithumb.msacommunity.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface BoardService {

    Flux<Board> findAll();

    // 게시글 조회
    Mono<Board> findById(Integer id);

    // 게시글 작성
    Mono<Board> saveBoard(Board board);


}
