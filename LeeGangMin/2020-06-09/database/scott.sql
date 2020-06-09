--1. count() : 갯수세기
select count(*)
from emp;

--2. 사원명과 함께 봉급합계
--그룹함수와 개별은 그냥은 같이 쓸수 없다
select ename, sum(sal)
from emp; --(X)

select deptno, sum(sal)
from emp
group by deptno; --(O)

--3. 부서 번호 출력(중복X)
select distinct deptno
from emp;

--4. 사원들이 속한 부서의 수
select count(distinct deptno)
from emp;

--5. 급여 합계 구하기(Distinct 중복 제거, all 사용(all은 써도 안써도 결과가 같음))
select sum(distinct sal),
       sum(all sal),
       sum(sal)
from emp;

--6. 사원들의 정보
select * from emp;

--7. 사원들의 수(행의 수)
select count(*)
from emp;

--8. 30번 부서의 사원수
select count(*)
from emp
where deptno = 30;

--9. 봉급의 갯수
select count(distinct sal),
    count(all sal),
    count(sal)
from emp;

--10. 보너스가 정해진 사람들
select count(comm)
from emp;

--11. 보너스 받는 사람 수
select count(comm)
from emp
where comm > 0;

--12. 보너스가 null 이 아닌 사람, 즉 정해진 사람의 수
select count(*)
from emp
where comm is not null; --(count(comm)도 동일한 결과)

--13. 최고 봉급액
select max(sal)
from emp;

--14. 10번 부서 최고 봉급액
select max(sal)
from emp
where deptno = 10;

--15. 10번 부서 최저 봉급액
select min(sal)
from emp
where deptno = 10;

--16. 10번 부서 평균 봉급액
select TRUNC(avg(sal),2)
from emp
where deptno = 10;

--17. 최근입사일
select max(hiredate)
from emp;

--18. 가장 먼저 입사한 사원의 입사일
select min(hiredate)
from emp;

--19. 20번 부서에서 최고참의 입사일
select min(hiredate)
from emp
where deptno = 20;

--20. 30번 부서의 평균 봉급액
select TRUNC(avg(sal), 2)
from emp
where deptno = 30;

--21. 10, 20, 30번 부서의 평균 봉급액 구하기(UNION ALL)
select TRUNC(avg(sal)) as SAL_AVERAGE, '10' as deptno from emp where deptno = 10
union all
select TRUNC(avg(sal)), '20' from emp where deptno = 20
union all
select TRUNC(avg(sal)), '30' from emp where deptno = 30;

--22. 부서 및 직급별 평균 봉급
select deptno, job, avg(sal)
from emp
group by deptno, job
order by deptno, job;

--23. 부서 및 직급별 평균 봉급구하는데 봉급 평균이 2000이상인 정보만
select deptno, job, avg(sal)
from emp
--where sal >= 2000
group by deptno, job
having avg(sal) >= 2000
order by deptno, job;

--24. 봉급이 3000이하인 사람들 대상 부서별, 직급별 평균 봉급이 2000이상인 정보
select deptno, job, avg(sal)
from emp
where sal <= 3000
group by deptno, job
having avg(sal) >= 2000
order by deptno, job;

--25. 부서별 직급별, 사원수, 최대 봉급, 봉급액 합계, 평균 봉급
select deptno, job, count(*), max(sal), sum(sal), TRUNC(avg(sal))
from emp
group by deptno, job
order by deptno, job;

--26. rollup으로 요약
select deptno, job, count(*), max(sal), sum(sal), TRUNC(avg(sal))
from emp
group by rollup(deptno, job)
order by deptno, job;

--27. cube ; rollup보다 상세한 요약
select deptno, job, count(*), max(sal), sum(sal), ROUND(avg(sal))
from emp
group by cube(deptno, job)
order by deptno, job;

--28. rollup을 job에 대해서만 부서, 직급별 인원수
select deptno, job, count(*)
from emp
group by deptno, rollup(job)
order by deptno, job;

--29. rollup을 deptno에 대해서만 부서, 직급별 인원수
select deptno, job, count(*)
from emp
group by job, rollup(deptno)
order by deptno, job;

--30. grouping sets ; 보고싶은것만 정렬해서 볼 수 있음
select deptno, job, count(*)
from emp
group by grouping sets(deptno, job)
order by deptno, job;

--31. grouping 함수. 0의 의미 : 그룹화되었음 , 1의 의미 : 그룹화되지 않은 데이터
select deptno, job, count(*), max(sal), sum(sal), round(avg(sal)),
  grouping(deptno),
  grouping(job)
from emp
group by cube(deptno, job)
order by deptno, job;

