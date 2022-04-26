package com.bithumb.msacommunity.router;

import com.bithumb.msacommunity.domain.Board;
import com.bithumb.msacommunity.domain.Reply;
import com.bithumb.msacommunity.handler.BoardHandler;
import com.bithumb.msacommunity.handler.ReplyHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.server.*;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class BoardRouter {
    @RouterOperations(
            {
                    @RouterOperation(path = "/community/list", produces = {
                            MediaType.APPLICATION_JSON_VALUE},
                            beanClass = BoardHandler.class, method = RequestMethod.GET, beanMethod = "getBoardList",
                            operation = @Operation(operationId = "getBoardList", responses = {
                                    @ApiResponse(responseCode = "200"),
                                    @ApiResponse(responseCode = "400")}
                            )
                    ),

                    @RouterOperation(path = "/community/write"
                            , produces = {
                            MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.POST, beanClass = BoardHandler.class, beanMethod = "writeBoard",
                            operation = @Operation(operationId = "writeBoard", responses = {
                                    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = Board.class))),
                                    @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(implementation = Board.class)))}
                                    , requestBody = @RequestBody(content = @Content(schema = @Schema(implementation = Board.class))))
                    ),

                    @RouterOperation(path = "/community/admin/board/hide"
                            , produces = {
                            MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.POST, beanClass = BoardHandler.class, beanMethod = "hideArticle",
                            operation = @Operation(operationId = "hideArticle", responses = {
                                    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = Board.class))),
                                    @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(implementation = Board.class)))}
                                    , requestBody = @RequestBody(content = @Content(schema = @Schema(implementation = Board.class))))
                    )
            }
    )
    @Bean
    public RouterFunction<ServerResponse> route(BoardHandler boardHandler) {
        return RouterFunctions
                .route(GET("/community/board/list").and(accept(MediaType.APPLICATION_JSON)), boardHandler::getBoardList) // 게시판 목록
                .andRoute(GET("/community/board/{boardId}").and(accept(MediaType.APPLICATION_JSON)), boardHandler::getBoard) // 게시판 열람
                .andRoute(POST("/community/write").and(accept(MediaType.APPLICATION_JSON)), boardHandler::writeBoard) // 게시글 작성
                .andRoute(POST("/community/admin/board/hide").and(accept(MediaType.APPLICATION_JSON)), boardHandler::hideArticle) // 게시글 숨김
                ;
    }

}
