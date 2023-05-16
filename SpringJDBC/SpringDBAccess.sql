
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

delete from freeboard where bno =7;

create user 'spring'@localhost identified by 'spring';

grant all privileges on spring.* to spring@localhost;
