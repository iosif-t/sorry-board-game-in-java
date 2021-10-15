package model;

public class Pawn {
	private String color;
	private boolean active;
	private int position,startingPos;
	/**
	 * constructor
	 * @param color color
	 */
	public Pawn(String color,int s) {
		this.color=color;
		this.active=true;
		this.position=0;
		this.startingPos=s;
	}
	public int getStartingPosition() {
		return this.startingPos;
	}
	/**
	 * observer
	 * post you know the color
	 * @return the color
	 */
	public String getColor() {
		return this.color;
	}
	/**
	 * Observer
	 * pre pass the square of the pawn at that time
	 * post check if the enemy can attack
	 * @param d square
	 * @return true if private
	 */
	public boolean isPawnSafe(Square d) {
		return d.isPrivate();
	}
	/**
	 * transformer
	 * pre if the pawn is alive set true
	 * post now its set
	 * @param p boolean
	 */
	public void setActive(boolean p) {
		this.active=p;
	}
	/**
	 * observer 
	 * post you know if the pawn is alive
	 * @return true if the pawn is alive
	 */
	public boolean isActive() {
		return this.active;
	}
	/**
	 * transformer
	 * pre if the number of the card + your current position on safe zone  = home position
	 * post the pawn is now home
	 * @param c card
	 * @return true if the pawn is home
	 */
	public boolean reachedHome(Card c) { //position + card == position of home
		return true;
	}
	/**
	 * transformer
	 * pre pass the right number
	 * post the position is now changed
	 * @param number number of card
	 */
	public void setPosition(int number) {
		this.position=number;
	}
	/**
	 * observer 
	 * post you know the position
	 * @return position
	 */
	public int getPosition() {
		return this.position;
	}
	/**
	 * observer
	 * post now you know if the pawn is on start square
	 * @return true if the pawn is on start
	 */
	public boolean isPawnAtStart() {
		return true; // gia tin sorry card
	}
	/**
	 * accessor
	 * post you know the start position
	 * @return the position of the starting square
	 */
	public int getStartPosition() {
		return 1;
	}
	/**
	 * observer
	 * post now you know if the pawn is on safe zone
	 * @return true if the pawn is on safe zone
	 */
	public boolean isPawnOnSafeZone() {
		return true;
	}
	
	
	
	
}
