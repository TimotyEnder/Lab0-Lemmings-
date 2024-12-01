package tp1.logic.gameobjects;

import tp1.logic.Direction;
import tp1.logic.GameWorld;
import tp1.logic.Position;
import tp1.logic.LemmingsRole.LemmingRole;

public abstract class GameObject implements GameItem{
	protected Position pos;
	protected GameWorld game;
	protected int fallForce;
	protected  Direction dir;
	protected boolean alive = false;
	public int GetExit() 
	{
		return 0;
	}
	public Position GetPos() 
	{
		return this.pos;
	}
	public void setPos(Position pos) 
	{
		this.pos = pos;
	}
	public abstract boolean isSolid();
	public abstract boolean isSoft();
	public abstract boolean isExit();
	public boolean isAlive() 
	{
		return this.alive;
	}
	public void setAlive(boolean alive) 
	{
		this.alive = alive;
	}
	public void update()
	{
		
	}
	public abstract boolean setRole(LemmingRole lr);
	public void SetGame(GameWorld g) 
	{
		this.game=g;
	}
	public void SetDir(Direction dir) 
	{
		this.dir=dir;
	}
	public void SetFallF(int i) 
	{
		this.fallForce=i;
	}
	public void SetExit(int ExitNum) 
	{
	}
}
