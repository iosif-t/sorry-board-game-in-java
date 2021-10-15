package model;

public class SimpleSquare extends Square {
	private int position;
	private String color;
	private boolean isemptySquare,privacy;
	/**
	 * constructor
	 * @param position posiiton of square
	 */
	public SimpleSquare(int position){
		this.color="white";
		this.privacy=false;
		this.position=position;
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
		return this.position;
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
