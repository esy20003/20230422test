package days02;

import java.util.Scanner;
// import 단축키 : Ctrl + Shift  + 'o'

public class Variable02 {

	public static void main(String[] args) {
		
		int number1, number2;
		int result1;  // 덧셈, 뺄셈, 곱셈의 결과를 저장할 변수
		double result2;  //나눗셈의 결과를 저장할 변수

		// 프로그래밍을 하다보면, 외부의 라이브러리 또는 API  를 불러다 사용해야할 경우가 있는데, 
		// 사용자로부터 화면 입력을 받는 도구는 외부 라이브러리에 있는 도구를 불러와서 사용해야 합니다.
		// 사용자 입력을 위해 불러와서 준비해야할 코드
		Scanner sc = new Scanner(System.in);   // 화면입력을 위한 준비코드
		
		System.out.printf("정수를 입력하세요 : ");
		// 원할한 입력을 위해 안내명령은 입력명령보다 반드시 위에 써줍니다
		number1 = sc.nextInt();  // 화면으로 부터 사용자가 입력한 내용을 프로그램 내부로 가져오라는 명령
		// 컴파일러가 sc.nextInt() 명령을 만나면 커서를 깜빡이면서 사용자에게서 입력이 있을때까지 무한정 대기합니다.
		System.out.println("입력한 정수는 " + number1 + "입니다");
		
		// number2 변수에 두번째 정수를 입력받고, 그 둘의 덧셈 뺄셈 곱셈 나눗셈의 결과를 이전 예제에서 처럼 출력하세요
		System.out.printf("두번째 정수를 입력하세요 : ");
		number2 = sc.nextInt();
		System.out.println("입력한 두번째 정수는 " + number2 + "입니다");
		
		result1 = number1 + number2;   // 덧셈의 결과 저장
		System.out.printf("%d + %d = %d\n",number1, number2, result1);
		result1 = number1 - number2;  // 뺄셈의 결과 저장
		System.out.printf("%d - %d = %d\n",number1, number2, result1);
		result1 = number1 * number2; // 곱셈의 결과 저장
		System.out.printf("%d x %d = %d\n",number1, number2, result1);
		result2 = number1 / (double)number2; // 나눗셈의 결과 저장
		System.out.printf("%d ÷ %d = %.1f\n",number1, number2, (int)(result2*10)/10.0);
		
	}

}
