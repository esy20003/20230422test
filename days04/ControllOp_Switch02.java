package days04;

import java.util.Scanner;

public class ControllOp_Switch02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("월 입력 : ");
		int m = sc.nextInt();
		System.out.print("일 입력 : ");
		int d = sc.nextInt();
		
		int days=0;
		
		switch( m ) {
			case 1: days = 0; break;
			case 2:  days = 31; break;
			case 3:  days = 31+28; break;
			case 4: days = 31+28+31; break;
			case 5: days = 31+28+31+30; break;
			case 6: days = 31+28+31+30+31; break;
			case 7: days = 31+28+31+30+31+30; break;
			case 8: days = 31+28+31+30+31+30+31; break;
			case 9: days = 31+28+31+30+31+30+31+31; break;
			case 10: days = 31+28+31+30+31+30+31+31+30; break;
			case 11: days = 31+28+31+30+31+30+31+31+30+31; break;
			case 12: days = 31+28+31+30+31+30+31+31+30+31+30; break;
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
