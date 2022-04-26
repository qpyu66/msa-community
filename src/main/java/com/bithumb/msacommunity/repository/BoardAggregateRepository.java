package com.bithumb.msacommunity.repository;

import com.bithumb.msacommunity.domain.BoardAggregate;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface BoardAggregateRepository extends ReactiveCrudRepository<BoardAggregate, Integer> {
    @Query("SELECT * FROM BOARD WHERE visibleyn = '0' and boardId = $1")
    Mono<BoardAggregate> findById(Integer BoardId);
}
