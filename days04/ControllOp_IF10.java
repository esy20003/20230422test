package days04;

import java.util.Scanner;

public class ControllOp_IF10 {

	public static void main(String[] args) {
		
		// 2023년에 한해서  월과 일을 입력받고  그 날짜에 해당하는 요일을 출력합니다
		
		// 1월 1일부터 입력한 날짜까지 몇일이 지났는지 모두 계산합니다
		// 계산된 날짜를 7로 나눈 나머지를 구해서
		// 1월 1일이 일요일이었으므로  그 나머지에 해당하는 상대적 요일을 출력
		
		Scanner sc = new Scanner(System.in);
		System.out.print("월 입력 : ");
		int m = sc.nextInt();
		System.out.print("일 입력 : ");
		int d = sc.nextInt();
		
		int days=0;
		
		// 1. 입력받은 월의 바로 전달까지 날짜수를 계산합니다
		if( m == 1) days = 0;
		else if( m == 2 ) days = 31;
		else if( m == 3 ) days = 31+28;
		else if( m == 4 ) days = 31+28+31;
		else if( m == 5 ) days = 31+28+31+30;
		else if( m == 6 ) days = 31+28+31+30+31;
		else if( m == 7 ) days = 31+28+31+30+31+30;
		else if( m == 8 ) days = 31+28+31+30+31+30+31;
		else if( m == 9 ) days = 31+28+31+30+31+30+31+31;
		else if( m == 10 ) days = 31+28+31+30+31+30+31+31+30;
		else if( m == 11 ) days = 31+28+31+30+31+30+31+31+30+31;
		else if( m == 12 ) days = 31+28+31+30+31+30+31+31+30+31+30;
		else {
			System.out.print("잘못입력하셨습니다. 프로그램이 종료됩니다");
			return;  // 프로그램 종료 - 원래는 프로그램 종료 명령은 아니지만 지금은 그 역할도 실행해줍니다
		}
		
		// 2. 입력된 일을 days 에 합산합니다
		days = days + d;   // days+=d
		
		int temp = days % 7;
		
		if( temp == 1 ) System.out.println("일요일 입니다");
		else if( temp == 2 ) System.out.println("월요일 입니다");
		else if( temp == 3 ) System.out.println("화요일 입니다");
		else if( temp == 4 ) System.out.println("수요일 입니다");
		else if( temp == 5 ) System.out.println("목요일 입니다");
		else if( temp == 6 ) System.out.println("금요일 입니다");
		else if( temp == 0 ) System.out.println("토요일 입니다");
		
		// if의 각 경우의수의 처리할 변수의 명령이 초기화되지 않은 변수에 값을 동작들이라면
		// 각 경우의 수에 맞지 않는 경우 변수값이 여전히 초기화되지 않으므로, else 를 써서 
		// 변수값이 대입될 경우의 수를 만들어 줍니다.
		// 그렇지 않을 예정이라면 변수 선언시 값이 넣어주는 방법을 쓸수도 있습니다.

	}

}








