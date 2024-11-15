package tp1.logic.gameobjects;

import tp1.logic.Position;
import tp1.logic.LemmingsRole.LemmingRole;
import tp1.logic.LemmingsRole.Walker;
import tp1.view.Messages;
import tp1.logic.Direction;
import tp1.logic.Game;
import tp1.logic.GameWorld;

public class Lemming extends GameObject 
{
	private final int LethalFall=4;
	private Direction prevDir;
	private Direction dir;
	private Integer fallForce;
	private LemmingRole lr;
	private GameWorld game;
	private Boolean turned=false;
	
	public Lemming (GameWorld game, Position pos,Direction dir) {
		this.pos=pos;
		this.alive=true;
		this.dir=dir;
		this.fallForce=0;
		this.game=game;
		this.lr= new Walker();
	}
	
	public boolean isSolid() {
		return false;
	}
	
	public boolean isExit() {
		return false;
	}
	public void Move ()
	{
		turned=false;
		if(this.GetPos().GetRow()>=0 && this.GetPos().GetRow()<Game.DIM_Y-1) 
		{
			Position fallPos=new Position(pos.GetCol(), pos.GetRow()+1);
			if(game.isSolid(fallPos))
			{
				Walk();
			}
			else 
			{
				Fall();
			}
			if(alive && !turned) 
			{
				Position MovePos=new Position(pos.GetCol()+dir.getX(),pos.GetRow()+dir.getY());
				this.pos=MovePos;
			}
		}
		else 
		{
			setAlive(false);
		}
		
	}
	private void Walk() 
	{
		Position bumpPos= new Position(pos.GetCol()+dir.getX(), pos.GetRow());
		if(fallForce<LethalFall) {
			if(fallForce > 0) 
			{
				fallForce=0;
				if(prevDir!=null) 
				{
					dir=prevDir;
				}
				else 
				{
					dir=Direction.RIGHT;
				}
			}
			if(game.isSolid(bumpPos) || bumpPos.GetCol()<0 || bumpPos.GetCol()>Game.DIM_X-1) 
			{
				turned=true;
				if(this.dir.equals(Direction.RIGHT)) 
				{
					this.dir=Direction.LEFT;
				}
				else 
				{
					this.dir=Direction.RIGHT;
				}
			}
		}
		else 
		{
			setAlive(false);
		}
	}
	private void Fall() 
	{
		if(prevDir!=null && prevDir.equals(Direction.DOWN)) 
		{
			prevDir=dir;
		}
		dir=Direction.DOWN;
		fallForce=FallForce();
	}
	public int FallForce() 
	{
		return lr.FallForce(fallForce);
	}
	public Direction GetDir() 
	{
		return dir;
	}
	@Override
	public void update() 
	{
		if(alive) 
		{
			lr.advance(this);
		}
	}
	public String toString() 
	{
		return lr.geticon(this);
	}
	
	public void setRole(LemmingRole lr) {
		this.lr = lr;
		System.out.println("changed to parachuter");
	}
	public void DisableRole() 
	{
		this.lr= new Walker();
	}
}
