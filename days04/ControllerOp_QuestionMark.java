package days04;

import java.util.Scanner;

public class ControllerOp_QuestionMark {

	public static void main(String[] args) {
		
		// 점수가 70점 이상이면 합격, 아니면 불합격을 출력하세요
		// 단순 조건으로 두중에 하나 선택하여 실행 또는 연산하는 경우
		Scanner sc = new Scanner(System.in);				
		System.out.printf("점수를 입력하세요 : ");
		int score = sc.nextInt();
		
		String prnText;
		// if( score>=70 ) prnText = "합격";
		// else prnText = "불합격";
		prnText = ( score>=70 )? "합격" : "불합격";
		// 괄호안의 비교연산이 true 이면 콜론 왼쪽의 "합격"이,  false 이면 콜론 오른쪽의 "불합격"이 prnText 에 저장
		System.out.println("입력한 점수는 " + prnText + " 입니다");
		
		System.out.printf("기본급을 입력하세요 : ");
		int a = sc.nextInt();
		// 기본급 100만원 이상이면 50%, 100만원 미만이면 60%가산하여 지급액을 출력
		
		// 코드#1
		double per = (a>=1000000)? 0.5 : 0.6;
		System.out.println("총지급액 " + (int)(a+a*per) );
		
		//코드 #2
		double b = ( a>=1000000 )? a+a*0.5 : a+a*0.6;  // 콜론 양옆에 연산식도 쓸수 있습니다
		System.out.println("총지급액 " + (int)b );
		
	}

}












