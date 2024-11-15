package tp1.logic.gameobjects;

import tp1.logic.Position;
import tp1.logic.LemmingsRole.LemmingRole;

public abstract class GameObject {
	protected Position pos;
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
}
