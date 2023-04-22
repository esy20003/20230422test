package days05;

import java.util.Scanner;

public class ControllOp_while02 {

	public static void main(String [] args) {
		
		/*
		// 1부터 100 사이의 짝수의 출력 : while 문을 이용해주세요
		int i=2;
		while(i<=100) {
			System.out.printf("%d ",  i);
			i+=2;
		}
		System.out.println();
		i=1;
		while(i<=100) {
			if( i%2 == 0) System.out.printf("%d ",  i);
			i++;
		}
		*/
		
		
		
		
		// 정수를 입력받아서 입력된 정수의 팩터리얼을 출력해주세요
		//  while 문을 이용합니다
				
		Scanner sc = new Scanner(System.in);
		int n, fact=1;
		System.out.print("\n팩터리얼을 계산할 정수 입력 : ");
		n = sc.nextInt();
				
		// 6을 입력하면 6! = 1x2x3x4x5x6 = 720
		System.out.printf("%d! = ", n);
		int i = 1;
		while(i<n) {
			System.out.printf("%dx", i);
			fact = fact * i;
			i++;// i를 1부터 1씩 늘어나게 하겠다
		}
		System.out.printf("%d = %d\n", n , fact*n);
		
//		int count = 0;
//		for(int j = 1; j < n; j++) {
//			count++;
//			fact = fact*count;
//			//System.out.println(count);
//			System.out.printf("%d", fact);
//		}
		//System.out.printf("%d! = ", n);
		//System.out.println(count);
		
		
		
	}
}










