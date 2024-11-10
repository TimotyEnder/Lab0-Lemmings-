package tp1.logic.LemmingsRole;

import tp1.logic.Direction;
import tp1.logic.gameobjects.Lemming;
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
		l.Move(false);
	}
	@Override
	public String geticon(Lemming l) {
		if(l.isAlive()) 
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
			return "";
		}
	}
	protected boolean matchRole(String c) 
	{
		return c.equalsIgnoreCase(this.GetName()) || c.equalsIgnoreCase(this.GetSc()); 
	} 
	public LemmingRole parse(String wordywords) {
		LemmingRole lr = new Walker();
		if(matchRole(wordywords)) 
		{
			return lr;
		}
		else 
		{
			return null;
		}
		
	}
}