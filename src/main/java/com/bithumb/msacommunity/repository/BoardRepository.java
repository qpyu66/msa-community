package com.bithumb.msacommunity.repository;

import com.bithumb.msacommunity.domain.Board;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends ReactiveSortingRepository<Board, Integer> {

    @Query("SELECT id, title, memberid, insertdt, updatedt FROM BOARD WHERE visibleyn = '0' ORDER BY id DESC")
    Flux<Board> findAllByPage(Pageable pageable);

    @Query("SELECT * FROM BOARD WHERE id = $1")
    Mono<Board> findById(Integer id);
}
