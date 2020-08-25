SELECT * FROM dept_tcl;
--Ʈ������ : ���� �ϴ� �ϳ��� ����, �۾� ����(�� �̻� ������ �� ���� �ּ� ���� ����)

--1. dept ���̺��� ��� ������ �����ؼ� ���̺��̸��� dept_tcl�� ���̺��� ����
create table dept_tcl
as select * from dept;

--2. 50�� �μ� DATABASE �μ�, SEOUL�� dept_tcl ���̺� ����
INSERT INTO dept_tcl(DEPTNO, DNAME, LOC) VALUES(50, 'DATABASE', 'SEOUL');
INSERT INTO dept_tcl VALUES(50, 'DATABASE', 'SEOUL');

--3. 40�� �μ��� �ּҸ� BUSAN���� ����
UPDATE dept_tcl SET LOC = 'BUSAN' WHERE DEPTNO = 40;

--4. �μ����� RESEARCH�� �μ��� ����
DELETE FROM dept_tcl WHERE DNAME = 'RESEARCH';

--5. ROLLBACK
ROLLBACK;

--6. DEPT_TCL ���̺� 50, NETWORK, SEOUL ���� ����
INSERT INTO dept_tcl VALUES(50, 'NETWORK', 'SEOUL');

--7. 20�� �μ� ��ġ:BUSAN���� ����
UPDATE dept_tcl SET LOC = 'BUSAN' WHERE DEPTNO = 20;

--8. 40�� �μ� ����
DELETE FROM dept_tcl WHERE DEPTNO = 40;

--9. ���� Ȯ��
SELECT * FROM dept_tcl;

--10. ����Ϸ�
COMMIT;

--11. ����Ȯ��
SELECT * FROM dept_tcl;

--12. ���̵����� ����
INSERT INTO dept_tcl VALUES(55, 'PROGRAMMING', 'DAEJEON');
DELETE FROM dept_tcl WHERE deptno = 55;

--13. 30�� �μ� �ּ� SEOUL�� ����
UPDATE dept_tcl SET LOC = 'SEOUL' WHERE deptno = 30;
UPDATE dept_tcl SET LOC = 'DAEJEON' WHERE deptno = 30;

--14.
DELETE FROM dept_tcl;

CREATE TABLE dept_hw as SELECT * FROM dept;

SELECT * FROM dept_hw;

-- DML�� �س��� COMMIT ���� �ʾƵ� DDL ����� �߻��� ��� DDL ��� ��� ����

---------------------------------------------------------------------
--12��
--1. ���̺� ����
--(�̸� : EMP_DDL, EMPNO : ���� 4�ڸ�, ENAME : ������ ���� 10, JOB : ������ ���� 9
-- MGR: ���� 4, HIREDATE : ��¥, SAL : ��ü 7�ڸ� �Ҽ����� 2�ڸ�(7,2),
-- COMM : ��ü 7�ڸ� �Ҽ����� 2�ڸ�, DEPTNO : ���� 2�ڸ�)

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

--2. Ȯ��
desc emp_ddl;

SELECT * FROM emp_ddl;

--3. DEPT ���̺�� ������ DEPT_DDL ���̺� ����(���� ����)
CREATE TABLE DEPT_DDL AS SELECT * FROM DEPT;

--4. Ȯ��
DESC DEPT_DDL;
SELECT * FROM DEPT_DDL;

--5. EMP ���̺��� 30�� �μ��� ���븸 �����ͼ� EMP_DDL_30 ���̺� ����
CREATE TABLE EMP_DDL_30 AS SELECT * FROM EMP WHERE DEPTNO = 30;
SELECT * FROM EMP_DDL_30;

