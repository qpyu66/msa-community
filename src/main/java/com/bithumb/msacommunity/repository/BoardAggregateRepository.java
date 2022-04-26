package com.bithumb.msacommunity.repository;

import com.bithumb.msacommunity.domain.BoardAggregate;
import org.springframework.data.r2dbc.repository.Query;
import reactor.core.publisher.Mono;

public interface BoardAggregateRepository {
    @Query("SELECT * FROM BOARD WHERE visibleyn = '0' and id = 1")
    Mono<BoardAggregate> getBoard(Integer BoardId);
}
