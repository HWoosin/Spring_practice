
# 해당 계정이 어떤 데이터베이스를 사용할 지 영시하는 문장
use spring;

drop table scores;
create table scores(
	stu_id int primary key auto_increment,
    stu_name varchar(30) not null,
    kor int default 0,
    eng int default 0,
    math int default 0,
    total int default 0,
    average decimal(5, 2)
);

select * from scores;

create table jdbc_board(
	board_no int primary key auto_increment,
    writer varchar(30) not null,
    title varchar(100) not null,
    content varchar(2000),
    reg_date datetime default current_timestamp
);


CREATE TABLE freeboard(
	bno INT PRIMARY KEY AUTO_INCREMENT,
   title VARCHAR(300) NOT NULL,
   writer VARCHAR(50) NOT NULL,
   content VARCHAR(3000) NOT NULL,
   reg_date DATETIME DEFAULT CURRENT_TIMESTAMP,
   update_date DATETIME DEFAULT NULL
);
select * from freeboard;

delete from freeboard;

create user 'spring'@localhost identified by 'spring';

grant all privileges on spring.* to spring@localhost;

select * from freeboard
order by bno desc
limit 0, 20;

create table users (
	user_id varchar(50) primary key,
    user_pw varchar(100) not null,
    user_name varchar(50) not null,
    user_phone1 varchar(50),
    user_phone2 varchar(50),
    user_email1 varchar(50),
    user_email2 varchar(50),
    addr_basic varchar(300),
    addr_detail varchar(300),
    addr_zip_num varchar(50),
    reg_date datetime default current_timestamp
);
use spring;
delete from users where user_id =' ';
drop table user;
select * from users;
select * from users where user_id = '321321';

select 
	user_name, user_phone1, user_phone2, user_email1, user_email2, 
    addr_basic, addr_detail, addr_zip_num,
    f.bno, f.title, f.reg_date
from users u 
left join freeboard f on u.user_id = f.writer
where u.user_id = 'abc1234'
order by f.bno desc
limit 0, 10;

create table freereply(
	rno int primary key auto_increment,
    bno int,
    reply varchar(1000),
    reply_id varchar(50),
    reply_pw varchar(50),
    replay_date datetime default current_timestamp,
    update_date datetime default null,
    
    constraint reply_bno_fk foreign key 
    (bno) references freeboard(bno) on delete cascade #원본 글이 지워져도 댓글이 지워지기 가능하게끔
);


