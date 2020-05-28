--1. TEST
select *
from emp
where sal BETWEEN 1000 AND 2000;

select *
from emp
where sal >= 1000 and sal <= 2000;

--2. 사원 이름의 첫 3자 출력
select SUBSTR(ENAME,1,3)
from emp;

--3.
select SUBSTR(ENAME,4,3)
from emp;

--4.
select JOB,                   -- length를 포인터라 생각
  substr(JOB, LENGTH(JOB)),  -- -length는 전체; -는 뒤에서부터 뽑아냄을 의미 (기본은 1이다)
  substr(JOB, -LENGTH(JOB), 2), --전체 길이에서 앞에서 2개
  substr(JOB, -3)             -- -3은 뒤에서 3글자
from emp;

--5.
select INSTR('HELLO, ORACLE!', 'L') AS INSTR_1,
       INSTR('HELLO, ORACLE!', 'L', 5) AS INSTR_2,
       INSTR('HELLO, ORACLE!', 'L', 2, 2) AS INSTR_3  -- 2번째 글자 이후에 2번째 L의 위치 찾기
    from DUAL;
    
--6. TEST(사원 이름에서 S가 들어있는 이름)
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
    LPAD('Oracle', 10, '#') as LPAD_1,  --LPAD는 왼쪽에, RPAD는 오른쪽에 채워라
    RPAD('Oracle', 10, '*') as RPAD_1,
    LPAD('Oracle', 10) as LPAD_2,
    RPAD('Oracle', 10) as RPAD_2
  from DUAL;
  
--9. 사원 이름에서 앞의 3자리만 뽑고 전체 10자리로 오른쪽은 *로 채우기
select RPAD(SUBSTR(ENAME,1,3), 10, '*') as RPAD_ENAME     -- -length(ENAME), 3
from emp;

--10. 971225- 뒤는 모두 별로(문자열 14칸 적음, 오른쪽은 *)
select RPAD('971225-', 14, '*') as RPAD_NO
from dual;

--11. concat : 합치다
select concat('ABC', 'DEF')
from dual;

--12. 사원번호:사원명
select concat(concat(EMPNO,':'),ENAME)
from emp;

select EMPNO||':'||ENAME    -- || : 붙이라는 의미
from emp;

--13. TRIM : 자른다는 의미(끝부터)
select '['||TRIM(' - -Oracle- - ')||']' AS TRIM,    --1번과 4번의 끝의 공백을 자름
'['||TRIM(LEADING FROM ' - -Oracle- - ')||']' AS TRIM_LEADING,  --왼쪽 (1번 공백만 자름)
'['||TRIM(TRAILING FROM ' - -Oracle- - ')||']' AS TRIM_LEADING, --오른쪽 (4번 공백만 자름)
'['||TRIM(BOTH FROM ' - -Oracle- - ')||']' AS TRIM_BOTH         --양쪽의 공백을 지운다 (1번과 4번 공백) / TRIM과 TRIM_BOTH는 같은 기능(한쪽만 공백이 있다면 한쪽만 지우게 된다)
from dual;

--14.
select '['||TRIM(' -Oracle- ')||']' AS TRIM,
       '['||LTRIM(' -Oracle- ')||']' AS LTRIM,
       '['||LTRIM('<-Oracle->', '-<')||']' AS LTRIM_2,    --왼쪽에 있는 '-','<' 순서 상관없이 연속적으로 나온건 다 자름
       '['||RTRIM(' -Oracle- ')||']' AS RTRIM,
       '['||RTRIM('<-Oracle->', '->')||']' AS RTRIM_2
       --'['||TRIM('<-Oracle->','>-')||']' AS TRIM_BOTH : 불가능
from dual;

--15. 567.567 반올림해서 소수 1자리로 ROUND(567.567, 1)
select ROUND(567.567,1)
from dual;

--16.
select ROUND(1234.5678) as ROUND,             -- 소수 이하 모두 반올림
       ROUND(1234.5678, 0) as ROUND_0,        -- 동일
       ROUND(1234.5678, 1) as ROUND_1,
       ROUND(1234.5678, 2) as ROUND_2,
       ROUND(1234.5678, -1) as ROUND_MINUS1,  -- -1은 동그라미 한개 추가
       ROUND(1234.5678, -2) as ROUND_MINUS2
from dual;

--17. 봉급 1000원 단위로 반올림
select * from emp;

select ENAME||':'||ROUND(SAL, -3)||'원' as ROUND_SAL
from emp;

--18. TRUNC 자름 -> 버림
select TRUNC(1234.5678) as TRUNC,
       TRUNC(1234.5678, 0) as TRUNC_0,
       TRUNC(1234.5678, 1) as TRUNC_1,
       TRUNC(1234.5678, 2) as TRUNC_2,
       TRUNC(1234.5678, -1) as TRUNC_MINUS1,
       TRUNC(1234.5678, -2) as TRUNC_MINUS2
from dual;

--19. 봉급 1000원 단위로 버림
select ENAME||':'||TRUNC(SAL, -3)||'원' as TRUNC_SAL
from emp;

--20.
select CEIL(3.14),
       FLOOR(3.14),
       CEIL(-3.14),
       FLOOR(-3.14)
from dual;

--21. 나머지
select MOD(15,6),
       MOD(10,2),
       MOD(11,2)
from dual;

--22. 오늘 날짜 뽑기
select SYSDATE, ADD_MONTHS(SYSDATE, 3)  --오늘로부터 3개월 뒤의 날짜 출력
from dual;

