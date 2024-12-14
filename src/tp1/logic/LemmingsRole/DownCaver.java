package tp1.logic.LemmingsRole;


import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.GameItem;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;
import tp1.view.Messages;

public class DownCaver implements LemmingRole  {

	private String name= Messages.DOWNCAVER_NAME;
	private String details= Messages.DOWNCAVER_DETAILS;
	private String sc=Messages.DOWNCAVER_SHORTCUT;
	private String help= Messages.DOWNCAVER_HELP;

	@Override
	public void start(Lemming l) {
		
	}

	@Override
	public void advance(Lemming l) {
		l.DownCaver();
	}

	@Override
	public String geticon(Lemming l) {
		return Messages.LEMMING_DOWN_CAVER;
	}

	@Override
	public int FallForce(int ff) {
		return 0;
	}

	@Override
	public String getDetails() {
		String r = this.details + ": " + this.help;
		return r;
	}

	@Override
	public LemmingRole matchRole(String c) {
		LemmingRole  d = new DownCaver();
		if(c.equalsIgnoreCase(d.GetName()) || c.equalsIgnoreCase(d.GetSc())) 
		{
			return d;
		}
		return null; 
	}

	public String GetSc() {
		// TODO Auto-generated method stub
		return sc;
	}

	public String GetName() {
		// TODO Auto-generated method stub
		return name;
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
		if(lemming.GetPos().GetRow()==wall.GetPos().GetRow()-1)
		{
			lemming.setPos(wall.GetPos());
			wall.setAlive(false);	
		}
		return true;
	}

	@Override
	public boolean interactWith(ExitDoor door, Lemming lemming) {
		// TODO Auto-generated method stub
		return false;
	}

}
