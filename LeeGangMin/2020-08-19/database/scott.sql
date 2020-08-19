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