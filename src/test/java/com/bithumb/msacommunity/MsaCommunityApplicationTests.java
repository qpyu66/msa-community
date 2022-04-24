package com.bithumb.msacommunity;

import com.bithumb.msacommunity.domain.Board;
import com.bithumb.msacommunity.service.BoardService;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Date;

@SpringBootTest
class MsaCommunityApplicationTests {

    private final BoardService boardService;

    MsaCommunityApplicationTests(BoardService boardService) {
        this.boardService = boardService;
    }

    @Test
    void contextLoads() {
    }

//    @Test
//    public void save() {
//        Board b = new Board(2,"t2","c2",1,"2","" ,"");
//        Mono<Board> profileMono = this.boardService.saveBoard(b);
//        StepVerifier
//                .create(profileMono)
//                .expectNextMatches(saved -> StringUtils.hasText(String.valueOf(saved.getId())))
//                .verifyComplete();
//    }

}
