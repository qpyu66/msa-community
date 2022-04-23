package com.bithumb.msacommunity.router;

import com.bithumb.msacommunity.handler.CommunityHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;

@Configuration()
public class CommunityRouter {

    CommunityHandler communityHandler = new CommunityHandler();

    @Bean
    public RouterFunction<ServerResponse> route() {
        return RouterFunctions
                .route(GET("/community/list"), communityHandler::viewNoticeBoardHandler)                    // 게시판 열람
                .andRoute(POST("/community/write"), communityHandler::writeCommunity)                // 게시글 작성
                .andRoute(POST("/community/reply/write"), communityHandler::writeCommentHandler)            // 댓글 작성
                .andRoute(POST("/community/operator/show"), communityHandler::showNoticeContentYnHandler)   // 게시글, 댓글 숨김처리
                ;
    }

}
