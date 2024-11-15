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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void advance(Lemming l) {
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
	public boolean matchRole(String c) {
		return c.equalsIgnoreCase(this.GetName()) || c.equalsIgnoreCase(this.GetSc()); 
	}

	private String GetSc() {
		// TODO Auto-generated method stub
		return sc;
	}

	private String GetName() {
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean interactWith(ExitDoor door, Lemming lemming) {
		// TODO Auto-generated method stub
		return false;
	}

}
