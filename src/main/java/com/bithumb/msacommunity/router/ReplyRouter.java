package com.bithumb.msacommunity.router;

import com.bithumb.msacommunity.domain.Board;
import com.bithumb.msacommunity.domain.Reply;
import com.bithumb.msacommunity.handler.BoardHandler;
import com.bithumb.msacommunity.handler.ReplyHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class BoardRouter {
    @Bean
    public RouterFunction<ServerResponse> route(BoardHandler boardHandler) {
        return RouterFunctions
                .route(GET("/community/list"), boardHandler::getBoardList)                    // 게시판 목록
//                .andRoute(POST("/community/write/{id}"), boardHandler::)                 // 게시판 열람
                .andRoute(POST("/community/write").and(accept(MediaType.APPLICATION_JSON)), boardHandler::writeBoard)                // 게시글 작성
//                .POST("/community/write", RequestPredicates.contentType(MediaType.APPLICATION_JSON), boardHandler::writeBoard)                // 게시글 작성
//                .andRoute(POST("/community/reply/write"), boardHandler::)            // 댓글 작성
//                .andRoute(POST("/community/operator/show"), boardHandler::)   // 게시글, 댓글 숨김처리
                .andRoute(POST("/community/reply/hide"))
                ;
    }

}
