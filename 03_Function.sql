-- 03_Function.sql

-- 숫자 관련 함수
-- abs(숫자) - 절대값 계산
-- CEILING(숫자) - 값보다 큰 정수 중 가장 작은 수 
-- FLOOR(숫자) - 값보다 작은 정수 중 가장 큰 수[ 실수를 무조건 버림(음수일 경우는 제외)]
-- round(숫자, 자리수) - 소수점 자리수만큼 남기고 아래서 반올림
-- truncate(숫자, 자리수) - round 와 같은 동작이지만 반올림이 아닌 버림
-- pow(x, y) -  x의 y 자승
-- mod(x, y) - x 를 y 로 나눈 나머지를 계산
-- greatest(x,y,z....) - 주어진 숫자 중에서 가장 큰 숫자
-- least(x,y,z...) - 주어진 숫자 중에서 가장 작은 숫자


-- 문자 관련 함수
-- ascii(문자) - 해당 문자의 아스키 코드값
-- concat(문자열1, 문자열2, 문자열3....) - 주어진 문자열들 이어붙이기 연산
-- insert(문자열, 기본문자열, 바꿀 문자열) - 문자열의 시작위치부터 길이 만큼 바꿀 문자열로 대체
-- replace(문자열, 기본문자열, 바꿀 문자열) - 문자열안에 있는 기본 문자열을 바꿀 문자열로 대체
-- INSTR('문자열', 개수) - 문자열 중 찾는 문자열의 위치값을 출력
-- LEFT('문자열', 갸수) - 문자열 중 왼쪽에서 개수만큼을 추출.
-- RIGHT('문자열', 개수) - 문자열 중 오른쪽에서 개수만큼을 추출.
-- MID('문자열',시작위치, 개수) - 문자열 중 시작위치부터 개수만큼 출력
-- SUNSTRING('문자열', 시작위치, 개수) - 문자열 중 시작위치부터 개수만큼 출력
-- LTRIM('문자열') - 문자열 중 왼쪽 공백을 없앤다
-- RTRIM('문자열') - 문자열 중 오른쪽 공백을 없앤다
-- TRIM('문자열') - 양쪽 모두의 공백을 없앤다
-- LCASE('문자열') or LOWER('문자열') - 소문자로 바꾼다
-- UCASE('문자열') or UPPER('문자열') - 대문자로 바꾼다
-- REVERSE('문자열') - 문자열을 반대로 나열한다


-- 집계 함수
-- COUNT(필드명) - NULL값이 아닌 레코드 수를 구한다
-- SUM(필드명) - 필드명의 합계를 구한다
-- AVG(필드명) - 각각의 그룹 안에서 필드명의 평균값을 구한다
-- MAX(필드명) - 최대값을 구한다
-- MIN(필드명) - 최소값을 구한다

-- 날짜 관련 함수
-- now() - 현재 날짜와 시간(datetime 형식)
-- curdate() or current_date() - 현재 날짜 (date 형식)
-- curttime() or current_time() - 현재 시간(time 형식)
-- DATE_ADD(날짜, INTERVAL 기준값 더할숫자) - 날짜에서 기준값단위로 더할 숫자만큼 더한다
select date_add(now(), INTERVAL 3 YEAR) FROM dual;

-- ※ 기준값 : YEAR , MONTH, DAY, HOUR, MINUTE, SECONT
-- DATE_SUB(날짜, INTERVAL 기준값 뺄숫자) - 날짜에서 기준값단위로 뺄 숫자만큼 뺀다
select date_SUB(now(), INTERVAL 3 YEAR) FROM dual; 

-- YEAR(날짜) - 날짜의 연도 출력
-- MONTH(날짜) - 날짜의 월 출력
-- MONTHNAME(날짜) - 날짜의 월을 영어로 출력
-- DAYNAME(날짜) - 날짜의 요일을 영어로 출력
-- DAYOFMONTH(날짜) - 날짜의 월별 일자 출력
-- DAYOFWEEK(날짜) - 날짜의 주별 일자 출력(일요일(1), 월요일(2), .... 토요일(7))
-- WEEKDAY(날짜) - 날짜의 주별 일자 출력(월요일(0), 화요일(1), ..... 일요일(6))
-- DAYSOFYEAR(날짜) - 일년을 기준으로 한 날짜까지의 수
-- FROM_DAYS(날 수) -- 00년 00월 00일부터 날 수 만큼 경과한 날의 날짜 출력 
-- TO_DAYS(날짜) -- 00년 00월 00일 부터 날짜까지의 일자 수 출력
-- DATE_FORMAT(날짜, '형식') : 날짜를 형식에 맞게 출력

-- 오라클의 to_char(SYSDATE, 'YYYYMMDD') 날짜 -> 문자
-- 오라클의 to_date('20230420', YYYYMMDD) 문자 -> 날짜
-- MySQL 
-- date_format(now(), '%Y%m%d')
-- str_to_date('20211013', '%Y%m%d')

select date_format(now() , '%Y%m%d') from dual;
select str_to_date('20211013', '%Y%m%d') from dual;


-- %a 	일(Sun ~ Sat)			-- %b월(Jan ~ Des)
-- %c 	월(0 ~ 12)				-- %D	일(1st, 2nd, 3rd...)
-- %d	일(01 ~ 31) 			-- %e 일 (0 ~ 31)
-- %f	Microsecontd (000000 to 999999)
-- %H	시간(00 ~ 23)			-- %h시간(00 ~ 12)
-- %I	시간(00 ~ 12)			--i	분(00 ~ 59)
-- %J	Day of the year (001 to 366) 			
-- %K	시간(0 ~ 23)			-- %i 시간(1 ~ 12)
-- %M	월(January ~ December)	-- %m	월(00 ~ 12)
-- %p	AM or PM
-- %r	시간(12시)을 hh:mm:ss AM/PM 형식으로
-- %S	초(00 ~ 59)				--%S 초(00 ~ 59)
-- %T	시간(24)DMF hh:mm:ss 형식으로









































