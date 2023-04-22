package days04;

import java.util.Scanner;

public class ControllOp_For09 {

	public static void main(String[] args) {
		
		int sum=0, i, num;
		Scanner sc = new Scanner(System.in);
		// 10 개의 정수를 입력받아 그들의 합계와 평균을 출력하세요
		// 10개를 입력하는 중간에 종료를 원하면 0을 입력하여 입력을 종료하고
		// 최종 합계를 출력합니다.
		
		// 입력양식 
		// 입력 1: XX
		// 입력 2: XX
		// 입력 3: XX
		//.....
		// 입력10 : XX
		
		// 출력양식 
		// 입력한 정수들의 합계 : XXX
		// 입력한 정수들의 평균 : XX.X
		
		// 중간에 0을 입력하면 입력이 종료되고  그 동안 입력한 데이터만으로 합계평균을 출력하세요
		System.out.print("정수 열개를 엔터와 함께 하나씩 입력하세요 : \n");
		for( i=1; i<=10; i++) {
			System.out.printf("%d : ", i);
			num= sc.nextInt();
			if( num == 0 ) break;   // 반복실행은 break로 정해진 횟수를 다 채우지 않고 멈출 수 있습니다.
			sum = sum + num; // 반복실행속에 입력명령이 있다면, 다음 입력으로 현재 입력이 사라질수 있습니다.
			System.out.println("반복종료후 i 값 : " + i );
		}
		
		System.out.println("입력된 정수의 합계 : " + sum );
		System.out.println("반복종료후 i 값 : " + i );
		System.out.println("입력된 정수의 평균 : " + sum/(double)(i-1) );
		
	}

}







