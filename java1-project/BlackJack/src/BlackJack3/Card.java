package BlackJack3;

public class Card {
	String suit, rank;
	
	public Card(String suit, String rank) {
		this.suit = suit;
		this.rank = rank;
	}
	
	public String getSuit() {
		return suit;
	}

	public String getRank() {
		return rank;
	}
	
	public String printCard() {
		suit = getSuit();
		rank = getRank();

		return String.format("%-4s", rank + suit+ "  ");
	}
}