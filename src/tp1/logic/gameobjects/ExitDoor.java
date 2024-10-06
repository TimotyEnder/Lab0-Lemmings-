package tp1.logic.gameobjects;

import tp1.logic.Position;

public class ExitDoor {
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
}
