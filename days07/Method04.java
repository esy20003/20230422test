package days07;

public class Method04 {

	public static void main(String[] args) {
		
		// prnTitle() : 성적표 제목, 번호 이름 국어 영어 등과 같은 열제목을 출력하는 메서드
		// prnScore() : 이름, 국어, 영어, 수학 를 전달받아서 총점 평균을 계산하고 성적점수들을 출력하는 메서드
		prnTitlePre();  // 성적표 제목 및 열제목(번호 이름 국어 영어 ....) 출력 
		prnScore(1,"홍길동", 87, 89, 97);
		prnScore(2,"홍길서", 45, 98, 78);
		prnScore(3,"홍길남", 77, 88, 99);
		prnTitlePost();  // 성적표 마지막에 그어지는 선
	}
	
	public static void prnTitlePre() {
		System.out.println("\t\t  ###성적표###");
		System.out.println("-----------------------------------------------------");
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println("-----------------------------------------------------");
	}
	public static void prnScore(int bunho, String name, int kor, int eng, int mat) {
		int tot = kor+eng+mat;
		double avg = tot/3.0;
		System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\t%.1f\n", bunho, name, kor, eng, mat, tot, avg);
	}
	public static void prnTitlePost() {
		System.out.println("-----------------------------------------------------");
	}

}
