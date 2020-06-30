--1. 전체 직원의 총 급여
select sum(sal)
from emp;

--2. 부서별 총 급여
select deptno, sum(sal)
from emp
group by deptno
order by deptno;

--3. 전체 직원 급여 평균
select trunc(avg(sal))
from emp;

--4 부서별 평균 급여
select deptno, trunc(avg(sal))
from emp
group by deptno
order by deptno;

--5 부서별 최대급여
select deptno, max(sal)
from emp
group by deptno
order by deptno;

--6 부서별 최대 급여와 같은 급여를 받는 사원들의 정보
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
            --some 도 동일
            
--7 부서 번호가 10, 20, 30인 사원정보
select *
from emp
where deptno in (10, 20, 30)
order by deptno;

--8 부서별 최대 급여를 받는 사원들의 정보
select *
from emp
where (deptno, sal) in (select deptno, max(sal)
                        from emp
                        group by deptno);
                        
--9 30번 부서에 속한 사람들의 급여 순, 같은 급여이면 사원 번호 순으로 정렬해서 급여와 사원번호 출력
select sal, empno
from emp
where deptno = 30
order by sal, empno;

--10, 11  30번 부서에 속한 어떤 사원들의 급여보다 작은 급여를 받는 사원들의 정보 급여순, 사원번호순
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

--12 10번 부서에 사원이 존재하면 모든 사원들의 정보 출력
select *
from emp
where EXISTS(select empno from emp where deptno = 10);

--13 50번 부서에 사원이 존재하면 모든 사원들의 정보 출력
select *
from emp
where EXISTS(select empno from emp where deptno = 50);

--14 사원들의 사번, 이름, 부서번호, 부서명, 위치
select E.empno, E.ename, E.deptno, D.dname, D.loc
from emp E, dept D
where E.deptno = D.deptno
order by E.DEPTNO;

--15 10번 부서 사원들의 사번, 이름, 부서번호, 부서명, 위치
select E.empno, E.ename, E.deptno, D.dname, D.loc
from emp E, dept D
where E.deptno = D.deptno and E.deptno = 10;

--16 사원번호, 사원명, 부서번호, 부서명, 위치. 단, 10번 부서에 소속된 사람만, INLINE VIEW 이용
SELECT E.EMPNO, E.ENAME, E.DEPTNO, D.DNAME, D.LOC
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO AND E.DEPTNO = 10;

SELECT E10.EMPNO, E10.ENAME, E10.DEPTNO, D.DNAME, D.LOC
FROM (SELECT * FROM EMP WHERE DEPTNO = 10) E10,
      (SELECT * FROM DEPT) D
WHERE E10.DEPTNO = D.DEPTNO;

--17 16번을 WITH절 사용
WITH
E10 AS(SELECT * FROM EMP WHERE DEPTNO = 10),
D AS(SELECT * FROM DEPT)
SELECT E10.EMPNO, E10.ENAME, E10.DEPTNO, D.DNAME, D.LOC
FROM E10, D
WHERE E10.DEPTNO = D.DEPTNO;

--18 사원번호, 이름, 직업, 급여, 급여등급, 부서번호, 부서명
SELECT E.EMPNO, E.ENAME, E.JOB, E.SAL, S.GRADE, E.DEPTNO, D.DNAME
FROM EMP E, DEPT D, SALGRADE S
WHERE E.DEPTNO = D.DEPTNO AND E.SAL BETWEEN S.LOSAL AND S.HISAL
ORDER BY S.GRADE, E.DEPTNO;

--SCALAR SUBQUERY(스칼라 부속질의)
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
--SELECT DISTINCT JOB FROM EMP WHERE DEPTNO = 30 -> 30번 부서의 각 직업 중복 제거 -> 비교 횟수를 줄일 수 있으므로 더 좋은 효율

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