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

USE prj1;
select *
FROM member
order by id DESC;


CREATE TABLE board
(
    id       INT PRIMARY KEY AUTO_INCREMENT,
    title    VARCHAR(200)  NOT NULL,
    content  VARCHAR(3000) NOT NULL,
    writer   VARCHAR(100)  NOT NULL,
    inserted DATETIME      NOT NULL DEFAULT NOW()
);

SELECT *
FROM board
ORDER BY id desc;

DELETE
FROM board
where id = 1466;

SELECT COUNT(*)
FROM board
WHERE title LIKE '%123%';

show index from PRJ1.member;

SELECT b.id, b.title, b.content, b.inserted, m.nick_name writer, m.id member_id
FROM board b
         JOIN member m
              ON b.member_id = m.id
WHERE b.id = 1476;

SELECT COUNT(*)
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
FROM member
ORDER BY id DESC;

DELETE
FROM member
WHERE email = 'kyb-0215@naver.com';

INSERT INTO authority (member_id, name)
VALUES (48, 'admin');
