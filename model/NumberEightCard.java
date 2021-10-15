package model;

public class NumberEightCard extends SimpleNumberCard {
	/**
	 * constructor
	 */
	public NumberEightCard() {
		super(8);
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
