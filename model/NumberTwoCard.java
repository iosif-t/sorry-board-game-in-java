package model;

public class NumberTwoCard extends NumberCard {
	
	/**
	 * constructor
	 */
	public NumberTwoCard(){
		super(2);
		setStartingCard(true);
		setPlayAgainCard(true);
	}
	/**
	 * transformer
	 * post the card now in on the playagain list
	 */
	public void playAgain() {
		
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
