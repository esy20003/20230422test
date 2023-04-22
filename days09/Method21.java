package days09;

import java.util.Scanner;

public class Method21 {

	public static void main(String[] args) {
		int [] mdays = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		Scanner sc = new Scanner(System.in);
		int y = inputYear(sc);
		int m = inputMonth(sc);
		int input = 0;
		while(true) {
			
			if( (y%4==0)&&(y%100!=0)||(y%400==0) ) mdays[2] = 29;
			else mdays[2] = 28;
			
			int days = sumDaysYear( y );  // 입력한 년도의 전년도까지의 날짜 합 계산
			days += sumDaysMonth( m, mdays );  // 입력한 월의 전월까지의 날짜 합 계산 
			days+=1;  // 날짜는 1일자 기준 합산
			int temp = days % 7;
			
			prnCalendar(y, m, mdays, temp);
			
			System.out.printf("\n[1.이전달][2.다음달][3.종료] : ");
			input = sc.nextInt();
			if(input==3) break;
			if( input == 1 ) {
				if( m == 1 ) {	y--; m=12; }
				else m--;
			}else if(input == 2){
				if( m == 12 ) {	y++; m=1; }
				else m++;
			}
			System.out.println("\n\n");
		}
		System.out.println("프로그램을 종료합니다");

	}
	private static int sumDaysYear(int y) {
		int days = 365*(y-1);
		for(int i=1; i < y; i++)
			if( (i%4==0)&&(i%100!=0)||(i%400==0) )
				days++;
		return days;
	}
	
	private static int sumDaysMonth(int m, int[] mdays) {
		int days = 0;
		for(int i=1; i<m; i++) days += mdays[i];
		return days;
	}

	private static void prnCalendar(int y, int m, int[] mdays, int temp) {
		System.out.printf("%d 년 %d 월\n" , y, m);
		System.out.println("-----------------------------------------------------");
		System.out.println("Sun Mon Tue Wed Thu Fri Sat");
		System.out.println("-----------------------------------------------------");
		for(int i=1; i<=temp;  i++) System.out.printf("    ");
		for(int day=1; day<= mdays[m] ; day++) {
			System.out.printf("%3d ", day);
			if( (day+temp)%7 == 0 )System.out.println();
		}
		System.out.println("\n-----------------------------------------------------");
	}

	private static int inputMonth(Scanner sc) {
		System.out.print("월 입력 : ");
		return sc.nextInt();
	}

	private static int inputYear(Scanner sc) {
		System.out.print("년도 입력 : ");
		return sc.nextInt();
	}

}
