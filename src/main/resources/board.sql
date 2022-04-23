CREATE TABLE IF NOT EXISTS board
(
    id      int          NOT NULL AUTO_INCREMENT COMMENT '커뮤니티 아이디',
    title   varchar(255) NOT NULL COMMENT '커뮤니티 제목',
    content TEXT         NOT NULL COMMENT '커뮤니티 내용',
    visibleYn  int      DEFAULT '0' COMMENT '커뮤니티 노출 여부 y-0, n-1',
    memberId         varchar(100) NOT NULL COMMENT '작성자',
    insertDt         datetime DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
    updateDt         datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일',
    PRIMARY KEY (id)
);

INSERT INTO board (id,title,content,visibleYn,memberId,insertDt,updateDt)
VALUES (1,'title1','content1',0,'1','2022-04-23 21:11:46',NULL);


