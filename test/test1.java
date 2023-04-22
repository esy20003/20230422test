package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class test1 {

	public static void main(String[] args) {
		for (int i=1;i<=20;i++) {
			int test = 1;
			for (int j=1;j<=i;j++) {
				test = test * j;
			}
			System.out.println("@@@@@@@@@@@ " + test);
		}
		
		
		ArrayList a = new ArrayList();	
		// 다양한 타입을 저장할 수 있는 컬렉션 클래스의 객체
		// void add( Object obj ) {}
		a.add(10);     // Integer
		a.add(1.1);	 // Double
		a.add("Hello");   // String
		
		Map<String, Object> map = new HashMap<>();
		Map<String, Object> temp = new HashMap<>();
		map.put("best", "123");
		map.put("abc", "456");
		map.put("cwe", "789");
		map.put("dfgdfg", "6666");
		map.put("ghjghj", "9999");
		a.add(map);
		
		for (int i=0;i<a.size();i++) {
			System.out.println("@@@@@ => " + a.get(i));
			if (i > 2) {
				temp = (Map<String, Object>) a.get(i);
				System.out.println("!!!!!!!!!!!! => " + temp.get("123"));
			}
			System.out.println("############# => " + a.get(i));
		}
		
		
	}

}
