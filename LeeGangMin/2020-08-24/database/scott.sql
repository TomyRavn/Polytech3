SELECT * FROM dept_tcl;
--트랜젝션 : 일을 하는 하나의 단위, 작업 단위(더 이상 분할할 수 없는 최소 수행 단위)

--1. dept 테이블의 모든 내용을 복사해서 테이블이름은 dept_tcl로 테이블을 생성
create table dept_tcl
as select * from dept;

--2. 50번 부서 DATABASE 부서, SEOUL을 dept_tcl 테이블에 삽입
INSERT INTO dept_tcl(DEPTNO, DNAME, LOC) VALUES(50, 'DATABASE', 'SEOUL');
INSERT INTO dept_tcl VALUES(50, 'DATABASE', 'SEOUL');

--3. 40번 부서의 주소를 BUSAN으로 변경
UPDATE dept_tcl SET LOC = 'BUSAN' WHERE DEPTNO = 40;

--4. 부서명이 RESEARCH인 부서를 삭제
DELETE FROM dept_tcl WHERE DNAME = 'RESEARCH';

--5. ROLLBACK
ROLLBACK;

--6. DEPT_TCL 테이블에 50, NETWORK, SEOUL 정보 삽입
INSERT INTO dept_tcl VALUES(50, 'NETWORK', 'SEOUL');

--7. 20번 부서 위치:BUSAN으로 변경
UPDATE dept_tcl SET LOC = 'BUSAN' WHERE DEPTNO = 20;

--8. 40번 부서 삭제
DELETE FROM dept_tcl WHERE DEPTNO = 40;

--9. 내용 확인
SELECT * FROM dept_tcl;

--10. 실행완료
COMMIT;

--11. 내용확인
SELECT * FROM dept_tcl;

--12. 더미데이터 삽입
INSERT INTO dept_tcl VALUES(55, 'PROGRAMMING', 'DAEJEON');
DELETE FROM dept_tcl WHERE deptno = 55;

--13. 30번 부서 주소 SEOUL로 변경
UPDATE dept_tcl SET LOC = 'SEOUL' WHERE deptno = 30;
UPDATE dept_tcl SET LOC = 'DAEJEON' WHERE deptno = 30;

--14.
DELETE FROM dept_tcl;

CREATE TABLE dept_hw as SELECT * FROM dept;

SELECT * FROM dept_hw;

-- DML을 해놓고 COMMIT 하지 않아도 DDL 명령이 발생할 경우 DDL 명령 즉시 실행

---------------------------------------------------------------------
--12강
--1. 테이블 생성
--(이름 : EMP_DDL, EMPNO : 숫자 4자리, ENAME : 가변형 문자 10, JOB : 가변형 문자 9
-- MGR: 숫자 4, HIREDATE : 날짜, SAL : 전체 7자리 소수이하 2자리(7,2),
-- COMM : 전체 7자리 소수이하 2자리, DEPTNO : 숫자 2자리)

CREATE TABLE EMP_DDL(
  EMPNO NUMBER(4) PRIMARY KEY,
  ENAME VARCHAR2(10),
  JOB VARCHAR2(9),
  MGR NUMBER(4),
  HIREDATE DATE,
  SAL NUMBER(7,2),
  COMM NUMBER(7,2),
  DEPTNO NUMBER(2)
);

--2. 확인
desc emp_ddl;

SELECT * FROM emp_ddl;

--3. DEPT 테이블과 동일한 DEPT_DDL 테이블 생성(내용 포함)
CREATE TABLE DEPT_DDL AS SELECT * FROM DEPT;

--4. 확인
DESC DEPT_DDL;
SELECT * FROM DEPT_DDL;

--5. EMP 테이블의 30번 부서의 내용만 가져와서 EMP_DDL_30 테이블 생성
CREATE TABLE EMP_DDL_30 AS SELECT * FROM EMP WHERE DEPTNO = 30;
SELECT * FROM EMP_DDL_30;

