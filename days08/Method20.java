package days08;

import java.util.Scanner;

public class Method20 {

	public static void main(String[] args) {
		int [][] scores;
		double [] avg;
		String [] grade; 
		Scanner sc = new Scanner(System.in);
		scores = memoryAllocation1(sc);  // 학생수 과목수 입력 받은 후 2차원 배열 생성해서 참조값 리턴
		avg = memoryAllocation2( scores.length );  // 전달한 학생수만큼 크기의 배열 생성후 참조값 리턴
		grade = memoryAllocation3( scores.length );  // 전달한 학생수만큼 크기의 배열 생성후 참조값 리턴
		input( scores ); 
		cals( scores, avg, grade ); 
		output( scores, avg, grade );			
	}	
	public static int[][] memoryAllocation1(Scanner sc) {
		System.out.print("학생수 : ");
		int s = sc.nextInt();
		System.out.print("과목수 : ");
		int k = sc.nextInt();
		int [][] score = new int[s][k+1]; //s = 학생수 , k = 과목수 ,총점저장을 위해 k + 1
		return score;
	}
	public static double[] memoryAllocation2(int length) {
		double [] a = new double[length];
		return a;
	}
	public static String[] memoryAllocation3(int length) {
		String [] g = new String[length];
		return g;
	}

	public static void cals(int[][] s, double[] a, String[] g) {	
		String [] grade = {"F","F","F","F","F","F","D","C","B","A","A",}; 
		for(int i=0; i < s.length; i++ ) { 
			int k = s[i].length-1; 
			System.err.println(k);
			for( int j=0; j< k ; j++) s[i][ k ] += s[i][j]; 
			a[i] = s[i][k] / (double) k; // a[i]번쨰 학생의 = 평균, s[i] = i번째 학생 [k] = 총점 / k = 과목수 
			g[i] = grade[ (int)(a[i] / 10) ]; 
		}		
	}
	public static void output(int[][] s, double[] a, String[] g) {
		System.out.println("\t\t  ###성적표###");
		System.out.println("------------------------------------------------------------");
		System.out.printf("번호\t");
		for(int i=0; i < s[0].length-1; i++) // 과목수 만큼 과목의 이름 "1과목  2과목 3과목 ..." 출력
			System.out.printf("%d과목\t", i+1);
		System.out.printf("총점\t평균\t학점\n");
		System.out.println("------------------------------------------------------------");
		
		for(int i=0; i < s.length; i++) {
			System.out.printf("%d\t", i+1);  // 번호출력
			for(int j=0; j<s[i].length; j++) 
				System.out.printf("%d\t", s[i][j]);  // 1과목부터 모든과목점수와 총점까지 출력
			System.out.printf("%.1f\t", a[i]);
			System.out.printf("%s\n", g[i]);
		}
		System.out.println("------------------------------------------------------------");
	}
	public static void input( int [][] s ) {
		// s 참조변수는 main의  scores 변수값을 받는 매개변수이므로,
		// s 이름으로 배열에 값을 넣으면 main 의 scores 배열에 값이 넣는것과 같습니다
		Scanner sc = new Scanner(System.in);
		for(int i=0; i < s.length; i++) {
			for(int j=0; j < s[i].length-1; j++) {
				System.out.printf("%d번 학생의 %d과목 점수 :  ", i+1, j+1);
				s[i][j] = Integer.parseInt( sc.nextLine()  );
			}
		}
	}
	

}
