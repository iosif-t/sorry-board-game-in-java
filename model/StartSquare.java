package model;

public class StartSquare extends Square {
	private int position;
	private String color;
	private boolean isemptySquare,privacy;
	/**
	 * constructor
	 * @param p player
	 * @param position position
	 */
	public StartSquare(Player p,int position) {
		
		this.color=p.getColor();
		this.position=position;
		this.privacy=false;
		
	}
	public StartSquare(String color,int position) {
		
		this.color=color;
		this.position=position;
		this.privacy=false;
		
	}
	
	/**
	 * transformer
	 * pre if both pawns have different posiiton with the position of the square pass true
	 * post state set
	 */
	public void setStateOfSquare(boolean state) {
		this.isemptySquare=state;
	}
	/**
	 * observer
	 * post we know if the square is empty
	 */
	public boolean isEmptySquare() {
		return this.isemptySquare;
	}
	/**
	 * accessor
	 * post we know the position of the square
	 */
	public int getPosition() {
		return 0;
	}
	/**
	 * accessor
	 * post we know the color
	 */
	public String getColor() {
		return this.color;
	}
	/**
	 * transformer
	 * pre 
	 * post privacy set
	 */
	public void setPrivacy(boolean p) {
		
	}
	/**
	 * observer
	 * post we know the privacy of the square
	 */
	public boolean isPrivate() {
		return false;
	}

}