--6. EMP, DEPT ���̺� �� EMPNO, ENAME, JOB, MGR, HIREDATE ,SAL, COMM, DEPTNO,
--   DNAME, LOC �Ӽ������� EMPDEPT_DDL ���̺� �����ϵ� ���� �������� �ʱ�
CREATE TABLE EMPDEPT_DDL AS 
                            SELECT E.EMPNO, E.ENAME, E.JOB, E.MGR, E.HIREDATE, E.SAL, E.COMM, E.DEPTNO, D.DNAME, D.LOC
                            FROM EMP E, DEPT D
                            WHERE 1 <> 1;
                            
SELECT * FROM EMPDEPT_DDL;               

--7. EMP�� ������ EMP_ALTER ���̺� ����
CREATE TABLE EMP_ALTER AS SELECT * FROM EMP;
SELECT * FROM EMP_ALTER;

--8. EMP_ALTER ���̺��� HP��� �Ӽ��� ������ 20�ڷ� �߰�
ALTER TABLE EMP_ALTER
ADD HP VARCHAR2(20);
--���� Ȯ��
SELECT * FROM EMP_ALTER;

--9. EMP_ALTER ���̺��� HP �Ӽ��� TEL�� �̸�����
ALTER TABLE EMP_ALTER RENAME COLUMN HP TO TEL;

--�߰�.
ALTER TABLE EMP_ALTER MODIFY EMPNO NUMBER(5);

--10. EMP_ALTER ���̺��� �̸��� EMP_RENAME���� �̸� ����
RENAME EMP_ALTER TO EMP_RENAME;
SELECT * FROM EMP_ALTER;
SELECT * FROM EMP_RENAME;

--11. EMP_RENAME ���̺� ���� ����� �ڵ� COMMIT
TRUNCATE TABLE EMP_RENAME;
SELECT * FROM EMP_RENAME;

--12. EMP_RENAME ���̺� ����
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

--1. ����ڰ� ���� ���̺� ��ȸ(SCOTT�� ���� TABLE)
SELECT *
FROM USER_TABLES;

SELECT TABLE_NAME
FROM USER_TABLES;

--2.
SELECT *
FROM DICT;

SELECT *
FROM DICTIONARY;

--3. �� �������� Ȯ�� ������(���� ������) ���̺��
SELECT * FROM ALL_TABLES;

--4. DBA�� �����ϴ� ���̺��
SELECT * FROM DBA_TABLES;

--5. �� ������ �ε����� Ȯ��
SELECT *
FROM USER_INDEXES;

--6. SYS����, ����ڸ��� SCOTT�� ���� ���� Ȯ��
SELECT *
FROM DBA_USERS
WHERE USERNAME='SCOTT';

--7. SCOTT ���� INDEX ������� �� Ȯ��
SELECT *
FROM USER_IND_COLUMNS;

--8. SCOTT EMP���̺��� SAL �Ӽ��� �������� �ε��� ����, �ε����� : IDX_EMP_SAL
CREATE TABLE EMP1
AS SELECT * FROM EMP;

--9. SCOOT ���� EMP1 ���̺��� SAL �Ӽ��� �������� �ε��� ����, �ε��� �� : IDX_EMP1_SAL
CREATE INDEX IDX_EMP1_SAL 
ON EMP1(SAL);

--10. 
SELECT *
FROM EMP1;

SELECT SAL
FROM EMP1;

--11. �ε��� Ȯ��
SELECT *
FROM USER_INDEXES;

--12. �ε��� ����
DROP INDEX IDX_EMP1_SAL;

--13. SYS��������, SCOTT���� VIEW���� ���� �ֱ�
GRANT CREATE VIEW TO SCOTT;

--14. SCOTT���� EMP���̺��� �����ȣ, �̸�, ����, �μ���ȣ �̿��ؼ� VW_EMP20���� �� ����
CREATE VIEW VW_EMP20
AS (SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE DEPTNO=20);

--15. �� Ȯ��
SELECT * FROM USER_VIEWS;
SELECT * FROM VW_EMP20;

--16. �� �ؽ�Ʈ Ȯ��
SELECT TEXT FROM USER_VIEWS;

