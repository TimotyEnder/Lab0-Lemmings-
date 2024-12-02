package tp1.logic;

public interface GameStatus extends GameCounters{
	public int getCycle() ;

	public String positionToString(int col, int row);

	public boolean playerLoses();

	public boolean playerWins();

}
