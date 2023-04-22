package days10;

//this 키워드의 용도 #1

// this 변수는 레퍼런스(참조) 변수입니다.
// 멤버변수는 new 생성자() 에 의해 새로운공간 객체별로 각각 만들입니다.
// 반면에 멤버 메서드는 한개만 만들어지며, 각객체들이 공유&호출해서 사용합니다.
// 이때 메서드내에는 "누가 자신을 호출했는지 구분"하기 위해 this 라는 참조변수를 준비해놓고 있습니다.
// 호출한 객체의 참조값이 this에 저장됩니다.
// this 변수는 따로 기술하지 않은 숨어있는 변수입니다

class ThisA{
	private int num;
	public void init(int num  /* , ThisA this  */ ) {
		this.num = num;
	}
	public void prn( /* ThisA this  */ ) {
		System.out.println("멤버변수 num 의 값 : " + this.num );
	}
	
	public int getNum( /* ThisA this  */ ) {
		return this.num;
	}
	public void setNum(int num /* , ThisA this  */) {
		this.num = num;
	}
	
	public void copy1( ThisA c /* , ThisA this  */ ) {  // c <- a4   this <- a6
		this.num = c.num;		
	}
	
	public ThisA copy2( /* ThisA this  */ ) {   // this <- a3
		ThisA temp = new ThisA();   // 새로운 객체 생성
		temp.num = this.num;    // 전달된 a3 의 num 값을 새객체의 num 에 복사
		return temp;   // 완성된 복사본의 참조값을 리턴
	}
	
	ThisA(){ }  // 아래 생성자가 만들어지면서 디폴트 생성자가 대체되었습니다
	// 다른곳에서 호출하던 디폴트 생성자가 없어지면서 에러를 발생할수 있으니
	// 간단하게 디폴트 생성자를 오버로딩해줍니다
	
	ThisA( ThisA t ){   // t <- a7  ,  this <- a8
		this.num = t.num;
		// 메서드 자체가 이미 생성자이기때문에  별도의 new ThisA() 는 필요치않고
		// 멤버변수값만 복사합니다
	}
}
public class Class18 {

	public static void main(String[] args) {
		ThisA  t1 = new ThisA(); 
		t1.init(100);
		t1.prn();
		ThisA  t2 = new ThisA(); 
		t2.init(200);
		t2.prn();
		
		ThisA a3 = new ThisA();
		ThisA a4 = new ThisA();
		a3.setNum(300);  //  a3 -> this   300->매개변수num
		a4.setNum(400);  //  a4 -> this   400->매개변수num
		System.out.println("a3의 멤버변수 num : " + a3.getNum() ); //  a3 -> this
		System.out.println("a4의 멤버변수 num : " + a4.getNum() ); //  a4 -> this
		
		ThisA a5 = a3;
		a3.setNum(500);
		a5.prn();
		a3.prn();
		
		ThisA a6 = new ThisA();
		a6.copy1(a4);   // 공간할당(new ThisA())이 된 상태에서 멤버변수값만 카피
		a4.setNum(600);
		a6.prn();
		a4.prn();
		
		ThisA a7 = a3.copy2();  // 새로운 공간생성후 멤버변수값 카피하고 그 객체의 참조값 리턴
		a3.setNum(800);
		a7.prn();
		a3.prn();
		
		ThisA a8 = new ThisA( a7 );
		
	}

}