select SYSDATE + 100                    --오늘로부터 100일 뒤
from dual;

select SYSDATE - 100
from dual;

--특정 날짜
select TO_DATE('2020-05-26', 'YYYY-MM-DD') + 100 -- 2020-05-26이란 문자를 YYYY-MM-DD의 날짜로 변경
from dual;

select SYSDATE, ADD_MONTHS(SYSDATE, 3.5)
from dual;

--24. 사원 번호, 이름, 입사일, 입사 후 120개월(10년) 후의 날짜
select EMPNO, ENAME, HIREDATE, ADD_MONTHS(HIREDATE, 120) as WORK_10YEARS
from emp;

--25.
select EMPNO, ENAME, HIREDATE, SYSDATE
from emp
where ADD_MONTHS(HIREDATE, 450) > SYSDATE; -- 아직 근속기간이 450개월 미만인 사람 출력

--26.
select EMPNO, ENAME, HIREDATE, SYSDATE,
  MONTHS_BETWEEN(HIREDATE, SYSDATE) AS MONTHS1,   --입사일과 오늘날짜 사이를 적어주면 그동안 근무한 기간이 나옴
  MONTHS_BETWEEN(SYSDATE, HIREDATE) AS MONTHS2,   --오늘 날짜가 큰 값이므로 앞에 둠
  TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) AS MONTHS3
from emp;

--27. 오늘 날짜와 오늘이 지난 후의 '월요일'이 언제인지?
select SYSDATE, NEXT_DAY(SYSDATE,'월'), LAST_DAY(SYSDATE)  --'월요일'도 가능
from dual;

--28. 날짜도 반올림이 됨
select SYSDATE,
      ROUND(SYSDATE, 'CC') AS FORMAT_CC,
      ROUND(SYSDATE, 'YYYY') AS FORMAT_YYYY,
      ROUND(SYSDATE, 'Q') AS FORMAT_Q,
      ROUND(SYSDATE, 'DDD') AS FORMAT_DDD,
      ROUND(SYSDATE, 'HH') AS FORMAT_HH
from dual;

--29. SCOTT라는 사원의 사원번호, 이름, 사원번호+500 출력
select EMPNO, ENAME, EMPNO+'500'
from emp
where ENAME='SCOTT';

--30. ABCD라는 문자열을 사원번호 앞에 붙여서 찍고, 사원번호 출력 (+는 먹히지 않음)
select 'ABCD' || EMPNO, EMPNO
from emp
where ENAME='SCOTT';

--31. 오늘의 날짜, 시분초 출력(TO_CHAR : 숫자를 문자로 변환) // 별칭 한글로 가능
SELECT SYSDATE, TO_CHAR(SYSDATE, 'YYYY/MM/DD HH24:MI:SS') AS 현재날짜시간
from dual;
            --HH12는 12시간 기준
            
--32. 오늘의 날짜를 월, 요일, 일
SELECT SYSDATE,
  TO_CHAR(SYSDATE,'MM') AS MM
FROM DUAL;

SELECT SYSDATE,
  TO_CHAR(SYSDATE,'MON') AS MM
FROM DUAL;

--MON과 MONTH는 길이의 차이인데 지금은 동일하게 보임
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

--35. 함수의 우선순위 : 안부터 처리 후 밖의 함수를 처리
SELECT SYSDATE,
  TO_CHAR(SYSDATE, 'HH24:MI:SS') AS HH24MISS,
  TO_CHAR(SYSDATE, 'HH12:MI:SS AM') AS HH12MISS_AM,
  TO_CHAR(SYSDATE, 'HH12:MI:SS PM') AS HH12MISS_PM,
  TO_CHAR(SYSDATE, 'HH:MI:SS P.M.') AS HHMISS_PM
from dual;

--36. 0을 넣은 곳은 공백일 시 0으로 무조건 채워줌, 9는 숫자
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

--38. ,가 있을 시 문자열로 보기 때문에 자동형변환해서 계산 X
SELECT '1,300' - '1,500'
FROM DUAL;

--39. TO_NUMBER : 숫자로 바꿔줌 (1,300을 999,999 형식의 숫자임을 인식시켜주고 숫자로 바꿔줌)
SELECT TO_NUMBER('1,300', '999,999') - TO_NUMBER('1,500', '999,999')
FROM DUAL;

--40.
SELECT TO_DATE('2018-07-14', 'YYYY-MM-DD') AS TODATE1,
       TO_DATE('20180714', 'YYYY-MM-DD') AS TODATE2
FROM DUAL;

--41. 입사일이 1981년 6월 1일 이후에 입사한 사람의 정보
SELECT *
FROM EMP
WHERE HIREDATE>='81-06-01';
      -- 시스템 상 순서등의 이유로 인식 못할 수 있음
SELECT *
FROM EMP
WHERE HIREDATE >= TO_DATE('1981/06/01', 'YYYY/MM/DD');
      -- TO_DATE 함수를 이용해 어떤 형식인지 확실히 명시적으로 표시
      
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
      SAL+NVL(COMM, 0)  -- comm이 null이면 0으로 바꿔서 계산
FROM EMP;

--44. COMM이 없으면 X로 출력, 있으면 O로 출력(null일 때 X)
-- 연봉 계산
SELECT EMPNO, ENAME, COMM, NVL2(COMM, 'O', 'X'),
      NVL2(COMM, SAL*12+COMM, SAL*12) AS ANNSAL
FROM EMP;