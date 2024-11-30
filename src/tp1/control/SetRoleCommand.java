package tp1.control;


import tp1.logic.GameModel;
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
	public SetRoleCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	public  void setRole(LemmingRole lr ) 
	{
		this.role=lr;
	}
	public void setCol(int col) 
	{
		this.col=col;
	}
	public void setRow(int row) 
	{
		this.row=row;
	}
	public Command parse(String[] sa) throws CommandParseException 
	{
		try
		{
			SetRoleCommand c= new SetRoleCommand();
		
		if(c.matchCommand(sa[0])) 
		{
			c.setRole(LemmingRoleFactory.parse(sa[1]));
			c.setCol(LetterToNum(sa[2].toUpperCase()));
			c.setRow(Integer.parseInt(sa[3])-1);
			return c;
		}
		else return null;
		}
		catch (NumberFormatException nfe) {
			throw new CommandParseException(Messages.INVALID_POSITION.formatted(Messages.POSITION.formatted(row, col)), nfe);
		}
	}
	
	@Override
	public void execute(GameModel mtg, GameView mtgview) throws OffBoardException, CommandExecuteException 
	{
		Position pos = new Position(row,col);
		mtg.LemmingRoleAssign(pos, role);
		mtg.update();
		mtgview.showGame();
	}
	public int LetterToNum(String let) 
	{
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