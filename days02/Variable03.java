package days02;

import java.util.Scanner;

public class Variable03 {

	public static void main(String[] args) {
		
		// 삼각형의 밑변과 높이를 입력받아서   넓이를 출력
		// 삼각형의 넓이 : 밑변 x 높이 x 0.5
		
		// 입력
		// 삼각형의 밑변 입력 : XX
		// 삼각형의 높이 입력 : XX
		
		// 출력 
		// 입력하신 삼각형의 넓이는 XX.X 입니다.
		
		Scanner sc = new Scanner(System.in);

		int num1, num2; // 삼각형의 높이, 밑변을 저장할 변수
		double result;   // 삼각형의 넓이를 계산해서 저장할 변수
		
		System.out.print("밑변을 입력하세요 : ");
		num1 = sc.nextInt();
		
		System.out.print("높이를 입력하세요 : ");
		num2 = sc.nextInt();
		
		result = num1 * num2 * 0.5;
		
		System.out.printf("입력한 삼각형의 넓이 : %.1f\n", result);
	}

}








