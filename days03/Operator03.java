package days03;

public class Operator03 {

	public static void main(String[] args) {
		
		// 관계연산자(비교연산자)
		// 좌항기준 >(초과), <(미만), >=(이상≥), <=(이하≤), ==(같다), !=(같지않다)
		// 좌항과 우항의 크기를 비교하여 true/false 값이 결과가 되는 연산
		// 관계식이 올바른 경우 true, 관계식이 틀린 경우 false 가 연산의 결과가 됩니다
		// n++  -> 단항연산         n1 < n2 ->  이항연산
		int n1 = 10;
		int n2 = 5;
		boolean result;
		result = n1 > n2;
		// n1 변수의 값이 n2 변수의 값보다 크면 true, 작으면 false 값이 저장
		System.out.printf("%d > %d  -> %b\n", n1, n2, result);
		result = n1 < n2;
		System.out.printf("%d < %d -> %b\n", n1, n2, result);
		result = n1 >= n2;
		System.out.printf("%d >= %d -> %b\n", n1, n2, result);
		result = n1 <= n2;
		System.out.printf("%d <= %d -> %b\n", n1, n2, result);
		result = n1 == n2;
		System.out.printf("%d == %d -> %b\n", n1, n2, result);
		result = n1 != n2;
		System.out.printf("%d != %d -> %b\n", n1, n2, result);
		System.out.println();
		// 문자(char) 데이터의 비교 : 각 데이터가 갖는 아스키(ASCII)코드값으로 비교
		char c1='A', c2='B';
		result = c1>c2;
		System.out.printf("%c > %c -> %b\n", c1, c2, result);
		result = c1<c2;
		System.out.printf("%c < %c -> %b\n", c1, c2, result);
		result = 'C' == 'C';
		System.out.printf("%c == %c -> %b\n", 'C', 'C', result);
		result = 'C' != 'C';
		System.out.printf("%c != %c -> %b\n", 'C', 'C', result);
		// String 데이터의 비교
		String s1 = "1234";
		String s2 = "987";
		// result = s1 > s2; 에러
		// result = s1 == s2;  // 동작에는 에러가 없지만 글자들의 비교가 일어나지 않습니다
		// result = s1 != s2;  // 동작에는 에러가 없지만 글자들의 비교가 일어나지 않습니다
		int r = s1.compareTo(s2);
		System.out.printf("%s > %s => %d\n", s1, s2, r);	
		result = s1.equals(s2); // 둘이 같으면 true, 다르면  false
		System.out.printf("%s == %s => %b\n", s1, s2, result);	
		s2 = "1234";
		result = s1.equals("1234");
		System.out.printf("%s == %s => %b\n",  s1, s2, result);
		
		// String 을 대상으로 할수 있는 비교연산은 == 와 != 둘밖에 없으며, 이마저도 우리가 원하는 결과로 연산되지 않습니다
		// 그래서 == 와 != 연산이 에러없이 가능은 하지만 이도 사용은 하지 않습니다
					
		// s1 과 s2 는 String 자료형이며, 다른 기본 자료형과 다르게 이 두변수가 직접 문자들을 저장하고 있지 않습니다.
		// 문자들은 별도의 장소에 저장되고, 변수는 저장위치값만 저장하고 있습니다
		// 따라서 변수들간의 비교(s1>s2) 는 저장위치정보의 비교이므로 연산이 의미가 있지도 않고  가능하지도 않습니다
				
		// String 자료간의 비교는 별도로 만들어져 있는 도구를 이용합니다.
		// String 의 크다 작다를 판단해주는 compareTo()
		// String 의 같다 다르다를 판단해주는  equals()
		
		// compareTo 를 사용한 결과는 앞선항의 글자에서 뒷항의 글자를 뺀결과가 정수형태로 나오는 형태입니다.
		// 앞글자가 크면 양수, 뒷글자가 크면 음수의 값이 두 글자의 아스키코드의 차값으로 계산됩니다.
		// 두String이 모두 같으면 결과는 0입니다
		
	}

}












