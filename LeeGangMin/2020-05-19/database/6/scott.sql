--실습 6-1
select ename, upper(ename), lower(ename), initcap(ename)
from emp;
--실습 6-2
select *
from emp
where upper(ename) = upper('scott');
--실습 6-3
select *
from emp
where upper(ename) like upper('%scott%');
--실습 6-4
select ename, length(ename)
from emp;
--실습 6-5
select ename, length(ename)
from emp
where length(ename) >= 5;
--실습 6-6
select length('한글'), lengthb('한글')
from dual;
--실습 6-7
select job, substr(job, 1, 2), substr(job, 3, 2), substr(job, 5)
from emp;
--실습 6-8
select job,
       substr(job, -length(job)),
       substr(job, -length(job), 2),
       substr(job, -3)
from emp;
--실습 6-9
select instr('HELLO, ORACLE!', 'L') as INSTR_1, 
       instr('HELLO, ORACLE!', 'L', 5) as INSTR_2, 
       instr('HELLO, ORACLE!', 'L', 2, 2) as INSTR_3 
    from dual;
--실습 6-10
select *
from emp
where instr(ENAME, 'S') > 0;
--실습 6-11
select *
from emp
where ename like '%S%';
--실습 6-12
select '010-1234-5678' as REPLACE_BEFORE,
       REPLACE('010-1234-5678', '-', ' ') as REPLACE_1,
       REPLACE('010-1234-5678', '-') as REPLACE_2
    from dual;
--실습 6-13
select 'Oracle',
       LPAD('Oracle', 10, '#') as LPAD_1,
       RPAD('Oracle', 10, '*') as RPAD_1,
       LPAD('Oracle', 10) as LPAD_2,
       RPAD('Oracle', 10) as RPAD_2
    from dual;
--실습 6-14
select
rpad('971225-', 14, '*') as RPAD_JMNO,
rpad('010-1234-', 13, '*') as RPAD_PHONE
from dual;
--실습 6-15
select concat(empno, ename),
       concat(empno, concat(' : ', ename))
from emp
where ename='SCOTT';
--실습 6-16
select '[' || TRIM(' _ _Oracle_ _ ') || ']' as TRIM,
       '[' || TRIM(LEADING FROM ' _ _Oracle_ _ ') || ']' as TRIM_LEADING,
       '[' || TRIM(TRAILING FROM ' _ _Oracle_ _ ') || ']' as TRIM_TRAILING,
       '[' || TRIM(BOTH FROM ' _ _Oracle_ _ ') || ']' as TRIM_BOTH
from dual;
--실습 6-17
select '[' || TRIM('_' FROM ' _ _Oracle_ _ ') || ']' as TRIM,
       '[' || TRIM(LEADING '_' FROM ' _ _Oracle_ _ ') || ']' as TRIM_LEADING,
       '[' || TRIM(TRAILING '_' FROM ' _ _Oracle_ _ ') || ']' as TRIM_TRAILING,
       '[' || TRIM(BOTH '_' FROM ' _ _Oracle_ _ ') || ']' as TRIM_BOTH
from dual;
--실습 6-18
select '[' || TRIM(' _Oracle_ ') || ']' as TRIM,
       '[' || LTRIM(' _Oracle_ ') || ']' as LTRIM,
       '[' || LTRIM('<_Oracle_>', '_<') || ']' as LTRIM_2,
       '[' || RTRIM(' _Oracle_ ') || ']' as RTRIM,
       '[' || RTRIM('<_Oracle_>', '>_') || ']' as RTRIM_2
from dual;
--실습 6-19
select round(1234.5678) as ROUND,
       round(1234.5678, 0) as ROUND_0,
       round(1234.5678, 1) as ROUND_1,
       round(1234.5678, 2) as ROUND_2,
       round(1234.5678, -1) as ROUND_MINUS1,
       round(1234.5678, -2) as ROUND_MINUS2
from dual;
--실습 6-20
select TRUNC(1234.5678) as TRUNC,
       TRUNC(1234.5678, 0) as TRUNC_0,
       TRUNC(1234.5678, 1) as TRUNC_1,
       TRUNC(1234.5678, 2) as TRUNC_2,
       TRUNC(1234.5678, -1) as TRUNC_MINUS1,
       TRUNC(1234.5678, -2) as TRUNC_MINUS2
from dual;
--실습 6-21
select ceil(3.14),
       floor(3.14),
       ceil(-3.14),
       floor(-3.14)
from dual;
--실습 6-22
select MOD(15, 6),
       MOD(10, 2),
       MOD(11, 2)
from dual;