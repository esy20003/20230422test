-- 02_DML.sql
-- 세개의 테이블에 각 필드의 자료형과 제약사항에 맞게 각 10개의 레코드를 insert 하세요

insert into scott.booklist(subject, makeyear, inprice, rentprice, grade) values( '좀비아이', 2018, 18000, 500, '13');
insert into scott.booklist(subject, makeyear, inprice, rentprice, grade) values( '일곱해의 마지막', 2019, 19000, 1500, 'all');
insert into scott.booklist(subject, makeyear, inprice, rentprice, grade) values( '봉제인형 살인사건', 2015, 20000, 2500, '18');
insert into scott.booklist(subject, makeyear, inprice, rentprice, grade) values( '쇼코의 미소', 2021, 17500, 500, 'all');
insert into scott.booklist(subject, makeyear, inprice, rentprice, grade) values( '가면산장 살인사건', 2015, 18000, 500, '13');
insert into scott.booklist(subject, makeyear, inprice, rentprice, grade) values( '나미야 잡화점의 기적', 2010, 16000, 1000, 'all');
insert into scott.booklist(subject, makeyear, inprice, rentprice, grade) values( '유튜브영상편집', 2023, 14000, 1000, 'all');
insert into scott.booklist(subject, makeyear, inprice, rentprice, grade) values( '이것이자바다', 2021, 18000, 500, '18');
insert into scott.booklist(subject, makeyear, inprice, rentprice, grade) values( 'JSP웹프로그래밍', 2022, 13000, 1500, 'all');
insert into scott.booklist(subject, makeyear, inprice, rentprice, grade) values( '오라클데이터베이스', 2021, 12000, 1000, '13');


insert into scott.memberlist(name, phone, birthday, bpoint, age, gender) values( '김지성', '010-1111-8888', '1984/07/18', 110, 29, 'M');
insert into scott.memberlist(name, phone, birthday, bpoint, age, gender) values( '이지성', '010-1111-9999', '1985/07/13', 210, 29, 'F');
insert into scott.memberlist(name, phone, birthday, bpoint, age, gender) values( '박지성', '010-1111-3333', '2020/02/21', 310, 29, 'M');
insert into scott.memberlist(name, phone, birthday, bpoint, age, gender) values( '최지성', '010-1111-4444', '2001/08/07', 210, 29, 'M');
insert into scott.memberlist(name, phone, birthday, bpoint, age, gender) values( '박지성1', '010-2222-1111', '2004/01/12', 140, 29, 'F');
insert into scott.memberlist(name, phone, birthday, bpoint, age, gender) values( '박지성2', '010-3333-2222', '1974/12/25', 170, 29, 'M');
insert into scott.memberlist(name, phone, birthday, bpoint, age, gender) values( '박지성3', '010-4444-3333', '1984/03/27', 190, 29, 'M');
insert into scott.memberlist(name, phone, birthday, bpoint, age, gender) values( '박지성4', '010-5555-4444', '1974/04/17', 210, 29, 'F');
insert into scott.memberlist(name, phone, birthday, bpoint, age, gender) values( '박지성5', '010-6666-5555', '2004/09/21', 250, 29, 'F');
insert into scott.memberlist(name, phone, birthday, bpoint, age, gender) values( '박지성6', '010-7777-6666', '2014/10/12', 130, 9, 'M');



insert into scott.rentlist(bnum, mnum, diccount) values( 1, 1, 100);
insert into scott.rentlist(bnum, mnum, diccount) values( 1, 10, 100);
insert into scott.rentlist(bnum, mnum, diccount) values( 2, 9, 100);
insert into scott.rentlist(bnum, mnum, diccount) values( 3, 8, 100);
insert into scott.rentlist(bnum, mnum, diccount) values( 4, 7, 100);
insert into scott.rentlist(bnum, mnum, diccount) values( 5, 6, 100);
insert into scott.rentlist(bnum, mnum, diccount) values( 6, 5, 100);
insert into scott.rentlist(bnum, mnum, diccount) values( 7, 4, 100);
insert into scott.rentlist(bnum, mnum, diccount) values( 8, 3, 100);
insert into scott.rentlist(bnum, mnum, diccount) values( 9, 2, 100);

select* from scott.booklist;
select* from scott.memberlist;
select* from scott.rentlist;


