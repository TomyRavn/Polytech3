--1. TEST
select *
from emp
where sal BETWEEN 1000 AND 2000;

select *
from emp
where sal >= 1000 and sal <= 2000;

--2. ��� �̸��� ù 3�� ���
select SUBSTR(ENAME,1,3)
from emp;

--3.
select SUBSTR(ENAME,4,3)
from emp;

--4.
select JOB,                   -- length�� �����Ͷ� ����
  substr(JOB, LENGTH(JOB)),  -- -length�� ��ü; -�� �ڿ������� �̾Ƴ��� �ǹ� (�⺻�� 1�̴�)
  substr(JOB, -LENGTH(JOB), 2), --��ü ���̿��� �տ��� 2��
  substr(JOB, -3)             -- -3�� �ڿ��� 3����
from emp;

--5.
select INSTR('HELLO, ORACLE!', 'L') AS INSTR_1,
       INSTR('HELLO, ORACLE!', 'L', 5) AS INSTR_2,
       INSTR('HELLO, ORACLE!', 'L', 2, 2) AS INSTR_3  -- 2��° ���� ���Ŀ� 2��° L�� ��ġ ã��
    from DUAL;
    
--6. TEST(��� �̸����� S�� ����ִ� �̸�)
select *
from emp
where INSTR(ename, 'S') > 0;

select *
from emp
where ename like '%S%';

--7.
select '010-1234-5678' as REPLACE_BEFORE,
    REPLACE('010-1234-5678', '-', ' ') as REPLACE_1,
    REPLACE('010-1234-5678', '-') as REPLACE_2
from DUAL;

--8.
select 'Oracle',
    LPAD('Oracle', 10, '#') as LPAD_1,  --LPAD�� ���ʿ�, RPAD�� �����ʿ� ä����
    RPAD('Oracle', 10, '*') as RPAD_1,
    LPAD('Oracle', 10) as LPAD_2,
    RPAD('Oracle', 10) as RPAD_2
  from DUAL;
  
--9. ��� �̸����� ���� 3�ڸ��� �̰� ��ü 10�ڸ��� �������� *�� ä���
select RPAD(SUBSTR(ENAME,1,3), 10, '*') as RPAD_ENAME     -- -length(ENAME), 3
from emp;

--10. 971225- �ڴ� ��� ����(���ڿ� 14ĭ ����, �������� *)
select RPAD('971225-', 14, '*') as RPAD_NO
from dual;

--11. concat : ��ġ��
select concat('ABC', 'DEF')
from dual;

--12. �����ȣ:�����
select concat(concat(EMPNO,':'),ENAME)
from emp;

select EMPNO||':'||ENAME    -- || : ���̶�� �ǹ�
from emp;

--13. TRIM : �ڸ��ٴ� �ǹ�(������)
select '['||TRIM(' - -Oracle- - ')||']' AS TRIM,    --1���� 4���� ���� ������ �ڸ�
'['||TRIM(LEADING FROM ' - -Oracle- - ')||']' AS TRIM_LEADING,  --���� (1�� ���鸸 �ڸ�)
'['||TRIM(TRAILING FROM ' - -Oracle- - ')||']' AS TRIM_LEADING, --������ (4�� ���鸸 �ڸ�)
'['||TRIM(BOTH FROM ' - -Oracle- - ')||']' AS TRIM_BOTH         --������ ������ ����� (1���� 4�� ����) / TRIM�� TRIM_BOTH�� ���� ���(���ʸ� ������ �ִٸ� ���ʸ� ����� �ȴ�)
from dual;

--14.
select '['||TRIM(' -Oracle- ')||']' AS TRIM,
       '['||LTRIM(' -Oracle- ')||']' AS LTRIM,
       '['||LTRIM('<-Oracle->', '-<')||']' AS LTRIM_2,    --���ʿ� �ִ� '-','<' ���� ������� ���������� ���°� �� �ڸ�
       '['||RTRIM(' -Oracle- ')||']' AS RTRIM,
       '['||RTRIM('<-Oracle->', '->')||']' AS RTRIM_2
       --'['||TRIM('<-Oracle->','>-')||']' AS TRIM_BOTH : �Ұ���
