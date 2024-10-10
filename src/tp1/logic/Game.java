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

			LemmingsNumber=0;

			gameCon.add(new Lemming(new Position(3,3),Direction.RIGHT));

			LemmingsNumber++;

			gameCon.add(new Lemming(new Position(2,3),Direction.RIGHT));

			LemmingsNumber++;

			gameCon.add(new Wall(new Position(2,4)));

			gameCon.add(new Wall(new Position(3,4)));

			gameCon.add(new Wall(new Position(4,4)));

			gameCon.add(new Wall(new Position(4,6)));

			gameCon.add(new Wall(new Position(5,6)));

			gameCon.add(new Wall(new Position(6,6)));

			gameCon.add(new Wall(new Position(7,6)));

			gameCon.add(new Wall(new Position(7,5)));

			gameCon.add(new ExitDoor(new Position(4,5)));

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
