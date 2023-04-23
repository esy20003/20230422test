-- 10_JOIN.sql

-- JOIN
-- 두개이상의 테이블에 나눠져 있는 관련 데이터들을 하나의 테이블로 모아서 조회하고자 할때 사용하는 명령입니다.

--[1] 이름 Douglas Grant 인 사원이  근무하는 부서명을  출력하고자 한다면...
select department_id from employees where emp_name='Douglas Grant';
-- 위명령을 실행후 얻어진 부서번호로 아래와 같이 부서번호 검색하여 부서명을 알아냅니다
select department_name   from departments where department_id=50;

-- 위의 두개의 명령을 하나의 명형으로 합해주는 역할을 join 명령이 실행합니다
--[2] join : 두개이상의 테이블에 나뉘어 져 있는 데이터를 한번의 sql문으로 원하는 결과를 얻습니다


--cross join : 두개 이상의 테이블이 조인될때 where절에 의해 공통되는 컬럼에 의한 결합이 발생하지 않는 경우 
-- * 가장 최악의 결과를 얻는 조인 방식
-- A 테이블과 B 테이블의 cross join 된다면
-- A테이블의 1번 레코드와 B테이블의 모든 레코드와 하나하나 모두 조합
-- A테이블의 2번 레코드와 B테이블의 모든 레코드와 하나하나 모두 조합
-- A테이블의 3번 레코드와 B테이블의 모든 레코드와 하나하나 모두 조합
-- ....

create table A(
a1 varchar2(5),
a2 varchar2(5),
a3 varchar2(5)
);
create table B(
b1 varchar2(5),
b2 varchar2(5),
b3 varchar2(5)
);
insert into  A values('ar1', 'ar1', 'ar1');
insert into  A values('ar2', 'ar2', 'ar2');
insert into  A values('ar3', 'ar3', 'ar3');
delete from B;
insert into  B values('br1', 'br1', 'ar1');
insert into  B values('br2', 'br2', 'ar2');
insert into  B values('br3', 'br3', 'ar3');
insert into  B values('br4', 'br4', 'ar3');

select * from A;
select * from B;

-- cross조인 : 별도의 조건이나 키워드 없이 from 뒤에 테이블이름을 컴마로 구분해서 두개이상쓰면 cross 조인이 됩니다
select * from A, B;


-- A테이블의 레코드가 8개, B테이블의 레코드가 7개 라면 총 크로스조인의 결과 레코드수는 8x7 = 56
-- A테이블의 필드가 8개, B테이블의 필드가 3개 라면 총 크로스조인의 결과 필드수는 8+3 = 11
 select * from dept   -- 레코드 4, 필드 3
 select * from emp  -- 레코드 14, 필드 8

 -- 크로스 조인 
select * from dept, emp   -- 레코드 56, 필드 11

--equi join : 조인 대상이 되는 두테이블에서 공통적으로 존재하는 컬럼의 값이 일치하는 행을 연결하여 결과를 생성
select * from dept, emp where emp.deptno = dept.deptno;


-- 각 사원의 이름, 부서번호, 부서명, 지역을 출력하세요. (emp, dept)
select ename, A.deptno, dname, loc from emp A, dept B where A.deptno = B.deptno;

-- 이름이 SCOTT인 사원의 이름, 부서번호, 부서명, 지역 출력 (emp, dept)
select ename, A.deptno, dname, loc from emp A, dept B where A.deptno = B.deptno and ename = 'SCOTT';
-- 컬럼 명 앞에 테이블 명을 기술하여 컬럼의 소속을 명확히 해주어야 오류가 없습니다.

-- 테이블 명에 별칭을 부여한 후 컬럼 앞에 소속 테이블을 지정
-- 테이블 명으로 소속을 기술 할때는 한쪽에만 있는 필드에 생략이 가능
-- 동일한 필드명의 경우 반드시 소속을 기술해야함
select ename, dname, loc, a.deptno from emp a, dept b where a.deptno = b.deptno and ename = 'SCOTT';
-- 테스트 시험 문제

-- rentlist의 대여건수의 대여일자, 대여도서번호, 대여회원번호, 할인금액을 출력하되 도서의 제목, 회원의 이름을 도서번호와 회원번호 옆에 출력하세요.
select rentdate, bnum, subject, mnum, name, rentprice - discount from rentlist R, booklist B, memberlist M where bnum = booknum and mnum = membernum order by rentdate;



-- non-equi join
-- 동일 컬럼이 없어서 다른 조건을 사용하여 join
-- join 조건에 특정 범위내에 있는지를 조사하기 위해 조건절에 조인 조건을 '=' 연산자 이외와 비교
-- 연산자를 이용

select ename, sal, grade from emp E, salgrade S where sal > losal and sal <= hisal;
select ename, sal, grade from emp E, salgrade S where sal between losal and hisal;


-- outer join
-- 조인 조건에 만족하지 못해서 해당 결과를 출력시에 누락이 되는 문제점이 발생할때 해당 레코드를 출력하는 조인
select B.booknum, B.subject, R.rentdate from booklist B, rentlist R where B.booknum = R.bnum(+);


-- 테스트 시험 문제
-- outer join으로 emp 테이블의 인원에 대한 부서명을 출력하되 부서명이 없는 필드는 null 값으로 표시하세요.
select * from emp E, dept D where E.deptno(+) = D.deptno;


-- [3] ANSI join
-- (1) Ansi cross join
-- select * from emp, dept;
select * from emp cross join dept;

-- (2) Ansi inner join -- 일반 equi join과 같다
-- select ename, danme from emp a, dept b where a.deptno = b.deptno
select ename, dname from emp inner join dept on emp.deptno = dept.deptno;
select ename, dname from emp inner join dept on using (deptno);
-- using : 두 테이블의 join 기준이 되는 필드명이 같을때만 사용 가능

-- (3) Ansi outer join
-- select * from emp, dept where emp.deptno = dept.deptno(+);
select * from emp left outer join dept on emp.deptno = dept.deptno;
select * from dept right outer join emp on emp.deptno = dept.deptno;
-- 기준이 되는 필드명 중 A 테이블의 필드에는 있으나 B 테이블 필드에는 해당 값이 없는 경우











