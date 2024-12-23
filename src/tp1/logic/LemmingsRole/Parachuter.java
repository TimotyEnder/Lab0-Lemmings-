package tp1.logic.LemmingsRole;

import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.GameItem;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;
import tp1.view.Messages;

public class Parachuter implements LemmingRole {

	private String name= Messages.PARACHUTER_NAME;
	private String details= Messages.PARACHUTER_DETAILS;
	private String sc=Messages.PARACHUTER_SHORTCUT;
	private String help= Messages.PARACHUTER_HELP;
	
	public String GetName() 
	{
		return this.name;
	}
	public String GetSc() 
	{
		return this.sc;
	}
	@Override
	public void start(Lemming l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void advance(Lemming l) {
		if(!l.GetAirborne()) 
		{
			l.resetRole();
			l.SetDir(l.GetPrevDir());
		}
		l.Move();
	}

	@Override
	public String geticon(Lemming l) {
		// TODO Auto-generated method stub
		if(l.isAlive())
		{
			return Messages.PARACHUTE;
		}
		else 
		{
			return "";
		}
	}
	public  LemmingRole matchRole(String c) 
	{
		LemmingRole  d = new Parachuter();
		if(c.equalsIgnoreCase(d.GetName()) || c.equalsIgnoreCase(d.GetSc())) 
		{
			return d;
		}
		return null; 
	} 
	public int FallForce(int ff) {
		return 0;
	}

	
	
	public String getDetails() {
		String r = this.details + ": " + this.help;
		return r;
	}
	@Override
	public boolean receiveInteraction(GameItem other, Lemming lemming) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean interactWith(Lemming receiver, Lemming lemming) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean interactWith(Wall wall, Lemming lemming) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean interactWith(ExitDoor door, Lemming lemming) {
		// TODO Auto-generated method stub
		return false;
	}
}
