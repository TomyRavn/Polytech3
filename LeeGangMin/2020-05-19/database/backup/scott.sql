--1.
select sysdate
from emp;

select *
from dual;  --dual : �������߱��(���� �� �ʿ���� 1���� �ʿ�� �� ��) �ӽ� ���̺�

select sysdate
from dual;  --���� ȯ�漳�� �����ͺ��̽� NLS���� ���� ��������

select sysdate + 1
from dual;  --��¥ �����Ϳ� ���� ����

select sysdate - (sysdate -1)
from dual;  --��¥ ������ + ��¥ ������ = �������� ����(���� �Ұ�)**

--2. ������ �̸��� �빮�ڷ�, �ҹ��ڷ�, ù�ڸ� �빮�ڷ�
select ename, upper(ename), lower(ename), initcap(ename)
from emp;

--3. �̸��� �ҹ��� scott�� ��� �˻�
select *
from emp
where upper(ename) = upper('scott');

--4. �̸��� scott�� �� ���
select *
from emp
where upper(ename) like upper('%scott%');

--5. �̸��� �̸��� ���̸� ���
select ename, length(ename)
from emp;

--6. �̸��� ���̰� 5�� �̻��� ����� ���
select ename, length(ename)
from emp
where length(ename) >= 5;

--7. ���� �̸� ���� �ѱ۷� �־ �� ���ڿ� �� ����Ʈ���� Ȯ��
select length('�̰���'), lengthb('�̰���')
from dual;

--8. job, job ù �ں��� �� ����, ��° ���ں��� 2����, 5��° ���ں��� ������ ���
select job, substr(job, 1, 2), substr(job, 3, 2), substr(job, 5)
from emp;