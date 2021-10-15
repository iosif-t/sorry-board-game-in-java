package model;

public class NumberOneCard extends NumberCard {
	/**
	 * constructor
	 */
	public NumberOneCard() {
		super(1);
		setStartingCard(true);
	}
	/**
	 * @param d deck
	 * @param p pawn
	 * observer
	 * pre pass an alive pawn and the deck
	 * post you now if the move is possible with that pawn
	 * @return if possible
	 */
	public boolean movePawn(Deck d,Pawn p) {
		return true;
	}
}