--6. EMP, DEPT 테이블 중 EMPNO, ENAME, JOB, MGR, HIREDATE ,SAL, COMM, DEPTNO,
--   DNAME, LOC 속성만으로 EMPDEPT_DDL 테이블 생성하되 값은 가져오지 않기
CREATE TABLE EMPDEPT_DDL AS 
                            SELECT E.EMPNO, E.ENAME, E.JOB, E.MGR, E.HIREDATE, E.SAL, E.COMM, E.DEPTNO, D.DNAME, D.LOC
                            FROM EMP E, DEPT D
                            WHERE 1 <> 1;
                            
SELECT * FROM EMPDEPT_DDL;               

--7. EMP와 동일한 EMP_ALTER 테이블 생성
CREATE TABLE EMP_ALTER AS SELECT * FROM EMP;
SELECT * FROM EMP_ALTER;

--8. EMP_ALTER 테이블의 HP라는 속성을 가변형 20자로 추가
ALTER TABLE EMP_ALTER
ADD HP VARCHAR2(20);
--내용 확인
SELECT * FROM EMP_ALTER;

--9. EMP_ALTER 테이블의 HP 속성을 TEL로 이름변경
ALTER TABLE EMP_ALTER RENAME COLUMN HP TO TEL;

--추가.
ALTER TABLE EMP_ALTER MODIFY EMPNO NUMBER(5);

--10. EMP_ALTER 테이블의 이름을 EMP_RENAME으로 이름 변경
RENAME EMP_ALTER TO EMP_RENAME;
SELECT * FROM EMP_ALTER;
SELECT * FROM EMP_RENAME;

--11. EMP_RENAME 테이블 내용 지우되 자동 COMMIT
TRUNCATE TABLE EMP_RENAME;
SELECT * FROM EMP_RENAME;

--12. EMP_RENAME 테이블 삭제
DROP TABLE EMP_RENAME;
SELECT * FROM EMP_RENAME;

--Q
CREATE TABLE EMP_HW(
  EMPNO NUMBER(4),
  ENAME VARCHAR2(10),
  JOB VARCHAR2(9),
  MGR NUMBER(4),
  HIREDATE DATE,
  SAL NUMBER(7,2),
  COMM NUMBER(7,2),
  DEPTNO NUMBER(2)
);

ALTER TABLE EMP_HW ADD BIGO VARCHAR2(20);

ALTER TABLE EMP_HW MODIFY BIGO VARCHAR2(30);

ALTER TABLE EMP_HW RENAME COLUMN BIGO TO REMARK;

SELECT * FROM EMP_HW;
SELECT * FROM EMP;

INSERT INTO EMP_HW(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) SELECT * FROM EMP;


----------------------------------------------------------------------------------

--1. 사용자가 만든 테이블 조회(SCOTT이 만든 TABLE)
SELECT *
FROM USER_TABLES;

SELECT TABLE_NAME
FROM USER_TABLES;

--2.
SELECT *
FROM DICT;

SELECT *
FROM DICTIONARY;

--3. 내 계정으로 확인 가능한(접근 가능한) 테이블들
SELECT * FROM ALL_TABLES;

--4. DBA가 관리하는 테이블들
SELECT * FROM DBA_TABLES;

--5. 내 계정의 인덱스들 확인
SELECT *
FROM USER_INDEXES;

--6. SYS접속, 사용자명이 SCOTT에 대한 정보 확인
SELECT *
FROM DBA_USERS
WHERE USERNAME='SCOTT';

--7. SCOTT 계정 INDEX 만들어진 열 확인
SELECT *
FROM USER_IND_COLUMNS;

--8. SCOTT EMP테이블의 SAL 속성을 기준으로 인덱스 생성, 인덱스명 : IDX_EMP_SAL
CREATE TABLE EMP1
AS SELECT * FROM EMP;

--9. SCOOT 계정 EMP1 테이블의 SAL 속성을 기준으로 인덱스 생성, 인덱스 명 : IDX_EMP1_SAL
CREATE INDEX IDX_EMP1_SAL 
ON EMP1(SAL);

--10. 
SELECT *
FROM EMP1;

SELECT SAL
FROM EMP1;

--11. 인덱스 확인
SELECT *
FROM USER_INDEXES;

--12. 인덱스 삭제
DROP INDEX IDX_EMP1_SAL;

