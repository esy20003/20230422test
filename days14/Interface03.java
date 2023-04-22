package days14;

interface InterSuper1 {	
	public abstract void InterSuper1_Test(); 
}
interface InterSuper2 {	
	public abstract void InterSuper2_Test(); 
}

// 인터페이스를 implements 한다는 것은 부모인터페이스에 있는 추상메서드를 자식클래스에서 내용을 채우고, 
// 더이상 추상메서드가 아닌 완벽한 메서드로 완성한다는 뜻이기도 합니다. 반드시 오버라이드를 해야합니다

// 그러나 , 인터페이스들끼리의 상속은  상속 받는 곳도 인터페이스 이기때문에(아직 implements 하기 전)
// 구현의 implements 의미보단  상속 extends 의 의미로 물려주는 관계가 가능합니다
// ★★★★★ 인터페이스끼리의  extends 는 추상매서드의 override 의무는 면제됩니다.
// ★★★★★ 또한 인터페이스들끼리 다중 상속(extends)이 가능합니다
interface InterSub extends InterSuper1, InterSuper2{
	// 상속받았기때문에 (구현하지 않고 물려받았기때문에) 아래와 같이 추상메서드가 존재하는 샘입니다
	// public abstract void InterSuper1_Test();  InterSuper1에서 상속받은 추상메서드
	// public abstract void InterSuper2_Test();  InterSuper2에서 상속받은 추상메서드
	public abstract void InterSub_Test();  // InterSub 인터페이스 자체의 추상메서드
}

// InterSub 를 implements 한 클래스는 InterSub 가 보유하고 있는 세개의 추상메서드를
// 모두 오버라이딩 해야합니다
class SubC2 implements InterSub {
	@Override
	public void InterSuper1_Test() { }
	@Override
	public void InterSuper2_Test() { }
	@Override
	public void InterSub_Test() { }
}

//두개이상의 인터페이스를 implements한 클래스는 그들에게 있는 추상메서드를 모두 오버라이딩 합니다
class SubC1 implements  InterSuper1, InterSuper2{
	@Override
	public void InterSuper1_Test() { }
	@Override
	public void InterSuper2_Test() { }
}


public class Interface03 {

	public static void main(String[] args) {
		SubC2 c2= new SubC2();  // 원래 자식객체
		SubC1 c1= new SubC1();  // 원래 자식객체
		
		// InterSub(추상메서드 3개보유)를 implement 한 자식객체를  InterSuper1 참조변수에 저장
		InterSuper1 s1 = new SubC2();
		s1.InterSuper1_Test();  // 이것만 사용가능
		
		// InterSub(추상메서드 3개보유)를 implement 한 자식객체를  InterSuper2 참조변수에 저장
		InterSuper2 s2 = new SubC2(); 
		s2.InterSuper2_Test(); // 이것만 사용가능
		
		// InterSub(추상메서드 3개보유)를 implement 한 자식객체를  InterSub 참조변수에 저장
		InterSub s3 = new SubC2(); 
		s3.InterSub_Test();      // 세개의 멤버메서드 모두 사용 가능
		s3.InterSuper1_Test();  // 세개의 멤버메서드 모두 사용 가능
		s3.InterSuper2_Test();  // 세개의 멤버메서드 모두 사용 가능
		
		// s1.InterSuper2_Test();  // 에러-InterSuper2_Test()는 InterSuper1이 물려준 메서드가 아닙니다
		// s1.InterSub_Test(); //  에러-InterSub_Test()는 InterSuper1이 물려준 메서드가 아닙니다
		// s2.InterSuper1_Test();  // 에러-InterSuper1_Test()는 InterSuper2이 물려준 메서드가 아닙니다	
		// s2.InterSub_Test(); // 에러-InterSub_Test()는 InterSuper2이 물려준 메서드가 아닙니다	
		
		// InterSuper1 과  InterSuper2 를 다중상속한 SubC1 의 객체를 InterSuper1 참조변수와
		// InterSuper2 참조변수에 저장.
		InterSuper1 s4 = new SubC1();  
		InterSuper2 s5 = new SubC1();  
		// InterSub s3 = new SubC1();  // 에러 -  SubC1 은 InterSub를 상속하지 않았으로 에러
		
		// InterSuper1 과 InterSuper2 각자가 물려준 메서드 호출 가능
		s4.InterSuper1_Test();
		s5.InterSuper2_Test();
		// 각자가 물려주지 않은 메서드는 호출 불가능
		// s4.InterSuper2_Test();  // X
		// s5.InterSuper1_Test();  // X
		
		// c1 : InterSuper1 과 InterSuper2 를 implement 한 SubC1 의 객체
		// c2 : InterSuper1, InterSuper2, InterSub 를 implement 한 SubC2 의 객체
		test1( c2 );
		test1( c1 );

		test2( c2 );
		test2( c1 );
		
		test3( c2 );		
		// test3( c1 );  
		// c1은 SubC1 클래스의 객체이며,  InterSub 인터페이스를 상속(구현)하지 않았습니다 
	}
	public static void test1( InterSuper1  i1 ) {  
		i1.InterSuper1_Test();
	}
	public static void test2( InterSuper2  i2 ) {  
		i2.InterSuper2_Test();
	}
	public static void test3( InterSub  i3 ) {  
		i3.InterSuper1_Test();
		i3.InterSuper2_Test();
		i3.InterSub_Test();
	}

}










