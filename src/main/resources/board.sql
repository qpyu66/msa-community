CREATE TABLE IF NOT EXISTS board
(
    id        int          NOT NULL AUTO_INCREMENT COMMENT '게시글 아이디',
    title     varchar(255) NOT NULL COMMENT '게시글 제목',
    content   TEXT         NOT NULL COMMENT '게시글 내용',
    visibleYn int      DEFAULT '0' COMMENT '게시글 노출 여부 y-0, n-1',
    memberId  int          NOT NULL COMMENT '작성자',
    insertDt  datetime DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
    updateDt  datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일',
    PRIMARY KEY (id)
);

INSERT INTO board (id,title,content,visibleYn,memberId,insertDt,updateDt)
VALUES (1,'title1','content1',0,'1',now(),NULL);

INSERT INTO board (id,title,content,visibleYn,memberId,insertDt,updateDt)
VALUES (2,'title2','content1',0,'1',now(),NULL);

INSERT INTO board (id,title,content,visibleYn,memberId,insertDt,updateDt)
VALUES (3,'title3','content1',1,'1',now(),NULL);

INSERT INTO board (id,title,content,visibleYn,memberId,insertDt,updateDt)
VALUES (4,'title4','content1',0,'1',now(),NULL);

INSERT INTO board (id,title,content,visibleYn,memberId,insertDt,updateDt)
VALUES (5,'title5','content1',0,'1',now(),NULL);


