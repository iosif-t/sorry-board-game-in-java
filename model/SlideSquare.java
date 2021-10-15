package model;

public class SlideSquare extends Square {
	private int slideLength;
	private Pawn p;
	private boolean canSlide;
	private int position;
	private String color;
	private boolean isemptySquare,privacy;
	/**
	 * constructor
	 * param color
	 * @param bigOrSmall length of slide
	 * @param position position
	 * @param color color
	 */
	public SlideSquare(String color,boolean bigOrSmall,int position) {
		this.color=color;
		this.position=position;
		
		if(bigOrSmall) 
			this.slideLength=5;
		else 
			this.slideLength=4;
		
		
		this.privacy=false;
	}
	
	/**
	 * observer 
	 * pre pass an alive pawn
	 * post you know if you have the right too slide
	 * @param p pawn
	 * @return true if you can slide
	 */
	public boolean slideOrNot(Pawn p) { //an exei idio xrwma uparxei den dikaioma gia slide
		
		return true;
		
	}
	/**
	 * Accessor 
	 * post you know the length of the slide
	 * @return the length of slide
	 */
	public int getSlideLength() {
		return this.slideLength;
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
		return false;
	}

	/**
	 * accessor
	 *post you have now the position of the square
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
	 * transformer
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
