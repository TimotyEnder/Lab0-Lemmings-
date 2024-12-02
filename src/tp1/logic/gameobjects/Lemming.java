package tp1.logic.gameobjects;

import tp1.logic.Position;
import tp1.logic.LemmingsRole.LemmingRole;
import tp1.logic.LemmingsRole.Walker;
import tp1.logic.Direction;
import tp1.logic.Game;
import tp1.logic.GameWorld;

public class Lemming extends GameObject 
{
	private final int LethalFall=3;
	private Direction prevDir;
	private LemmingRole lr;
	private boolean turned=false;
	private boolean exited=false;
	
	public Lemming (GameWorld game, Position pos,Direction direction) {
		this.pos=pos;
		this.alive=true;
		this.dir=direction;
		this.prevDir=dir;
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
			Position unParachutePos= new Position(pos.GetCol(), pos.GetRow()+2);
			if(game.isSolid(unParachutePos)) 
			{
				resetRole();
			}
			if(!GetAirborne())
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
			Die();
		}
		
	}
	private void Walk() 
	{
		Position bumpPos= new Position(pos.GetCol()+dir.getX(), pos.GetRow());
		if(fallForce<LethalFall) {
			if(fallForce > 0) 
			{
				fallForce=0;
				if(prevDir!=dir) 
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
			Die();
		}
	}
	private void Fall() 
	{
		if(!dir.equals(Direction.DOWN)) 
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
	public Direction GetPrevDir() 
	{
		return prevDir;
	}
	public boolean GetAirborne() 
	{
		Position fallPos=new Position(pos.GetCol(), pos.GetRow()+1);
		return !game.isSolid(fallPos);
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
	
	public boolean setRole(LemmingRole lr) {
		if(this.lr!=lr) 
		{
			this.lr = lr;
			return true;
		}
		else 
		{
			return false;
		}
	}
	public void resetRole() 
	{
		this.lr= new Walker();
	}
	@Override
	public boolean receiveInteraction(GameItem other) {
		return other.interactWith(this);
	}

	@Override
	public boolean interactWith(Lemming lemming) {
		return false;
	}

	@Override
	public boolean interactWith(Wall wall) {
		lr.interactWith(wall, this);
		return false;
	}
	public void DownCaver() 
	{
		if(GetAirborne()) 
		{
			resetRole();
		}
	}
	@Override
	public boolean interactWith(ExitDoor door) {
		door.Exit();
		exited=true;
		alive=false;
		return true;
	}

	@Override
	public boolean isInPosition(Position pos) {
		return pos.Eq(pos);
	}

	@Override
	public boolean isSoft() {
		return false;
	}
	public boolean hasExited() 
	{
		return exited;
	}
	public void Die() 
	{
		this.setAlive(false);
		this.game.LemmingDying();
	}
}
