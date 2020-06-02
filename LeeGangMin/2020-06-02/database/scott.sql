--1
select ename
from emp
where sal between 2000 and 3000;

--2
select sal, comm, sal*12+nvl(comm, 0) as "연 봉"
from emp;

--nvl2(comm의 값을, null이 아닐때는 sal*12+comm, null일때는 sal*12로 출력)
select sal, comm, nvl2(comm, sal*12+comm, sal*12) as "연 봉"
from emp;

--3. decoding 복호화 / encoding 부호화
--job이 뭐냐에 따라서 값을 계산하는게 달라진다(switch문과 비슷) 마지막은 default(else)값
select empno, ename, job, sal,
    decode(job, 
              'MANAGER', sal*1.1,
              'SALESMAN', sal*1.05,
              'ANALYST', sal,
              sal*1.03) as UPSAL
from emp;

--4 case도 decode와 유사하게 사용
--case : ~ 하는 경우에
select empno, ename, job, sal,
      case job
        when 'MANAGER' then sal*1.1
        when 'SALESMAN' then sal*1.05
        when 'ANALYST' then sal
        else sal*1.03
      end as UPSAL
from emp;

--5
--comm = null (X)
-- || = concat()
select empno, ename, job, sal,
    case
      when comm is null then '해당사항없음'
      when comm = 0 then '수당없음'
      when comm > 0 then '수당:'||COMM
      end as COMM_TEXT
from emp;

--6장 연습문제
--1.
--(1)
select empno, rpad(substr(empno,-length(empno),2), length(empno), '*') as MASKING_EMPNO, ename, rpad(substr(ename, -length(ename), 1), length(ename), '*') as MASKING_ENAME
from emp
where length(ename) >= 5 and length(ename) < 6;
--where length(ename) = 5

--(2)
select empno,
      rpad(substr(empno, 1, 2), 4, '*') as MASKING_EMPNO,
      ename,
      rpad(substr(ename, 1, 1), length(ename), '*') as MASKING_ENAME
from emp
where length(ename) = 5;
--where length(ename) >= 5 and length(ename) < 6;

--2.
-- 전체 봉급 / 날짜수 = 하루 봉급
-- 하루 봉급 / 근무 시간 = 시급
select empno, ename, sal,
        TRUNC(sal/21.5,2) as DAY_PAY,
        ROUND(TRUNC(sal/21.5,2)/8, 1) as TIME_PAY
from emp;

--3.
--NVL() 문자로 찍어줄 때는 앞의 매개변수도 모두 문자로 바꿔줘야함
select empno, ename, hiredate,
      TO_CHAR(NEXT_DAY(ADD_MONTHS(HIREDATE, 3), '월'),'YYYY-MM-DD') as R_JOB,
      NVL(TO_CHAR(comm), 'N/A') as COMM
      --NVL2(TO_CHAR(comm), TO_CHAR(comm), 'N/A') as COMM
from emp;

--4.
--substr은 문자로 뽑아낸다
select empno, ename, NVL(TO_CHAR(MGR), ' ') as MGR,
    case
      when MGR is null then '0000'
      when SUBSTR(MGR, 1, 2) = '75' then '5555'
      when SUBSTR(MGR, 1, 2) = '76' then '6666'
      when SUBSTR(MGR, 1, 2) = '77' then '7777'
      when SUBSTR(MGR, 1, 2) = '78' then '8888'
      else TO_CHAR(MGR)
    end as CHG_MGR
from emp;

------------------------------------------------
--7-1
select SUM(sal), COUNT(sal), MAX(sal), MIN(sal), TRUNC(AVG(sal),2) as "AVG(SAL)"
from emp;

--7-2 사원수
select --COUNT(*) 
    COUNT(COMM)
from emp;

--7-3 부서의 수
select * from dept;

select count(*)
from dept;

--7-4 보너스 없는 사원의 수
select count(*)
from emp
where comm is null;

--7-5 10번 부서 사원수
-- *가 안정적
select count(*)
from emp
where deptno=10;

select count(deptno)
from emp
where deptno=10;

--7-6 각 부서별 사원수
-- order by는 제일 마지막에
select deptno, count(*)
from emp
group by deptno
order by deptno;

--7-7 각 부서별 최고 봉급
select deptno, MAX(sal)
from emp
group by deptno
order by deptno;

--7-8 각 부서별 최장기간 근무한 사람의 입사일
select deptno, MIN(hiredate)
from emp
group by deptno
order by deptno;

--7-9
select deptno
from emp;

--7-10 distinct : 중복제거
select distinct deptno
from emp;

--7-11 SUM에 ALL은 생략가능
select SUM(SAL), SUM(ALL SAL), SUM(DISTINCT SAL)
from emp;

