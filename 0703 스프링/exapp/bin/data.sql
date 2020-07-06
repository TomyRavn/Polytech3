
--회원 정보(member) 저장을 위한 테이블 생성
--회원 아이디 mem_id  문자열(최대 : 50 바이트)
--회원 비밀번호 mem_pass  문자열(최대 : 50 바이트)
--회원 이름 mem_name  문자열(최대 : 50 바이트)
--회원 포인트 mem_point  숫자(최대 : 10자리 정수)
CREATE TABLE member (
mem_id VARCHAR2(50),
mem_pass VARCHAR2(50),
mem_name VARCHAR2(50),
mem_point NUMBER(10,0),
PRIMARY KEY (mem_id)
);

INSERT INTO member
(mem_id, mem_pass, mem_name, mem_point)
VALUES
('a001','1234','고길동',100);

--//a001 회원의 포인트를 777로 변경하는 프로그램을 작성하세요.
UPDATE member SET mem_point = 77 where MEM_ID = 'a001';
commit;

SELECT * FROM MEMBER;

SELECT mem_id, mem_pass, mem_name, mem_point FROM MEMBER;
SELECT * FROM MEMBER;


CREATE TABLE student (
stu_no VARCHAR2(50), --학번
stu_name VARCHAR2(50), --이름
stu_score NUMBER(10,0), --성적
PRIMARY KEY (stu_no)
);

SELECT * FROM student
