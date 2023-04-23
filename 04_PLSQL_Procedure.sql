-- 04_PLSQL_Procedure.sql

-- 프로시져
-- 함수와 비슷한 구조입니다
-- 함수는 결과 리턴이 있지만 프로시져는 결과리턴이 없는것이 특징입니다. (리턴을 위한 별도의 코드(변수 )가 있습니다)
-- return 키워드 대신, 리턴역할을 하는 변수를 필요 갯수만큼 만들어서 사용합니다

-- 프로시져의 생성
-- CREATE OR REPLACE PROCERDURE 프로시져이름(
--      매개변수명1 [IN | OUT | IN OUT ] 데이터타입 [:= 디폴트 값],
--      매개변수명2 [IN | OUT | IN OUT ] 데이터타입 [:= 디폴트 값],
--  ......
-- )
-- IS[AS]
--      변수, 상수 선언
-- BEGIN
--      실행부
-- [EXCEPTION
--      예외처리부 ]
-- END [프로시져 이름];


--CREATE OR REPLACE PROCEDURE : 프로시져를 생성하는 구문
--매개변수명1 [ IN | OUT | IN OUT ] : 매개변수를 만들되 전달되는 전달인수를 받는 IN변수와
-- 리턴역할을 할 수 있는 OUT변수를 만들 때 사용한다.  입력변수와 출력변수의 역할이 동시에 부여되려면 IN OUT을 같이 기술한다.
-- 프로시져는 기본적으로 리턴값이 없지만 (실제 RETURN명령을 사용하지 않음)
-- 변수의 속성에 OUT속성 하나를 부여함으로써 리턴 역할을 흉내낼 수 있게는 사용이 가능하다.
-- 변수 속성이 IN인경우 생략이 가능하다.

-- rentlist 테이블에 레코드를 추가하는 프로시져
CREATE OR REPLACE PROCEDURE newrentlist (
    p_bnum IN rentlist.bnum%TYPE,
    p_mnum IN rentlist.mnum%TYPE,
    p_discount IN rentlist.discount%TYPE
)
IS
BEGIN
    INSERT INTO rentlist (rentdate, numseq, bnum, mnum, discount)
    values(sysdate, rent_seq.nextVal, p_bnum, p_mnum, p_discount);
    commit;
END;

EXEC newrentlist(22,3, 300);



-- IN , OUT, IN OUT 매개변수 사용 #1
-- newrentlist 프로시져에서 입력된 오늘 날짜를 호출한곳에서 되돌려 받아서 출력합니다
CREATE OR REPLACE PROCEDURE newrentlist2 (
    p_bnum IN rentlist.bnum%TYPE,
    p_mnum IN rentlist.mnum%TYPE,
    p_discount IN rentlist.discount%TYPE,
    p_outdate OUT rentlist.rentdate%TYPE
)
IS
    v_sysdate rentlist.rentdate%TYPE := SYSDATE;
BEGIN
    INSERT INTO rentlist (rentdate, numseq, bnum, mnum, discount)
    VALUES(v_sysdate, rent_seq.nextVal, p_bnum, p_mnum, p_discount);
    commit;
    p_outdate := v_sysdate;  -- OUT 변수에 오늘날짜를 담고 있는 변수값을 대입합니다
    -- OUT 변수에 값을 넣는 것은 호출할때 OUT 변수에 전달해준 변수로 그 값을 전달하는 것과 같습니다
END;

DECLARE
    v_date rentlist.rentdate%TYPE;
BEGIN
    newrentlist2(28, 20, 200, v_date);
    -- 익명블럭에서 프로시져를 호출할때는 exec 를 사용하지 않습니다
    -- 프로시져가 아닌 함수였다면 v_curdate = newrentdate2(7,2, 200); 와 같이 사용하겠지만
    -- 프로시져이기 때문에 매개변수중에도 OUT 변수에, 값 대신 변수를 전달해줍니다. (자바의 CALL BY REFERENCE 와 같은 의미)
    -- 프로시져는 내부에서 OUT 변수에 값을 넣는 동작이 있으면 , 호출한 곳에서 넣어준 변수에 그 값을 전달받아서 사용한것과 같다
   
    -- 프로시져에서 넣어준 값이 현재 변수를 통해 출력됩니다
    DBMS_OUTPUT.PUT_LINE(v_date);
END;

select * from rentlist order by numseq desc;
select* from booklist;
select* from memberlist;


-- IN , OUT, IN OUT 의 사용 예 #2
-- IN 변수와 OUT 변수와 IN OUT 변수
CREATE OR REPLACE PROCEDURE paramater_test (
    p_var1 IN VARCHAR2,
    p_var2 OUT VARCHAR2,
    p_var3 IN OUT VARCHAR2
)
IS

