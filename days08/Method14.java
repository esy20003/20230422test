package days08;

public class Method14 {

	public static void main(String[] args) {
		
		int [] a = {65,87,89,12,45,36,57,45};
		int tot = sum(a);
		double avg = average(a);
		prn(a, tot, avg); // 배열안의 숫자들 출력후 합계 평균 출력
	}
	
	public static int sum( int [] b ) {
		int tot = 0;
		for(int i=0; i<b.length; i++)
			tot += b[i];
		return tot;
	}
	
	public static double average( int [] c) {
		//int tot = 0;
		//for(int i=0; i<c.length; i++)	tot += c[i];
		int tot = sum( c );
		return tot/(double)c.length;
	}
	
	public static void prn( int [] d, int t, double a) {
		System.out.print("배열의 요소 : ");
		for(int k : d) System.out.printf("%d ", k);
		System.out.println();
		System.out.printf("합계 : %d, 평균 : %.1f\n", t, a);
	}

}






