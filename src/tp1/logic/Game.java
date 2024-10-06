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
		
		return 0;
	}

	public int numLemmingsExit() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int numLemmingsToWin() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String positionToString(int col, int row) {
		return  gameCon.SearchForPos(new Position(col,row));
	}

	public boolean playerWins() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean playerLooses() {
		// TODO Auto-generated method stub
		return false;
	}

	public String help() {
		// TODO Auto-generated method stub
		return null;
	}

}
