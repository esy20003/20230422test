package JDBC03;

import java.util.Scanner;

public class Booklist_insert {

	public static void main(String[] args) {
		BookDto bdto = new BookDto();
		Scanner sc = new Scanner(System.in);
		System.out.print("제목을 입력하세요 : ");
		// String subject = sc.nextLine();
		bdto.setSubject(sc.nextLine());
		System.out.print("출판년도를 입력하세요 : ");
		// String makeyear = sc.nextLine();
		bdto.setMakeyear(Integer.parseInt(sc.nextLine() ) );
		System.out.print("입고가격을 입력하세요 : ");
		// String inprice = sc.nextLine();
		bdto.setInprice(Integer.parseInt(sc.nextLine() ) );
		System.out.print("대여가격을 입력하세요 : ");
		// String rentprice = sc.nextLine();
		bdto.setRentprice(Integer.parseInt(sc.nextLine() ) );
		System.out.print("등급을 입력하세요 : ");
		// String grade = sc.nextLine();
		bdto.setGrade(sc.nextLine());
		BookDao bdao = new BookDao();
		// bdao.insertBook(subject , makeyear, inprice, rentprice, grade);
		//
		// bdto.setSubject(subject);
		// bdto.setMakeyear(Integer.parseInt(makeyear));
		// bdto.setInprice(Integer.parseInt(inprice));
		// bdto.setRentprice(Integer.parseInt(rentprice));
		// bdto.setGrade(grade);
		int result = bdao.insertBook(bdto);
		if(result == 1) System.out.println("저장 성공");
		else System.out.println("저장 실패");
	}

}