-- 회원 정보(member) 저장을 위한 테이블 생성
-- 회원 아이디 : mem_id // 문자열 : 최대 50바이트(16자 정도)
-- 회원 비밀번호 : mem_pass //문자열 : 최대 50바이트
-- 회원 이름 : mem_name // 문자열 : 최대 50바이트
-- 회원 포인트 : mem_point // 숫자 : 최대 10자리 정수
-- NUMBER(자릿수, 소수점이하 자릿수)
-- id 중복 방지(기본 키 입력 -> 기본 키가 있어야 추후 테이블 관리에 편리)
-- 꼭 필요하지 않아도 만들어주는 습관을 들일 것
-- 정식으로는 CONSTRAINT 제약조건명 도 붙여주는 게 맞음

CREATE TABLE member (
mem_id VARCHAR2(50),
mem_pass VARCHAR2(50),
mem_name VARCHAR2(50),
mem_point NUMBER(10,0),
PRIMARY KEY (mem_id)
);

INSERT INTO member
(mem_id, mem_pass, mem_name, mem_point) --데이터를 삽입할 컬럼명
VALUES
('a001', '1234', '고길동', 100);

UPDATE member SET mem_point = 555 where mem_id = 'a001';

select * from member;

--다른 사용자가 내가 INSERT한 자료를 볼 수 있게 함(자바에서 변경 후 COMMIT을 한번 하고 자바에서 재실행)
COMMIT;

CREATE TABLE student (
stu_no VARCHAR2(50),
stu_name VARCHAR2(50),
stu_score NUMBER(10, 0),
PRIMARY KEY (stu_no)
);

select * from student;

--게시판 테이블
CREATE TABLE bbs(
bbs_no NUMBER(10, 0),		--글번호	//자동으로 입력됨
bbs_title VARCHAR2(150),	--글제목
bbs_content CLOB,			--글내용
bbs_writer VARCHAR2(50),	--작성자(아이디)
bbs_reg_date DATE DEFAULT SYSDATE,			--글 등록일(작성일/시,분,초까지 저장)	//자동으로 입력됨
bbs_count NUMBER(10, 0) DEFAULT 0,	--조회수							//자동으로 입력됨
PRIMARY KEY ( bbs_no ),
FOREIGN KEY ( bbs_writer ) REFERENCES member (mem_id)	--작성자는 멤버 아이디를 참조한다
);									--글최종수정일, 작성자접속IP주소, ... 등

select * from bbs;

insert into bbs(bbs_no, bbs_title, bbs_content, bbs_writer)
values(seq_bbs_no.NEXTVAL, '테스트제목', '테스트내용', 'a001');

ALTER TABLE bbs ADD(bbs_edit_date DATE DEFAULT SYSDATE);

--자동으로 입력되게 하는 방법 : SEQUENCE (자동 증가하는 숫자 생성)
--시퀀스 (게시판 글번호를 위한 자동증가 정수값 생성)
CREATE SEQUENCE seq_bbs_no;

select seq_bbs_no.NEXTVAL from dual;	--시퀀스의 다음값(증가된 값) 가져오기
select seq_bbs_no.CURRVAL from dual;	--시퀀스의 현재값 가져오기

delete from bbs where bbs_no = 33;
