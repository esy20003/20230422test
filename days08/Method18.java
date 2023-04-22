package days08;

import java.util.Scanner;

public class Method18 {

	public static void main(String[] args) {

		int [][] scores;
		double [] avg;
		String [] grade;
		int s = getStudentNumber(); // 학생수를 입력받아서 리턴하는 메서드
		int k = getSubjectNumber(); // 과목수를 입력받아서 리턴하는 메서드
		scores = new int[s][k+1]; // k 는 과목수이며 총점열을 위해 k + 1 만큼 지정
		avg = new double[s];// 학생수 평균
		grade = new String[s]; // 학점
		input(scores); // s 명의 학생의 k 개의 과목 점수 입력 (과목점수 입력 받을때 , 과목명은)
		cals(scores, avg, grade); // 총점 , 평균, 학점 계산
		output(scores, avg, grade); // 양식에 맞게 성적표 출력
	}
	public static void input(int [][] s) {
		Scanner sc = new Scanner(System.in);
		// s 참조변수는 main 의 scores 변수값을 받는 매개변수이므로,
		// s 이름으로 배열에 값을 넣으면 main 의 scores 배열에 값을 넣는것과 같습니다
		for(int i = 0; i < s.length; i++) {
			for(int j = 0; j < s[i].length-1; j++) {
				System.out.printf("%d 번 학생의 %d 과목 점수 : ", i+1, j+1);
				s[i][j] = Integer.parseInt(sc.nextLine() );
				System.out.println(s[i][j]);
			}
		}
	}
	// 선생님화면
	public static void cals(int [][] s, double [] a, String [] g) {
		String [] grade = {"F","F","F","F","F","F","D","C","B","A","A"};
		for(int i = 0; i < s.length; i++) { // 학생의 인원 수 만큼 반복실행
			int k = s[i].length-1;
			// s[i].length : i 행의 열 갯수, 마지막 열의 첨자 s[i].length-1
			for(int j = 0; j < k; j++) { // 입력받은 과목수 만큼 반복실행
				s[i][ k ] += s[i][j]; // 첫번째 열부터 마지막열의 바로전 칸까지의 값을 마지막칸에 합산
			} // 총점계산
			a[i] = s[i][k] / (s[i].length-1); // or (double) k; //평균계산  //s[i].length;
			//System.out.println(s[i].length); // 기본3 length-1은 2인데 평균을 계산할떄는 왜 안듣지? ***** 왜 안나눠지는지 ****** s[i].length-1을 해도 결과가 이상하다 // 0316추가 s[i]는 학생 수였나...? k 가 평균을 담았으니.. i 는 학생일거고
			// 연산의 우선순위 떄문에  s[i][k] / s[i].length << 먼저계산 이후 -1 
			g[i] = grade[(int)(a[i] / 10)]; // 학점 선택
		}
		// 반드시 엑셀에 학생수 행 과목수 + 1 열만큼 배열을 그려놓고 시뮬레이션 해보기
	}
	public static void output(int [][] s, double [] a, String [] g) {
		System.out.println("\t\t   ###성적표###");
		System.out.println("----------------------------------------------------------");
		System.out.printf("번호\t");
		for(int i = 0; i < s[0].length-1; i++) { // 과목수 만큼 과목의 이름 "1과목"  "2과목" "3과목" ... 출력
			System.out.printf("%d과목\t", i+1);
		}
		System.out.printf("총점\t평균\t학점\n");
		System.out.println("----------------------------------------------------------");
		for(int i = 0; i < s.length; i++) {
			System.out.printf("%d\t", i+1); // 번호출력
			for(int j = 0; j < s[i].length; j++) {
				System.out.printf("%d\t", s[i][j]); // 1과목부터 모든 과목점수와 총점까지 출력
			}
			System.out.printf("%.1f\t", a[i]);
			System.out.printf("%s\n", g[i]);
		}
		System.out.println("----------------------------------------------------");
	}
	public static int getStudentNumber() {
		Scanner sc = new Scanner(System.in);
		System.out.print("학생이 몇명인가요? : ");
		return sc.nextInt();
	}
	public static int getSubjectNumber() {
		Scanner sc = new Scanner(System.in);
		System.out.print("과목이 몇개인가요? : ");
		return sc.nextInt();
	}

}








