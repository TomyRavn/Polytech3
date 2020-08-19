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