package tp1.logic.LemmingsRole;

import tp1.logic.gameobjects.Lemming;
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
		l.Move(true);
		
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
	protected boolean matchRole(String c) 
	{
		return c.equalsIgnoreCase(this.GetName()) || c.equalsIgnoreCase(this.GetSc()); 
	} 
	public LemmingRole parse(String wordywords) {
		LemmingRole lr = new Parachuter();
		if(matchRole(wordywords)) 
		{
			return lr;
		}
		else 
		{
			return null;
		}
		
	}
	
	
	public String getDetails() {
		String r = this.details + ": " + this.help;
		return r;
	}
}
