package model;

public class NumberFourCard extends NumberCard {
	/**
	 * constructor
	 */
	public NumberFourCard() {
		super(-4);
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
