use spring;
show databases;
create database spring;
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
select *from jdbc_board;
Select * from jdbc_board order by board_no desc;



drop user 'spring'@localhost;
create user 'spring'@localhost identified by 'spring';

grant all privileges on spring.* to spring@localhost;

show grants for spring@localhost;