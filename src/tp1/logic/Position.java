package tp1.logic;

/**
 * 
 * Immutable class to encapsulate and manipulate positions in the game board
 * 
 */
public class Position {

	final int col;
	final int row;
	
	public Position(int col, int row) {
		this.col=col;
		this.row=row;
	}
	public int GetCol() 
	{
		return col;
	}
	public int GetRow() 
	{
		return row;
	}
	public boolean Eq(Position pos) 
	{
		return (this.col==pos.col) && (this.row==pos.row);
	}
	//TODO fill your code

}
