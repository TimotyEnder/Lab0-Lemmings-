package tp1.logic.LemmingsRole;

import java.util.ArrayList;

import tp1.logic.Direction;
import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.GameItem;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;
import tp1.view.Messages;

public class Drone implements LemmingRole {

	private String name= Messages.DRONE_NAME;
	private String details= Messages.DRONE_DETAILS;
	private String sc=Messages.DRONE_SHORTCUT;
	private String help= Messages.DRONE_HELP;
	private ArrayList<Direction> dirs = new ArrayList<Direction>();
	private ArrayList<String> directions = new ArrayList<String>();
	
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
		for(String str : directions) {
			if(str.equalsIgnoreCase("up") || str.equalsIgnoreCase("u")) {
				dirs.add(Direction.UP);
			}
			else if(str.equalsIgnoreCase("down") || str.equalsIgnoreCase("d")){
				dirs.add(Direction.DOWN);
			}
			else if(str.equalsIgnoreCase("right") || str.equalsIgnoreCase("r")){
				dirs.add(Direction.RIGHT);
			}
			else if (str.equalsIgnoreCase("left") || str.equalsIgnoreCase("l")){
				dirs.add(Direction.LEFT);
			}
		}
	}
		
	@Override
	public void advance(Lemming l) {
		if(!dirs.isEmpty()) {
			Direction nextDir = dirs.getFirst();		//Grab first element
			l.MoveWithDir(nextDir);						//Move lemming in that dir
			dirs.removeFirst();							//Remove the element.
		}
		else {
			l.resetRole();
		}
		
	}

	@Override
	public String geticon(Lemming l) {
		return Messages.LEMMING_DRONE;
	}
	
	public  LemmingRole matchRole(String c) 
	{
		LemmingRole  d = new Drone();
		if(c.equalsIgnoreCase(d.GetName()) || c.equalsIgnoreCase(d.GetSc())) 
		{
			return d;
		}
		return null; 
	} 
	public int FallForce(int ff) {
		return ff + 1;
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
	
	public void setDirStr(ArrayList<String> directions){
		for(String newDir : directions) {
			this.directions.add(newDir);
		}
	}
}
