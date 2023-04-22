package days08;

import java.util.Scanner;

public class Method19 {

	public static void main(String[] args) {
		
		// 리턴 값으로 사용되는 참조변수, 참조값
		
		/*
		int [][] scores;
		int s = getStudentNumber();
		int k = getSubjectNumber();
		scores = new int[s][k+1];
		// 2차원배열의 공간할당
		*/
		
		/*
		int s = getStudentNumber();
		int [] kor = new int[s];
		int [] eng = new int[s];
		int [] mat = new int[s];
		// 1차원 배열의 공간할당
		*/
		
		Scanner sc = new Scanner(System.in);
		
		int [] kor = memoryAllocation( sc );
			
		for(int k : kor)
			System.out.printf("%d ", k);
	}

	// 리턴값이 참조값이 되는 메서드
	public static int[] memoryAllocation( Scanner sc ) {
		
		
		System.out.print("학생수 입력 : ");
		int s = sc.nextInt();
		int [] m = new int[s]; // 입력받은 학생수 만큼 1차원 배열이 만들어집니다
		m[0] = 90;
		m[1] = 80;
		m[2] = 70;
		return m;
	}
	
	
}







