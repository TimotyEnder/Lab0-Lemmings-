package tp1.control;


import tp1.logic.GameModel;

import java.util.ArrayList;

import tp1.exceptions.*;
import tp1.logic.Position;
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
	private int col;
	private int row;
	private LemmingRole role;
	private ArrayList<String> directions = new ArrayList<String>();
	public SetRoleCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	public Command parse(String[] sa) throws CommandParseException 
	{
		try
		{
			SetRoleCommand c= new SetRoleCommand();
			
			if(c.matchCommand(sa[0])) 
			{
				try {
					c.role=(LemmingRoleFactory.parse(sa[1]));
					c.col=(LetterToNum(sa[2].toUpperCase()));
					c.row=(Integer.parseInt(sa[3])-1);
					if(sa.length>4) 
					{
						for(int i = 4; i <  sa.length; ++i) {
							c.directions.add(sa[i]);
						}
					}
				} catch (RoleParseException e) {
					throw new CommandParseException(Messages.INVALID_COMMAND_PARAMETERS,e);
				}
				catch (Exception e) {
					throw new CommandParseException(Messages.INVALID_COMMAND_PARAMETERS);
				}
				return c;
			}
			else
			{
				return null;
			}
		}
		catch (NumberFormatException nfe) {
		throw new CommandParseException(Messages.INVALID_POSITION.formatted
			(Messages.POSITION.formatted(row, col)), nfe);
	 }
	}
	
	@Override
	public void execute(GameModel mtg, GameView mtgview) throws  CommandExecuteException 
	{
			Position pos = new Position(row,col);
			try 
			{
				role.setDirStr(directions);
				mtg.LemmingRoleAssign(pos, role);
			}
			catch (OffBoardException e) 
			{
				throw new CommandExecuteException(Messages.COMMADN_EXECUTE_PROBLEM,e);
			}
			mtg.update();
			mtgview.showGame();
	}
	public int LetterToNum(String let)
	{
		// Check if the character is an uppercase letter
	    char ch = let.charAt(0);
	    if (ch < 'A' || ch > 'Z') {
	        throw new NumberFormatException();
	    }
		return let.charAt(0) - 'A';
	}
	
	@Override
	public  String GetHelp() 
	{
		String help = HELP;
		help += LemmingRoleFactory.getHelpRole();
		return help;
	}
}