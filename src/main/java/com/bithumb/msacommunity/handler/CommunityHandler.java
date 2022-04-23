package com.bithumb.msacommunity.handler;

import com.bithumb.msacommunity.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Component
public class CommunityHandler {

    @Autowired
    CommunityService communityService;

    // 게시판 열람
    public Mono<ServerResponse> viewNoticeBoardHandler(ServerRequest request) {
        Map<String, Object> result = new HashMap<>();
        //lectureService... 서비스로직
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(result, Map.class);
    }

    // 게시글 작성
    public Mono<ServerResponse> writeBoardHandler(ServerRequest request) {
        Map<String, Object> result = new HashMap<>();
        //lectureService... 서비스로직
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(result, Map.class);
    }

    // 댓글 작성
    public Mono<ServerResponse> writeCommentHandler(ServerRequest request) {
        Map<String, Object> result = new HashMap<>();
        //lectureService... 서비스로직
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(result, Map.class);
    }

    // 게시글, 댓글 숨김처리
    public Mono<ServerResponse> showNoticeContentYnHandler(ServerRequest request) {
        Map<String, Object> result = new HashMap<>();
        //lectureService... 서비스로직
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(result, Map.class);
    }


}
