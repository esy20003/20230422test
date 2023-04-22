package days11;



public class PlayingGame {

	public static void main(String[] args) {
		
		/*
		Card c1 = new Card( 3 , 3 );
		Card c2 = new Card();
		String s1 = c1.toString();
		String s2 = c2.toString();
		System.out.println(s1);
		System.out.println(s2);
		*/
		
		Deck deck = new Deck();  // 52장의 카드가 deck 에 생성됩니다
		deck.shuffle();
		/*
		Card c1 = deck.pick(0);
		Card c2 = deck.pick(1);
		Card c3 = deck.pick(50);
		Card c4 = deck.pick(51);
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		System.out.println(c3.toString());
		System.out.println(c4.toString());
		
		deck.shuffle();
		System.out.println();
		c1 = deck.pick(0);
		c2 = deck.pick(1);
		c3 = deck.pick(50);
		c4 = deck.pick(51);
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		System.out.println(c3.toString());
		System.out.println(c4.toString());
		*/
		
		Card [] player1 = new Card[5];
		Card [] player2 = new Card[5];
		Card [] player3 = new Card[5];
		Card [] player4 = new Card[5];
		
		// 1명당 5장씩 분배하고 한명당 1줄에 보유카드를 한번에 출력해서 네줄을 출력해주세요
		// player1[0] = deck.pick(0);

		int cardIndex = 0;  // 순서데로 카드를 꺼내기위한 변수
		for(int i=0; i<5; i++ ) { // 반복실행 1회당 4명에게 1장씩 카드 배부
			player1[i] = deck.pick( cardIndex++ );
			player2[i] = deck.pick( cardIndex++ );
			player3[i] = deck.pick( cardIndex++ );
			player4[i] = deck.pick( cardIndex++ );			
		}
		for(int i=0; i<5; i++) System.out.printf("%s ", player1[i]);
		System.out.println();
		for(int i=0; i<5; i++) System.out.printf("%s ", player2[i]);
		System.out.println();
		for(int i=0; i<5; i++) System.out.printf("%s ", player3[i]);
		System.out.println();
		for(int i=0; i<5; i++) System.out.printf("%s ", player4[i]);
		System.out.println();
		
		// -------------------------------------------------------------------------------------
		
		Card c1 = new Card(Card.diamond , 13);
		System.out.println( c1.toString() );
		Card c2 = new Card();
		System.out.println( c2.toString() );
		
		// toString() 메서드를 정의하고 포함한 클래스. 
		// 그 클래스형태데로 만든 객체는  System.out.println() 으로 참조변수를 출력했을때 
		// "패키지이름.클래스이름@해시코드" 가 출력되는것이 아니라
		// toString() 메서드가 리턴해주는 String 값이 출력됩니다.
		System.out.println( c1 );   //  c1 뒤에  .toString() 이 생략된 형태라고 할수 있습니다.
		System.out.println( c2 );
		
		// 이것은 참조변수 단독으로 사용되기 보단 다른연산에 참조변수가 참여하고 있을때 적용되는 규칙입니다
		String result = "카드 1 : " + c1;
		System.out.println( result );
		result = "카드 2 : " + c2;
		System.out.println( result );
	}

}











