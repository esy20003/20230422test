package days06;

public class Array06 {

	public static void main(String[] args) {
		
		// 배열에 있는 값들중 최대값과 최소값을 찾아서 출력하세요

		int [] a = {56, 87, 96, 87, 45, 89, 69, 36, 13, 98, 100, 12};

		int max = a[0];
		
		for(int i=1; i<a.length; i++) {
			if( max < a[i] ) max = a[i];
		}
		
		System.out.println("가장 큰값 : " + max);
		
		int min = a[0];
		for(int i=1; i<a.length; i++) {
			if( min > a[i] ) min = a[i];
		}
		
		System.out.println("가장 작은 값 : " + min);
	}

}





