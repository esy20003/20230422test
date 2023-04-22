package days11;

class SuperF{
	int superNum;
	void abc() { 
		System.out.println("super method"); 
	}
}

class SubF extends SuperF{
	int subNum;
	void abc() {   // 부모클래스의 메서드를 오버라이딩 한 메서드
		System.out.println("sub method"); 
	}
}

public class Extends09_TypeCasting02 {

	public static void main(String[] args) {
		
		// 부모클래스의 객체를 생성
		SuperF super1 = new SuperF();
		// 자식클래스의 객체를 생성
		SubF sub1 = new SubF();
		
		// 객체간의 TypeCasting  #1
		// 일반 자료형은  용량이 큰 변수에 작은용량 값을 대입하면 별도의 연산없이 대입이 가능
		// 객체간에는 부로클래스의 참조변수에  자식 클래스의 인스턴스주소를 저장하면 별도의 연산없이 가능
		super1 = sub1;
		// 부모참조변수  <- 자식 인스턴스의 주소  OK
		SuperF super2 = new SubF();  // new 인스턴스의 주소도 가능
		// super2 가 저장한 값은 참조값이고,  그 참조값의 주인공인 new SubF() 는 자식클래스의 인스턴스가 됩니다.
		
		// 객체간 TypeCasting #2
		// 자식클래스의 참조변수에 부코클래스의 인스턴스의 주소는 아무런 조치 없이 저장할 수 없습니다.
		// 자식참조변수 <- 부모 인스턴스의 주소  X
		SuperE super3 = new SuperE();
		// SubE sub3 = super3;  // 에러
		// SubF sub2 = new SuperF();  // 에러
		
		
		// 객체간 TypeCasting #3
		// 자식클래스의 참조변수에 부코클래스의 인스턴스 주소를 그래도 저장하고 싶다면 강제캐스팅을 이용할 수는 있습니다
		SuperF super4 = new SuperF();
		// SubF sub4 = (SubF) super4;  // 문법으로는 오류가 없지만 실행상 오류가 발생 -> 런타임 오류
		// 부모인스턴스가 강제캐스팅(SubF)를 앞에 두고 아무리 "자식인척해도"  언제는 부모인게 들통난다는 뜻입니다.
		
		
		// 객체간의 TypeCasting  #4
		// 만약 앞의 #3에서 super4 참조변수가 저장하고 있는 인스턴스 주소가 자식 인스턴스의 주소였다면,
		// 주인공은 자식 인스턴스이므로 - 부모클래스 참조변수로 자식클래스 참조변수에 주소를 저장할 수 있습니다.)
		// 그렇다면  SubE sub4 = (SubE) super4;  이코드는 정상 실행합니다.
		// 결과적으로 자식인스턴스 주소를 자식 참조변수에 저장한 셈이 되므로 정상 실행
		SuperF super5 = new SubF();  // 부모참조변수 <- 자식 인스턴스 주소
		SubF sub5 = (SubF) super5;   // 자식참조변수 <- (부모참조변수 <- 자식 인스턴스 주소)
		
		// 자식인스턴스 의 주소 -> 부모 참조변수 ->(타입캐스팅)-> 자식 참조변수  OK
		// 부모인스턴스의 주소 -> 부모 참조변수 ->(티입캐스팅)-> 자식참조변수 X 런타임에러
		
		// 자식인스턴스 주소가 부모참조변수에 저장될때는 문제가 없지만  다시 나와서 자식참조변수에 저장될때는
		// 강제캐스팅이 반드시 필요합니다.
		
		
		// 객체간의 TypeCasting  #5
		// #1  부모 참조변수 <- 자식 인스턴스 주소
		// #1 에서 자식인스턴스 주소를 저장한 부모참조변수는  부모클래스에서 물려준 멤버들에만 접근이 가능합니다
		SuperF super6 = new SubF();  // 부모참조변수 <- 자식인스턴스주소
		
		super6.superNum = 100;  // 부모가 물려준 멤버변수 자유롭게 사용가능
		// super6.subNum = 200;  // ★★★★★ 에러 .  자식 멤버변수에는 접근이 불가능합니다.
		super6.abc();   // ★★★★★ 부모클래스 메서드보다 재정의된 자식클래스 매서드가 우선 실행됩니다.
		
		// 부모참조변수로 접근이 불가능한 자식멤버변수를 사용하려면...
		//   -> 저장된 자식인스턴스 주소를 자식 참조변수에 옮겨담고 접근하는 수 밖에 없습니다
		SubF sub6 = (SubF)super6;
		sub6.subNum = 300;
		
		// 객체간의 TypeCasting  #6
		// #4 에서 있었던    "자식 레퍼런스 <- (타입캐스팅) 부모레퍼런스 <- 부모 인스턴스의 주소 : 런타임에러"
		// 이에러를 방지하는 방법.
		SuperF super81 = new SubF();  // 부모참조변수 <- 자식인스턴스 주소
		SubF sub8;
		
		if( super81 instanceof SubF ) {   // intanceof : 왼쪽 객체가 오른쪽 클래스형으로 캐스팅 가능이면 true
			sub8 = (SubF)super81;  // 자식인스턴스주소를 갖고 있는 부모 참조변수값을 자식참조변수에 저장
			System.out.println("super81 형변환 성공~!"); 
		}else {
			System.out.println("super81 형변환 실패~!"); 
		}
		
		
		SuperF super82 = new SuperF();  // 부모 참조 변수 <- 부모 인스턴스 주소
		if( super82 instanceof SubF ) {   
			sub8 = (SubF)super82; 
			System.out.println("super82 형변환 성공~!"); 
		}else {
			System.out.println("super82 형변환 실패~!"); 
		}
		
	}

}









