package tp1.control;

import tp1.logic.gameobjects.LemmingRole;
import tp1.logic.GameModel;
import tp1.view.GameView;
import tp1.view.Messages;

public class setRole extends NoParamsCommand{
	private static final String NAME = Messages.COMMAND_SETROLE_NAME;
	private static final String SHORTCUT = Messages.COMMAND_SETROLE_SHORTCUT;
	private static final String DETAILS = Messages.COMMAND_SETROLE_DETAILS;
	private static final String HELP = Messages.COMMAND_SETROLE_HELP;

	public setRole() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
	//Remember to change this, as it needs to recognize a position (ROW COL)
	protected boolean matchCommand(String c) 
	{
		return c.equalsIgnoreCase(this.GetName()) || c.equalsIgnoreCase(this.GetShortCut()); 
	} 
	public Command parse(String[] sa) 
	{
		ExitCommand c= new ExitCommand();
		if(c.matchCommand(sa[0])) 
		{
			return c;
		}
		else return null;
	}
	
	//Not sure how to implement this yet
	public boolean setARole(LemmingRole r) 
	{
		return false;
	}
	
	//Not sure what to execute in here
	@Override
	public void execute(GameModel mtg, GameView mtgview) 
	{
	}
}