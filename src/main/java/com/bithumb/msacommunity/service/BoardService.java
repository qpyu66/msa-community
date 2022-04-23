package com.bithumb.msacommunity.service;

import com.bithumb.msacommunity.domain.Board;
import reactor.core.publisher.Mono;

public interface BoardService {


    // 게시글 작성
    Mono<Board> saveBoard(Board board);


}
