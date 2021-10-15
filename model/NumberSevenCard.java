package model;

public class NumberSevenCard extends NumberCard {
	/**
	 * constructor
	 */
	public NumberSevenCard() {
		super(7);
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
	 * pre pass both your pawns
	 * the shared the distance
	 * @param first first pawn
	 * @param second second pawn
	 */
	public void moveBothPawns(int first,int second) {};
}
