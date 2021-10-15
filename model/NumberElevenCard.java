package model;

public class NumberElevenCard extends NumberCard {
	/**
	 * constructor
	 */
	public NumberElevenCard() {
		super(11);
		setStartingCard(false);
	}
	/**
	 * observer
	 * pre pass an alive pawn and the deck
	 * post you now if the move is possible with that pawn
	 */
	public boolean movePawn(Deck d,Pawn p) {return true;}
	
	/**
	 * transformer
	 * pre pass two alive pawns 
	 * post they trade positions
	 * @param p1 first pawn
	 * @param p2 second pawn
	 */
	public void ChangePosition(Pawn p1,Pawn p2) {
	}
	
}
