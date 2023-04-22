package days13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// ArrayList나 Vector 와 비슷하지만 운영방식이 다른 LinkedList 라는 리스트가 있지만, 거의 사용하지 않으므로 생략

// - Set(HashSet) 클래스
//	데이터의 중복을 허용하지 않고 저장하는 클래스
//	- 검색을 위해서 사용되는 클래스
//			(저장할때 hash 연산의 결과로 저장하니, 검색할때도 hash 연산 결과로 검색하여 빠른 검색이 가능)
// - hash 연산 : 클래스 내에서 유일 한값을 얻어 낼수 있는 고유 알고리즘연산
//	- 중복된 값을 제거하면서 데이터를 저장하기 위해 사용

public class Collection03 {

	public static void main(String[] args) {
		
		ArrayList<Integer> a = new ArrayList<>();
		a.add(1);	a.add(2);	a.add(2);
		System.out.println("ArrayList 자료 갯수 : " + a.size()); // 중복을 허용하기 때문에 3이 반환

		HashSet<Integer> h = new HashSet<>();
		h.add(1);	h.add(2);	h.add(2); 
		System.out.println("HashSet 자료 갯수 : " + h.size()); // 중복을 허용하기 않기 때문에 2이 반환
		
		System.out.println("\nArrayList : ");
		for(Integer k : a) System.out.printf("%d ", k);
		System.out.println("\nHashSet : ");
		for(Integer k : h) System.out.printf("%d ", k);
		System.out.println("\n\n");
		
		// 로또 번호 발생기
		HashSet<Integer> lotto = new HashSet<>();
		while( lotto.size() <6 ) 
			lotto.add(  (int)(Math.random()*45 + 1 ) );
		for( Integer k : lotto ) 	System.out.printf("%d  ", k);
		System.out.println();
		

		// 해쉬세트에는 정렬메서드가 없습니다. 
		// 따라서 링크드 리스트의 부모클래스인 List 클래스에 전해주고 리스트로 변환해서 , 
		// Collections의 스태틱 메서드로 정렬합니다
		List<Integer> list = new LinkedList( lotto );
		Collections.sort( list );
		System.out.println( list );  // 한번에 출력		
		for( Integer k : list ) 	System.out.printf("%d  ", k);
		System.out.println();
		
		// 리스트 또는 해쉬세트의 내부 값들을 순회하는 방법
		// 1. iterator 를 이용하는 방법
		// 		- Iterator 객체는 컬렉션 내부의 데이터를  순회할 수 있는 객체
		Iterator<Integer> iter1 = lotto.iterator();
		Iterator<Integer> iter2 = list.iterator();
		// lotto 및 list 에 값들에 접근할 수 있는 권한을 Iterator 객체에 저장합니다
		
		System.out.println("\niter1 로 lotto(HashSet) 방문 출력 : ");
		while( iter1.hasNext()  )    // .hasNext():방문할 다음데이터가 있다면 true 없다면 false
			System.out.printf("%d  ", iter1.next() );
		// 최초에 데이터들의 맨앞쪽을 가리키고 있다가 iter1.next() 에 의해 첫번째 데어터부터 방문하게 됩니다.
		System.out.println("\niter2 로 list(List)  방문 출력 : ");
		while( iter2.hasNext() )  
			System.out.printf("%d  ", iter2.next() );
			
		
		
		
	}

}







