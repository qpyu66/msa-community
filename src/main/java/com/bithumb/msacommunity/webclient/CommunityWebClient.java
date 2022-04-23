package com.bithumb.msacommunity.webclient;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class CommunityWebClient {

    private final WebClient client;
    public CommunityWebClient(WebClient.Builder builder) {
        this.client = builder.baseUrl("http://localhost:8082").build();
    }

}
