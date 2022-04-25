package com.bithumb.msacommunity.router;

import com.bithumb.msacommunity.domain.Board;
import com.bithumb.msacommunity.handler.BoardHandler;
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
                .route(GET("/community/admin/board/list").and(accept(MediaType.APPLICATION_JSON)), boardHandler::getBoardList) // 게시판 목록
                .andRoute(POST("/community/admin/board/{id}").and(accept(MediaType.APPLICATION_JSON)), boardHandler::getBoard) // 게시판 열람
                .andRoute(POST("/community/write").and(accept(MediaType.APPLICATION_JSON)), boardHandler::writeBoard) // 게시글 작성
                .andRoute(POST("/community/admin/board/hide").and(accept(MediaType.APPLICATION_JSON)), boardHandler::hideArticle) // 게시글 숨김
                ;
    }

}
