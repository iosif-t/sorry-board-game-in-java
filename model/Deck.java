package model;

import java.util.ArrayList;
import java.util.Random;

import view.View;

public class Deck {
	private Player p1,p2;
	private Card[] cards;
	private Square[] table;
	private boolean fold;
	
	/**
	 * constructor
	 * pre pass two names and two colors
	 * post the players have been initialized
	 * @param firstName name for first player
	 * @param firstColor color for first player
	 * @param secondName name for second player
	 * @param secondColor color for second player
	 */
	public Deck(int s1,int s2,int s3,int s4) {
		this.cards= new Card[44];
		this.table = new Square[73];
		
		this.p1 = new Player("Name1","yellow",s1,s2);
		this.p2 = new Player("Name2","red",s3,s4);
		
	}
	/**
	 * setter
	 * @param i an integer
	 */
	public void setPositionOfPlayer1Pawn1(int i) {
		p1.getFirstPawn().setPosition(i);
	}
	/**
	 * setter
	 * @param i an integer
	 */
	public void setPositionOfPlayer1Pawn2(int i) {
		p1.getSecondPawn().setPosition(i);
	}
	/**
	 * setter
	 * @param i an integer
	 */
	public void setPositionOfPlayer2Pawn1(int i) {
		p2.getFirstPawn().setPosition(i);
	}
	/**
	 * setter
	 * @param i an integer
	 */
	public void setPositionOfPlayer2Pawn2(int i) {
		p2.getSecondPawn().setPosition(i);
	}
	/**
	 * observer
	 * now we know the position of the 1 pawn
	 * @return position of the pawn
	 */
	public int getPositionOfPlayer1Pawn1() {
		return p1.getFirstPawn().getPosition();
	}
	/**
	 * observer
	 * now we know the position of the 2 pawn
	 * @return position of the pawn
	 */
	public int getPositionOfPlayer1Pawn2() {
		return p1.getSecondPawn().getPosition();
	}
	/**
	 * observer
	 * now we know the position of the 3 pawn
	 * @return position of the pawn
	 */
	public int getPositionOfPlayer2Pawn1() {
		return p2.getFirstPawn().getPosition();
	}
	/**
	 * observer
	 * now we know the position of the 4 pawn
	 * @return position of the pawn
	 */
	public int getPositionOfPlayer2Pawn2() {
		return p2.getSecondPawn().getPosition();
	}
	
	
	/**
	 * post the turn now changed
	 * @param p boolean
	 */
	public void SetTurnOfPlayer1(boolean p) {
		this.p1.setTurn(p);
	}
	/**
	 * getter
	 * @return if its the players turn
	 */
	public boolean getTurnOfPlayer1() {
		return this.p1.getTurn();
	}
	/**
	 * the turn now changed
	 * @return p boolean
	 */
	public void SetTurnOfPlayer2(boolean p) {
		this.p2.setTurn(p);
	}
	/**
	 *
	 * @return if its the players turn
	 */
	public boolean getTurnOfPlayer2() {
		return this.p2.getTurn();
	}
	
	/**
	 * accessor
	 * post you have a random player
	 * 
	 * @return a random player
	 */
	
	public void randomPlayer(View a) {
		Random i=new Random();
		int num=i.nextInt(2);
		if(num==1) {
			SetTurnOfPlayer1(true);
			SetTurnOfPlayer2(false);
			a.getTxt().setText("Info Box\nYellow players turn");
		}else {
			SetTurnOfPlayer1(false);
			SetTurnOfPlayer2(true);
			a.getTxt().setText("Info Box\nRed players turn");
		}
		
		
	}
	/**
	 * observer
	 * post you have the pawns
	 * @return
	 */
	public Pawn[] getPawns() {
		Pawn[] a=new Pawn[4];
		a[0]=this.getFirstPlayer().getFirstPawn();
		a[1]=this.getFirstPlayer().getSecondPawn();
		a[2]=this.getSecondPlayer().getFirstPawn();
		a[3]=this.getSecondPlayer().getSecondPawn();
		return a;
	}
	/**
	 * accessor
	 * post you have the first player
	 * @return the first player
	 */
	public Player getFirstPlayer() {
		return this.p1;
	}
	/**
	 * accessor
	 * post you have the second player
	 * @return the second player
	 */
	public Player getSecondPlayer() {
		return this.p2;
	}
	/**
	 * accessor
	 * post you have a card
	 * @return a card
	 */
	public Card getCard() {
		return null;
	}
	/**
	 * observer
	 * post you know if a player wants to fold or not
	 * @return fold
	 */
	public boolean isFold() {
		return true;
	}
	
	/**
	 * transformer
	 * post the pawn is now moved
	 * 
	 */
	public void movePawn() {
	}
	
	/**
	 * observer 
	 * post now you know if the move is possible or not
	 * @return true if the move is possible
	 */
	public boolean checkIfMoveIsPossible() {
		return true;
	}
	/**
	 * transformer
	 * post now the player is on fold
	 */
	public void setFold() {
		
	}
	/**
	 * observer
	 * post now you know if the deck is empty or not
	 * @return state of deck
	 */
	public boolean isDeckEmpty() {
		return true;
	}
	/**
	 * constructor
	 * post the deck is ready
	 * 
	 */
	public void initializeDeck() {
	}
	/**
	 * constructor
	 * post the table is ready
	 */
	public void initializeTable() {}
	
	/**
	 * accessor
	 * 
	 * post now you have the deck
	 * @return the deck of cards
	 */
	public Card[] getCards(){
		return this.cards;
	}
	public void setCards(Card[] c) {
		this.cards=c;
	}
	/**
	 * accessor
	 * post you have the whole table
	 * @return the table
	 */
	public Square[] getTable(){
		return this.table;
	}
	
	/**
	 * constructor
	 * post the deck now is ready to used again
	 */
	public void Shuffle() {
	}
	

}
