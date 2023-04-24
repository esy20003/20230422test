-- 01_DDL

CREATE TABLE `scott`.`booklist` (
  `booknum` INT NOT NULL AUTO_INCREMENT,
  `subject` VARCHAR(45) NOT NULL,
  `makeyear` INT NULL,
  `inprice` INT NULL,
  `rentprice` INT NULL,
  `grade` VARCHAR(5) NULL DEFAULT 'all',
  PRIMARY KEY (`booknum`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COMMENT = '도서목록';

-- 연습 문제.
-- 아래의 필드명을 담은 memberlist 테이블을 생성하세요
-- 필드명 : membernum(int, 자동 증가, not null, 기본키), name(varchar(30), not null),
-- phone(varchar(30), nut null),  birth(datetime, not null), bpoint(int), joindate(datetime, 기본값 now() ), age(int) , gender(varchar(3))
-- 테이블 comment : 회원 목록
-- 기본 문자set : utf-8mb4
-- 워크 벤치에서 테이블 생성하는 명령을 복사해도 됩니다



CREATE TABLE `scott`.`memberlist` (
  `membernum` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  `phone` VARCHAR(30) NOT NULL,
  `birth` DATETIME NOT NULL,
  `bpoint` INT NULL DEFAULT 100,
  `joindate` DATETIME NULL DEFAULT now(),
  `age` INT NULL,
  `gender` VARCHAR(3) NULL,
  PRIMARY KEY (`membernum`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COMMENT = '회원목록';


-- 자주 쓰는 자료형
-- INT : 정수 자료형(FLOAT, DOUBLE 은 실수)
-- TEXT : 긴 문자열은 TEXT 로 별도 저장
-- DATETIME : 날짜 자료형 저장
-- TINYINT : - -128에서 127까지 저장하지만 여기서는 1 또는 0만 저장해 Boolean 값 표현

-- 자주쓰는 제약 조건
-- NOT NULL : 빈 값은 받지 않는다는 뜻 (NULL 은 빈값 허횽)
-- AUTO_INCREMENT : 숫자 자료형인 경우 다음 로우가 저장될때 자동으로 1 씩 증가
-- USINGNED : 0과 양수만 허용
-- ZEROFILL : 숫자의 자리수가 고정된 경우 빈 자리에 0을 넣음
-- DEFAULT now() : 날짜 컬럼의 기본값을 현재 시간으로. DATETIME 자료형에 적용 가능

-- 테이블-필드의 수정
ALTER TABLE `scott`.`memberlist` 
CHANGE COLUMN `birth` `birthday` DATE NOT NULL ;

ALTER TABLE `scott`.`memberlist` 
DROP COLUMN `gender`;

ALTER TABLE `scott`.`memberlist`
ADD COLUMN `gender` VARCHAR(3) NULL AFTER `age`;

ALTER TABLE `scott`.`memberlist` 
ADD COLUMN `joindate` VARCHAR(45);

-- 연습문제2
-- 테이브 이름 : rentlist
-- 필드 : rentdate(datetime, dafault now() ), numseq(int , AI), bnum(int)
-- mnum(int), discount(int)
-- 워크벤치에서 테이블 생성화면을 구성한 후 실행하지 말고 기다립니다


CREATE TABLE `scott`.`rentlist` (
  `numseq` INT NOT NULL AUTO_INCREMENT,
  `rentdate` DATETIME NOT NULL DEFAULT now(),
  `bnum` INT NOT NULL,
  `mnum` INT NOT NULL,
  `diccount` INT NULL DEFAULT 100,
  PRIMARY KEY (`numseq`)
)
--  INDEX `fk1_idx` (`bnum` ASC) VISIBLE,
--  INDEX `fk2_idx` (`mnum` ASC) VISIBLE,
-- CONSTRAINT `fk1` FOREIGN KEY (`bnum`) REFERENCES `scott`.`booklist` (`booknum`) ON DELETE CASCADEON UPDATE CASCADE,
-- CONSTRAINT `fk2` FOREIGN KEY (`mnum`) REFERENCES `scott`.`memberlist` (`membernum`) ON DELETE CASCADEON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COMMENT = '대여기록';

ALTER TABLE `scott`.`rentlist` 
drop table rentlist;


-- 외래키 제약 조건 추가
ALTER TABLE `scott`.`rentlist` 
ADD INDEX `fk1_idx` (`bnum` ASC) VISIBLE,
ADD INDEX `fk2_idx` (`mnum` ASC) VISIBLE;
;
ALTER TABLE `scott`.`rentlist` 
ADD CONSTRAINT `fk1`
  FOREIGN KEY (`bnum`)
  REFERENCES `scott`.`booklist` (`booknum`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `fk2`
  FOREIGN KEY (`mnum`)
  REFERENCES `scott`.`memberlist` (`membernum`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;































