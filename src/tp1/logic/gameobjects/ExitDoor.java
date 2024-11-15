package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Position;
import tp1.logic.LemmingsRole.LemmingRole;
import tp1.view.Messages;

public class ExitDoor extends GameObject
{
	private int ExitNum=0;
	//Maybe should redirect the calls to GameObject instead of having this function
	public ExitDoor(Game game, Position pos) 
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
	
	public  boolean isSoft() 
	{
		return false;
	}
	public boolean isExit() {
		return true;
	}
	@Override
	public boolean setRole(LemmingRole lr) {
		return  false;
	}
	@Override
	public boolean receiveInteraction(GameItem other) {
		// TODO Auto-generated method stub
		return other.interactWith(this);
	}
	@Override
	public boolean interactWith(Lemming lemming) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean interactWith(Wall wall) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean interactWith(ExitDoor door) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isInPosition(Position pos) {
		return pos.Eq(pos);
	}
}
