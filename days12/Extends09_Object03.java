package days12;

// Object 클래스의 equals 메서드 : 객체간의 비교를 위해서 사용되는 메서드
// Object 가 상속한 메서드들 중 toString 과 함꼐 가장 많이 오버라이딩 되는 메서드

class Point {
	private int x;
	private int y;
	Point(int x, int y) {this.x = x; this.y = y;}
	public String toString( ) { 	return "x:" + this.x + ", y:" + this.y;  	}
	
	// 오버라이딩 되는 메서드의 조건 : 리턴값의 유형, 매개변수의 유형-갯수-순서가 같아야 합니다
	// "부모클래스의 참조변수에 자식클래스의 인스턴스 참조값을 아무런 제약없이 저장할수 있다"
	// equals 의 매개변수는 모든 클래스의 부모클래스인 Object 형 매개변수가 존재해야 하고
	// 그렇게 되면 어떤 자료형이든 전달인수로 전달이 가능합니다.
	public boolean equals(  Object obj  ) {   
		// 메서드의 호출 형태 : p1.equals( p2 );
		// this <- p1      obj <- p2
		// "자식 인스턴스를 저장한 부모클래스 참조변수는 물려준 멤버만 접근이 가능합니다"
		// "물려주지 않은 멤버변수 x, y 에 접근이 안됩니다."
		// 또한 현재 상태는 obj(Object)와   this(Point) 를 갖고 비교해야 하는 상황입니다
		// 원할 비교를 위해서 obj(Object)를 Point 형으로 변환할 필요가 있습니다
		// "부모참조변수에 저장된 값을 자식 참조변수에 옮겨담을땐 강제캐스팅이 필요합니다"
		if( !(obj instanceof Point) ) return false; 
		// 전달된 비교대상 객체가 Point 로 캐스팅될수 없는 개체라면  비교하지말고 바로 false 리턴
		Point p = (Point)obj;
		boolean result = (p.x == this.x)  && (p.y==this.y);
		return result;
	}
}

public class Extends09_Object03 {

	public static void main(String[] args) {
		
		// 일반적인 기본자료형들의 비교 ( == )
		int n1 = 10;
		int n2 = 20;	
		if( n1 == n2 )	System.out.println("n1 변수와 n2 변수는 같습니다.");
		else 	System.out.println("n1 변수와 n2 변수는 다릅니다.");
		
		// String 자료형의 비교 ( == )
		String s1 = "Hello";
		String s2 = "Hello";
		if( s1 == s2 )	System.out.println("s1 변수와 s2 변수는 같습니다.");
		else	System.out.println("s1 변수와 s2 변수는 다릅니다.");
		// String s1 = "Hello";   이 명령에의해 Heap 에 "Hello" String 데이터가 저장될 공간이 잡히고
		// s1 에 그 공간의 주소(참조값)이 저장됩니다.
		// 그 다음에 String s2 = "Hello"; 가 실행되면, new 가 없으므로, 혹시 Heap 안에  "Hello" 가 
		// 저장되어 있는지 한번정도 검색을하고   발견되면 그주소(참조값)를 s2에 저장합니다.
		// 발견되지 않으면, 다시말해서 다른  text 이면 그때 새로운 공간을 할당합니다.
		// 결국 s1 == s2 는 text 들의 비교가 아니라 참조변수가 저장하고 있는 참조값(주소)들의 비교였던 것입니다
		
		String s3 = new String("Hello");
		String s4 = new String("Hello");
		if( s3 == s4 )	System.out.println("s3 변수와 s4 변수는 같습니다.");
		else	System.out.println("s3 변수와 s4 변수는 다릅니다.");
		// new 에 의해서 새로운 공간이 생기고 같은 text 를 갖었다고 할수 있지만
		// 비교는 s3 이 저장한 참조값하고 s4 가 저장한 참조값이 비교가되어  두 변수는 다릅니다 라는 결과를 출력
		
		// 결론 : (==) 이 연산자는 클래스 멤버인 글자들의 비교가 아니라, 레퍼런스 주소들의 비교입니다.
		
		if( s3.equals(s4) )
			System.out.println("s3 변수와 s4 변수는 같습니다.(equals)");
		else	
			System.out.println("s3 변수와 s4 변수는 다릅니다.(equals)");
		// 참조값이 다른 객체라도 equals를 이용한다면 실제 저장된 멤버값들을 비교하여 같은지 같지 않은지를 
		// 확인할수 있습니다
		
		Point p1 = new Point(20,30);
		Point p2 = new Point(20,30);
		if( p1==p2 )	System.out.println("p1 변수와 p2 변수는 같습니다.(==)");
		else	System.out.println("p1 변수와 p2 변수는 다릅니다.(==)");
		
		if( p1.equals(p2) )	System.out.println("p1 변수와 p2 변수는 같습니다.(equals)");
		else	System.out.println("p1 변수와 p2 변수는 다릅니다.(equals)");
		
		// equals 메서드는 Object 클래스의 메서드로서 최초는 레퍼런스값(주소)들의 비교를 정의하고 있습니다.
		// String 클래스는 이미 equals 메서드를 text값들이 비교되도록 오버라이딩 되어 있으며
		// 기타 다른 사용자 정의 클래스(Point)에서는 별도로 equals 를 실제값으로 비교하도록 오버라이딩 해줘야 합니다
		
		p1.equals(s1);
	}

}








