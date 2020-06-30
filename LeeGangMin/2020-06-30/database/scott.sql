--1. ��ü ������ �� �޿�
select sum(sal)
from emp;

--2. �μ��� �� �޿�
select deptno, sum(sal)
from emp
group by deptno
order by deptno;

--3. ��ü ���� �޿� ���
select trunc(avg(sal))
from emp;

--4 �μ��� ��� �޿�
select deptno, trunc(avg(sal))
from emp
group by deptno
order by deptno;

--5 �μ��� �ִ�޿�
select deptno, max(sal)
from emp
group by deptno
order by deptno;

--6 �μ��� �ִ� �޿��� ���� �޿��� �޴� ������� ����
--select deptno, max(sal), (select ename from emp where sal = max(sal) group by sal)
--from emp
--group by deptno, ename
--order by deptno, ename;
select *
from emp
where sal in (select max(sal)
            from emp
            group by deptno);
            
select *
from emp
where sal = any(select max(sal)
            from emp
            group by deptno);
            --some �� ����
            
--7 �μ� ��ȣ�� 10, 20, 30�� �������
select *
from emp
where deptno in (10, 20, 30)
order by deptno;

--8 �μ��� �ִ� �޿��� �޴� ������� ����
select *
from emp
where (deptno, sal) in (select deptno, max(sal)
                        from emp
                        group by deptno);
                        
--9 30�� �μ��� ���� ������� �޿� ��, ���� �޿��̸� ��� ��ȣ ������ �����ؼ� �޿��� �����ȣ ���
select sal, empno
from emp
where deptno = 30
order by sal, empno;

--10, 11  30�� �μ��� ���� � ������� �޿����� ���� �޿��� �޴� ������� ���� �޿���, �����ȣ��
select *
from emp
where sal < (select min(sal) from emp where deptno=30)
order by sal, empno;

select *
from emp
where sal < all(select sal from emp where deptno=30)
order by sal, empno;
--some -> max(sal)
--all -> min(sal)

--select sal
--from emp
--where deptno = 30;

--12 10�� �μ��� ����� �����ϸ� ��� ������� ���� ���
select *
from emp
where EXISTS(select empno from emp where deptno = 10);

--13 50�� �μ��� ����� �����ϸ� ��� ������� ���� ���
select *
from emp
where EXISTS(select empno from emp where deptno = 50);

--14 ������� ���, �̸�, �μ���ȣ, �μ���, ��ġ
select E.empno, E.ename, E.deptno, D.dname, D.loc
from emp E, dept D
where E.deptno = D.deptno
order by E.DEPTNO;

--15 10�� �μ� ������� ���, �̸�, �μ���ȣ, �μ���, ��ġ
select E.empno, E.ename, E.deptno, D.dname, D.loc
from emp E, dept D
where E.deptno = D.deptno and E.deptno = 10;

--16 �����ȣ, �����, �μ���ȣ, �μ���, ��ġ. ��, 10�� �μ��� �Ҽӵ� �����, INLINE VIEW �̿�
SELECT E.EMPNO, E.ENAME, E.DEPTNO, D.DNAME, D.LOC
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO AND E.DEPTNO = 10;

SELECT E10.EMPNO, E10.ENAME, E10.DEPTNO, D.DNAME, D.LOC
FROM (SELECT * FROM EMP WHERE DEPTNO = 10) E10,
      (SELECT * FROM DEPT) D
WHERE E10.DEPTNO = D.DEPTNO;

--17 16���� WITH�� ���
WITH
E10 AS(SELECT * FROM EMP WHERE DEPTNO = 10),
D AS(SELECT * FROM DEPT)
SELECT E10.EMPNO, E10.ENAME, E10.DEPTNO, D.DNAME, D.LOC
FROM E10, D
WHERE E10.DEPTNO = D.DEPTNO;

--18 �����ȣ, �̸�, ����, �޿�, �޿����, �μ���ȣ, �μ���
SELECT E.EMPNO, E.ENAME, E.JOB, E.SAL, S.GRADE, E.DEPTNO, D.DNAME
FROM EMP E, DEPT D, SALGRADE S
WHERE E.DEPTNO = D.DEPTNO AND E.SAL BETWEEN S.LOSAL AND S.HISAL
ORDER BY S.GRADE, E.DEPTNO;

--SCALAR SUBQUERY(��Į�� �μ�����)
SELECT EMPNO, ENAME, JOB, SAL, (SELECT GRADE FROM SALGRADE WHERE E.SAL BETWEEN LOSAL AND HISAL) AS SALGRADE, E.DEPTNO, (SELECT DNAME FROM DEPT WHERE E.DEPTNO = DEPTNO) AS DNAME
FROM EMP E
ORDER BY E.DEPTNO;


--Q1.
SELECT E.JOB, E.EMPNO, E.ENAME, E.SAL, E.DEPTNO, D.DNAME
FROM EMP E, DEPT D
WHERE E.JOB = (SELECT JOB FROM EMP WHERE ENAME = 'ALLEN') AND E.DEPTNO = D.DEPTNO
ORDER BY E.SAL DESC, E.ENAME;

--Q2.
SELECT E.EMPNO, E.ENAME, D.DNAME, E.HIREDATE, D.LOC, E.SAL, S.GRADE
FROM EMP E, DEPT D, SALGRADE S
WHERE E.DEPTNO = D.DEPTNO AND (E.SAL BETWEEN S.LOSAL AND S.HISAL) AND E.SAL > (SELECT AVG(SAL) FROM EMP)
ORDER BY SAL DESC, EMPNO;

--Q3.
SELECT E.EMPNO, E.ENAME, E.JOB, E.DEPTNO, D.DNAME, D.LOC
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO AND E.DEPTNO = 10 AND JOB NOT IN (SELECT JOB FROM EMP WHERE DEPTNO = 30);
--SELECT DISTINCT JOB FROM EMP WHERE DEPTNO = 30 -> 30�� �μ��� �� ���� �ߺ� ���� -> �� Ƚ���� ���� �� �����Ƿ� �� ���� ȿ��

--Q4.
SELECT E.EMPNO, E.ENAME, E.SAL, S.GRADE
FROM EMP E, SALGRADE S
WHERE (E.SAL BETWEEN S.LOSAL AND S.HISAL) AND SAL > (SELECT MAX(SAL) FROM EMP WHERE JOB = 'SALESMAN')
ORDER BY EMPNO;

--SELECT E.EMPNO, E.ENAME, E.SAL, S.GRADE
--FROM EMP E, (SELECT * FROM EMP WHERE JOB = 'SALESMAN') ES,
--      (SELECT * FROM SALGRADE) S
--WHERE (E.SAL BETWEEN S.LOSAL AND S.HISAL) AND E.SAL > ES.SAL;

--SELECT E1.EMPNO, E1.ENAME, 