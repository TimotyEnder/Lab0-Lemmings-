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
	
	public Lemming (Position pos,Direction dir) {
		this.pos=pos;
		this.alive=true;
		this.dir=dir;
		this.fallForce=0;
	}
	public void Move () 
	{
		Position fallPos=new Position(pos.GetCol(), pos.GetRow()-1);
		Position bumpPos= new Position(pos.GetCol()+dir.getX(), pos.GetRow()+dir.getY());
		if(game.isWall(fallPos))
		{
			if(fallForce<LethalFall) {
				if(game.isWall(bumpPos)) 
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
	public Direction GetDir() 
	{
		return dir;
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
