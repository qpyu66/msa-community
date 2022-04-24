package com.bithumb.msacommunity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
public class MsaCommunityApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsaCommunityApplication.class, args);
    }

}
