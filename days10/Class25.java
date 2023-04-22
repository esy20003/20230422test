package days10;

import java.util.Random;

// static 메서드

// static 변수와 같이 프로그램 구동전에 메모리에 로딩되어서 객체 생성없이 호출될수 있는 클래스의 멤버 메서드
// static 변수사용과 같이  메서드이름앞에  클래스이름과 (.)으로 연결해서 사용합니다. 
// 객체생성과 상관없이 사용합니다
// 대표 사용 예 : Math.random();

class StaticC{
	static final int apple = 25;
	// final : 해당 변수의 값이 선언과 동시에 초기화된 값으로 고정됩니다
	// 수정할 수 없습니다. 수정을 시도하면 에러가 발생합니다
	// static 멤버 뿐만 아니라 final로 선언되는 모든 변수와 메서드가 변경이 허락하지 않고자 할때 사용합니다.
	// 프로그램내부에 변경되면 안되는 지표가될 데이터에 대해서 이와 같이 static final 키워드를 붙여 사용합니다
}

public class Class25 {

	public static void main(String[] args) {
		
		// StaticC.apple = 30;  // 에러
		
		// java.lang 패키지에 있는 클래스중 static 메서드들의 실제 사용 예
		// 간단한 수학적 계산을 위해 만들어진 Math 클래스의 static 메서드들
		// sqrt, randaom,  abs 등
		// 클래스 내부에 정의된 메서드의 모습은
		// public static int abs(int n){ }

		// abs : 절대값 계산 메서드, 
		// sqrt : 제곱근 계산 메서드, 
		// random : 난수 발생 매서드
		
		// https://docs.oracle.com/javase/8/docs/api/
		
		// static 메서드는 클래스이름을 앞에 두고 호출되고, 인스턴스 메서드는 객체이름을 앞에 두고 호출됩니다
		double d = Math.random();
		System.out.println("Math.random() 이 발생한 난수 : " + d);
		
		Random rd = new Random();
		int i = rd.nextInt();
		System.out.println("Random 클래스의 nextInt()가 발생한 난수 : " + i);

		// java.lang 패키지는 별도의 import 가 없어도 미리 import 되어 있는 패키지입니다.
		System.out.println("Math 클래스의 static  PI 변수값 : " + Math.PI);
		
		
		//abs 의 사용
		int num = -10;
		System.out.printf("num = %d, num 변수의 절대값 = %d\n",num, Math.abs(num));
		//sqrt의 사용
		num = 9;
		System.out.printf("num = %d, num 변수의 제곱근 = %.2f\n",num, Math.sqrt(num));
		
		System.out.println();
		// Integer 클래스(int 타입의 자료형과 매칭되는 클래스)
		System.out.println("Integer의 max_value : " + Integer.MAX_VALUE);
		System.out.println("Integer의 min_value : " + Integer.MIN_VALUE);
		String strNum1 = "123";
		String strNum2 = "456";
		System.out.println("문자연산 : " + (strNum1 + strNum2) );
		System.out.println("정수변환 후 연산 : " + ( Integer.parseInt(strNum1) + Integer.parseInt(strNum2) ) );
		
		System.out.println();
		// Double 클래스 ( double 타입의 자료형과 매치되는 클래스)
		System.out.println("Double의 max_value : " + Double.MAX_VALUE);
		// 출력값 : 1.7976931348623157E308  -> 1.7976~~ 의 10의 308승
		System.out.println("Double의 min_value : " + Double.MIN_VALUE);
		strNum1 = "10.75";
		strNum2 = "5.2";
		System.out.println("문자연산 : " + (strNum1 + strNum2) );
		System.out.println("실수연산 :  " + 
						(Double.parseDouble(strNum1)+ Double.parseDouble(strNum2)) );
		
		
		// int 또는 double, boolean 형 자료를  String 으로 변환 -   valueOf()
		System.out.println();
		int intNum1 = 456;
		int intNum2 = 789;
		System.out.println("int 산술연산 : " + (intNum1 + intNum2));
		System.out.println("문자변환 후 연산 : " + (String.valueOf(intNum1) + String.valueOf(intNum2)) );
		System.out.println();
		double doubleNum3 = 456.123;
		double doubleNum4 = 789.123;
		System.out.println("double 산술연산 : " + (doubleNum3 + doubleNum4));
		System.out.println("문자변환 후 연산 : "+ ( String.valueOf(doubleNum3) + String.valueOf(doubleNum4) ) );
		System.out.println();
		boolean b1 = true;
		boolean b2 = false;
		System.out.println("boolean 논리연산 : " + (b1 && b2));
		System.out.println("boolean 문자변환 후 연산 : " 	+ (String.valueOf(b1) + String.valueOf(b2)));	
		
		
				
		
	}

}








