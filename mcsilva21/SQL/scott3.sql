--1.���� ������ 2000~3000�� ���
SELECT * FROM EMP
WHERE sal between 2000 and 3000;
--2. ������ ���Ͽ���
SELECT sal,comm,sal*12+comm as "�� ��" FROM EMP;
--3.������ null���� 0���� �ٲ��
SELECT sal,comm,sal*12+nvl(+comm,0) as "�� ��" FROM EMP;
SELECT sal,comm,nvl2(comm,sal*12+comm,sal*12) as "�� ��" FROM EMP;
--4.DECODE �� ����Ͽ� ���غ� �λ�� �޿��� ����Ͽ���.
select empno,ename,job,sal,
DECODE(JOB,
        'MANAGER',SAL*1.1,
        'SALESMAN',SAL*1.05,
        'ANALYST',SAL,
        SAL*1.03) AS UPSAL
FROM EMP;        
--5.CASE�� ����Ͽ� ���غ� �λ�� �޿��� ����Ͽ���.
select empno,ename,job,sal,
CASE JOB
WHEN 'MANAGER' THEN SAL*1.1
WHEN 'SALESMAN'THEN SAL*1.05
WHEN 'ANALYST'THEN SAL
ELSE SAL*1.03
END AS UPSAL
FROM EMP;     
--6.CASE������ ������ ����Ͽ���.
Select empno,ename,comm,
case 
when comm is null then '�ش���� ����'
when comm =0  then '���� ����'
when comm >0 then '����:'||comm
end as comm_text
from emp;
--6�� �������� 1��
SELECT EMPNO,ENAME,
RPAD(SUBSTR(EMPNO,1,2),4,'*')AS MASKING_EMPNO,
ENAME,
RPAD(SUBSTR(ENAME, 1, 1), LENGTH(ENAME), '*') AS MASKING_ENAME
FROM EMP
WHERE LENGTH(ENAME)=5;
--6�� �������� 2��
SELECT EMPNO,ENAME,SAL,
TRUNC(SAL/21.5,2) AS DAY_PAY,
ROUND(SAL/21.5/8,1) AS TIME_PAY
FROM EMP;
--6�� �������� 3��
SELECT EMPNO,ENAME,HIREDATE,
TO_CHAR(NEXT_DAY(ADD_MONTHS(HIREDATE,3),'��'),'YYYY-MM-DD')AS R_JOB,
NVL(TO_CHAR(COMM),'N/A')AS COMM
FROM EMP;
--6�� �������� 4��
select empno,ename,MGR,
CASE 
WHEN MGR IS NULL THEN '0000'
WHEN SUBSTR(MGR,1,2)='78'THEN '8888'
WHEN SUBSTR(MGR,1,2)='77'THEN '7777'
WHEN SUBSTR(MGR,1,2)='76'THEN '6666'
WHEN SUBSTR(MGR,1,2)='75'THEN '5555'
ELSE TO_CHAR(MGR)
END AS CHG_MGR
FROM EMP;
--7-1 ������ �հ�,�ִ밪,�ּҰ�,��հ��� ��������
SELECT SUM(SAL),MAX(SAL),MIN(SAL),AVG(SAL)
FROM EMP;
--7-2 ����� ���ϱ�
SELECT COUNT(EMPNO)
FROM EMP;
--7-3 �μ��� �� ���ϱ�
SELECT COUNT(*)
FROM DEPT;
--7-4 ���ʽ� ���� ����� ��
SELECT COUNT(*)
FROM EMP
WHERE COMM IS NULL;
--7-5 10�� �μ��� ��� ��
SELECT COUNT(*)
FROM EMP
WHERE DEPTNO=10;
--7-6 �� �μ��� �����
SELECT DEPTNO,COUNT(*)
FROM EMP
GROUP BY DEPTNO
ORDER BY DEPTNO;

--7-7 �� �μ��� �ְ� ����
SELECT DEPTNO,MAX(SAL)
FROM EMP
GROUP BY DEPTNO
ORDER BY DEPTNO;

