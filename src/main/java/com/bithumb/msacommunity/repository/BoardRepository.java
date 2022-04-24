package com.bithumb.msacommunity.repository;

import com.bithumb.msacommunity.domain.Board;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends ReactiveCrudRepository<Board, Integer> {
}
