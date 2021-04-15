-- bit(0,1),tinyint(小范围整数),int,bigint,long
-- date 年月日 datetime 年月日时分秒
-- varchar
-- 主键：不能重复，不能有null
create table `user`(
`id` BIGINT auto_increment,
`name` varchar(200) not null DEFAULT '',
`gender` TINYINT(1) not null DEFAULT 1,
`birthday` date,
`age` int(3) not null default 1,
PRIMARY KEY(`id`)
);

insert into `user` VALUES (default,'史密斯',1,'1991-01-02',29)

select * from user

commit;

insert into `user` VALUES
(default,'bob',1,'1995-03-22',25),
(default,'lucy',0,'1991-12-11',29),
(default,'allen',1,'1993-09-30',27),
(default,'ella',0,'1992-05-02',28),
(default,'mike',1,'1994-01-23',26)

insert into `user`(id,name,gender,birthday,age) VALUES
(default,'bob',1,'1995-03-22',25),
(default,'lucy',0,'1991-12-11',29),
(default,'allen',1,'1993-09-30',27),
(default,'ella',0,'1992-05-02',28),
(default,'mike',1,'1994-01-23',26)

set autocommit=off