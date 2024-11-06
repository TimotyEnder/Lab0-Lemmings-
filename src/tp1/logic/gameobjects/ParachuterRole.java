package tp1.logic.gameobjects;

import tp1.view.Messages;

public class ParachuterRole implements LemmingRole {

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

}
