package days07;

public class Method07 {

	public static void main(String[] args) {
		
		int [] a = {50,60,80,70,20,10,60,120,64, 15};
		// a배열을 오름차순 또는 내림차순으로 정렬해서 출력하는 아래 메서드를 작성하세요
		sortAsc(a);  // 오름차순 정렬후 출력
		System.out.println();
		sortDesc(a);  // 내림차순 정렬후 출력
	}
	
	public static void sortAsc( int [] b ) {
		for(int i=0; i<b.length; i++ ) {
			for(int j=i+1; j<b.length; j++) {
				if(b[i]>b[j]) {
					int temp = b[i];  // 5,  8,  9,  4,  5,  2,  7,   
					b[i] = b[j];
					b[j] = temp;
				}
			}
		}
		for(int k : b)System.out.printf("%d ", k);
	}
	
	public static void sortDesc( int [] b ) {
		for(int i=0; i<b.length; i++ ) {
			for(int j=i+1; j<b.length; j++) {
				if(b[i]<b[j]) {
					int temp = b[i];
					b[i] = b[j];
					b[j] = temp;
				}
			}
		}
		for(int k : b)System.out.printf("%d ", k);
	}


}
