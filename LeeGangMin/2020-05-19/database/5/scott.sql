--실습 5-1
select *
from emp;
--실습 5-2
select *
from emp
where deptno = 30;
--실습 5-3
select *
from emp
where deptno = 30
and job = 'SALESMAN';
--실습 5-4
select *
from emp
where deptno = 30
or job = 'CLERK';
--실습 5-5
select *
from emp
where sal * 12 = 36000;
--실습 5-6
select *
from emp
where sal >= 3000;
--실습 5-7
select *
from emp
where ename >= 'F';
--실습 5-8
select *
from emp
where ename <= 'FORZ';
--실습 5-9, 5-10, 5-11
select *
from emp
where sal != 3000;

select *
from emp
where sal <> 3000;

select *
from emp
where sal ^= 3000;
--실습 5-12
select *
from emp
where not sal = 3000;
--실습 5-13
select *
from emp
where job = 'MANAGER'
   or job = 'SALESMAN'
   or job = 'CLERK';
--실습 5-14
select *
from emp
where job in ('MANAGER', 'SALESMAN', 'CLERK');
--실습 5-15
select *
from emp
where job != 'MANAGER'
  and job <> 'SALESMAN'
  and job ^= 'CLERK';
--실습 5-16
select *
from emp
where job not in ('MANAGER', 'SALESMAN', 'CLERK');
--실습 5-17
select *
from emp
where sal >= 2000
and sal <= 3000;
--실습 5-18
select *
from emp
where sal between 2000 and 3000;
--실습 5-19
select *
from emp
where sal not between 2000 and 3000;
--실습 5-20
select *
from emp
where ename like 'S%';
--실습 5-21
select *
from emp
where ename like '_L%';
--실습 5-22
select *
from emp
where ename like '%AM%';
--실습 5-23
select *
from emp
where ename not like '%AM';
--실습 5-24
select ename, sal, sal*12+comm as ANNSAL, COMM
from emp;
--실습 5-25
select *
from emp
where comm = null;
--실습 5-26
select *
from emp
where comm is null;
--실습 5-27
select *
from emp
where MGR is not null;
--실습 5-28
select *
from emp
where SAL > null
and comm is null;
--실습 5-29
select *
from emp
where SAL > null
or comm is null;
--실습 5-30
select empno, ename, sal, deptno
from emp
where deptno = 10
UNION
select empno, ename, sal, deptno
from emp
where deptno = 20;
--실습 5-31
select empno, ename, sal, deptno
from emp
where deptno = 10
UNION
select empno, ename, sal
from emp
where deptno = 20;
--실습 5-32
select empno, ename, sal, deptno
from emp
where deptno = 10
UNION
select ename, empno, deptno, sal
from emp
where deptno = 20;
--실습 5-33
select empno, ename, sal, deptno
from emp
where deptno = 10
UNION
select sal, job, deptno, sal
from emp
where deptno = 20;
--실습 5-34
select empno, ename, sal, deptno
from emp
where deptno = 10
UNION
select empno, ename, sal, deptno
from emp
where deptno = 10;
--실습 5-35
select empno, ename, sal, deptno
from emp
where deptno = 10
UNION ALL
select empno, ename, sal, deptno
from emp
where deptno = 10;
--실습 5-36
select empno, ename, sal, deptno
from emp
MINUS
select empno, ename, sal, deptno
from emp
where deptno = 10;
--실습 5-37
select empno, ename, sal, deptno
from emp
INTERSECT
select empno, ename, sal, deptno
from emp
where deptno = 10;
--Q1
select * from emp where ename like '%S';
--Q2
select empno, ename, job, sal, deptno
from emp
where deptno=30 and job='SALESMAN';
--Q3
--집합연산자 사용X
select empno, ename, sal, deptno
from emp
where deptno in(20, 30) and sal>2000;
--집합연산자 사용O
select empno, ename, sal, deptno
from emp
where deptno=20 and sal>2000
UNION
select empno, ename, sal, deptno
from emp
where deptno=30 and sal>2000;
--Q4
select *
from emp
where not (sal>=2000 and sal<=3000);
--Q5
select ename, empno, sal, deptno
from emp
where ename like '%E%'
and sal not between 1000 and 2000
and deptno=30;
--Q6
select *
from emp
where mgr is not null and job='CLERK' or job='MANAGER' and comm is null
MINUS
select *
from emp
where ename like '_L%';