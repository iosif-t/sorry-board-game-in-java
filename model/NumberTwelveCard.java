package model;

public class NumberTwelveCard extends SimpleNumberCard {
	/**
	 * constructor
	 */
	public NumberTwelveCard() {
		super(12);
		setStartingCard(false);
	}
	/**
	 * observer
	 * pre pass an alive pawn and the deck
	 * post you now if the move is possible with that pawn
	 */
	public boolean movePawn(Deck d,Pawn p) {
		return true;
	}

}
