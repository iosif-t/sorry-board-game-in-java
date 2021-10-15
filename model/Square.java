package model;

public abstract class Square {
	
	
	/**
	 * transformer
	 * pre pass true false if the sqaure is empty
	 * post we know if its empty or not
	 * @param state true or false
	 */
	public abstract void setStateOfSquare(boolean state);
	/**
	 * observer
	 * post we know the state of square
	 * @return true if its empty
	 */
	public abstract boolean isEmptySquare();
	/**
	 * accessor
	 * post we know the position of the square
	 * @return the position
	 */
	public abstract int getPosition();	
	/**
	 * accesor
	 * post we know the color of the square
	 * @return the color of the square
	 */
	public abstract String getColor();
	/**
	 * transformer
	 * pre if the enemy cant attack on that square pass true
	 * post safety set
	 * @param p boolean 
	 */
	public abstract void setPrivacy(boolean p);
	/**
	 * observer
	 * post we know if the pawn is safe or not
	 * @return the privacy
	 */
	public abstract boolean isPrivate();
	
	

}