--7-12 중복제거한 입사일 출력
select distinct hiredate
from emp;

--7-13 30번 부서의 사원수
select deptno, count(*)
from emp
where deptno = 30
group by deptno;

--7-14 10번 부서의 최고 봉급액
select deptno, max(sal)
from emp
where deptno = 10
group by deptno;

--7-15 10번 부서 최저 봉급액
select min(sal)
from emp
where deptno = 10;

--7-16 20번 부서의 최근 입사자의 입사일
select max(hiredate)
from emp
where deptno = 20;

--7-17 20번 부서의 최고 장기간 근무한사람의 입사일
select min(hiredate)
from emp
where deptno = 20;

--7-18 30번 부서의 평균 봉급
select TRUNC(AVG(sal),2)
from emp
where deptno = 30;

--7-19 30번 부서의 평균 봉급(단, 봉급의 중복은 제거 후 평균)
select AVG(distinct sal)
from emp
where deptno = 30;

--7-20
select ROUND(avg(sal)), '10' as deptno from emp where deptno = 10
union all
select ROUND(avg(sal)), '20' as deptno from emp where deptno = 20
union all
select ROUND(avg(sal)), '30' as deptno from emp where deptno = 30;

--7-21 부서번호, 직급별 평균 봉급
select deptno, job, avg(sal)
from emp
group by deptno, job
order by deptno, job;

--7-22 부서와 직급별로 평균 봉급이 2000이상인 사원들의 부서번호, 직급, 평균 봉급
--부서번호, 직급 순으로 출력
--그룹 함수이므로 where이 아닌 having에 평균 봉급 2000이상인 조건 기재
select deptno, job, avg(sal)
from emp
group by deptno, job
having avg(sal) >= 2000
order by deptno, job;

--7-23  where절에는 그룹 함수를 쓸 수 없음  
-- avg(sal) <-> sal
select deptno, job, avg(sal)
from emp
where sal >= 2000
group by deptno, job
order by deptno, job;

--7-24 봉급이 3000이하인 사원들을 대상으로 부서, 직급별 평균 봉급이 2000이상
select deptno, job, avg(sal)
from emp
where sal <= 3000
group by deptno, job
having avg(sal) >= 2000
order by deptno, job;

--7-25 부서, 직급별 사원수, 최대 봉급, 봉급 합계, 평균 봉급 출력
--(1)
select deptno, job, count(*) as COUNT, max(sal) as MAX, sum(sal) as SUM, TRUNC(avg(sal)) as AVG
from emp
group by deptno, job
order by deptno, job;

--(2) rollup : deptno의 구간별 계산
select deptno, job, count(*) as COUNT, max(sal) as MAX, sum(sal) as SUM, TRUNC(avg(sal)) as AVG
from emp
group by rollup(deptno, job)
order by deptno, job;

--7-26 cube : deptno, job의 구간별 계산
select deptno, job, count(*) as COUNT, max(sal) as MAX, sum(sal) as SUM, TRUNC(avg(sal)) as AVG
from emp
group by cube(deptno, job)
order by deptno, job;

--7-27 deptno의 구간 계산(10번 부서의 사원의 수, ...)
select deptno, job, count(*)
from emp
group by deptno, rollup(job);

--7-28  job의 구간 계산(전체 CLERK 직급인 사원의 수, ...)
select deptno, job, count(*)
from emp
group by job, rollup(deptno);

--7-29
select deptno, job, count(*)
from emp
group by grouping sets(deptno, job)
order by deptno, job;

--7-30  두 개다 rollup할 경우 두 개 모두에 대한 전체 합계가 포함출력됨
select deptno, job, count(*)
from emp
group by rollup(job, deptno);

--7-31  grouping sets = 전체를 그룹화해 집합으로 출력
-- deptno, job 의 각각의 집합으로 출력
select deptno, job, count(*)
from emp
group by grouping sets(deptno, job)
order by deptno, job;

--7-32
--0이 grouping된 목록임
select deptno, job, count(*), max(sal), sum(sal), TRUNC(avg(sal),2) as "AVG(SAL)",
      grouping(deptno),
      grouping(job)
from emp
group by cube(deptno, job)
order by deptno, job;

--7-33  deptno의 그룹핑 값이 1이면 해당 값을 'ALL_DEPT'로 출력하겠다는 뜻
select decode(grouping(deptno),1,'ALL_DEPT', DEPTNO) as DEPTNO,
      decode(grouping(job), 1, 'ALL_JOB', JOB) as JOB,
      count(*), max(sal), sum(sal), avg(sal)
from emp
group by cube(deptno, job)
order by deptno, job;