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

    @Test
    void contextLoads() {
    }

}
