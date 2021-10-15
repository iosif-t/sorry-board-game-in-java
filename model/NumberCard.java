package model;

public class NumberCard extends Card {
	private int number;
	private boolean played,movingBackwards,startingCard,playAgaincard,tradeAbleCard;
	/**
	 * Constructor
	 * @param number number of card
	 */
	
	public NumberCard(int number) {
		this.number=number;
	}
	/**
	 * pre if you played a card pass true
	 * post the card now is in the not available list
	 * @param played boolean true if played
	 */
	public void cardPlayed(boolean played) {
		this.played = played;
	}
	/**
	 * observer 
	 * post now you know if the card is available
	 */
	public boolean getCardStatus() {
		return this.played;
	}
	/**
	 * accessor
	 * post now you have the number of the card
	 */
	public int getNumber() {
		return this.number;
	}
	
	
	/**
	 * pre if the number is 1 or 2 set true
	 * post the starting cards have been set
	 * @param p true if the card is starting one
	 */
	public void setStartingCard(boolean p) {
		this.startingCard=p;
	}
	/**
	 * observer
	 * post now you now if the card is a starting one
	 * @return true if starting card
	 */
	public boolean isStartingCard() {
		return this.startingCard;
	}
	/**
	 * pre if you have the option to play again with a certain card pass true
	 * post now the playagain cards have been set
	 * @param p true if playe again card
	 */
	public void setPlayAgainCard(boolean p) {
		this.playAgaincard=p;
	}
	/**
	 * observer
	 * post now you now if the card gives you the play again option
	 * @return true if play again card
	 */
	public boolean playAgainCard() {
		return this.playAgaincard;
		
	}
	
	/**
	 * pre set true if theres a backward option
	 * post now its set
	 * @param p boolean
	 */
	public void setBackwardsChoice(boolean p) {
		this.movingBackwards=p;
	}
	
	/**
	 * observer 
	 * post now you now if you can move backwards
	 * @return true if movingBack card
	 */
	public boolean isMoveableBackwards() {
		return this.movingBackwards;
	}
	
	/**
	 * pre if theres an option to trade pawns with this card set true
	 * post now its set
	 * @param p boolean
	 */
	public void setTradeCard(boolean p) {
		this.tradeAbleCard=p;
	}
	/**
	 * observer
	 * post now you know if you have the trade option
	 * @return true if trade card
	 */
	public boolean isTradeAbleCard() {
		return this.tradeAbleCard;
	}
	/**
	 * transformer
	 * pre pass a not discarded card and the deck
	 * post now the card have been discarded
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
