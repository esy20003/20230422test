package days06;

public class Array08 {

	public static void main(String[] args) {
		
		int[] a = new int[6];
		// 다섯세트가 출력되도록 프로그램을 변경해주세요
		
		// 1~45 사이의 임의의 난수를  a 배열에 여섯개 저장한 후,
		// 오름차순으로 정렬해서 출력하세요.
		for( int k=1; k<=5; k++) {
			
				for( int i=0; i<6; i++) {
					a[i] = (int)(Math.random()*45)+1;
					int count = 0;
					for(int j=0; j<i; j++) {
						if(a[j]==a[i])count++; // 중복 걸러내기
					}
					if(count > 0) i--; // 중복이 0보다 크면 i , 숫자에서 빼겠다
				}
				
				for(int i=0; i<a.length; i++) {
					for(int j=i+1; j<a.length; j++) {
						System.out.printf("%d", j);
						if(a[i]>a[j]) {
							int temp = a[i];
							a[i] =a[j];
							a[j] =temp;
						}
					}
				}
				for(int i=0; i<a.length; i++)
					System.out.printf("%2d ", a[i]);
				System.out.println();
				
		}

	}

}
