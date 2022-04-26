package com.bithumb.msacommunity.repository;

import com.bithumb.msacommunity.domain.BoardAggregate;
import com.bithumb.msacommunity.service.BoardAggregatorService;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class BoardAggregateRepositoryImpl implements BoardAggregateRepository {
    
    private final BoardAggregatorService boardAggregatorService;
    
    public BoardAggregateRepositoryImpl(BoardAggregatorService boardAggregateService) { this.boardAggregatorService = boardAggregateService; }

    @Override
    public Mono<BoardAggregate> getBoard(Integer id) {
        return this.boardAggregatorService.getBoard(id);
    }
}
