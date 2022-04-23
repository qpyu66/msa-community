CREATE TABLE IF NOT EXISTS boardList
(
    num     int     NOT NULL AUTO_INCREMENT,
    title  VARCHAR(100)    NOT NULL,
    memberId    VARCHAR(100) NOT NULL,
    createDt    datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '생성 날짜',
    updateDt    datetime    DEFAULT CURRENT_TIMESTAMP COMMENT '수정 날짜',
    readCount   int         NOT NULL COMMENT '조회수',
    PRIMARY KEY (num)
);

INSERT INTO boardList (title, memberId, createDt, updateDt, readCount)
VALUES ('Title 1', 'member 1', now(), now(), 0);

INSERT INTO boardList (title, memberId, createDt, updateDt, readCount)
VALUES ('Title 2', 'member 2', now(), now(), 0);

INSERT INTO boardList (title, memberId, createDt, updateDt, readCount)
VALUES ('Title 3', 'member 3', now(), now(), 0);

INSERT INTO boardList (title, memberId, createDt, updateDt, readCount)
VALUES ('Title 4', 'member 3', now(), now(), 0);
