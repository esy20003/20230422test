-- 03_PLSQL_Function.sql

-- 함수
-- PL/SQL 코드 작성시에는 지금까지 사용하던 익명 블럭은 잘 사용하지않습니다
-- 일반적으로 이름이 있는 서브 프로그램 (함수) 또는 프로시저를 사용하는것이 대부분 입니다
-- 익명 블럭은 한번 사용하고 나면 없어져 버리는 휘발성 블럭이지만
-- 함수 또는 프로시저는 컴파일을 거쳐 데이터베이스에 저장되어 재사용이 가능한 구조입니다.


-- 함수의 정의 형태

-- create or replace function 함수이름 ( 매개변수1, 매개변수2...  )
-- RETURN 리턴될 데이터타입;
-- IS(AS)
--      변수, 상수 선언
-- BEGIN
--      실행부
--      RETURN 리턴값;
-- [ EXCEPTION
--    예외처리부  ] -- 생략가능
-- END [함수이름];

-- 각 키워드별 상세내용

-- 상세내용

-- CREATE OR REPLACE FUNCTION
-- : CREATE OR REPLACE FUCTION이라는 구문을 이용하여 함수를 생성한다.
-- 함수를 만들고 수정하더라도 이 구문을 계속 컴파일 할 수 있고, 마지막으로 컴파일 한 내용이 함수의 내용과 이름으로 사용된다.
-- 매개변수 : 전달인수를 저장하는 변수로 "변수이름 변수의 자료형" 형태로 작성한다.
-- 첫 번째 RETURN 구문 다음에는 리턴될 자료의 자료형을 쓰고, 아래쪽 두 번째 RETURN 구문 옆에는 그 자료형으로 실제 리턴될 값 또는 변수이름을 써준다.
-- [] 안에 있는 EXCEPTION 구문은 필요하지 않으면 생략 가능하다

-- 두개의 정수를 전달해서 첫번째값을 두번째값으로 나눈 나머지를 구해서 리턴해주는 함수

CREATE OR REPLACE FUNCTION myMod(num1 NUMBER , num2 NUMBER)
    RETURN NUMBER
IS
    v_remain NUMBER := 0;  -- 나눈 나머지를 저장할 변수
    v_mok NUMBER := 0;  -- 나눈 몫을 저장할 변수
BEGIN
    v_mok := FLOOR( num1 / num2 );  -- 나눈 몫의 정수부분만 저장(소수점 절사)
    v_remain := num1 - (num2 * v_mok);  -- 몫 * 젯수 를  피젯수에서 빼면 나머지가 계산됩니다
    RETURN v_remain;
END;

SELECT myMod(14 , 4) FROM DUAL;


-- 연습문제 1
-- 도서번호를 전달인수로 전달하여, Booklist 에서 해당 도서 제목을 리턴받는 함수는 제작하세요

-- 함수 호출 명령
SELECT subjectbynum(21) , subjectbynum(22) FROM dual;


-- 함수 제작
CREATE OR REPLACE FUNCTION subjectbynum(num number )
    RETURN VARCHAR2
IS
    v_subject VARCHAR2(50);
    -- v_subject booklist.booknum%TYPE;
BEGIN
    SELECT subject
    INTO v_subject
    FROM booklist
    WHERE booknum = num;
   
    RETURN v_subject;
END;



-- 연습문제 2
-- 위의 함수의 기능중 전달된 도서번호 검색된 도서가 없다며느, '해당 도서 없음' 이라는 문구가 리턴되도록 수정해주세요
-- FUNCTION 내부에서 COUNT(*) 함수 활용, 조회한 도서번호의 레코드 갯수가 0개이면 "해당 도서 없음" 리턴
-- 도서가 있으면 도서 제목을 리턴

SELECT subjectbynum2(17) , subjectbynum2(42) FROM dual;

CREATE OR REPLACE FUNCTION subjectbynum2(num NUMBER)
    RETURN VARCHAR2
IS
    v_cnt NUMBER :=0;
    v_subject booklist.subject%TYPE; -- v_subject 는 booklist 테이블의 subject 필드의 자료형
BEGIN
    SELECT COUNT(*) INTO v_cnt FROM booklist WHERE booknum = num; -- 입력받은 번호 를 v_cnt 에 대입 해당하는 번호의 booklist 의 레코드를 전부(count(*))로 가져온다
    -- 해당번호가 없어서 0이라면  v_subject 에 '해당도서없음' 밑에서 리턴한다
    IF v_cnt = 0 THEN
        v_subject := '해당 도서 없음'; -- RETURN '해당 도서 없음'
    ELSE
        SELECT subject INTO v_subject FROM booklist WHERE booknum = num; -- 번호가 있다면  subject 를 가져와서 v_subject 에 넣어서 리턴
    END IF;
    RETURN v_subject;
END;


-- 매개변수가 없는 함수
CREATE OR REPLACE FUNCTION fn_get_user -- 매개변수가 없는 함수는 괄오 없이 정의하기도 합니다
    RETURN VARCHAR2
IS
    vs_user_name VARCHAR2(80);
BEGIN
    SELECT USER INTO vs_user_name FROM dual; -- 현재 오라클 로그인 유저 조회  -> vs_user_nams 변수에 저장
    RETURN vs_user_name;  -- 사용자이름 리턴
END;
SELECT fn_get_user(), fn_get_user FROM dual; -- 매개변수가 없는 함수는 괄호 없이 호출하기도 합니다

-- 연습문제 3
-- emp 테이블에서 각 부서번호를 전달받아서 급여의 평균값을 계산하여 리턴하는 함수는 제작하세요
-- 전달된 부서번호의 사원이 없으면 급여평균은 0 으로 리턴하세요
-- 함수 호출은 아래와 같습니다
SELECT salAvgDept(10), salAvgDept(20),  salAvgDept(30), salAvgDept(40) FROM dual;

SELECT salAvgDept(10) FROM dual;

CREATE OR REPLACE FUNCTION salAvgDept(num NUMBER) -- salAvgDept 의 번호를 입력 num 에 담는다
    RETURN NUMBER -- number 자료형을 리턴한다
IS
    v_cnt NUMBER :=0; -- v_cnt 의 기본값은 number자료형 0이다
    v_salAvg emp.sal%TYPE;  -- v_salAvg 은 emp 테이블의 sal의 자료형 이다
BEGIN
    SELECT COUNT(*) INTO v_cnt FROM emp WHERE DEPTNO = NUM; -- emp 테이블에서 deptno 가 위에서 입력받은 번호의 조건일 때  count 로 긁어온 데이터가 v_cnt 에 담긴다
    IF v_cnt = 0 THEN -- 만약 긁어온 자료가 0개 라면 -- 조회를 했을때 null 과 조회가 되지 않은것은 다르다 떄문에 count(*) 로 우선 조회를 해야한다 (sal 만 따로 불러 처리할 수 있나 에 대한 답)
        v_salAvg := 0; --  v_salAvg 은 0이다
    ELSE
        SELECT ROUND(AVG(sal), 0) INTO v_salAvg FROM emp WHERE deptno = NUM; -- 있다면 emp 테이블에서 deptno 에 해당하는 sal 의 평균을 round 로 소수점 자리는 뗴고 출력한다
    END IF;
    RETURN v_salAvg;
END;