-- 4-1
desc emp;
-- 4-2
desc dept;
-- 4-3
desc SALGRADE;
-- 4-4
select * from emp;
-- 4-5
select empno, ename, deptno from emp;
-- 4-6
select distinct deptno from emp;
-- 4-7
select distinct job, deptno from emp;
-- 4-8
select all job, deptno from emp;
-- 4-9
select ename, sal, sal*12+comm, comm
from emp;
-- 4-10
select ename, sal, sal+sal+sal+sal+sal+sal+sal+sal+sal+sal+sal+sal+comm, comm
from emp;
-- 4-11
select ename, sal, sal*12+comm as ANNSAL, comm from emp;
-- 4-12
select * from emp order by sal;
-- 4-13
select * from emp
order by sal desc;
-- 4-14
select * from emp
order by deptno asc, sal desc;
-- select count (*) from emp where deptno=10; 

-- p.92 Q2
select distinct JOB from EMP;
-- p.92 Q3
select EMPNO as EMPLOYEE_NO, ENAME as EMPLOYEE_NAME, MGR as MANAGER, SAL as SALARY, COMM as COMMISSION, DEPTNO as DEPARTMENT_NO from emp;
select * from emp;
select EMPNO as EMPLOYEE_NO, ENAME as EMPLOYEE_NAME, job, MGR as MANAGER, hiredate, SAL as SALARY, COMM as COMMISSION, DEPTNO as DEPARTMENT_NO from emp order by deptno desc, ename;

-- select all empno, ename, mgr, sal, comm, deptno from emp order by deptno desc, ename;