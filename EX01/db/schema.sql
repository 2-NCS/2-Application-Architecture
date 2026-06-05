-- B-Member 회원 관리 스키마
-- MySQL testdb 에 직접 실행한다. (localhost:3306 / root / 1234)

DROP TABLE IF EXISTS tbl_member;

CREATE TABLE tbl_member (
    id       BIGINT       NOT NULL AUTO_INCREMENT,
    name     VARCHAR(50),
    email    VARCHAR(100),
    phone    VARCHAR(20),
    createAt TIMESTAMP,
    PRIMARY KEY (id)
);

-- seed 3건
INSERT INTO tbl_member VALUES (null, '김철수', 'kim@example.com', '010-1111-2222', now());
INSERT INTO tbl_member VALUES (null, '이영희', 'lee@example.com', '010-3333-4444', now());
INSERT INTO tbl_member VALUES (null, '박민수', 'park@example.com', '010-5555-6666', now());
