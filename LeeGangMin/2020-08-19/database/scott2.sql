SELECT * FROM dept_tcl;

UPDATE dept_tcl SET LOC = 'BUSAN' WHERE deptno = 30;

ROLLBACK;

COMMIT;