--32. decode ; 복호화
--그룹핑 시킨것의 값이 1이면 'ALL_DEPT'라고 찍고, 항목은 DEPTNO, 제목은 DEPTNO라고 한다
select decode(grouping(deptno), 1, 'ALL_DEPT', DEPTNO) AS DEPTNO,
  decode(grouping(job), 1, 'ALL_JOB', JOB) AS JOB,
  count(*), max(sal), sum(sal), ROUND(avg(sal))
from emp
group by cube(deptno, job)
order by deptno, job;

--33. grouping_id 그룹핑 된 값들을 2진수로 표시
select deptno, job, count(*), sum(sal),
  grouping(deptno),
  grouping(job),
  grouping_id(deptno, job)
from emp
group by cube(deptno, job)
order by deptno, job;

--34. listagg : 가로로 출력 ; ',' 자리는 구분자
select deptno,
    listagg(ename, ',')
    within group(order by sal desc) as enames --먼저 나온 사람이 급여가 제일 많음
from emp
group by deptno;

select deptno,
    listagg(ename, ',')
    within group(order by hiredate) as enames
from emp
group by deptno;

--35.
select deptno, job, max(sal)
from emp
group by deptno, job
order by deptno, job;

--36. 엑셀 pivot 기능 처럼, 행을 열로 바꿔줌 // <-> unpivot 열을 행으로 바꿔줌
select *
from(select deptno, job, sal from emp) --인라인 뷰(임시로 보여줌)
pivot(max(sal) for deptno in(10,20,30))
order by job;

--37.
--오라클은 대/소문자 엄격하게 구분하지 않지만, 들어있는 데이터가 대문자라면 대문자로 비교해주어야함
select *
from (select job, deptno, sal from emp)
pivot(max(sal)
  for job in ('CLERK' as CLERK,
              'SALESMAN' as SALESMAN,
              'PRESIDENT' as PRESIDENT,
              'MANAGER' as MANAGER,
              'ANALYST' as ANALYST)
  )
ORDER BY DEPTNO;

--38.
-- 별칭을 쓸 때 공백이 있다면 ""를 꼭 써주어야함
select deptno,
  max(decode(job,'CLERK',SAL)) as CLERK,
  max(decode(job,'SALESMAN',SAL)) as SALESMAN,
  max(decode(job,'PRESIDENT',SAL)) as PRESIDENT,
  max(decode(job,'MANAGER',SAL)) as MANAGER,
  max(decode(job,'ANALYST',SAL)) as ANALYST
from emp
group by deptno
order by deptno;

--39.
select *
from (select deptno,
      max(decode(job, 'CLERK', SAL)) as "CLERK",
      max(decode(job, 'SALESMAN', SAL)) as "SALESMAN",
      max(decode(job, 'PRESIDENT', SAL)) as "PRESIDENT",
      max(decode(job, 'MANAGER', SAL)) as "MANAGER",
      max(decode(job, 'ANALYST', SAL)) as "ANALYST"
  from emp
  group by deptno
  order by deptno)
unpivot(
  sal for job in (CLERK, SALESMAN, PRESIDENT, MANAGER, ANALYST))
order by deptno, job;


--Q1.
select deptno, TRUNC(avg(sal)) as AVG_SAL, max(sal) As MAX_SAL, min(sal) as MIN_SAL, count(*) as CNT
from emp
group by deptno
order by deptno desc;

--Q2.
select job, count(*)
from emp
group by job
having count(job) >= 3;

--Q3.
select TO_CHAR(hiredate,'YYYY') as HIRE_YEAR, deptno, count(*) as CNT
from emp
group by TO_CHAR(hiredate,'YYYY'), deptno --여기가 핵심(hiredate로 group by 하는 것이 아님)
order by TO_CHAR(hiredate,'YYYY') desc, deptno;

--Q4.
select 'X' as EXIST_COMM, count(*) as CNT
from emp
where comm is null
union all
select 'O', count(comm) as CNT
from emp;

select nvl2(comm, 'O', 'X') as EXIST_COMM,
      count(*) as CNT
from emp
group by nvl2(comm, 'O', 'X');

--Q5.
--O
select deptno,
      TO_CHAR(hiredate, 'YYYY') as HIRE_YEAR,
      count(*) as CNT,
      MAX(sal) as MAX_SAL,
      SUM(sal) as SUM_SAL,
      AVG(sal) as AVG_SAL
from emp
group by rollup(deptno, to_char(hiredate, 'YYYY'));


--X
select deptno, TO_CHAR(hiredate,'YYYY'), count(*), max(sal), sum(sal), avg(sal)
from emp
group by rollup (deptno, TO_CHAR(hiredate,'YYYY'));