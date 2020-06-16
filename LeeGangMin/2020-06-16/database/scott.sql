--1. count() : ��������
select count(*)
from emp;

--2. ������ �Բ� �����հ�
--�׷��Լ��� ������ �׳��� ���� ���� ����
select ename, sum(sal)
from emp; --(X)

select deptno, sum(sal)
from emp
group by deptno; --(O)

--3. �μ� ��ȣ ���(�ߺ�X)
select distinct deptno
from emp;

--4. ������� ���� �μ��� ��
select count(distinct deptno)
from emp;

--5. �޿� �հ� ���ϱ�(Distinct �ߺ� ����, all ���(all�� �ᵵ �Ƚᵵ ����� ����))
select sum(distinct sal),
       sum(all sal),
       sum(sal)
from emp;

--6. ������� ����
select * from emp;

--7. ������� ��(���� ��)
select count(*)
from emp;

--8. 30�� �μ��� �����
select count(*)
from emp
where deptno = 30;

--9. ������ ����
select count(distinct sal),
    count(all sal),
    count(sal)
from emp;

--10. ���ʽ��� ������ �����
select count(comm)
from emp;

--11. ���ʽ� �޴� ��� ��
select count(comm)
from emp
where comm > 0;

--12. ���ʽ��� null �� �ƴ� ���, �� ������ ����� ��
select count(*)
from emp
where comm is not null; --(count(comm)�� ������ ���)

--13. �ְ� ���޾�
select max(sal)
from emp;

--14. 10�� �μ� �ְ� ���޾�
select max(sal)
from emp
where deptno = 10;

--15. 10�� �μ� ���� ���޾�
select min(sal)
from emp
where deptno = 10;

--16. 10�� �μ� ��� ���޾�
select TRUNC(avg(sal),2)
from emp
where deptno = 10;

--17. �ֱ��Ի���
select max(hiredate)
from emp;

--18. ���� ���� �Ի��� ����� �Ի���
select min(hiredate)
from emp;

--19. 20�� �μ����� �ְ����� �Ի���
select min(hiredate)
from emp
where deptno = 20;

--20. 30�� �μ��� ��� ���޾�
select TRUNC(avg(sal), 2)
from emp
where deptno = 30;

--21. 10, 20, 30�� �μ��� ��� ���޾� ���ϱ�(UNION ALL)
select TRUNC(avg(sal)) as SAL_AVERAGE, '10' as deptno from emp where deptno = 10
union all
select TRUNC(avg(sal)), '20' from emp where deptno = 20
union all
select TRUNC(avg(sal)), '30' from emp where deptno = 30;

--22. �μ� �� ���޺� ��� ����
select deptno, job, avg(sal)
from emp
group by deptno, job
order by deptno, job;

--23. �μ� �� ���޺� ��� ���ޱ��ϴµ� ���� ����� 2000�̻��� ������
select deptno, job, avg(sal)
from emp
--where sal >= 2000
group by deptno, job
having avg(sal) >= 2000
order by deptno, job;

--24. ������ 3000������ ����� ��� �μ���, ���޺� ��� ������ 2000�̻��� ����
select deptno, job, avg(sal)
from emp
where sal <= 3000
group by deptno, job
having avg(sal) >= 2000
order by deptno, job;

--25. �μ��� ���޺�, �����, �ִ� ����, ���޾� �հ�, ��� ����
select deptno, job, count(*), max(sal), sum(sal), TRUNC(avg(sal))
from emp
group by deptno, job
order by deptno, job;

--26. rollup���� ���
select deptno, job, count(*), max(sal), sum(sal), TRUNC(avg(sal))
from emp
group by rollup(deptno, job)
order by deptno, job;

--27. cube ; rollup���� ���� ���
select deptno, job, count(*), max(sal), sum(sal), ROUND(avg(sal))
from emp
group by cube(deptno, job)
order by deptno, job;

--28. rollup�� job�� ���ؼ��� �μ�, ���޺� �ο���
select deptno, job, count(*)
from emp
group by deptno, rollup(job)
order by deptno, job;

--29. rollup�� deptno�� ���ؼ��� �μ�, ���޺� �ο���
select deptno, job, count(*)
from emp
group by job, rollup(deptno)
order by deptno, job;

--30. grouping sets ; ��������͸� �����ؼ� �� �� ����
select deptno, job, count(*)
from emp
group by grouping sets(deptno, job)
order by deptno, job;

--31. grouping �Լ�. 0�� �ǹ� : �׷�ȭ�Ǿ��� , 1�� �ǹ� : �׷�ȭ���� ���� ������
select deptno, job, count(*), max(sal), sum(sal), round(avg(sal)),
  grouping(deptno),
  grouping(job)
from emp
group by cube(deptno, job)
order by deptno, job;

--32. decode ; ��ȣȭ
--�׷��� ��Ų���� ���� 1�̸� 'ALL_DEPT'��� ���, �׸��� DEPTNO, ������ DEPTNO��� �Ѵ�
select decode(grouping(deptno), 1, 'ALL_DEPT', DEPTNO) AS DEPTNO,
  decode(grouping(job), 1, 'ALL_JOB', JOB) AS JOB,
  count(*), max(sal), sum(sal), ROUND(avg(sal))
from emp
group by cube(deptno, job)
order by deptno, job;

--33. grouping_id �׷��� �� ������ 2������ ǥ��
select deptno, job, count(*), sum(sal),
  grouping(deptno),
  grouping(job),
  grouping_id(deptno, job)
from emp
group by cube(deptno, job)
order by deptno, job;

--34. listagg : ���η� ��� ; ',' �ڸ��� ������
select deptno,
    listagg(ename, ',')
    within group(order by sal desc) as enames --���� ���� ����� �޿��� ���� ����
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

--36. ���� pivot ��� ó��, ���� ���� �ٲ��� // <-> unpivot ���� ������ �ٲ���
select *
from(select deptno, job, sal from emp) --�ζ��� ��(�ӽ÷� ������)
pivot(max(sal) for deptno in(10,20,30))
order by job;

--37.
--����Ŭ�� ��/�ҹ��� �����ϰ� �������� ������, ����ִ� �����Ͱ� �빮�ڶ�� �빮�ڷ� �����־����
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
-- ��Ī�� �� �� ������ �ִٸ� ""�� �� ���־����
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
group by TO_CHAR(hiredate,'YYYY'), deptno --���Ⱑ �ٽ�(hiredate�� group by �ϴ� ���� �ƴ�)
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