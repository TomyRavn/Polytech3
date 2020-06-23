--1. emp, dept 테이블 정보
select *
from emp, dept;

--2. 중첩 해결(Cartesian Product)
select *
from emp E, dept D
where E.DEPTNO = D.DEPTNO;

--3. 2번을 부서번호 순으로
select *
from emp E, dept D
where E.DEPTNO = D.DEPTNO
ORDER BY E.DEPTNO;

--4. 사원번호, 사원명, 부서명만 찍기
SELECT EMPNO, ENAME, DNAME
FROM emp, dept;

--5. 사원명, 봉급, 등급
SELECT ENAME, e.SAL, GRADE
FROM emp e, salgrade s
where e.sal between s.losal and s.hisal;

--6. 급여가 2000~3000 사이인 사람만
SELECT ename, e.sal, grade
FROM emp e, salgrade s
WHERE e.sal between s.losal and s.hisal
and e.sal between 2000 and 3000;

--7. 사원명, 부서위치, 급여등급을 부서, 등급 순으로
SELECT E.ENAME, D.LOC, S.GRADE
FROM EMP E, DEPT D, SALGRADE S
WHERE E.DEPTNO = D.DEPTNO
AND E.SAL BETWEEN S.LOSAL AND S.HISAL
ORDER BY E.DEPTNO, S.GRADE;

--8. 사원번호, 사원명, 관리자번호
SELECT EMPNO, ENAME, MGR
FROM EMP;

--9. 