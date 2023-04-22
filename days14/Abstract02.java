package days14;

// 추상 클래스 작성방법
// 클래스 생성구문 앞에 abstract 키워드를 붙여서 생성합니다.
// 추상메서드를 포함한 클래스 : 추상 메서드를 하나이상 포함하면 추상클래스라고 부릅니다
// 추상메서드 : 메소드의 원형만 존재하고 실제 내용이 없는 메서드

abstract class AbstractAnimal{
	public abstract void crying( );
	// 메서드의 원형만 있고, 메서드의 body(몸체)구현은 없습니다.
}

// 추상 메서드의 작성방법
// 접근지정자 abstract 리턴값의타입 메소드명( 매개변수 );
// 추상 클래스는 일반 클래스와 동일하게 일반 멤버변수 일반 메소드, 생성자 등을 포함할 수 있습니다.
// 단, 추상 메소드를 포함할 수 있는 특징이 추가된 클래스입니다.
// 추상클래스는 상속을 통한 다형성 구현을 위해서 생성됩니다

class DogA extends AbstractAnimal{
	public void crying( ) {
		System.out.println("멍~멍~");
	}
}
class CatA extends AbstractAnimal{
	// @Override : 어너테이션. 자바에 사용되는 변수나 메서드에 명찰처럼 사용되는 표시
	// 어너테이션은 명령은 아닙니다. 다만 필요한 곳에 표시를 해서 JVM 이 프로그램 구성이나 준비동작에 도움이 
	// 되도록 하는 표식입니다.   어너테이션은 Override 말고도 다양한 표시가 있습니다
	@Override  
	public void crying() {
		System.out.println("야옹~");		
	}
}
// 추상클래스를 상속받은 자식클래스는 반드시 물려받은 추상메서드를 오버라이드 해야 에러가 발생하지 않습니다.
// - 오버라이딩에 강제성을 부여

public class Abstract02 {

	public static void main(String[] args) {
		// AbstractAnimal a = new AbstractAnimal(); // 에러    추상클래스로 객체생성은 되지 않습니다
		// 추상클래스를 상속받은 자식클래스는 객체 생성이 가능합니다
		DogA d1 = new DogA();
		CatA c1 = new CatA();
		d1.crying();
		c1.crying();
		
		AbstractAnimal a;  // new AbstractAnimal() 을 이용하여 객체는 만들지 못하지만 
		// 참조변수는 생성은 가능합니다.
		
		// 추상클래스가 공통의 요소를 모아서 생성되고, 상속을 받은 케이스이므로 이들은 분명한 부모클래스입니다
		// ★★★★★ 상속 다형성 규칙 중 하나
		// 부모클래스의 참조변수에 자식클래스의 인스턴스 주소를 저장할 수 있다
		AbstractAnimal a1 = new DogA();
		AbstractAnimal a2 = new CatA();
		// ★★★★★ 상속 다형성 규칙 중 둘
		// 자식클래스의 인스턴스 주소를 저장하고 있는 부모참조변수는 물려준 멤버변수와 물려준 멤버메서드만 접근이 가능하다
		// 자식클래스의 인스턴스 주소를 저장하고 있는 부모참조변수는 자식클래스가 새롭게 만든 멤버에 접근이 불가능하다
		// 자식인스턴스 주소를 저장하고 있는 부모 참조변수로 물려준 메서드를 실행하면, 오보라이딩된 자식메서드가 실행된다
		a1.crying();
		a2.crying();
	}

}









