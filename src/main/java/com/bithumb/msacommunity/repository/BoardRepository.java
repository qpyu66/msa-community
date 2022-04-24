package com.bithumb.msacommunity.repository;

import com.bithumb.msacommunity.domain.Board;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public interface BoardRepository extends ReactiveCrudRepository<Board, Integer> {

    @Query("SELECT * FROM BOARD")
    Flux<Board> findAll();

    @Query("SELECT * FROM BOARD WHERE id = $1")
    Mono<Board> findById(Integer id);
}
