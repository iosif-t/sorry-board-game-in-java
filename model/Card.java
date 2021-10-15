package model;

public abstract class Card {
	/**
	 * Observer
	 * Post: check if a card has been used
	 * @return  true if the card has been used,false otherwise
	 */
	public abstract boolean getCardStatus();
	/**
	 * transformer
	 * pre: pass an existing and not played card and the deck
	 * post: the card is removed
	 * @param c card
	 * @param d deck
	 */
	public abstract void removeCardFromDeck(Card c,Deck d);
	/**
	 *transformer
	 * pre pass the deck and an alive pawn
 	 * post checks if the move is possible
	 * @param d deck 
	 * @param p pawn
	 * @return return true if the move is possible
	 */
	public abstract boolean movePawn(Deck d,Pawn p);
	
	/**
	 * Accessor
	 * post you have the number of the card
	 * @return return the number of the card
	 */
	public abstract int getNumber();
	
	
}
