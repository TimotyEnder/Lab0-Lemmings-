package tp1.logic.gameobjects;

import tp1.logic.Position;

import tp1.logic.Direction;
import tp1.logic.Game;

public class Lemming 
{
	private final int LethalFall=2;
	private Position pos;
	private boolean alive;
	private Direction dir;
	private Integer fallForce;
	private Walker role;
	private Game game;
	
	public Lemming (Position pos, boolean alive, Direction dir, Integer fForce) {
		this.pos=pos;
		this.alive=alive;
		this.dir=dir;
		this.fallForce=fForce;
	}
	public void Move () 
	{
		
		if(game.positionToString(pos.GetCol(), pos.GetRow()-1)=="w") 
		{
			if(fallForce<LethalFall) {
			if(game.positionToString(pos.GetCol()+dir.getX(), pos.GetRow()+dir.getY())=="w") 
			{
				dir.invert();
			}
			}
			else 
			{
				alive=false;
			}
		}
		else 
		{
			dir=Direction.DOWN;
			fallForce++;
		}
		if(alive) 
		{
			Position MovePos=new Position(dir.getX(),dir.getY());
			this.pos=MovePos;
		}
		
	}
	public Position GetPos() 
	{
		return this.pos;
	}	
	public void update() 
	{
		if(alive) 
		{
			role.Advance(this);
		}
	}
	public boolean isAlive() {
		return this.alive;
	}
}
