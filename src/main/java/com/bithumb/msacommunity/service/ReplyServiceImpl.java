package com.bithumb.msacommunity.service;

import com.bithumb.msacommunity.repository.ReplyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@Slf4j
public class ReplyServiceImpl implements ReplyService {

    private final ReplyRepository replyRepository;

    public ReplyServiceImpl(ReplyRepository replyRepository) {
        this.replyRepository = replyRepository;
    }

    //댓글 숨기기
    public Mono hideReply(Integer replyId) {
        return replyRepository.findById(replyId)
                .filter(Objects::nonNull) //있는 댓번일때
                .filter(item -> item.getReplyvisibleyn()==0) //show상태일떄
                .doOnNext(item -> item.setReplyvisibleyn(1))
                .flatMap(item -> replyRepository.save(item))
                .log();
    }
}
