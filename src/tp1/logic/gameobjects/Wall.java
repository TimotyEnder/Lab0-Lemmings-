package tp1.logic.gameobjects;

import tp1.logic.Position;
import tp1.view.Messages;
public class Wall extends GameObject
{
	public boolean isSolid() {
		return true;
	}
	public boolean isExit() {
		return false;
	}
 	public Wall( Position pos) 
	{
		setPos(pos);
	}
	public String toString() 
	{
		return Messages.WALL;
	}
}
