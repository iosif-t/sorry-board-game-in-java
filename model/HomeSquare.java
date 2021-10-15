package model;

public class HomeSquare extends Square {
	private int position;
	private String color;
	private boolean isemptySquare,privacy;
	/**
	 * constructor 
	 * @param p player
	 * @param position position
	 */
	public HomeSquare(Player p,int position) {
		this.color=p.getColor();
		this.position=position;
		privacy = true;
	}
	public HomeSquare(String color,int position) {
		this.color=color;
		this.position=position;
		privacy = true;
	}

	/**
	 * transformer
	 * pre pass true if a pawn is on the certain square
	 * post the state of the square now has been set
	 */
	public void setStateOfSquare(boolean state) {
		this.isemptySquare=state;
	}

	/**
	 * observer
	 * post you know if a square is empty or not
	 */
	public boolean isEmptySquare() {
		return this.isemptySquare;
	}

	/**
	 * accessor
	 * post you have now the position of the square
	 */
	public int getPosition() {
		return this.position;
	}

	/**
	 * accessor
	 * post now you know the color of the square
	 */
	public String getColor() {
		return this.color;
	}

	/**
	 * 
	 * pre pass true if the enemy cant harm the pawns in the certain square
	 * post the privacy is now set
	 */
	public void setPrivacy(boolean p) {
	}

	/**
	 * observer
	 * post now you know if the square is private or not
	 */
	public boolean isPrivate() {
		
		return false;
	}
	

}
