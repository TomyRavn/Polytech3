SELECT * FROM book;

SELECT * FROM
    (SELECT * FROM book ORDER BY bookid DESC) sub;

--�ְ��� ���� : � �������� ���������̼��� �Ǿ ����
--���� : DB�� �����ϰ� �ǹǷ� ���� ���� ���� �߻�
SELECT * FROM
  (SELECT ROWNUM rn, sub.* FROM
    (SELECT * FROM book ORDER BY bookid DESC) sub)
WHERE rn BETWEEN (2 - 1) * 5 + 1 AND 2 * 5;