from dual;

--15. 567.567 �ݿø��ؼ� �Ҽ� 1�ڸ��� ROUND(567.567, 1)
select ROUND(567.567,1)
from dual;

--16.
select ROUND(1234.5678) as ROUND,             -- �Ҽ� ���� ��� �ݿø�
       ROUND(1234.5678, 0) as ROUND_0,        -- ����
       ROUND(1234.5678, 1) as ROUND_1,
       ROUND(1234.5678, 2) as ROUND_2,
       ROUND(1234.5678, -1) as ROUND_MINUS1,  -- -1�� ���׶�� �Ѱ� �߰�
       ROUND(1234.5678, -2) as ROUND_MINUS2
from dual;

--17. ���� 1000�� ������ �ݿø�
select * from emp;

select ENAME||':'||ROUND(SAL, -3)||'��' as ROUND_SAL
from emp;

--18. TRUNC �ڸ� -> ����
select TRUNC(1234.5678) as TRUNC,
       TRUNC(1234.5678, 0) as TRUNC_0,
       TRUNC(1234.5678, 1) as TRUNC_1,
       TRUNC(1234.5678, 2) as TRUNC_2,
       TRUNC(1234.5678, -1) as TRUNC_MINUS1,
       TRUNC(1234.5678, -2) as TRUNC_MINUS2
from dual;

--19. ���� 1000�� ������ ����
select ENAME||':'||TRUNC(SAL, -3)||'��' as TRUNC_SAL
from emp;

--20.
select CEIL(3.14),
       FLOOR(3.14),
       CEIL(-3.14),
       FLOOR(-3.14)
from dual;

--21. ������
select MOD(15,6),
       MOD(10,2),
       MOD(11,2)
from dual;

--22. ���� ��¥ �̱�
select SYSDATE, ADD_MONTHS(SYSDATE, 3)  --���÷κ��� 3���� ���� ��¥ ���
from dual;

select SYSDATE + 100                    --���÷κ��� 100�� ��
from dual;

select SYSDATE - 100
from dual;

--Ư�� ��¥
select TO_DATE('2020-05-26', 'YYYY-MM-DD') + 100 -- 2020-05-26�̶� ���ڸ� YYYY-MM-DD�� ��¥�� ����
from dual;

select SYSDATE, ADD_MONTHS(SYSDATE, 3.5)
from dual;

--24. ��� ��ȣ, �̸�, �Ի���, �Ի� �� 120����(10��) ���� ��¥
select EMPNO, ENAME, HIREDATE, ADD_MONTHS(HIREDATE, 120) as WORK_10YEARS
from emp;

--25.
select EMPNO, ENAME, HIREDATE, SYSDATE
from emp
where ADD_MONTHS(HIREDATE, 450) > SYSDATE; -- ���� �ټӱⰣ�� 450���� �̸��� ��� ���

--26.
select EMPNO, ENAME, HIREDATE, SYSDATE,
  MONTHS_BETWEEN(HIREDATE, SYSDATE) AS MONTHS1,   --�Ի��ϰ� ���ó�¥ ���̸� �����ָ� �׵��� �ٹ��� �Ⱓ�� ����
  MONTHS_BETWEEN(SYSDATE, HIREDATE) AS MONTHS2,   --���� ��¥�� ū ���̹Ƿ� �տ� ��
  TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) AS MONTHS3
from emp;

--27. ���� ��¥�� ������ ���� ���� '������'�� ��������?
select SYSDATE, NEXT_DAY(SYSDATE,'��'), LAST_DAY(SYSDATE)  --'������'�� ����
from dual;

