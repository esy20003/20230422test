package days03;

import java.util.Scanner;

public class ControllOp_IF05 {

	public static void main(String[] args) {
		
		//  출생년도를 입력 받아서 나이를 계산하고    2023 - 입력한 년도 + 1
		// 12세 미만 어린이, 12~18세 청소년, 19~25세 청년, 26세 이상(나머지) 성년  입니다. 라고 출력하는 if 문 작성
		
		int year;
		int age;
		Scanner sc = new Scanner(System.in);
		System.out.println("출생년도 입력 : ");
		year = sc.nextInt();
		
		age = 2023-year+1;
		if( age < 12 ) System.out.println("어린이");
		else if( age < 19 ) System.out.println("청소년");
		else if( age < 26 ) System.out.println("청년");
		else  System.out.println("성년");
		

	}

}
