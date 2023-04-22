package days04;

import java.util.Scanner;

public class ControllOp_For06 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int k;
		
		/*
		System.out.print("합계를 구할 끝숫자를 입력하세요 : ");
		k = sc.nextInt();
		int sum = 0;
		for(int i=1; i<= k; i++)
			sum += i;
		System.out.println("1부터 " + k + "까지의 합계 : " + sum);
		*/
		
		System.out.printf("출력할 팩터리얼을 입력하세요 : ");
		k = sc.nextInt();
		
		/*
		// 입력한 숫자의 팩터리얼 계산후 출력
		// 6을 입력했다면
		// 6! = 720 
		int fact=1;
		for(int i=1; i<=k; i++)
			fact = fact * i;
		System.out.printf("%d ! = %d\n" , k, fact);
		*/
		
		// 6! = 1x2x3x4x5x6 = 720
		
		int fact = 1;
		
		System.out.printf("%d! = ", k);
		
		for(int i=1; i<=k-1 ; i++) {     // k에 7을 입력했다면 반복은 1부터 6까지만 반복
			System.out.printf("%dx", i);    //  1x2x3x4x5x6x  출력
			fact = fact * i;     // 1부터 6까지 곱셈 계산
		}
		
		fact = fact * k;   // 7따로 곱셈계산
		
		System.out.printf("%d = %d", k, fact);    // 7과 최종 결과 7! 값은 반복실행과는 별도로 출력
			
	}

}









