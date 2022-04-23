CREATE TABLE IF NOT EXISTS reply
(
    replyId        int NOT NULL AUTO_INCREMENT COMMENT '댓글 아이디',
    boardId        int NOT NULL COMMENT '커뮤니티 아이디',
    memberId       int NOT NULL COMMENT '작성자 아이디',
    replyContent text NOT NULL COMMENT '댓글 내용',
    replyVisibleYn  int      DEFAULT NULL COMMENT '댓글 노출 여부 y-0, n-1',
    insertDt       datetime DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
    updateDt       datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일',
    PRIMARY KEY (replyId)
);


INSERT INTO reply (replyId,boardId,memberId,replyContent,replyVisibleYn,insertDt,updateDt)
VALUES (1,1,1,'test',0,'2022-04-23 21:00:23',NULL);