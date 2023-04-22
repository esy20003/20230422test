package days10;

// int 형 자료를 매개변수로하는 생성자 와 디폴트 생성자를 오버로딩하하는 클래스 생성
// 전달인수가 있으면 전달인수를 멤버변수 dan에 저장, 전달인수가 없으면  dan 에 0 저장
// 멤버변수는 int dan;  한개만 생성
// 멤버매서드는 print() 하나
// print 메서드의 내용
// dan 이 0이 아니면 해당 구구단 출력
// dan 이 0이면 2~9단 구구단 모두 출력

class Googooan{
	int dan;

	Googooan(){ // 전달인수없으면
		dan = 0;
	}
	Googooan(int d){ // 전달인수있으면
		dan = d;
	}
	public void print() {
		if( dan != 0 ) {
			for(int i=1; i<=9; i++)
				System.out.printf("%dx%d=%2d\n", dan, i, dan*i);
		}else {
			
			for(int i=1; i<=9; i++) {
				for(int j=2; j<=5; j++) {
					System.out.printf("%dx%d=%2d  ", j, i, j*i);
				}
				System.out.println();
			}
			System.out.println();
			for(int i=1; i<=9; i++) {
				for(int j=6; j<=9; j++) {
					System.out.printf("%dx%d=%2d  ", j, i, j*i);
				}
				System.out.println();
			}
		}
	}
}
public class Class17 {
	public static void main(String[] args) {
		Googooan g1 = new Googooan(4);
		Googooan g2 = new Googooan();
		g1.print();
		g2.print();

	}

}
