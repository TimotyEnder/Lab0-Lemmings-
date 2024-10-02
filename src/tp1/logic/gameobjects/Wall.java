package tp1.logic.gameobjects;

import javax.swing.text.Position;

public class Wall {
	private Position pos;
	public Wall(Position pos) 
	{
		this.pos=pos;
	}
	public Position GetPos() 
	{
		return this.pos;
	}
	public void update() {};
}
