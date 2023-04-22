package days07;

public class Method05 {

	public static void main(String[] args) {
		int num = 100;
		System.out.println("main 메서드에서의  num 변수값 : " + num); // 100 출력
		updateValue(num); // updateValue 메서드 호출
		System.out.println("updateValue 실행후 main 메서드에서의  num 변수 값 : " + num); // 100
	}
	
	// 호출한 지역(main)에서의 변수와  호출된 메서드의 매개변수 이름은 같아도 무방합니다.
	// 이름이 같은 두 변수는 서로 다른 변수이므로 각자의 지역에서 일련의 변화를 주어도
	// 서로의 값에 아무런 영향을 주지 않습니다.
	// 다만 호출한 지역에서 호출된 매서드에  변수값을 전달해주기위해    
	// 전달인수->매개변수 구조를 이용할 뿐입니다.
	// 이때도 전달인수로 변수를 지정했다면  이는 변수가 전달되는것이 아니라
	// 변수에 저장된 값의 복사본이 전달되므로 호출된 메서드의 연산으로 부터 원본은 아무런 영향을 받지 않습니다
	// 이렇게 값에의한 호출을 Call By Value 라고 합니다
	
	public static void updateValue( int num ) {	
		num = 200;
		System.out.printf("updateValue  메서드 내의 num 변수 값 : %d\n", num);  // 200 출력
	}

}
