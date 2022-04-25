package com.bithumb.msacommunity.webclient;

import com.bithumb.msacommunity.domain.UserDTO;
import com.bithumb.msacommunity.repository.ReplyRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;

@Component
public class CommunityWebClient {

    private final WebClient client;
    public CommunityWebClient() {
        this.client = WebClient.create("http://localhost:8081");
    }

    public Mono<UserDTO> getMemberInfo(Integer memId) {

        Mono result = client.get()
                .uri("/member/findMemberInfo/"+memId)
                .retrieve()
                .bodyToMono(UserDTO.class);

        return result;

    }

}
