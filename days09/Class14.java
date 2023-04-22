package days09;


class Cclass{

	private int age;
	Cclass(int i) {
		age = i;
	}   // 1-2. 매개변수가 있는 생성자 정의
	Cclass(){
		age = 100;
	}   // 2-2. 디폴트 생성자를 오버로딩하여 추가로 정의합니다
	
}
class Dclass{
	private int age;
	private String name;
	
	public Dclass() {
		super();
	}

	public Dclass(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	
}

public class Class14 {

	public static void main(String[] args) {
		
		Cclass c1 = new Cclass(20);
		Cclass c2 = new Cclass(30);
		// 1-1. 생성자에 전달인수를 만들고 다른 값을 전달하여, 객체마다 멤버변수의 초기값을 달리 하여 
		//    생성할 수 있습니다.
		
		Cclass c3 = new Cclass();
		// 2-1. 클래스 내부에 생성자가 꺼내어 져서 매개변수를 사용할 경우, 매개변수가 없는 디폴트 생성자는 
		//    새로 생성된 생성자로 "대체"되어져서 없는 생성자가 됩니다.   따라서 위 명령은 에러가 됩니다.
		
		// 3. 디폴트생성자의 오버로딩을 통해  없어진 디폴트생성자 문제를  해결할 수 있습니다
	}

}
