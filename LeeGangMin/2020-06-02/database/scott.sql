--1
select ename
from emp
where sal between 2000 and 3000;

--2
select sal, comm, sal*12+nvl(comm, 0) as "�� ��"
from emp;

--nvl2(comm�� ����, null�� �ƴҶ��� sal*12+comm, null�϶��� sal*12�� ���)
select sal, comm, nvl2(comm, sal*12+comm, sal*12) as "�� ��"
from emp;

--3. decoding ��ȣȭ / encoding ��ȣȭ
--job�� ���Ŀ� ���� ���� ����ϴ°� �޶�����(switch���� ���) �������� default(else)��
select empno, ename, job, sal,
    decode(job, 
              'MANAGER', sal*1.1,
              'SALESMAN', sal*1.05,
              'ANALYST', sal,
              sal*1.03) as UPSAL
from emp;

--4 case�� decode�� �����ϰ� ���
--case : ~ �ϴ� ��쿡
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
      when comm is null then '�ش���׾���'
      when comm = 0 then '�������'
      when comm > 0 then '����:'||COMM
      end as COMM_TEXT
from emp;

--6�� ��������
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
-- ��ü ���� / ��¥�� = �Ϸ� ����
-- �Ϸ� ���� / �ٹ� �ð� = �ñ�
select empno, ename, sal,
        TRUNC(sal/21.5,2) as DAY_PAY,
        ROUND(TRUNC(sal/21.5,2)/8, 1) as TIME_PAY
from emp;

--3.
--NVL() ���ڷ� ����� ���� ���� �Ű������� ��� ���ڷ� �ٲ������
select empno, ename, hiredate,
      TO_CHAR(NEXT_DAY(ADD_MONTHS(HIREDATE, 3), '��'),'YYYY-MM-DD') as R_JOB,
      NVL(TO_CHAR(comm), 'N/A') as COMM
      --NVL2(TO_CHAR(comm), TO_CHAR(comm), 'N/A') as COMM
from emp;

--4.
--substr�� ���ڷ� �̾Ƴ���
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

--7-2 �����
select --COUNT(*) 
    COUNT(COMM)
from emp;

--7-3 �μ��� ��
select * from dept;

select count(*)
from dept;

--7-4 ���ʽ� ���� ����� ��
select count(*)
from emp
where comm is null;

--7-5 10�� �μ� �����
-- *�� ������
select count(*)
from emp
where deptno=10;

select count(deptno)
from emp
where deptno=10;

--7-6 �� �μ��� �����
-- order by�� ���� ��������
select deptno, count(*)
from emp
group by deptno
order by deptno;

--7-7 �� �μ��� �ְ� ����
select deptno, MAX(sal)
from emp
group by deptno
order by deptno;

--7-8 �� �μ��� ����Ⱓ �ٹ��� ����� �Ի���
select deptno, MIN(hiredate)
from emp
group by deptno
order by deptno;

--7-9
select deptno
from emp;

--7-10 distinct : �ߺ�����
select distinct deptno
from emp;

--7-11 SUM�� ALL�� ��������
select SUM(SAL), SUM(ALL SAL), SUM(DISTINCT SAL)
from emp;

--7-12 �ߺ������� �Ի��� ���
select distinct hiredate
from emp;

--7-13 30�� �μ��� �����
select deptno, count(*)
from emp
where deptno = 30
group by deptno;

--7-14 10�� �μ��� �ְ� ���޾�
select deptno, max(sal)
from emp
where deptno = 10
group by deptno;

--7-15 10�� �μ� ���� ���޾�
select min(sal)
from emp
where deptno = 10;

--7-16 20�� �μ��� �ֱ� �Ի����� �Ի���
select max(hiredate)
from emp
where deptno = 20;

--7-17 20�� �μ��� �ְ� ��Ⱓ �ٹ��ѻ���� �Ի���
select min(hiredate)
from emp
where deptno = 20;

