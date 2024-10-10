package tp1.logic;

import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;

public class Game {

	public static final int DIM_X = 10;
	public static final int DIM_Y = 10;
	private int level;
	private int lemmingsToWin;
	private int CyclesNumber;
	private int LemmingsNumber;
	private GameObjectContainer gameCon= new GameObjectContainer();	
	public Game(int nLevel) {
		this.level=nLevel;
		Init(level);
	}
	public void Init(int level) 
	{
		if(level==1) 
		{
			gameCon.add(new Lemming(new Position(4, 4), true, Direction.RIGHT, 0));  // D4
			gameCon.add(new Lemming(new Position(8, 4), true, Direction.RIGHT, 0));  // D8
			gameCon.add(new Lemming(new Position(2, 9), true, Direction.RIGHT, 0));  // I2

			// Add Walls
			for (int col = 3; col <= 10; col++) {
				gameCon.add(new Wall(new Position(col, 2)));  // B3 to B10
			}
			for (int col = 2; col <= 11; col++) {
				gameCon.add(new Wall(new Position(col, 5)));  // E2 to E11
			}
			for (int col = 7; col <= 11; col++) {
				gameCon.add(new Wall(new Position(col, 6)));  // F7 to F11
			}
			for (int col = 2; col <= 10; col++) {
				gameCon.add(new Wall(new Position(col, 7)));  // G2 to G10
			}
			for (int col = 7; col <= 11; col++) {
				gameCon.add(new Wall(new Position(col, 9)));  // I7 to I11
			}
			for (int col = 1; col <= 10; col++) {
				gameCon.add(new Wall(new Position(col, 10)));  // J1 to J10
			}
			gameCon.add(new ExitDoor(new Position(6, 6)));  // F6
			gameCon.PrintArrays();
	}
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
		return this.lemmingsToWin;
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
	public void Reset() 
	{
		this.CyclesNumber=0;
		this.LemmingsNumber=0;
		this.gameCon=new GameObjectContainer();
		this.Init(level);
	}
}
