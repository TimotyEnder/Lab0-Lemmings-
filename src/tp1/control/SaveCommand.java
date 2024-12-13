package tp1.control;

import tp1.exceptions.CommandExecuteException;
import tp1.exceptions.CommandParseException;
import tp1.exceptions.GameModelException;
import tp1.logic.GameModel;
import tp1.view.GameView;
import tp1.view.Messages;

public class SaveCommand extends Command{
	public static final String NAME = Messages.COMMAND_SAVE_NAME;
	public static final String SHORTCUT = Messages.COMMAND_SAVE_SHORTCUT;
	public static final String DETAILS = Messages.COMMAND_SAVE_DETAILS;
	public static final String HELP = Messages.COMMAND_SAVE_HELP;
	
	private String fileName;
	
	public SaveCommand() {
		super(NAME, SHORTCUT,DETAILS, HELP);
	}
	@Override
	protected void execute(GameModel game, GameView view) throws CommandExecuteException {
		try 
		{
		    game.save(fileName);
		}
		catch(GameModelException e) 
		{
			throw new CommandExecuteException(Messages.COMMADN_EXECUTE_PROBLEM,e);
		}
	}
	@Override
	public Command parse(String[] sa) throws CommandParseException {
		SaveCommand c= new SaveCommand();
		if(c.matchCommand(sa[0])) 
		{
			c.fileName=(sa[1]);
			return c;
		}
		return null;
	}
}
