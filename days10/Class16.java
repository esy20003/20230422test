package days10;

import java.util.Scanner;

class Student{
	private int bun;
	private String name;
	private int [] scores;
	private double avg;
	Scanner sc = new Scanner(System.in);
	
	Student(){ 
		//System.out.print("과목을 입력하세요 : ");
		//int k = sc.nextInt();
		//scores = new int[k+1];
		scores = new int[4];  
		// 멤버변수에 참조변수만 존재한다면 생성자에서 메모리 할당 명령이실행됩니다
		name = "김하나";
		scores[0] = 89;
		scores[1] = 87;
		scores[2] = 98;
		// 번호는 객체가 생성될때마다 부여되는 연속번호입력방법을 공부하고 넣겠습니다
	}
	Student(String name){ 
		scores = new int[4]; 
		this.name = name;
		scores[0] = 67;
		scores[1] = 88;
		scores[2] = 76;
	}
	Student(String name, int kor, int mat, int eng){ 
		scores = new int[4]; 
		this.name = name;
		scores[0] = kor;
		scores[1] = mat;
		scores[2] = eng;
	}
	
	public void prnTitle() {
		
	}
	public void prnScore() {
		
	}
	Student(  Student s  ){
		scores = new int[4]; 
		this.name = s.name;
		this.scores[0] = s.scores[0];
		this.scores[1] = s.scores[1];
		this.scores[2] = s.scores[2];
	}
	public void copy1( Student s ) {
		this.name = s.name;
		this.scores[0] = s.scores[0];
		this.scores[1] = s.scores[1];
		this.scores[2] = s.scores[2];
		System.out.println(1);
	}
}
// 아래 생성자들이 모두 실행가능하도록 생성자를 제작합니다
// 모든 생성자에서  scores 에 과목점수 정수세개를 저장할 배열을 만들고 주소를 저장하도록 코딩하세요.
// 디폴트 생성자와 이름만 전달되는 생성자에서 각 점수는 임의의 값을 대입하세요
public class Class16 {

	public static void main(String[] args) {
		Student s1 = new Student();   	
		Student s2 = new Student("홍길서");
		Student s3 = new Student("홍길남", 98,69,87);	
		Student s4 = new Student(s3);
		Student s5 = new Student();
		s5.copy1(s1);
		

	}

}
