package days02;

import java.util.Scanner;

public class Variable04 {

	public static void main(String[] args) {
		
		// 반지름을 입력받아서 원의 넓이와, 둘레의 길이를 출력합니다
		// 입력1, 출력2
		// 필요한 변수의 이름은 임의로 지어서 사용합니다.

		// 출력양식
		// 입력한 원의 넓이 : XX.XX ,  둘레의 길이 : XX.XX
		
		// 넓이-반지름x반지름x3.141592   둘레-2x반지름x3.141592
		// 결과는 소수점 둘째자리까지만 표시.  println  또는 printf 중 선택은 본인선택
		
		Scanner sc = new Scanner(System.in);
		int num;
		double n, d;
		
		System.out.print("반지름을 입력하세요 : ");
		num = sc.nextInt();
		
		n = num * num * 3.141592;
		d = 2 * num * 3.141592;
		
		System.out.printf("입력한 원의 넓이 : %.2f ,  둘레의 길이 : %.2f\n", n, d);
		System.out.print("입력한 원의 넓이 : " + (int)(n*100)/100.0 );
		System.out.print(" ,  둘레의 길이 : " + (int)(d*100)/100.0 );
		

	}

}









