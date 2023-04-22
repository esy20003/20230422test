package days15;
// Thread 를 추가 생성해서 동시실행 명령을 실행하는 방법 #1
// 1-1. Thread 클래스를 상속받은 클래스를 생성
// 1-2. 그 클래스안에 run 메서드를 오버라이드
// 1-3. 실행할명령은 run 메서드에 작성
// 1-4. 객체를 만들어서 start 메서드를 호출

// Thread 를 추가 생성해서 동시실행 명령을 실행하는 방법 #2 
// Runnable 인터페이스를 구현(implements)하는 방법
// 2-1. Runnable 인터페이스를 구현하는 클래스 작성
// 2-2. public void run() 오버라이딩 구현
// 2-3. 해당 클래스의 A 객체 생성
// 2-4. A 객체를 Thread 클래스의 생성자로 전달하여 Thread 객체 생성
// 2-5. 생성시킨 쓰레드의 start 메소드 호출!

class ThreadF1 implements Runnable{
	@Override
	public void run() {
		for( int i = 1 ; i <= 10 ; i++ ) {			
			System.out.printf("ThreadF1 : i -> %d\n", i);
			try {	Thread.sleep(100);
			} catch (InterruptedException e) {	e.printStackTrace();}
		}
	}
}
class ThreadF2 implements Runnable {
	public void run() {
		for( int i = 1 ; i <= 10 ; i++ ) {
			System.out.printf("ThreadF2 : i -> %d\n", i);
			try {	Thread.sleep(100);
			} catch (InterruptedException e) {	e.printStackTrace();}
		}
	}
}

public class Thread05 {

	public static void main(String[] args) {
		
		// 1. Runnable 인터페이스를 implements 한 클래스의 객체를 생성
		ThreadF1 f1 = new ThreadF1();
		// 2. new Thread() 명ㄹ여으로 Thread 클래스의 새 객체를 생성하되, 
		//     생성자의 전달인수로 f1 을 전달해줍니다
		Thread t1 = new Thread( f1 );
		// 3. 그리고 생성된 Thread 객체에서 .start() 메서드를 호출합니다. 
		//      -> 쓰레드 추가생성 & f1 객체의 run 메서드 실행
		t1.start();
		
		// 위의 1, 2, 3 과정을 한개의 명령, 한라인의 코딩으로 표현이 가능합니다
		new Thread( new ThreadF2() ).start();
		
		for( int i = 1 ; i <= 10 ; i++ ) {
			System.out.printf("main : i -> %d\n", i);
			try { Thread.sleep(100);
			} catch (InterruptedException e) {	e.printStackTrace();}
		}
		

	}

}












