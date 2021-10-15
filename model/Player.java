package model;

public class Player {
	private String color,name;
	private Pawn firstPawn ,secondPawn;
	private boolean myTurn;
	
	/**
	 * constructor
	 * @param name name of player
	 * @param color color of player
	 */
	public Player(String name,String color,int s1,int s2){
		this.name=name;
		this.color=color;
		this.firstPawn = new Pawn(color,s1);
		this.secondPawn = new Pawn(color,s2);
	}
	/**
	 * observer
	 * pre both pawns are on home
	 * post we have a winner
	 * @return true if player won
	 */
	public boolean isWinner() {
		return true;
	}
	/**
	 * transformer
	 * pre if the enemy player finished his move pass true
	 * post now you know that its youur turn
	 * @param turn boolean
	 */
	public void setTurn(boolean turn) {
		this.myTurn=turn;
	}
	/**
	 * observer
	 * post returns turn
	 * @return true if its the players turn
	 */
	public boolean getTurn() {
		return this.myTurn;
	}
	/**
	 * accessor
	 * post we know the name
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * post we know the color
	 * @return the color
	 */
	public String getColor() {
		return this.color;
	}
	/**
	 * post we know the first pawn
	 * @return first pawn
	 */
	public Pawn getFirstPawn() {
		return this.firstPawn;
	}
	/**
	 * post we know the second pawn
	 * @return the 2nd pawn
	 */
	public Pawn getSecondPawn() {
		return this.secondPawn;
	}
}
