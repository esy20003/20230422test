package days02;

import java.util.Scanner;

public class Operator02 {

	public static void main(String[] args) {
		
		// (입력) 갖고 있는 사과의 총갯수 입력 : XX
		// (입력) 상자 하나에에 담길 사과의 갯수 입력 : XX
		
		// (출력)입력조건으로 포장했을때, 포장된 박스갯수, 남은 사과 갯수 출력
		// 박스갯수 : XX 
		// 남은 사과 : XX
		
		Scanner sc = new Scanner(System.in);
		System.out.printf("사과의 갯수를 입력하세요  : ");
		int apple;
		apple = sc.nextInt();
		
		System.out.printf("상자하나에 포장될 사과의 갯수를 입력하세요  : ");
		int boxOneQuantity;
		boxOneQuantity = sc.nextInt();
		
		int boxQuantity = apple / boxOneQuantity;
		int theRest = apple % boxOneQuantity;
		System.out.println("포장된 사과박스 갯수 : " + boxQuantity);
		System.out.println("남은 사과갯수 : " + theRest );

	}

}
