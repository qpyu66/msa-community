package com.bithumb.msacommunity.router;

import com.bithumb.msacommunity.domain.Reply;
import com.bithumb.msacommunity.handler.ReplyHandler;
import com.bithumb.msacommunity.service.ReplyService;
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
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.HashMap;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class ReplyRouter {
    @Bean
    @RouterOperations(
            {
                    @RouterOperation(path = "/community/reply/write"
                            , produces = {
                            MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.POST, beanClass = ReplyHandler.class, beanMethod = "writeReply",
                            operation = @Operation(operationId = "writeReply", responses = {
                                    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = Reply.class))),
                                    @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(implementation = Reply.class)))}
                                    , requestBody = @RequestBody(content = @Content(schema = @Schema(implementation = Reply.class))))
                    ),

                    @RouterOperation(path = "/community/admin/reply/hide"
                            , produces = {
                            MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.POST, beanClass = ReplyHandler.class, beanMethod = "hideReply",
                            operation = @Operation(operationId = "hideReply", responses = {
                                    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = Reply.class))),
                                    @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(implementation = Reply.class)))}
                                    , requestBody = @RequestBody(content = @Content(schema = @Schema(implementation = Reply.class))))
                    )
            }
    )
    public RouterFunction<ServerResponse> route2(ReplyHandler handler) {
        return RouterFunctions
                .route(POST("/community/reply/write").and(accept(MediaType.APPLICATION_JSON)), handler::writeReply)   // 댓글 작성
                .andRoute(POST("/community/admin/reply/hide").and(accept(MediaType.APPLICATION_JSON)), handler::hideReply) // 댓글 숨김
                ;
    }

}