--13. SYS계정에서, SCOTT에게 VIEW생성 권한 주기
GRANT CREATE VIEW TO SCOTT;

--14. SCOTT계정 EMP테이블에서 사원번호, 이름, 직업, 부서번호 이용해서 VW_EMP20으로 뷰 생성
CREATE VIEW VW_EMP20
AS (SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE DEPTNO=20);

--15. 뷰 확인
SELECT * FROM USER_VIEWS;
SELECT * FROM VW_EMP20;

--16. 뷰 텍스트 확인
SELECT TEXT FROM USER_VIEWS;

--17. VW_EMP20 뷰 삭제
DROP VIEW VW_EMP20;

--18. 삭제 조회
SELECT * FROM VW_EMP20;

--19. ROWNUM : 줄 번호
SELECT ROWNUM, E.*
FROM EMP E;

--20. 봉급 역순으로 정렬해서 출력하는데 줄번호와 함께 출력(줄번호가 먼저 붙여지고(검색이 먼저 되고), 정렬이 됨)
SELECT ROWNUM, E.*
FROM EMP E
ORDER BY SAL DESC;

--21. 정렬(봉급 역순) 후 줄번호 부여
SELECT ROWNUM, E.*
FROM (SELECT *
      FROM EMP
      ORDER BY SAL DESC) E;
      
--22. 부서번호 순, 같은 부서이면 이름순 정렬해서 번호 부여
SELECT ROWNUM, E.*
FROM (SELECT *
      FROM EMP
      ORDER BY DEPTNO, ENAME) E;
      
--23. 입사일 순 정렬, 번호 부여
SELECT ROWNUM, E.*
FROM (SELECT *
      FROM EMP
      ORDER BY HIREDATE) E;
      
--24. WITH 사용해 23번과 동일하게
WITH E AS(SELECT * FROM EMP ORDER BY HIREDATE)
SELECT ROWNUM, E.*
FROM E;

--25. 23번 응용 예제, 최고 3위까지 출력
SELECT ROWNUM, E.*
FROM (SELECT *
      FROM EMP
      ORDER BY HIREDATE) E
WHERE ROWNUM <= 3;

--26. DEPT 테이블을 복사해서 DEPT2 생성
CREATE TABLE DEPT2
AS SELECT *
   FROM DEPT
WHERE 1<>1;

SELECT * FROM DEPT2;

--27. SEQUENCE SEQ_DEPT2 생성, 증가값 : 10 초기값 : 10, 최대치 : 90, 
--    최소치 : 0, 반복 X, 캐쉬 : 2
CREATE SEQUENCE SEQ_DEPT2
INCREMENT BY 10
START WITH 10
MAXVALUE 90
MINVALUE 0
NOCYCLE
CACHE 2;
-- NOCYCLE : 10을 넘어설 수 없으므로 최대치인 90이 되면 ERROR가 발생
-- CYCLE : 다시 초기값인 10으로 돌아가서 반복

--28. USER_SEQUENCES 테이블 내용 확인
SELECT *
FROM USER_SEQUENCES;

--29. DEPT2테이블에 SEQ_DEPT2.NEXTVAL, 'DATABASE', 'SEOUL'를 삽입하기
SELECT *
FROM DEPT2;

--9번 반복 실행
INSERT INTO DEPT2 VALUES(SEQ_DEPT2.NEXTVAL, 'DATABASE', 'SEOUL');

--30. 현재 SEQ_DEPT2.CURRVAL 확인
SELECT SEQ_DEPT2.CURRVAL FROM dual;

--31. 시퀀스 CYCLE로 변경 ; 99 초과시 최소치인 0으로 돌아감
ALTER SEQUENCE SEQ_DEPT2 
INCREMENT BY 3
MAXVALUE 99
CYCLE;

--32. INSERT 문장을 3번 추가 후 SELECT * FROM DEPT2; 확인

--33. SEQ_DEPT2 삭제
DROP SEQUENCE SEQ_DEPT2;

SELECT *
FROM USER_SEQUENCES;


----------------------------------------
SELECT D.*, E.ENAME, E.DEPTNO, D.DNAME, E.SAL
FROM EMP E,DEPT D
WHERE E.DEPTNO = D.DEPTNO(+);