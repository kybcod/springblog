CREATE DATABASE blog;

USE blog;
CREATE TABLE member
(
    id        INT PRIMARY KEY AUTO_INCREMENT,
    email     VARCHAR(200) NOT NULL UNIQUE,
    password  VARCHAR(200) NOT NULL,
    nick_name VARCHAR(100) NOT NULL UNIQUE,
    inserted  DATETIME     NOT NULL DEFAULT NOW()
);

select *
FROM member;

CREATE TABLE board
(
    id       INT PRIMARY KEY AUTO_INCREMENT,
    title    VARCHAR(200)  NOT NULL,
    content  VARCHAR(3000) NOT NULL,
    writer   VARCHAR(100)  NOT NULL,
    inserted DATETIME      NOT NULL DEFAULT NOW()
);

SELECT *
FROM board;


ALTER TABLE board
    ADD COLUMN member_id INT REFERENCES member (id);

UPDATE board
SET member_id = 8
WHERE id > 0;

ALTER TABLE board
    DROP COLUMN writer;

USE prj1;

CREATE TABLE authority
(
    id        INT PRIMARY KEY AUTO_INCREMENT,
    member_id INT         NOT NULL REFERENCES member (id),
    name      VARCHAR(20) NOT NULL
);

SELECT *
FROM authority;

SELECT *
FROM member m
         LEFT JOIN authority a on m.id = a.member_id;
SELECT *
FROM member;

DELETE
FROM member
WHERE email = 'kyb-0215@naver.com';

INSERT INTO authority (member_id, name)
VALUES (48, 'admin');
