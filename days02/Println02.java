package days02;

public class Println02 {

	public static void main(String[] args) {
		
		System.out.println("\t\t###성적표###");
		System.out.println("------------------------------------------------------------");
		System.out.println("번호\t성명\t\t국어\t영어\t수학\t총점\t평균");
		System.out.println("------------------------------------------------------------");
		System.out.println("1\t홍길동\t\t87\t98\t85\t" + (87+98+85) + "\t" + (87+98+85)/3.0 );
		System.out.println("2\t홍길동\t\t54\t54\t86\t" + (54+54+86) + "\t" + (54+54+86)/3.0 );
		System.out.println("3\t홍길동\t\t56\t58\t67\t" + (56+58+67) + "\t" + (56+58+67)/3.0 );
		System.out.print("------------------------------------------------------------\n");
		// System.out.println 으로 출력되는 실수는 소수점 조절이 되지 않습니다
		// System.out.println 으로 출력되는 수치 데이터는 소수점 정렬도 하기가 어렵습니다.
		// 단순출력은  print 로도 가능합니다.
	
	}
	
}
