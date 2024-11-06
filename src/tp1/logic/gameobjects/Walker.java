package tp1.logic.gameobjects;

import tp1.logic.Direction;
import tp1.view.Messages;

public class Walker implements LemmingRole
{
	@Override
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
}
