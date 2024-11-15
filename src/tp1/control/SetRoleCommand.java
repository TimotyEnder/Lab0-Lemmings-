package tp1.control;

import javax.swing.text.View;

import tp1.logic.GameModel;
import tp1.logic.GameWorld;
import tp1.logic.Position;
import tp1.logic.LemmingsRole.LemmingRole;
import tp1.logic.LemmingsRole.LemmingRoleFactory;
import tp1.logic.gameobjects.GameObject;
import tp1.view.GameView;
import tp1.view.Messages;

public class SetRoleCommand extends Command{
	private static final String NAME = Messages.COMMAND_SETROLE_NAME;
	private static final String SHORTCUT = Messages.COMMAND_SETROLE_SHORTCUT;
	private static final String DETAILS = Messages.COMMAND_SETROLE_DETAILS;
	private static final String HELP = Messages.COMMAND_SETROLE_HELP;
	

	//parameter attributes
	private int col;
	private int row;
	private LemmingRole role;
	public SetRoleCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
	//Remember to change this, as it needs to recognize a position (ROW COL
	public Command parse(String[] sa) 
	{
		SetRoleCommand c= new SetRoleCommand();
		
		if(c.matchCommand(sa[0])) 
		{
			role= LemmingRoleFactory.parse(sa[1]);
			col= LetterToNum(sa[2].toUpperCase());
			row= Integer.parseInt(sa[3])-1;
			return this;
		}
		else return null;
	}
	
	@Override
	public void execute(GameModel mtg, GameView mtgview) 
	{
		if(role==null) 
		{
			mtgview.showError(Messages.SETROLE_ERROR_ROLE);
		}
		Position pos = new Position(row,col);
		if(!mtg.LemmingRoleAssign(pos, role)) {
			mtgview.showError(Messages.SETROLE_ERROR);
		}
		mtgview.showGame();
	}
	public int LetterToNum(String let) 
	{
		return let.charAt(0) - 'A';
	}
	
	@Override
	public  String GetHelp() 
	{
		String help = this.HELP;
		help += LemmingRoleFactory.getHelpRole();
		return help;
	}
}