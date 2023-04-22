package days15;

//Thread 를 추가 생성해서 동시실행 명령을 실행하는 방법 #3 
// 익명 클래스를 이용하는 방법
// 이방법은 앞선 예제의 new Thread( new ThreadF2() ).start(); 의 방법과 조금 흡사합니다

// 익명 클래스 : 클래스 객체변수 이름없이 상속 또는 구현(implements) 를 위해서 만드는 클래스

public class Thread06 {

	public static void main(String[] args) {
		
		// 여기쯤에서 별도 클래스 생성을 외부에 하지 않고 쓰레드를 활용하여 동시실행을 하고자 할때
		new Thread(){
			public void run() {
				for( int i = 1 ; i <= 10 ; i++ ) {
					System.out.printf("익명클래스 : i -> %d\n", i);
					try {	Thread.sleep(100);	 
					}catch (InterruptedException e) { e.printStackTrace(); }
				}
			}
		}.start();
		// new Thread() {}.start(); 
		// new Thread 로 객체를 새로만들지만 그 객체를 참조변수에 저장하지 않고 start() 호출
		// run 메서드는 중괄호 안에 작성합니다
		for( int i = 1 ; i <= 10 ; i++ ) {
			System.out.printf("main : i -> %d\n", i);
			try {	Thread.sleep(100);	} 
			catch (InterruptedException e) {e.printStackTrace();}
		}
		
		//--------------------------------------------------------------------------------
		TestClass t1 = new TestClass();  // 객체생성후
		t1.testVar = 100;  // 변수이용
		t1.testMethod();   // 메서드 호출
		TestClass.testStaticMethod();
		//-----------------------------------------------------------------------------------
		new TestClass().testVar = 100;   // 객체 생성과 동시에 변수이용
		new TestClass().testMethod();    // // 객체 생성과 동시에 메서드 호출
		new TestClass() {}.testMethod(); // 중괄호 안에 추가 또는 재정의 가능
	}
}
class TestClass{
	int testVar;
	public void testMethod() {
	}
	public static void testStaticMethod() {
	}
}









