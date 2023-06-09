package days04;

import java.util.Scanner;

public class ControllOp_Switch03 {

	public static void main( String [] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("월 입력 : ");
		int m = sc.nextInt();
		System.out.print("일 입력 : ");
		int d = sc.nextInt();
		int days=0;
		
		switch( m ) {
			case 12: days = days + 30;  // 11월의 날짜수 30일을 합산
			case 11: days = days + 31;
			case 10: days = days + 30;
			case 9: days = days + 31;
			case 8: days = days + 31;
			case 7: days = days + 30;
			case 6: days = days + 31;
			case 5: days = days + 30;
			case 4: days = days + 31;
			case 3: days = days + 28;
			case 2: days = days + 31; 
			case 1: break;
			default :
				System.out.print("잘못입력하셨습니다. 프로그램이 종료됩니다");
				return; 		
		}
		
		days = days + d;   // days+=d
		int temp = days % 7;
		switch(temp) {
			case 1 : System.out.println("일요일"); break;
			case 2 : System.out.println("월요일"); break;
			case 3 : System.out.println("화요일"); break;
			case 4 : System.out.println("수요일"); break;
			case 5 : System.out.println("목요일"); break;
			case 6 : System.out.println("금요일"); break;
			case 0 : System.out.println("토요일"); break;
		}
	}
}