--28. ��¥�� �ݿø��� ��
select SYSDATE,
      ROUND(SYSDATE, 'CC') AS FORMAT_CC,
      ROUND(SYSDATE, 'YYYY') AS FORMAT_YYYY,
      ROUND(SYSDATE, 'Q') AS FORMAT_Q,
      ROUND(SYSDATE, 'DDD') AS FORMAT_DDD,
      ROUND(SYSDATE, 'HH') AS FORMAT_HH
from dual;

--29. SCOTT��� ����� �����ȣ, �̸�, �����ȣ+500 ���
select EMPNO, ENAME, EMPNO+'500'
from emp
where ENAME='SCOTT';

--30. ABCD��� ���ڿ��� �����ȣ �տ� �ٿ��� ���, �����ȣ ��� (+�� ������ ����)
select 'ABCD' || EMPNO, EMPNO
from emp
where ENAME='SCOTT';

--31. ������ ��¥, �ú��� ���(TO_CHAR : ���ڸ� ���ڷ� ��ȯ) // ��Ī �ѱ۷� ����
SELECT SYSDATE, TO_CHAR(SYSDATE, 'YYYY/MM/DD HH24:MI:SS') AS ���糯¥�ð�
from dual;
            --HH12�� 12�ð� ����
            
--32. ������ ��¥�� ��, ����, ��
SELECT SYSDATE,
  TO_CHAR(SYSDATE,'MM') AS MM
FROM DUAL;

SELECT SYSDATE,
  TO_CHAR(SYSDATE,'MON') AS MM
FROM DUAL;

--MON�� MONTH�� ������ �����ε� ������ �����ϰ� ����
SELECT SYSDATE,
  TO_CHAR(SYSDATE,'MM') AS MM,
  TO_CHAR(SYSDATE,'MON') AS MON,
  TO_CHAR(SYSDATE,'MONTH') AS MONTH,
  TO_CHAR(SYSDATE,'DD') AS DD,
  TO_CHAR(SYSDATE,'DY') AS DY,
  TO_CHAR(SYSDATE,'DAY') AS DAY
FROM DUAL;

--33.
SELECT SYSDATE,
  TO_CHAR(SYSDATE, 'MM') AS MM,
  TO_CHAR(SYSDATE, 'MON', 'NLS_DATE_LANGUAGE = KOREAN') AS MON_KOR,
  TO_CHAR(SYSDATE, 'MON', 'NLS_DATE_LANGUAGE = JAPANESE') AS MON_JAP,
  TO_CHAR(SYSDATE, 'MON', 'NLS_DATE_LANGUAGE = ENGLISH') AS MON_ENG,
  TO_CHAR(SYSDATE, 'MONTH', 'NLS_DATE_LANGUAGE = KOREAN') AS MONTH_KOR,
  TO_CHAR(SYSDATE, 'MONTH', 'NLS_DATE_LANGUAGE = JAPANESE') AS MONTH_JAP,
  TO_CHAR(SYSDATE, 'MONTH', 'NLS_DATE_LANGUAGE = ENGLISH') AS MONTH_ENG
from dual;

--34.
SELECT SYSDATE,
  TO_CHAR(SYSDATE, 'MM') AS MM,
  TO_CHAR(SYSDATE, 'DD') AS DD,
  TO_CHAR(SYSDATE, 'DY', 'NLS_DATE_LANGUAGE = KOREAN') AS DY_KOR,
  TO_CHAR(SYSDATE, 'DY', 'NLS_DATE_LANGUAGE = JAPANESE') AS DY_JAP,
  TO_CHAR(SYSDATE, 'DY', 'NLS_DATE_LANGUAGE = ENGLISH') AS DY_ENG,
  TO_CHAR(SYSDATE, 'DAY', 'NLS_DATE_LANGUAGE = KOREAN') AS DAY_KOR,
  TO_CHAR(SYSDATE, 'DAY', 'NLS_DATE_LANGUAGE = JAPANESE') AS DAY_JAP,
  TO_CHAR(SYSDATE, 'DAY', 'NLS_DATE_LANGUAGE = ENGLISH') AS DAY_ENG
