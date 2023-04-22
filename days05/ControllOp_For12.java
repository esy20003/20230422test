package days05;

import java.util.Scanner;

public class ControllOp_For12 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num1, num2;
		int i, small;
		System.out.printf("첫번째 정수 입력 : ");
		num1 = sc.nextInt();
		System.out.printf("두번째 정수 입력 : ");
		num2 = sc.nextInt();
		
		// 입력 받은 두개의  정수들의 공약수들을 출력하세요
		// 12  36  을 입력 한경우   1  2  3  4  6  12
		if( num1 < num2 ) small = num1;
		else small = num2;
		
		int k=0;
		//System.out.printf("%d %d 의 공약수 :  ", num1, num2);
		for( i=1; i<=small; i++) {
			if( (num1%i == 0)&&(num2%i == 0) ) {
				System.out.printf("%d ", i); // num1 % i 나머지가 0 이면서 num2 % i 의 나머지가 0으로 떨어지는 값이 공약수고 그 숫자가 k 에 저장된다
				k = i;
			}
		}
		System.out.printf("\n최대공약수 : %d\n" , k);
		
		// 공약수가 모두 출력이 되었다면,   최대공약수를 따로 출력
	}

}
