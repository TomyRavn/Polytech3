--1. emp, dept ���̺� ����
select *
from emp, dept;

--2. ��ø �ذ�(Cartesian Product)
select *
from emp E, dept D
where E.DEPTNO = D.DEPTNO;

--3. 2���� �μ���ȣ ������
select *
from emp E, dept D
where E.DEPTNO = D.DEPTNO
ORDER BY E.DEPTNO;

--4. �����ȣ, �����, �μ��� ���
SELECT EMPNO, ENAME, DNAME
FROM emp, dept;

--5. �����, ����, ���
SELECT ENAME, e.SAL, GRADE
FROM emp e, salgrade s
where e.sal between s.losal and s.hisal;

--6. �޿��� 2000~3000 ������ �����
SELECT ename, e.sal, grade
FROM emp e, salgrade s
WHERE e.sal between s.losal and s.hisal
and e.sal between 2000 and 3000;

--7. �����, �μ���ġ, �޿������ �μ�, ��� ������
SELECT E.ENAME, D.LOC, S.GRADE
FROM EMP E, DEPT D, SALGRADE S
WHERE E.DEPTNO = D.DEPTNO
AND E.SAL BETWEEN S.LOSAL AND S.HISAL
ORDER BY E.DEPTNO, S.GRADE;

--8. �����ȣ, �����, �����ڹ�ȣ
SELECT EMPNO, ENAME, MGR
FROM EMP;

--9. 