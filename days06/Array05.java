package days06;

import java.util.Scanner;

public class Array05 {

	public static void main(String [] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("성적표에 출력될 학생이 몇명인가요? ");
		int stdNum = Integer.parseInt( sc.nextLine() );
		
		int [] kor = new int[ stdNum ];   // 국어점수들 저장용 배열
		int [] eng = new int[ stdNum ]; // 영어 점수용
		int [] mat = new int[ stdNum ]; // 수학점수용
		int [] tot  = new int[ stdNum ]; // 총점 용
		double [] avg = new double[ stdNum ];   // 평균용
		String [] name = new String[ stdNum ]; // 학생 이름용
		// 세명의 학생의 세과목 점수를 입력받고 총점 평균을 계산해서 성적표를 출력하세요
		// 반복실행문을 이용합니다.
		
		for(int i=0; i < kor.length; i++) {
			System.out.printf("%d번학생의 이름입력 : ", i+1);
			name[i] = sc.nextLine();			
			System.out.printf("%d번학생의 국어점수입력 : ", i+1);
			//String k = sc.nextLine();
			//kor[i] = Integer.parseInt(k);
			kor[i] = Integer.parseInt( sc.nextLine() );
			System.out.printf("%d번학생의 영어점수입력 : ", i+1);
			eng[i] = Integer.parseInt( sc.nextLine() );
			System.out.printf("%d번학생의 수학점수입력 : ", i+1);
			mat[i] = Integer.parseInt( sc.nextLine() );
			// sc.nextLine();
		}
		
		for(int i=0; i < stdNum; i++) {
			tot[i] = kor[i] + eng[i] + mat[i];
			avg[i] = tot[i] / 3.0;
		}
		
		System.out.println("\t\t  ###성적표###");
		System.out.println("-------------------------------------------------------");
		System.out.println("번호\t이름\t\t국어\t영어\t수학\t총점\t평균");
		System.out.println("-------------------------------------------------------");
		for(int i=0; i < avg.length; i++) {
			System.out.printf("%d\t%s\t\t%d\t%d\t%d\t%d\t%.1f\n", i+1, name[i], kor[i], eng[i], mat[i], tot[i], avg[i] );
		}
		System.out.println("-------------------------------------------------------");
	}
}











