package days04;

public class ControllOp_For11 {

	public static void main(String[] args) {
		
		//1부터 20사이 : 이전 숫자와 다음 숫자가 세트를 이루는 수열 출력하세요
		// (0,1,2) (1,2,3) (2,3,4).... (19,20,21)
		for( int i=1; i<=20; i++) { 
			System.out.printf("(%d,%d,%d)  ", i-1, i , i+1);
			if(i%5 == 0) System.out.println();
		}
	}
}
