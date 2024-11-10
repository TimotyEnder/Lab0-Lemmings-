package tp1.control;

import tp1.logic.GameModel;
import tp1.logic.GameWorld;
import tp1.logic.LemmingsRole.LemmingRole;
import tp1.logic.LemmingsRole.LemmingRoleFactory;
import tp1.view.GameView;
import tp1.view.Messages;

public class SetRoleCommand extends Command{
	private static final String NAME = Messages.COMMAND_SETROLE_NAME;
	private static final String SHORTCUT = Messages.COMMAND_SETROLE_SHORTCUT;
	private static final String DETAILS = Messages.COMMAND_SETROLE_DETAILS;
	private static final String HELP = Messages.COMMAND_SETROLE_HELP;
	

	//parameter attributes
	private int col=0;
	private int row=0;
	private String roleName="";
	public SetRoleCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
	//Remember to change this, as it needs to recognize a position (ROW COL)
	protected boolean matchCommand(String c) 
	{
		return c.equalsIgnoreCase(this.GetName()) || c.equalsIgnoreCase(this.GetShortCut()); 
	} 
	public Command parse(String[] sa) 
	{
		SetRoleCommand c= new SetRoleCommand();
		
		if(c.matchCommand(sa[0])) 
		{
			roleName= sa[1];
			row= LetterToNum(sa[2]);
			col= Integer.parseInt(sa[3])-1;
			return c;
		}
		else return null;
	}
	
	//Not sure what to execute in here
	@Override
	public void execute(GameModel mtg, GameView mtgview) 
	{
		LemmingRole lr= LemmingRoleFactory.parse(roleName);
		
	}
	public int LetterToNum(String let) 
	{
		return let.charAt(0) - 'A';
	}
}