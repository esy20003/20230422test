package JDBC03;

import java.util.ArrayList;

public class Booklist_Select {

	public static void main(String[] args) {
		BookDao bdao = new BookDao();
		// 현재 위치에서 필요한건 데이터베이스에서 booklist 를 조회한 결과
		// 그 조회를 BookDad 의 selectBook 메서드에 맡기고 그 결과를 리턴받을 예정입니다
		// 데이터베이스의 결과를 ResultSet 객체에 저장되지만  selectBook 메서드에서 하나하나의 값들을
		// ArrayList 에 넣어서 리턴받을 예정입니다
		// 다만, 필드값 하나하나를 ArrayList 에 담는것이 아니라, 필드값들 레코드단위의 저장소에 담고,
		// 그 레코드단위의 저장소를 ArrayList 에 담습니다.
		// 여기서 레코드단위의 저장도 클래스로 정의합니다.
		ArrayList<BookDto>list = bdao.selectBook();
		System.out.println("도서번호 \t 출판년도 \t 입고가격 \t 대여가격 \t 등급 \t 제목");
		System.out.println("--------------------------------------------------------------------------------");
		for(BookDto dto : list) {
			System.out.printf("%d \t\t %d \t\t %,d \t %,d \t\t %s \t %s\n" , dto.getBooknum(), dto.getMakeyear(),
					dto.getInprice(), dto.getRentprice(), dto.getGrade(), dto.getSubject());
		}
	}

}