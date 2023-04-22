package days08;

import java.util.Scanner;

public class Method08 {

	public static void main(String[] args) {
		
		int [] a = {56,54,87,89,25,36,57,98};
		Scanner sc = new Scanner(System.in);
		
		System.out.print("메뉴를 선택하세요\n(합계:1, 평균:2, 오름차순정렬:3, 내림차순정렬:4) : ");
		int input = sc.nextInt();
		switch(input) {
			case 1 : sum(a); break;
			case 2 : avg(a); break;
			case 3 : sort(1, a); break;
			case 4 : sort(2, a); break;
		}
	}
	
	public static void sum(int [] b) {
		int tot = 0;
		for( int i=0; i<b.length; i++)
			tot += b[i];
		System.out.println("배열의 합계 : " + tot);
	}
	
	public static void avg(int [] c) {
		// sum(c);
		int tot = 0;
		for( int i=0; i<c.length; i++)
			tot += c[i];
		double ave = tot / (double)c.length;
		System.out.println("배열의 평균 : " + (int)(ave*100)/100.0);
	}
	
	public static void sort( int val, int [] d) {
		if( val == 1) {
			for(int i=0; i<d.length; i++) {
				for(int j=i+1; j<d.length; j++) {
					if(d[i]>d[j]) {
						int temp = d[i];
						d[i] = d[j];
						d[j] = temp;
					}
				}
			}
		}else {
			for(int i=0; i<d.length; i++) {
				for(int j=i+1; j<d.length; j++) {
					if(d[i]<d[j]) {
						int temp = d[i];
						d[i] = d[j];
						d[j] = temp;
					}
				}
			}
		}
		for( int k : d)
			System.out.printf("%d ", k);
		System.out.println();
	}

}





