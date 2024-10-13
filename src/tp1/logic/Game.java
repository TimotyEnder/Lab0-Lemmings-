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
	private GameObjectContainer gameCon;
	public Game(int nLevel) {
		this.level=nLevel;
		gameCon= new GameObjectContainer();	
		Init(level);
	}
	public void Init(int level) 
	{
		if(level==1) 
		{

			LemmingsNumber=0;

			gameCon.add(new Lemming(this, new Position(3,3),Direction.RIGHT));

			LemmingsNumber++;

			gameCon.add(new Lemming(this, new Position(2,3),Direction.RIGHT));

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
			
			lemmingsToWin=LemmingsNumber;

		}
		if(level==2) 
		{
			LemmingsNumber=0;

			gameCon.add(new Lemming(this, new Position(4,0),Direction.RIGHT));

			gameCon.add(new Lemming(this, new Position(5,0),Direction.RIGHT));

			gameCon.add(new Lemming(this, new Position(6,0),Direction.RIGHT));

			gameCon.add(new Lemming(this, new Position(7,0),Direction.RIGHT));



			LemmingsNumber = 4;


			gameCon.add(new Wall(new Position(2,1)));

			gameCon.add(new Wall(new Position(3,1)));

			gameCon.add(new Wall(new Position(4,1)));

			gameCon.add(new Wall(new Position(5,1)));

			gameCon.add(new Wall(new Position(6,1)));

			gameCon.add(new Wall(new Position(7,1)));



			gameCon.add(new Wall(new Position(5,3)));

			gameCon.add(new Wall(new Position(6,3)));

			gameCon.add(new Wall(new Position(7,3)));



			gameCon.add(new Wall(new Position(3,9)));

			gameCon.add(new Wall(new Position(4,9)));

			gameCon.add(new Wall(new Position(5,9)));

			gameCon.add(new Wall(new Position(6,9)));

			gameCon.add(new Wall(new Position(7,9)));



			gameCon.add(new Wall(new Position(3,8)));



			gameCon.add(new ExitDoor(new Position(7,8)));

			lemmingsToWin=LemmingsNumber;
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
		return this.LemmingsNumber-numLemmingsDead();
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
		return numLemmingsInBoard() < numLemmingsToWin();
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