--17. VW_EMP20 �� ����
DROP VIEW VW_EMP20;

--18. ���� ��ȸ
SELECT * FROM VW_EMP20;

--19. ROWNUM : �� ��ȣ
SELECT ROWNUM, E.*
FROM EMP E;

--20. ���� �������� �����ؼ� ����ϴµ� �ٹ�ȣ�� �Բ� ���(�ٹ�ȣ�� ���� �ٿ�����(�˻��� ���� �ǰ�), ������ ��)
SELECT ROWNUM, E.*
FROM EMP E
ORDER BY SAL DESC;

--21. ����(���� ����) �� �ٹ�ȣ �ο�
SELECT ROWNUM, E.*
FROM (SELECT *
      FROM EMP
      ORDER BY SAL DESC) E;
      
--22. �μ���ȣ ��, ���� �μ��̸� �̸��� �����ؼ� ��ȣ �ο�
SELECT ROWNUM, E.*
FROM (SELECT *
      FROM EMP
      ORDER BY DEPTNO, ENAME) E;
      
--23. �Ի��� �� ����, ��ȣ �ο�
SELECT ROWNUM, E.*
FROM (SELECT *
      FROM EMP
      ORDER BY HIREDATE) E;
      
--24. WITH ����� 23���� �����ϰ�
WITH E AS(SELECT * FROM EMP ORDER BY HIREDATE)
SELECT ROWNUM, E.*
FROM E;

--25. 23�� ���� ����, �ְ� 3������ ���
SELECT ROWNUM, E.*
FROM (SELECT *
      FROM EMP
      ORDER BY HIREDATE) E
WHERE ROWNUM <= 3;

--26. DEPT ���̺��� �����ؼ� DEPT2 ����
CREATE TABLE DEPT2
AS SELECT *
   FROM DEPT
WHERE 1<>1;

SELECT * FROM DEPT2;

--27. SEQUENCE SEQ_DEPT2 ����, ������ : 10 �ʱⰪ : 10, �ִ�ġ : 90, 
--    �ּ�ġ : 0, �ݺ� X, ĳ�� : 2
CREATE SEQUENCE SEQ_DEPT2
INCREMENT BY 10
START WITH 10
MAXVALUE 90
MINVALUE 0
NOCYCLE
CACHE 2;
-- NOCYCLE : 10�� �Ѿ �� �����Ƿ� �ִ�ġ�� 90�� �Ǹ� ERROR�� �߻�
-- CYCLE : �ٽ� �ʱⰪ�� 10���� ���ư��� �ݺ�

--28. USER_SEQUENCES ���̺� ���� Ȯ��
SELECT *
FROM USER_SEQUENCES;

--29. DEPT2���̺� SEQ_DEPT2.NEXTVAL, 'DATABASE', 'SEOUL'�� �����ϱ�
SELECT *
FROM DEPT2;

--9�� �ݺ� ����
INSERT INTO DEPT2 VALUES(SEQ_DEPT2.NEXTVAL, 'DATABASE', 'SEOUL');

--30. ���� SEQ_DEPT2.CURRVAL Ȯ��
SELECT SEQ_DEPT2.CURRVAL FROM dual;

--31. ������ CYCLE�� ���� ; 99 �ʰ��� �ּ�ġ�� 0���� ���ư�
ALTER SEQUENCE SEQ_DEPT2 
INCREMENT BY 3
MAXVALUE 99
CYCLE;

--32. INSERT ������ 3�� �߰� �� SELECT * FROM DEPT2; Ȯ��

--33. SEQ_DEPT2 ����
DROP SEQUENCE SEQ_DEPT2;

SELECT *
FROM USER_SEQUENCES;


----------------------------------------
SELECT D.*, E.ENAME, E.DEPTNO, D.DNAME, E.SAL
FROM EMP E,DEPT D
WHERE E.DEPTNO = D.DEPTNO(+);