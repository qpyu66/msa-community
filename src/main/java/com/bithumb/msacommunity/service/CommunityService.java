package com.bithumb.msacommunity.service;
import com.bithumb.msacommunity.domain.Community;
import com.bithumb.msacommunity.repository.CommunityRepository;
import com.bithumb.msacommunity.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

public interface CommunityService {

    // 게시판 열람



    // 게시글 작성
    Mono<Community> saveBoard(Community community);


    // 댓글 작성

    // 게시글, 댓글 숨김처리
}
