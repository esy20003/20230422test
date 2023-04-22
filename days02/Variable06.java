package days02;

import java.util.Scanner;

public class Variable06 {

	public static void main( String [] args) {
		
		// 정수형 : byte(1), short(2), int(4 - 기본형) -2147483648~2147482647,   long(8)
		// 실수형 : float(4), double(8 - 기본형)
		
		// 기본형이란 별도의 표시없이 쓰여지는 정수나 실수가 int 와 double 로 인식되어 사용된다는 뜻입니다
		//  100(int형 자료),  100L(Long 형)       123.123( double )   123.123F (float 형)
		// byte b = 1234;   // 에러
		// float f = 123.12;   // 에러
		
		// 문자형 : char(2 - 유니코드 지원)   
		// 진위형 : boolean( X - true/false의 값만 저장할 수 있음)
		// 문자열 : String(클래스, 정해진 크기가 없음)
		
		
		
		Scanner sc = new Scanner(System.in);
		// 변수의 다양한 선언(생성) 방법
		
		// 1. 변수 선언후 값을 할당(대입)
		int n1;
		n1 = 10;
		
		// 2. 변수의 선언과 값의 대입을 동시에 처리
		int n2 = 20;
		
		// 3. 다수개의 변수를 한번에 선언하는 방법( 동이랗ㄴ 자료형만 가능)
		int n3, n4, n5;
		
		// 4. 다수개의 변수도 선언과 도잇에 값을 대입할수 있습니다
		int n6 = 60, n7 = 70;
		
		// 5. 선언과 동시에 값을 대입한다고 해서 반드시 모든 변수에 값을 넣어야 하는것은 아닙니다
		int n8, n9=80, n10;
		
		// 변수 선언의 위치
		// 사용할 변수가  아직 사용전이라면 그 위치 어디에나 변수를 선어할 수 있습니다
		int v1=10;
		System.out.println("프로그램 시작 v1변수의 값 : " + v1);
		// 변수는 반드시 선언(생성) 후에 사용할 수 있으며, 선언전에 사용하는 변수는 오류
		
		//System.out.println("프로그램 시작 v3변수의 값 : " + v3);  // 에러 - 실행순서상 만들어지지 않은 변수사용
		//int v3 = 20;
		
		// 변수는 선언 이후라도, 값이 대입되지 않으면 사용이 불가합니다.
		int v4;
		// System.out.printf("v4 변수의 값 %d\n", v4);  //오류
		v4 = 40;
		System.out.printf("v4 변수의 값 %d\n", v4);
		
		// 변수의 값은 여러번 대입할수 있으며, 저장되는 값은 가장 최근, 마지막에 저장한 값이 저장되어 사용됩니다
		// 그 이전에 저장되는 값은 소멸 - 한번에 하나씩만 저장할 수 있는 단점이 있음
		n1=60;
		System.out.println("프로그램 실행중 변경된 n1변수의 값 : " + n1);
		
		
		// char 형 데이터는 컴퓨터 저장장치에 저장될때 특별한 이진수 코드로 저장됩니다
		// 문자를 저장하기 위한 코드체계에 의해 조합된 코드입니다.
		// 이 이진수를 십진수로 변환하면 정수로 변환이 가능합니다.
		// 그 결과 정수와 문자간에는 약간의 호환성이 발생됩니다
		
		char ch = 'A';
		int intchar = ch;
		
		System.out.printf("ch -> 정수형 변수에 저장 %d\n", intchar);
		System.out.printf("ch -> %c\n", ch);
		System.out.printf("ch -> 정수 출력자리에 문자출력 %d\n", (int)ch);
		System.out.printf("ch -> 문자 출력자리에 정수출력 %c\n", intchar);
		
		ch = 'B';
		System.out.printf("'B' -> 정수값으로 캐스팅 %d\n", (int)ch);
		System.out.printf("'B' -> 정수값으로 캐스팅 %d\n", (int)'B');
		System.out.printf("'C' -> 정수값으로 캐스팅 %d\n", (int)'C');
		System.out.printf("'Z' -> 정수값으로 캐스팅 %d\n", (int)'Z');
		System.out.printf("'a' -> 정수값으로 캐스팅 %d\n", (int)'a');
		System.out.printf("'z' -> 정수값으로 캐스팅 %d\n", (int)'z');
		System.out.printf("'0' -> %d, '9' -> %d\n", (int)'0', (int)'9');
		
		// 대문자 B 값에 32를 더하여 소문자 b 로 변경
		System.out.printf("%c + 32 -> %c\n", ch, ch + 32);
		
		// 아라비아 기호 '8' 에서  아라비아 기호 '0' 을 빼면, 정수 8이 결과로 나옵니다
		System.out.printf(" '8'-'0' -> %d\n", '8' - '0' );
		
		// 실수형 변수의 초기화
		// 자바에서 모든 실수들은 별도의 표기가 없으면, 기본적으로 double  타입으로 인식합니다
		// float 타입으로 값을 저장하기 위해서는 float 형 변수를 선언하고  float  형 데이터를 저장합니다.
		// float 변수에  double 형 데이터 입력 -> 에러
		// float f1 = 1.123;  // 에러
		// float  변수에   float  형 데이터 입력 -> 정상실행
		float f2 = 1.123f;  // 또는 float f2 = 1.123F;
		
		// float 변수에 double 형 변수값을 저장하는 방법 : 캐스팅 연산 실행
		double f3 = 1.123;
		float f4 = (float)f3;
		// 용량이 큰 자료형(double)에  작은 자료형(float) 데이터 대입  -> 정상실행
		float f5 = 123.123F;
		double f6 = f5;  // 캐스팅 연산이 필요 없습니다
		
		// 정수들의 값의 대입
		int a = 100;
		byte b1 = (byte)a;
		// byte b2 = a;    // 에러 - 변수를 이용한 값의 대입은 캐스팅이 필요
		byte b2 = 123;    // 일반값에 의한 대입은 캐스팅이 필요가 없습니다 ( 정수데이터에 한해서만 허용 )
		a = b2;  // 용량이 작은 자료형을 큰 자료형에 대입은 정상실행
		
		// 용량이 큰 변수값을 용량이 작은 변수갑으로 넣으려고 하면 캐스팅 연산 필요
		// 반대의 경우는 문제없이 모든 실행이 가능합니다.
		
	}
}










