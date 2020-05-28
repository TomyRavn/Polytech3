--1.
select sysdate
from emp;

select *
from dual;  --dual : 구색갖추기용(여러 개 필요없이 1개를 필요로 할 때) 임시 테이블

select sysdate
from dual;  --도구 환경설정 데이터베이스 NLS에서 형태 수정가능

select sysdate + 1
from dual;  --날짜 데이터에 연산 가능

select sysdate - (sysdate -1)
from dual;  --날짜 데이터 + 날짜 데이터 = 지원되지 않음(연산 불가)**

--2. 사원명과 이름을 대문자로, 소문자로, 첫자만 대문자로
select ename, upper(ename), lower(ename), initcap(ename)
from emp;

--3. 이름이 소문자 scott인 사람 검색
select *
from emp
where upper(ename) = upper('scott');

--4. 이름에 scott이 든 사람
select *
from emp
where upper(ename) like upper('%scott%');

--5. 이름과 이름의 길이를 출력
select ename, length(ename)
from emp;

--6. 이름의 길이가 5자 이상인 사람만 출력
select ename, length(ename)
from emp
where length(ename) >= 5;

--7. 본인 이름 글자 한글로 넣어서 몇 글자와 몇 바이트인지 확인
select length('이강민'), lengthb('이강민')
from dual;

--8. job, job 첫 자부터 두 글자, 셋째 글자부터 2글자, 5번째 글자부터 끝까지 출력
select job, substr(job, 1, 2), substr(job, 3, 2), substr(job, 5)
from emp;