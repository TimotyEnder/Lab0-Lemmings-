package tp1.logic.LemmingsRole;

import java.util.Vector;

import tp1.logic.Direction;
import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.GameItem;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;
import tp1.view.Messages;

public class Drone implements LemmingRole{
	private String name= Messages.DRONE_NAME;
	private String details= Messages.DRONE_DETAILS;
	private String sc=Messages.DRONE_SHORTCUT;
	private String help= Messages.DRONE_HELP;
	
	private Vector<Direction> dirs= new Vector<Direction>();
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
		if(!dirs.isEmpty()) 
		{
			if(!l.Crashed()) 
			{
				l.Displace(dirs.elementAt(0));
			}
			dirs.remove(0);
		}
		else 
		{
			//l.SetDir(Direction.RIGHT);
			l.resetRole();
		}
	}
	public void ParseDirs(String[] dirStrings) 
	{
		for(int i=1;i<dirStrings.length;i++) 
		{
			Direction dir=Direction.valueOf(dirStrings[i]);
			this.dirs.add(dir);
		}
	}
	@Override
	public String geticon(Lemming l) {
		// TODO Auto-generated method stub
		if(l.isAlive())
		{
			return Messages.DRONE;
		}
		else 
		{
			return "";
		}
	}
	public  LemmingRole matchRole(String[] dirs) 
	{
		LemmingRole  d = new Drone();
		if(dirs[0].equalsIgnoreCase(d.GetName()) || dirs[0].equalsIgnoreCase(d.GetSc())) 
		{
			((Drone) d).ParseDirs(dirs);
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
