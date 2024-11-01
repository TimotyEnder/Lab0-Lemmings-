package tp1.logic.gameobjects;

import tp1.logic.Position;

public abstract class GameObject {
	protected Position pos;
	protected boolean alive = true;
	
	public Position GetPos() 
	{
		return this.pos;
	}
	public void setPos(Position pos) 
	{
		this.pos = pos;
	}
	public boolean isAlive() {
		return this.alive;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	public void update()
	{
		
	}
}
