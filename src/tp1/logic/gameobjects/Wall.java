package tp1.logic.gameobjects;

import tp1.logic.Position;
public class Wall {
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
}
