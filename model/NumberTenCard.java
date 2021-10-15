package model;

public class NumberTenCard extends NumberCard {
	/**
	 * constructor
	 */
	public NumberTenCard() {
		super(10);
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
	/**
	 * transformer
	 * post the pawn now moved back
	 */
	public void moveBackWards() {};
	

}
