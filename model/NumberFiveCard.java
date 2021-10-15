package model;

public class NumberFiveCard extends SimpleNumberCard {
	/**
	 * constructor
	 */
	public NumberFiveCard() {
		super(5);
		setStartingCard(false);
	}
	
	/**
	 * observer
	 * pre pass an alive pawn and the deck
	 * post you now if the move is possible with that pawn
	 * @return if possible
	 */
	public boolean movePawn(Deck d,Pawn p) {
		return true;
	}

}
