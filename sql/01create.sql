CREATE DATABASE spring_blog;
CREATE TABLE member(
    id INT PRIMARY KEY AUTO_INCREMENT,
    member_id VARCHAR(20) NOT NULL,
    password VARCHAR(20) NOT NULL ,
    email1 VARCHAR(20),
    email2 VARCHAR(20),
    birth VARCHAR(20),
    phone VARCHAR(20)
);

Drop table member;

SELECT * FROM member;