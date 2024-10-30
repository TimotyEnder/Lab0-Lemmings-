package tp1.logic.gameobjects;

import tp1.logic.Position;
import tp1.view.Messages;
public class Wall extends GameObject
{
	private Position pos;
	public Wall( Position pos) 
	{
		this.pos=pos;
	}
	public Position GetPos() 
	{
		return this.pos;
	}
	public void update() {};
	public String toString() 
	{
		return Messages.WALL;
	}
}
