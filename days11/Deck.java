package days11;


public class Deck {
	
	private int [] scores;
	
	private Card [] cards = new Card[52];
	// cards[0] = new Card(Card.spade, 1);
	// cards[51] = new Card(Card.clover, 13);
	
	Deck() {
		int cardIndex=0;
		for(int kind=4; kind>=1; kind--) {
			for(int number=1; number<=13; number++) {
				cards[ cardIndex ] = new Card( kind , number);
				cardIndex++;
			}
		}
	}

	public Card pick(int i) {
		return cards[i];   // 전달된 i값에 의해 i번째 카드가 리턴
	}

	public void shuffle() {
		for(int i=0; i<cards.length; i++) {
			// 반복이 실행되는 동안 i번째 카드와   random 번째카드의 자리를 서로 맞바꿉니다
			int r = (int)(Math.random()*52);
			Card temp = cards[i];
			cards[i] = cards[r];
			cards[r] = temp;
		}
	}
}










