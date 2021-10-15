package model;

public class SorryCard extends Card {
	private int number;
	/**
	 * constructor
	 */
	public SorryCard(){
		this.number=0;
	}
	/**
	 * accessor
	 * post you now that this is the sorry card
	 */
	public int getNumber() {
		return this.number;
	}
	/**
	 * observer
	 * post checks if the card have been played
	 */
	public boolean getCardStatus() {
		return false;
	}
	
	/**
	 * transformer
	 * pre pass a friendly and and an enemy pawn 
	 * post now the changed positions
	 * @param p1 friendly pawn
	 * @param p2 enemy pawn
	 */
	public void tradePawns(Pawn p1,Pawn p2) {
		
	}

	/**
	 * transformer
	 * pre pass an alive card and the deck
	 * post the card have been discarded
	 */
	public void removeCardFromDeck(Card c,Deck d) {
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
