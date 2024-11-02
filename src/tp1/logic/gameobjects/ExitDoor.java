package tp1.logic.gameobjects;

import tp1.logic.Position;
import tp1.view.Messages;

public class ExitDoor extends GameObject
{
	private int ExitNum=0;
	//Maybe should redirect the calls to GameObject instead of having this function
	public ExitDoor(Position pos) 
	{
		setPos(pos);
	}
	@Override
	public int GetExit() 
	{
		return ExitNum;
	}
	public void Exit() 
	{
		ExitNum++;
	}
	public String toString() 
	{
		return Messages.EXIT_DOOR;
	}
	
	public boolean isSolid() {
		return false;
	}
	
	public boolean isExit() {
		return true;
	}
}