BEGIN
    -- in 변수와 out 변수에 전달된 내용을 모두 출력해 봅니다
    DBMS_OUTPUT.PUT_LINE('p_var1 value = ' || p_var1);
    -- OUT 변수는 전달인수를 값으로 전달받지 못하는 변수입니다 값을 전달해줘도 적용받지 않습니다
    -- IN 변수로서의 기능을 부여하려면 변수선언 당시 IN 과 OUT 을 같이 사용합니다
    DBMS_OUTPUT.PUT_LINE('p_var2 value = ' || p_var2);
    DBMS_OUTPUT.PUT_LINE('p_var3 value = ' || p_var3);
    -- IN 변수와 OUT 변수에 모두 값을 대입해봅니다
  -- p_var1 := 'A2';  -- IN 변수는 전달인수에 의해 값이 정해질 뿐 임의로 값을 변경하지 못합니다
 
  -- out 기능이 부여된 두개의 변수에 값을 넣으면, 전달인수로서의 변수(익명블럭의 V_VAR2, V_VAR3) 에 리턴됩니다
    p_var2 := 'B2';
    p_var3 := 'C2';
END;

DECLARE
    v_var1 VARCHAR2(10) := 'A';
    v_var2 VARCHAR2(10) := 'B';
    v_var3 VARCHAR2(10) := 'C';
BEGIN
    paramater_test(v_var1, v_var2, v_var3);
    DBMS_OUTPUT.PUT_LINE('v_var1 value = ' || v_var1);
    DBMS_OUTPUT.PUT_LINE('v_var2 value = ' || v_var2);
    DBMS_OUTPUT.PUT_LINE('v_var3 value = ' || v_var3);
    -- 프로시져에 OUT 변수로 전달된 값은 프로시져 실행 후 프로시져 실행명령에 넣어준 변수에 저장 됩니다.
END;


-- IN OUT 변수의 사용규칙
-- 1. ON 변수는 전달인수로 전달되어 저장된 값을 참조만 할 수 있고, 값을 할당할 수 없습니다
-- 2. OUT 변수에는 전달인수로 값을 전달할수는 있지만 , 참조할수 없으므로 의미가 없는 전달입니다
-- 3. OUT 변구와 IN OUT 변수는 디폴트값을 지정할 수 없습니다
-- 4. IN 변수에는 변수 , 상수, 각 데이터형에 따른 값을 전달인수로 전달할 수 있지만, OUT 변수와 IN OUT 변수는
-- 반드시 함수형태로 전달인수를 넣어줘야합니다


-- 디폴트 벨류
create or replace procedure newrentlist3(
    p_bnum IN rentlist.bnum%TYPE,
    p_mnum IN rentlist.mnum%TYPE,
    p_discount IN rentlist.discount%TYPE := 100 -- 디폴트 벨류 : 매개변수에 값을 미리 저장합니다.
)
IS
BEGIN
    INSERT INTO rentlist(rentdate, numseq, bnum, mnum, discount)
    VALUES(sysdate, rent_seq.nextVal, p_bnum, p_mnum, p_discount);
    COMMIT;
END;
EXEC newrentlist3(22, 10, 400);

-- 매개변수 인수 전달시 , 순서 변경
EXEC newrentlist3(p_mnum => 10, p_bnum => 22);



SELECT * FROM rentlist order by numseq desc;

select* from memberlist;
select* from booklist;


-- 프로시저에서 RETURN은 값을 리턴하겠다는 명령이 아니고, 현시점에서 프로시저를 끝내겠다는 뜻
-- rentlist 에 레코드를 추가하기 전에 전달된 도서번호와 회원번호가 없다면 해당 도서번호가 없습니다.
-- 또는 해당 회원번호가 없습니다 라고 출력하고 중간에 프로시져가 끝나도록 아래 프로시저를 수정하세요

CREATE OR REPLACE PROCEDURE newrentlist3(
    p_bnum IN rentlist.bnum%TYPE, p_mnum IN rentlist.mnum%TYPE, p_discount IN rentlist.discount%TYPE := 100
)
IS
    bcnt NUMBER;  mcnt NUMBER;
BEGIN
    SELECT COUNT(*) INTO bcnt FROM booklist WHERE booknum = p_bnum;
    IF bcnt = 0 THEN
        DBMS_OUTPUT.PUT_LINE('해당 도서번호가 없습니다');
        RETURN; -- 프로시져 종료
    END IF;
    SELECT COUNT(*) INTO mcnt FROM memberlist WHERE membernum = p_mnum;
    IF mcnt = 0 THEN
        DBMS_OUTPUT.PUT_LINE('해당 회원번호가 없습니다');
        RETURN; -- 프로시져 종료
    END IF;
    INSERT INTO rentlist(rentdate, numseq, bnum, mnum, discount)
    VALUES(sysdate, rent_seq.nextVal, p_bnum, p_mnum, p_discount);
    COMMIT;
END;

EXEC newrentlist3(21 ,10, 150);

SELECT * FROM rentlist order by numseq desc;

select * from memberlist;
select * from booklist;