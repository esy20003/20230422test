package days10;

//복소수  5 + 3i   
//i -> 루트-1  : -1 의 제곱근 (허수)

class Complex{
	int real;
	int image;
	
	Complex(){
		this.real = 5;
		this.image = 6;
	}
	Complex(int real, int image){
		this.real = real;
		this.image = image;
	}
	public void init(int real, int image) {
		this.real = real;
		this.image = image;
	}		
	public void prn() {
		System.out.println("(" + real + "+" + image + "i)");
	}
	
	public Complex add( Complex c ) {  // this <- c1,    c <- c2 
		Complex result = new Complex();
		result.real = this.real + c.real;
		result.image = this.image + c.image;
		return result;
	}
	
	public Complex subtract(Complex c) {
		Complex result = new Complex();
		result.real = this.real - c.real;
		result.image = this.image - c.image;
		return result;
	}
}

public class Class19 {

	public static void main(String[] args) {
		Complex c1 = new Complex();
		c1.init( 5, 6);
		Complex c2 = new Complex(2, 3);  // 2는 실수부에 3허수부에 저장하는 생성자 호출
		c1.prn();   // (5 + 6i) 형태로 출력되는 메서드 호출
		c2.prn();
		
		System.out.println();
		Complex c3 = c1.add(c2);  // 실수부는 실수부끼리  허수부는 허수부끼라 합산
		c1.prn();
		c2.prn();
		c3.prn();
		
		System.out.println();
		c3 = c1.subtract(c2);   // 실수부는 실수부끼리  허수부는 허수부끼라 뺄셈
		c1.prn();  
		c2.prn();
		c3.prn();
		
	}

}
