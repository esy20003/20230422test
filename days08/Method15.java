package days08;

// 메서드 오버로딩(Overloading)
// 메서드의 이름은 같고, 매개변수의 타입, 개수, 순서가 다르면 서로 다른 메소드로 인지하는 문법
// 일관된 메서드 이름을 사용하여 사용자에게 직관적인 이름을 사용하게 합니다
// 전달인수(매개변수)의 자료형, 순서 등이 서로 달라도 가능


public class Method15 {

	public static void main(String[] args) {
		int maxValue = max(56,87,23);
		System.out.println("56,87,23 중 가장 큰 값은 " + maxValue + "입니다");
		maxValue = max(89,78,56,36);
		System.out.println("89,78,56,36 중 가장큰값은 " + maxValue + "입니다");
		
		maxValue = max(56,87);
		System.out.println("56,87 중 가장큰값은 " + maxValue + "입니다");
		
		double maxValueD = max(123.45, 456.56);
		System.out.println("123.45, 456.56 중 가장큰값은 " + maxValueD + "입니다");
		
	}
	
	public static int max(int n1, int n2) {
		int maxValue = (n1>n2)?n1:n2;
		return maxValue;
	}
	public static double max( double d1, double d2) {
		double maxValue = (d1>d2)?d1:d2;
		return maxValue;
	}
	
	
	public static int max(int n1, int n2, int n3, int n4) {
		int max1, max2, max3;
		max1 = (n1>n2)? n1:n2;
		max2 = (n3>n4)? n3:n4;
		max3 = (max1>max2)?max1:max2;
		return max3;
	}
	
	public static int max( int n1, int n2, int n3) {
		int max = (n1>n2)? n1 : n2;
		if(max<n3)max = n3;
		return max;
	}
	
}
