package tp1.logic.gameobjects;

import tp1.logic.Position;

import tp1.logic.Direction;
import tp1.logic.Game;

public class Lemming 
{
	
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
		Position MovePos=new Position(dir.getX(),dir.getY());
		this.pos=MovePos;
		
	}
	public void update() 
	{
		if(alive) 
		{
			role.Advance(this);
		}
	}

}
