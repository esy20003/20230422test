package days05;

import java.util.Scanner;

public class ControllOp_For16 {

	public static void main(String[] args) {
		
		
		
		// 1부터 자기 자신바== 바의 숫자로 모두 나눠보고 나눠떨어지는 횟수가 딱 2번인경우 
		//int count=0; 
		// 나눠떨어지는 횟수를 카운트하기위한 변수,  나눠떨어질때마다 count++ 연산으로
		// 횟수를 카운트합니다
		
		int i , j;
		for( i=2; i<=100; i++) {
			int count = 0;
			for( j=2; j<=i/2; j++) {
				// i 값을 1~i 값을 갖는 j로 모두 나눠봅니다
				if( i%j == 0 ) count++; // count = count + 1;
				//System.out.print(count++);
			}
			//System.out.print(count);
			//System.out.printf("%d %d" ,i, j);
			if(count == 0)System.out.printf("%d " , i); // i%j 로 나눈 나머지가 0 이라면i 를 출력하겠다
		}
		
		/*		
		// 정수하나를 입력 받아서 그 숫자가 소수(prime number) 인지 아닌지를 출력합니다
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int num = sc.nextInt();
		
		int i;
		for( i=1; i<=num; i++ ) {
			if( num%i == 0 )count++;
		}
		if(count == 2) System.out.println("입력한 정수 " + num + "은 소수(prime number)입니다");
		else System.out.println("입력한 정수 " + num + "은 소수(prime number)가 아닙니다");
		*/
		
		// 1부터 100 사아의 소수를 모두 출력해주세요
	
		
	}

}