from dual;

--35. �Լ��� �켱���� : �Ⱥ��� ó�� �� ���� �Լ��� ó��
SELECT SYSDATE,
  TO_CHAR(SYSDATE, 'HH24:MI:SS') AS HH24MISS,
  TO_CHAR(SYSDATE, 'HH12:MI:SS AM') AS HH12MISS_AM,
  TO_CHAR(SYSDATE, 'HH12:MI:SS PM') AS HH12MISS_PM,
  TO_CHAR(SYSDATE, 'HH:MI:SS P.M.') AS HHMISS_PM
from dual;

--36. 0�� ���� ���� ������ �� 0���� ������ ä����, 9�� ����
SELECT SAL,
  TO_CHAR(SAL, '$999,999') AS SAL_$,
  TO_CHAR(SAL, 'L999,999') AS SAL_L,
  TO_CHAR(SAL, '999,999.00') AS SAL_1,
  TO_CHAR(SAL, '000,999,999.00') AS SAL_2,
  TO_CHAR(SAL, '000999999.99') AS SAL_3,
  TO_CHAR(SAL, '999,999,00') AS SAL_4
  --TO_CHAR(SAL, '999,090,00') AS SAL_5
from emp;

--37.
SELECT 1300 - '1500',
  '1300' + 1500
FROM DUAL;

--38. ,�� ���� �� ���ڿ��� ���� ������ �ڵ�����ȯ�ؼ� ��� X
SELECT '1,300' - '1,500'
FROM DUAL;

--39. TO_NUMBER : ���ڷ� �ٲ��� (1,300�� 999,999 ������ �������� �νĽ����ְ� ���ڷ� �ٲ���)
SELECT TO_NUMBER('1,300', '999,999') - TO_NUMBER('1,500', '999,999')
FROM DUAL;

--40.
SELECT TO_DATE('2018-07-14', 'YYYY-MM-DD') AS TODATE1,
       TO_DATE('20180714', 'YYYY-MM-DD') AS TODATE2
FROM DUAL;

--41. �Ի����� 1981�� 6�� 1�� ���Ŀ� �Ի��� ����� ����
SELECT *
FROM EMP
WHERE HIREDATE>='81-06-01';
      -- �ý��� �� �������� ������ �ν� ���� �� ����
SELECT *
FROM EMP
WHERE HIREDATE >= TO_DATE('1981/06/01', 'YYYY/MM/DD');
      -- TO_DATE �Լ��� �̿��� � �������� Ȯ���� ��������� ǥ��
      
--42.
SELECT TO_DATE('49/12/10', 'YY/MM/DD') AS YY_YEAR_49,
       TO_DATE('49/12/10', 'RR/MM/DD') AS RR_YEAR_49,
       TO_DATE('50/12/10', 'YY/MM/DD') AS YY_YEAR_50,
       TO_DATE('50/12/10', 'RR/MM/DD') AS RR_YEAR_50,
       TO_DATE('51/12/10', 'YY/MM/DD') AS YY_YEAR_51,
       TO_DATE('51/12/10', 'RR/MM/DD') AS RR_YEAR_51
FROM DUAL;

--43. NVL : Null Value
SELECT EMPNO, ENAME, SAL, COMM, SAL+COMM,
      NVL(COMM, 0),
      SAL+NVL(COMM, 0)  -- comm�� null�̸� 0���� �ٲ㼭 ���
FROM EMP;

--44. COMM�� ������ X�� ���, ������ O�� ���(null�� �� X)
-- ���� ���
SELECT EMPNO, ENAME, COMM, NVL2(COMM, 'O', 'X'),
      NVL2(COMM, SAL*12+COMM, SAL*12) AS ANNSAL
FROM EMP;