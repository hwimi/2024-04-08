--유저 생성 구문
create user 'javaUser'@'localhost'indentified by'mysql';

--db생성
create database javadb;

--유저권한 부여
grant all privileges on javadb.*to 'javaUser'@'localhost' with grant option;
flush privileges;

--상품등록
create table product(
pno int not null auto increment,
pname varchar(50) not null,
price int not null default(),
regdate datetime default now(),
madeby text,
primary key(pno));