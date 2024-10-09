package tp1.logic;

public class Game {

	public static final int DIM_X = 10;
	public static final int DIM_Y = 10;
	
	private int CyclesNumber;
	private int LemmingsNumber;
	private GameObjectContainer gameCon= new GameObjectContainer();	
	public Game(int nLevel) {
		// TODO Auto-generated constructor stub
	}
	public void update() 
	{
		CyclesNumber++;
		gameCon.update();
	}

	public int getCycle() {
		return this.CyclesNumber;
	}

	public int numLemmingsInBoard() {
		return this.LemmingsNumber;
	}

	public int numLemmingsDead() {
		return gameCon.numLemmingDead();
	}

	public int numLemmingsExit() {
		return gameCon.GetExit();
	}

	public int numLemmingsToWin() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String positionToString(int col, int row) {
		return  gameCon.SearchForPos(new Position(col,row));
	}

	public boolean playerWins() {
		return numLemmingsExit()==numLemmingsToWin();
	}

	public boolean playerLooses() {
		return numLemmingsInBoard() > numLemmingsToWin();
	}

	public String help() {
		return null;
	}
	public Boolean isWall(Position pos) 
	{
		return gameCon.isWall(pos);
	}
	// is solid en el container tmb
	// is in air
	// pos to string es para pintar

}
