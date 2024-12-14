package tp1.logic.LemmingsRole;

import tp1.logic.Direction;
import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.GameItem;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;
import tp1.view.Messages;

public class Walker implements LemmingRole
{
	private String name= Messages.WALKER_NAME;
	private String details= Messages.WALKER_DETAILS;
	private String sc=Messages.WALKER_SHORTCUT;
	private String help= Messages.WALKER_HELP;

	public String GetName() 
	{
		return this.name;
	}
	public String GetSc() 
	{
		return this.sc;
	}
	public void start(Lemming l) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void advance(Lemming l) {
		l.Move();
	}
	@Override
	public String geticon(Lemming l) {
		if(l.isAlive()) 
		{
			if(l.GetDir()!=Direction.DOWN) 
			{
				if(l.GetDir()==Direction.LEFT) 
				{
					return Messages.LEMMING_LEFT;
				}
				else 
				{
					return Messages.LEMMING_RIGHT;
				}
			}
			else 
			{
				if(l.GetPrevDir()==Direction.LEFT) 
				{
					return Messages.LEMMING_LEFT;
				}
				else 
				{
					return Messages.LEMMING_RIGHT;
				}
			}
		}
		else 
		{
			return "";
		}
	}
	public LemmingRole matchRole(String c) 
	{
		LemmingRole  d = new Walker();
		if(c.equalsIgnoreCase(d.GetName()) || c.equalsIgnoreCase(d.GetSc())) 
		{
			return d;
		}
		return null;
	} 
	public int FallForce(int ff) {
		
		return ff+1;
	}
	public String getDetails() {
		String r = this.details + ": " + this.help;
		return r;
	}
	@Override
	public boolean receiveInteraction(GameItem other, Lemming lemming) {
		return false;
	}
	@Override
	public boolean interactWith(Lemming receiver, Lemming lemming) {
		return false;
	}
	@Override
	public boolean interactWith(Wall wall, Lemming lemming) {
		return false;
	}
	@Override
	public boolean interactWith(ExitDoor door, Lemming lemming) {
		return false;
	}
}
