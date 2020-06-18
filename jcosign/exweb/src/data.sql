
SELECT * FROM MEMBER;

SELECT mem_id, mem_pass, mem_name, mem_point FROM member;

SELECT * FROM student;
--학생테이블
CREATE TABLE student (
stu_no VARCHAR29(50),	--학번
stu_name VARCHAR2(50),	--이름
stu_score NUMBER(10,0),	--성적
PRIMARY KEY (stu_no)
);

-- 게시판
CREATE TABLE bbs(
bbs_no NUMBER(10,0),	--글번호
bbs_title VARCHAR2(100),	--글제목
bbs_content CLOB,	--글내용
bbs_writer VARCHAR2(50),	--작성자의 ID
bbs_reg_date DATE DEFAULT SYSDATE,	--글등록일(작성일)
bbs_count NUMBER(10,0) DEFAULT 0,	--조회수
PRIMARY KEY (bbs_no),
FOREIGN KEY (bbs_writer) REFERENCES member (mem_id)
);	--글최종수정일,작성자접속IP주소,....

insert into bbs(bbs_no,bbs_title, bbs_content, bbs_writer)
values(seq_bbs_no.NEXTVAL,'테스트제목','테스트내용','a001');

SELECT * FROM bbs;
SELECT bbs_no, bbs_title, bbs_writer, bbs_reg_date, bbs_count FROM bbs;

--시퀀스 (게시판 글번호를 위한 자동증가 정수값 생성)
CREATE SEQUENCE seq_bbs_no;

SELECT seq_bbs_no.NEXTVAL FROM DUAL;	--시퀀스의 다음값(증가된 값) 가져오기
SELECT seq_bbs_no.CURRVAL FROM DUAL;	--시퀀스의 현재값 가져오기