--7-18 30�� �μ��� ��� ����
select TRUNC(AVG(sal),2)
from emp
where deptno = 30;

--7-19 30�� �μ��� ��� ����(��, ������ �ߺ��� ���� �� ���)
select AVG(distinct sal)
from emp
where deptno = 30;

--7-20
select ROUND(avg(sal)), '10' as deptno from emp where deptno = 10
union all
select ROUND(avg(sal)), '20' as deptno from emp where deptno = 20
union all
select ROUND(avg(sal)), '30' as deptno from emp where deptno = 30;

--7-21 �μ���ȣ, ���޺� ��� ����
select deptno, job, avg(sal)
from emp
group by deptno, job
order by deptno, job;

--7-22 �μ��� ���޺��� ��� ������ 2000�̻��� ������� �μ���ȣ, ����, ��� ����
--�μ���ȣ, ���� ������ ���
--�׷� �Լ��̹Ƿ� where�� �ƴ� having�� ��� ���� 2000�̻��� ���� ����
select deptno, job, avg(sal)
from emp
group by deptno, job
having avg(sal) >= 2000
order by deptno, job;

--7-23  where������ �׷� �Լ��� �� �� ����  
-- avg(sal) <-> sal
select deptno, job, avg(sal)
from emp
where sal >= 2000
group by deptno, job
order by deptno, job;

--7-24 ������ 3000������ ������� ������� �μ�, ���޺� ��� ������ 2000�̻�
select deptno, job, avg(sal)
from emp
where sal <= 3000
group by deptno, job
having avg(sal) >= 2000
order by deptno, job;

--7-25 �μ�, ���޺� �����, �ִ� ����, ���� �հ�, ��� ���� ���
--(1)
select deptno, job, count(*) as COUNT, max(sal) as MAX, sum(sal) as SUM, TRUNC(avg(sal)) as AVG
from emp
group by deptno, job
order by deptno, job;

--(2) rollup : deptno�� ������ ���
select deptno, job, count(*) as COUNT, max(sal) as MAX, sum(sal) as SUM, TRUNC(avg(sal)) as AVG
from emp
group by rollup(deptno, job)
order by deptno, job;

--7-26 cube : deptno, job�� ������ ���
select deptno, job, count(*) as COUNT, max(sal) as MAX, sum(sal) as SUM, TRUNC(avg(sal)) as AVG
from emp
group by cube(deptno, job)
order by deptno, job;

--7-27 deptno�� ���� ���(10�� �μ��� ����� ��, ...)
select deptno, job, count(*)
from emp
group by deptno, rollup(job);

--7-28  job�� ���� ���(��ü CLERK ������ ����� ��, ...)
select deptno, job, count(*)
from emp
group by job, rollup(deptno);

--7-29
select deptno, job, count(*)
from emp
group by grouping sets(deptno, job)
order by deptno, job;

--7-30  �� ���� rollup�� ��� �� �� ��ο� ���� ��ü �հ谡 ������µ�
select deptno, job, count(*)
from emp
group by rollup(job, deptno);

--7-31  grouping sets = ��ü�� �׷�ȭ�� �������� ���
-- deptno, job �� ������ �������� ���
select deptno, job, count(*)
from emp
group by grouping sets(deptno, job)
order by deptno, job;

--7-32
--0�� grouping�� �����
select deptno, job, count(*), max(sal), sum(sal), TRUNC(avg(sal),2) as "AVG(SAL)",
      grouping(deptno),
      grouping(job)
from emp
group by cube(deptno, job)
order by deptno, job;

--7-33  deptno�� �׷��� ���� 1�̸� �ش� ���� 'ALL_DEPT'�� ����ϰڴٴ� ��
select decode(grouping(deptno),1,'ALL_DEPT', DEPTNO) as DEPTNO,
      decode(grouping(job), 1, 'ALL_JOB', JOB) as JOB,
      count(*), max(sal), sum(sal), avg(sal)
from emp
group by cube(deptno, job)
order by deptno, job;