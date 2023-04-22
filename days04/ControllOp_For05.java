package days04;

import java.util.Scanner;

public class ControllOp_For05 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int i, a, b;
		System.out.printf("첫번째 정수 입력 : ");
		a = sc.nextInt();
		System.out.printf("두번째 정수 입력 : ");
		b = sc.nextInt();
		
		/*
		// a 변수값부터 b변수값까지  차례로 출력  
		// 3, 8을 입력했다면   3 4 5 6 7 8  이라고 출력되게 반복실행문을 작성하세요
		//  for(a=1; a<=b; a++ )  X
		for( i=a; i<=b; i++){
			System.out.printf("%d ", i);
		}
		*/
		
		// 입력받은 숫자 중 작은 숫자부터 큰숫자까지 모든 정수를 출력하세요
		// 8과 3을 입력했다면  3 4 5 6 7 8

		if(a<b) {
			for( i=a; i<=b; i++){
				System.out.printf("%d ", i);
			}
		}else {
			for( i=b; i<=a; i++){
				System.out.printf("%d ", i);
			}
		}
		
		
		System.out.println();
		int min, max;
		if(a<b) {
			min = a;
			max = b;
		}else {
			min = b;
			max = a;
		}
		for( i=min; i<=max; i++){
			System.out.printf("%d ", i);
		}
	}

}