--7-8 �� �μ��� ����Ⱓ �ٹ��� ����� �Ի���
SELECT DEPTNO,MIN(HIREDATE)
FROM EMP
GROUP BY DEPTNO
ORDER BY DEPTNO;
--7-9 �μ���ȣ ���
SELECT DEPTNO
FROM EMP;
--7-10 �μ���ȣ ��� �ߺ�����
SELECT DISTINCT DEPTNO
FROM EMP;
--7-11 ���� ���
SELECT SUM(SAL),SUM(ALL SAL),SUM(DISTINCT SAL)
FROM EMP;
--7-12 �Ի��� ��� �ߺ�����,
SELECT DISTINCT HIREDATE
FROM EMP;
--7-13 30�� �μ��� �����
SELECT count(*)
FROM EMP
where deptno=30;
--7-14 10���μ��� �ְ� ���޾�
SELECT max(sal)
FROM EMP
where deptno=10;
--7-15 10���μ��� ���� ���޾�
SELECT min(sal)
FROM EMP
where deptno=10;
--7-16 20�� �μ��� �ֱ� �Ի����� �Ի���
SELECT max(hiredate)
FROM EMP
where deptno=20;
--7-17 20�� �μ��� �ְ� ��Ⱓ �ٹ��� ����� �Ի���
SELECT min(hiredate)
FROM EMP
where deptno=20;
--7-18 30�� �μ��� ��� ����
SELECT avg(sal)
FROM EMP
where deptno=30;
--7-19 30�� �μ��� ��� ���� �ߺ��� ����
SELECT avg(DISTINCT sal)
FROM EMP
where deptno=30;
--1�к���.185P
SELECT AVG(COMM)
FROM EMP
WHERE DEPTNO=30;
--7-20 �μ���ȣ 10,20,30������� ��� �޿��� �Ҽ��ڸ� ���ּ� ���
SELECT ROUND(avg(sal)),'10' AS DEPTNO FROM EMP WHERE DEPTNO = 10
UNION ALL
SELECT ROUND(avg(sal)),'20' AS DEPTNO FROM EMP WHERE DEPTNO = 20
UNION ALL
SELECT ROUND(avg(sal)),'30' AS DEPTNO FROM EMP WHERE DEPTNO = 30;
--7-21 �μ���ȣ,���޺� ��� ����
SELECT DEPTNO,JOB,AVG(SAL)
FROM EMP
GROUP BY DEPTNO,JOB
ORDER BY DEPTNO,JOB;
--188 1�к���
SELECT AVG(COMM)DEPTNO
FROM EMP
GROUP BY DEPTNO;
--7-22 �μ��� ���޺��� ������ 2000�̻��� ������� �μ���ȣ,����,��� ����,�μ���ȣ,
--���� ������ ���
SELECT DEPTNO,JOB,AVG(SAL)
FROM EMP
GROUP BY DEPTNO,JOB
HAVING AVG(SAL)>=2000
ORDER BY DEPTNO,JOB;
--7-23
SELECT DEPTNO,JOB,AVG(SAL)
FROM EMP
GROUP BY DEPTNO,JOB
HAVING AVG(SAL)>=2000 --WHERE ������ �׷��Լ��� �� �� ����.
ORDER BY DEPTNO,JOB;
--7-24 ������ 3000������ ������� ������� �μ�,���޺�,��պ����� 2000�̻��� 
SELECT DEPTNO,JOB,AVG(SAL)
FROM EMP
WHERE SAL <=3000
GROUP BY DEPTNO,JOB
HAVING AVG(SAL)>=2000 
ORDER BY DEPTNO,JOB;
--194 1�к���
SELECT DEPTNO,JOB,AVG(SAL)
FROM EMP
GROUP BY DEPTNO,JOB
HAVING AVG(SAL)>=500
ORDER BY DEPTNO,JOB;
--7-24
SELECT DEPTNO,JOB,COUNT(*),MAX(SAL),SUM(SAL),AVG(SAL)
FROM EMP
GROUP BY DEPTNO,JOB
ORDER BY DEPTNO,JOB;
--7-25 �μ�,���޺� �����,�ִ� ����,���� �հ�,��� ���� ���
SELECT DEPTNO,JOB,COUNT(*),MAX(SAL),SUM(SAL),AVG(SAL)
FROM EMP
GROUP BY ROLLUP(DEPTNO,JOB)
ORDER BY DEPTNO,JOB;
--7-26 
SELECT DEPTNO,JOB,COUNT(*),MAX(SAL),SUM(SAL),AVG(SAL)
FROM EMP
GROUP BY CUBE(DEPTNO,JOB)
ORDER BY DEPTNO,JOB;
--7-27 DEPTNO�� ���� �׷�ȭ�� rollup�Լ��� ����
SELECT DEPTNO,JOB,COUNT(*)
FROM EMP
GROUP BY DEPTNO,ROLLUP(JOB);
--7-28 job�� ���� �׷�ȭ�� rollup�Լ��� DEPTNO����
SELECT DEPTNO,JOB,COUNT(*)
FROM EMP
GROUP BY JOB, ROLLUP(DEPTNO);
--7-29
SELECT DEPTNO,JOB,COUNT(*)
FROM EMP
GROUP BY GROUPING SETS(DEPTNO,JOB)
ORDER BY DEPTNO,JOB;
--7-30
SELECT DEPTNO,JOB,COUNT(*)
FROM EMP
GROUP BY ROLLUP(JOB,DEPTNO); --��ü����� �� ���������� ��µ�.
--7-31 �μ���,���޺��� ����� ������ ���Ͽ���
SELECT DEPTNO,JOB,COUNT(*)
FROM EMP
GROUP BY GROUPING SETS(DEPTNO,JOB)
ORDER BY DEPTNO,JOB;
--7-32
SELECT DEPTNO, JOB, COUNT(*), MAX(SAL), SUM(SAL), AVG(SAL),
GROUPING(DEPTNO),
GROUPING(JOB)
FROM EMP
GROUP BY CUBE(DEPTNO, JOB) --������ �׸� ���ؼ� �ڼ��ϰ� ������
ORDER BY DEPTNO, JOB;
--7-33
SELECT DECODE(GROUPING(DEPTNO), 1, 'ALL_DEPT', DEPTNO) AS DEPTNO,--�μ���ȣ �׷����Ѱ� 1�̸� ALL_DEPT�� ����ϰ� 
DECODE(GROUPING(JOB), 1, 'ALL_JOB', JOB) AS JOB, --JOB�� �׷����Ͽ� 1�̸� ALL_JOB���� ���
COUNT(*), MAX(SAL), SUM(SAL), AVG(SAL)
FROM EMP
GROUP BY CUBE(DEPTNO, JOB)
ORDER BY DEPTNO, JOB;
