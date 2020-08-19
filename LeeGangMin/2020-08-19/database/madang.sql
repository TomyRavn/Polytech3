SELECT * FROM book;

SELECT * FROM
    (SELECT * FROM book ORDER BY bookid DESC) sub;

--최고의 장점 : 어떤 쿼리에든 페이지네이션이 되어서 나옴
--단점 : DB에 접근하게 되므로 성능 저하 문제 발생
SELECT * FROM
  (SELECT ROWNUM rn, sub.* FROM
    (SELECT * FROM book ORDER BY bookid DESC) sub)
WHERE rn BETWEEN (2 - 1) * 5 + 1 AND 2 * 5;