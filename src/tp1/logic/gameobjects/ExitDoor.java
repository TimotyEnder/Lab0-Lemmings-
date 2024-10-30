package tp1.logic.gameobjects;

import tp1.logic.Position;
import tp1.view.Messages;

public class ExitDoor extends GameObject
{
	private Position pos;
	private int ExitNum=0;
	public ExitDoor(Position pos) 
	{
		this.pos=pos;
	}
	public int GetExit() 
	{
		return ExitNum;
	}
	public void Exit() 
	{
		ExitNum++;
	}
	public Position GetPos() 
	{
		return this.pos;
	}
	public String toString() 
	{
		return Messages.EXIT_DOOR;
	}
}
