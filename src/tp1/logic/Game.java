package tp1.logic;

import tp1.logic.LemmingsRole.LemmingRole;
import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;

public class Game implements GameModel, GameStatus,GameWorld{

	private int level;
	private int lemmingsToWin;
	private int CyclesNumber;
	private int LemmingsNumber;
	private GameObjectContainer gameCon;
	private Boolean exit=false;

	public Game(int nLevel) {
		this.level = nLevel;
		gameCon = new GameObjectContainer();
		Init(level);
	}

	public void Init(int level) {
		if (level == 1) {
			LemmingsNumber = 0;
			Add(new Lemming(this, new Position(3, 3), Direction.RIGHT));
			Add(new Lemming(this, new Position(3, 3), Direction.RIGHT));
			Add(new Lemming(this, new Position(2, 3), Direction.RIGHT));

			Add(new Wall(this, new Position(2, 4)));

			Add(new Wall(this, new Position(3, 4)));

			Add(new Wall(this, new Position(4, 4)));

			Add(new Wall(this, new Position(4, 6)));

			Add(new Wall(this, new Position(5, 6)));

			Add(new Wall(this, new Position(6, 6)));

			Add(new Wall(this, new Position(7, 6)));

			Add(new Wall(this, new Position(7, 5)));

			Add(new ExitDoor(this, new Position(4, 5)));

			lemmingsToWin = LemmingsNumber;

		}
		if (level == 2) {
			LemmingsNumber = 0;

			Add(new Lemming(this, new Position(4, 0), Direction.RIGHT));

			Add(new Lemming(this, new Position(5, 0), Direction.RIGHT));

			Add(new Lemming(this, new Position(6, 0), Direction.RIGHT));

			Add(new Lemming(this, new Position(7, 0), Direction.RIGHT));

			Add(new Wall(this, new Position(2, 1)));

			Add(new Wall(this, new Position(3, 1)));

			Add(new Wall(this, new Position(4, 1)));

			Add(new Wall(this, new Position(5, 1)));

			Add(new Wall(this, new Position(6, 1)));

			Add(new Wall(this, new Position(7, 1)));

			Add(new Wall(this, new Position(5, 3)));

			Add(new Wall(this, new Position(6, 3)));

			Add(new Wall(this, new Position(7, 3)));

			Add(new Wall(this, new Position(3, 9)));

			Add(new Wall(this, new Position(4, 9)));

			Add(new Wall(this, new Position(5, 9)));

			Add(new Wall(this, new Position(6, 9)));

			Add(new Wall(this, new Position(7, 9)));

			Add(new Wall(this, new Position(3, 8)));

			Add(new ExitDoor(this, new Position(7, 8)));

			lemmingsToWin = LemmingsNumber;
		}
		if(level == 3) 
		{
			LemmingsNumber = 0;
	        Add(new Lemming(this, new Position(0,8),Direction.RIGHT));

	        Add(new Lemming(this, new Position(2,3),Direction.RIGHT));

	        Add(new Lemming(this, new Position(9,0),Direction.RIGHT));

	        Add(new Lemming(this, new Position(3,3),Direction.RIGHT));


	        Add(new Wall(this, new Position(0,9)));

	        Add(new Wall(this, new Position(1,9)));

	        Add(new Wall(this, new Position(2,4)));

	        Add(new Wall(this, new Position(3,4)));

	        Add(new Wall(this, new Position(4,4)));


	        Add(new Wall(this, new Position(4,6)));

	        Add(new Wall(this, new Position(5,6)));

	        Add(new Wall(this, new Position(6,6)));

	        Add(new Wall(this, new Position(7,6)));

	        Add(new Wall(this, new Position(7,5)));

	        Add(new Wall(this, new Position(8,1)));

	        Add(new Wall(this, new Position(9,1)));

	        Add(new Wall(this, new Position(8,8)));

	        Add(new Wall(this, new Position(9,9)));

	        Add(new Wall(this, new Position(8,8)));

	        Add(new Wall(this, new Position(8,9)));


	        Add(new ExitDoor(this, new Position(4,5)));

	        this.lemmingsToWin = 3;//por ejempo
		}
	}

	public void update() {
		CyclesNumber++;
		gameCon.update();
	}
	public int getCycle() {
		return this.CyclesNumber;
	}

	public int numLemmingsInBoard() {
		//this.LemmingsNumber -= numLemmingsDead();
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
		return gameCon.SearchForPos(new Position(col, row));
	}

	public boolean playerWins() {
		return numLemmingsExit() == numLemmingsToWin();
	}

	public boolean playerLoses() {
		return numLemmingsInBoard() - numLemmingsDead() < numLemmingsToWin();
	}

	public Boolean isSolid(Position pos) {
		return gameCon.isSolid(pos);
	}

	public void Add(Lemming l) {
		LemmingsNumber++;
		gameCon.add(l);
	}

	public void Add(ExitDoor e) {
		gameCon.add(e);
	}

	public void Add(Wall w) {
		gameCon.add(w);
	}

	public void reset() {
		this.CyclesNumber = 0;
		this.LemmingsNumber = 0;
		this.gameCon = new GameObjectContainer();
		this.Init(level);
	}
	public boolean seFinito(boolean exiting) 
	{
		if(exiting) 
		{
			exit=true;
		}
		return exit? true : this.playerWins() || this.playerLoses();
	}
	public void LemmingRoleAssign(Position pos, LemmingRole lr) 
	{
		gameCon.LemmingRoleAssigner(pos, lr);
	}
}
