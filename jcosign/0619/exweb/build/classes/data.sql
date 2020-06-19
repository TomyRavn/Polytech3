
SELECT * FROM MEMBER;

SELECT mem_id, mem_pass, mem_name, mem_point FROM member;

SELECT * FROM student;
--�л����̺�
CREATE TABLE student (
stu_no VARCHAR29(50),	--�й�
stu_name VARCHAR2(50),	--�̸�
stu_score NUMBER(10,0),	--����
PRIMARY KEY (stu_no)
);

-- �Խ���
CREATE TABLE bbs(
bbs_no NUMBER(10,0),	--�۹�ȣ
bbs_title VARCHAR2(100),	--������
bbs_content CLOB,	--�۳���
bbs_writer VARCHAR2(50),	--�ۼ����� ID
bbs_reg_date DATE DEFAULT SYSDATE,	--�۵����(�ۼ���)
bbs_count NUMBER(10,0) DEFAULT 0,	--��ȸ��
PRIMARY KEY (bbs_no),
FOREIGN KEY (bbs_writer) REFERENCES member (mem_id)
);	--������������,�ۼ�������IP�ּ�,....

insert into bbs(bbs_no,bbs_title, bbs_content, bbs_writer)
values(seq_bbs_no.NEXTVAL,'�׽�Ʈ����','�׽�Ʈ����','a001');

SELECT * FROM bbs;
SELECT bbs_no, bbs_title, bbs_writer, bbs_reg_date, bbs_count FROM bbs;

--������ (�Խ��� �۹�ȣ�� ���� �ڵ����� ������ ����)
CREATE SEQUENCE seq_bbs_no;

SELECT seq_bbs_no.NEXTVAL FROM DUAL;	--�������� ������(������ ��) ��������
SELECT seq_bbs_no.CURRVAL FROM DUAL;	--�������� ���簪 ��������