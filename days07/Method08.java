package days07;

import java.util.Scanner;

public class Method08 {

	public static void main(String[] args) {
		int [] a = {56, 54, 87, 89, 25, 36, 57, 98};
		Scanner sc = new Scanner(System.in);
		System.out.print("메뉴를 \n 선택하세요(합계 :1, 평균:2, 오름차순정렬:3, 내림차순정렬:4) : ");
		int input = sc.nextInt();
		switch(input) {
		case 1 : sum(a); break;
		case 2 : avg(a); break;
		case 3 : sort1(1, a); break;
		case 4 : sort2(2, a); break;
		}
	}
	
	
	public static void sum(int [] a) {
		int tot = 0;
		for(int sum : a) {
			tot = tot + sum;
		}
		System.out.printf("합계 "+tot);
	}
	public static void avg(int [] b) {
		int tot = 0;
		double avg = 0;
		for(int sum : b) { // sum 은 b[i]와 같다
			tot = tot + sum;
			avg = tot / b.length;
		}
		System.out.printf("합계 "+tot);
		System.out.printf("평균 "+avg);
	}
	public static void sort1(int i, int [] a) {
		for(i = 0; i < a.length; i++) {
			//System.out.print(a[i]);
			for(int j = i+1; j < a.length; j++) {
				//System.out.print(a[j]);
				if(a[i] < a[j]) {
					// a[i] -> 첫번째 54
					// a[j] -> 첫번째 87
					int temp = a[i]; // temp 는 54
					//System.out.print(a[j]);
					a[i] = a[j]; // a[i] 는 54 a[j] 는 87
					a[j] = temp;
				}
			}
		}
		// int [] a = {56, 54, 87, 89, 25, 36, 57, 98};
		for(int k : a) System.out.printf("%d ", k);
	}
	public static void sort2(int i, int [] b) {
		for(i = 0; i < b.length; i++) {
			for(int j = i+1; j < b.length; j++) {
				if(b[i] > b[j]) {
					int temp = b[i];
					b[i] = b[j];
					b[j] = temp;
				}
			}
		}
		// int [] a = {56, 54, 87, 89, 25, 36, 57, 98};
		for(int k : b) System.out.printf("%d ", k);
	}


}
