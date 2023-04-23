-- Test.sql

DROP TABLE DEPT;
CREATE TABLE DEPT (
	DEPTNO NUMBER(2) CONSTRAINT PK_DEPT PRIMARY KEY, 
	DNAME VARCHAR2(14) ,
	LOC VARCHAR2(13) 
) ;

DROP TABLE EMP;
CREATE TABLE EMP  (
	EMPNO NUMBER(4) CONSTRAINT PK_EMP PRIMARY KEY,
	ENAME VARCHAR2(10),
	JOB VARCHAR2(9),
	MGR NUMBER(4),
	HIREDATE DATE,
	SAL NUMBER(7,2),
	COMM NUMBER(7,2),
	DEPTNO NUMBER(2) CONSTRAINT FK_DEPTNO REFERENCES DEPT
);

INSERT INTO DEPT VALUES (10,'ACCOUNTING','NEW YORK');
INSERT INTO DEPT VALUES (20,'RESEARCH','DALLAS');
INSERT INTO DEPT VALUES (30,'SALES','CHICAGO');
INSERT INTO DEPT VALUES (40,'OPERATIONS','BOSTON');
INSERT INTO EMP VALUES (7369,'SMITH','CLERK',7902,to_date('17-12-1980','dd-mm-yyyy'),800,NULL,20);
INSERT INTO EMP VALUES (7499,'ALLEN','SALESMAN',7698,to_date('20-2-1981','dd-mm-yyyy'),1600,300,30);

INSERT INTO EMP VALUES (7521,'WARD','SALESMAN',7698,to_date('22-2-1981','dd-mm-yyyy'),1250,500,30);
INSERT INTO EMP VALUES (7566,'JONES','MANAGER',7839,to_date('2-4-1981','dd-mm-yyyy'),2975,NULL,20);
INSERT INTO EMP VALUES (7654,'MARTIN','SALESMAN',7698,to_date('28-9-1981','dd-mm-yyyy'),1250,1400,30);
INSERT INTO EMP VALUES (7698,'BLAKE','MANAGER',7839,to_date('1-5-1981','dd-mm-yyyy'),2850,NULL,30);
INSERT INTO EMP VALUES (7782,'CLARK','MANAGER',7839,to_date('9-6-1981','dd-mm-yyyy'),2450,NULL,10);
INSERT INTO EMP VALUES (7788,'SCOTT','ANALYST',7566,to_date('13-7-1987','dd-mm-yyyy'),3000,NULL,20);
INSERT INTO EMP VALUES (7839,'KING','PRESIDENT',NULL,to_date('17-11-1981','dd-mm-yyyy'),5000,NULL,10);
INSERT INTO EMP VALUES (7844,'TURNER','SALESMAN',7698,to_date('8-9-1981','dd-mm-yyyy'),1500,0,30);
INSERT INTO EMP VALUES (7876,'ADAMS','CLERK',7788,to_date('13-7-1987','dd-mm-yyyy'),1100,NULL,20);
INSERT INTO EMP VALUES (7900,'JAMES','CLERK',7698,to_date('3-12-1981','dd-mm-yyyy'),950,NULL,30);
INSERT INTO EMP VALUES (7902,'FORD','ANALYST',7566,to_date('3-12-1981','dd-mm-yyyy'),3000,NULL,20);
INSERT INTO EMP VALUES (7934,'MILLER','CLERK',7782,to_date('23-1-1982','dd-mm-yyyy'),1300,NULL,10);

DROP TABLE BONUS;
CREATE TABLE BONUS (
 ENAME VARCHAR2(10) ,
 JOB VARCHAR2(9)  ,
 SAL NUMBER,
 COMM NUMBER
 ) ;

DROP TABLE SALGRADE;
CREATE TABLE SALGRADE( 
	GRADE NUMBER, 
	LOSAL NUMBER, 
	HISAL NUMBER 
);
INSERT INTO SALGRADE VALUES (1,700,1200);
INSERT INTO SALGRADE VALUES (2,1201,1400);
INSERT INTO SALGRADE VALUES (3,1401,2000);
INSERT INTO SALGRADE VALUES (4,2001,3000);
INSERT INTO SALGRADE VALUES (5,3001,9999);

COMMIT



//---------------------------------------------------------------------------------------


select * from employees;

select to_char(hire_date, 'YYYY'), count(*) from employees where hire_date >= '2000-01-01' group by to_char(hire_date, 'YYYY') order by to_char(hire_date, 'YYYY');
select to_char(hire_date, 'YYYY"년"') as year, to_char(hire_date, 'MM"월"') as month, count(*) from employees where hire_date >= '2000-01-01' group by to_char(hire_date, 'YYYY"년"'), to_char(hire_date, 'MM"월"') order by to_char(hire_date, 'YYYY"년"'), to_char(hire_date, 'MM"월"');
select to_char(hire_date, 'YYYY"년"') as year, to_char(hire_date, 'MM"월"') as month, count(*) from employees where hire_date >= '2000-01-01' group by to_char(hire_date, 'YYYY"년"'), to_char(hire_date, 'MM"월"') order by year, month;
select to_char(hire_date, 'YYYY"년"') as year, to_char(hire_date, 'MM"월"') as month, count(*) from employees where hire_date >= '2000-01-01' group by year, month order by year, month;

select to_char(hire_date, 'YYYY"년"') as year, to_char(hire_date, 'MM"월"') as month, count(*) from employees where hire_date >= '2000-01-01' group by to_char(hire_date, 'YYYY"년"'), to_char(hire_date, 'MM"월"') having to_char(hire_date, 'MM"월"') = '01월' order by year, month ;

select to_char(hire_date, 'YYYY"년"') as year, to_char(hire_date, 'MM"월"') as month, count(*) from employees where hire_date >= '2000-01-01' group by to_char(hire_date, 'YYYY"년"'), to_char(hire_date, 'MM"월"') order by year, month ;
select to_char(hire_date, 'YYYY"년"') as year, to_char(hire_date, 'MM"월"') as month, count(*) from employees where hire_date >= '2000-01-01' group by to_char(hire_date, 'YYYY"년"'), to_char(hire_date, 'MM"월"') having to_char(hire_date, 'YYYY"년"') > '2002' order by year, month ;





