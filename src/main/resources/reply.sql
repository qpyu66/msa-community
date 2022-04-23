CREATE TABLE IF NOT EXISTS reply
(
    `replyId`        int NOT NULL AUTO_INCREMENT COMMENT '댓글 아이디',
    `boardId`        int NOT NULL COMMENT '커뮤니티 아이디',
    `memberId`       int NOT NULL COMMENT '작성자 아이디',
    `commentContent` text NOT NULL COMMENT '댓글 내용',
    `commentShowYN`  int      DEFAULT NULL COMMENT '댓글 노출 여부',
    `insertDt`       datetime DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
    `updateDt`       datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일',
    PRIMARY KEY (`replyId`)
);


-- INSERT INTO reply()
-- VALUES (  );