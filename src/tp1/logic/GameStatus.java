package tp1.logic;

public interface GameStatus {
	public int getCycle() ;

	public int numLemmingsInBoard();

	public int numLemmingsDead();

	public int numLemmingsExit();

	public int numLemmingsToWin();

	public String positionToString(int col, int row);

	public boolean playerLoses();

	public boolean playerWins();

}
