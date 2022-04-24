package com.bithumb.msacommunity.repository;

import com.bithumb.msacommunity.domain.Reply;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ReplyRepository extends ReactiveCrudRepository<Reply, Integer> {
}
