-- BOARD 게시판 테이블 생성
create table board(
	idx int not null auto_increment,
	title varchar(100) not null,
	content varchar(2000) not null,
	writer varchar(100) not null,
	indate datetime default now(),
	count int default 0,
	primary key(idx)
);


-- test 데이터 넣기
insert into board(
	title,
	content,
	writer
)
values(
	"주술회전 개잼씀",
	"유우지 제발 정신 좀 차려..",
	"후시구로 메구미"
);

insert into board(
	title,
	content,
	writer
)
values(
	"주술회전 개재미없음",
	"유우지 개약함...",
	"독자"
);

insert into board(
	title,
	content,
	writer
)
values(
	"애니는 귀멸의 칼날이지..",
	"유우지 뭐하는데..",
	"렌고쿠 쿄쥬로"
);

select *
  from board;
  
  
 drop table member;
  
 -- 회원 테이블 만들기
 CREATE TABLE MEMBER(
 	memIdx int auto_increment,
 	memId varchar(20) not null unique,
 	memPw varchar(20) not null,
 	memName varchar(20) not null,
 	memAge int,
 	memGender varchar(20),
 	memEmail varchar(20),
 	memProfile varchar(100),
 	primary key (memIdx)
 ); 
  
 insert into member(
 	memId,
 	memPw,
 	memName,
 	memAge,
 	memGender,
 	memEmail
 )value(
 	"noh",
 	"1234",
 	"노은비",
 	"23",
 	"female",
 	"noh@naver.com"
 );
 
  
 select *
   from member;
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  