package com.bithumb.msacommunity.handler;

import com.bithumb.msacommunity.service.ReplyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.HashMap;

@Component
@RequiredArgsConstructor
public class ReplyHandler {
    private final ReplyService replyService;

    //TODO:: 인테저가 아닌 모노로 넘기는 쪽이 더 메이저 해보이니 그쪽으로 수정 예정
    public Mono<ServerResponse> hideReply(ServerRequest req) {
        JSONObject obj = req.bodyToMono(JSONObject.class).toProcessor().peek();
//        HashMap<String,Object> jsonMap = new ObjectMapper().readValue(obj, HashMap.class);
//        Integer id =

        return (Mono<ServerResponse>) ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON);
    }
}
