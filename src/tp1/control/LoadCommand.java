package tp1.control;

import tp1.exceptions.CommandExecuteException;
import tp1.exceptions.CommandParseException;
import tp1.exceptions.GameLoadException;
import tp1.exceptions.ObjectParseException;
import tp1.exceptions.RoleParseException;
import tp1.logic.GameModel;
import tp1.view.GameView;
import tp1.view.Messages;

public class LoadCommand extends Command{
	public static final String NAME = Messages.COMMAND_LOAD_NAME;
	public static final String SHORTCUT = Messages.COMMAND_LOAD_SHORTCUT;
	public static final String DETAILS = Messages.COMMAND_LOAD_DETAILS;
	public static final String HELP = Messages.COMMAND_LOAD_HELP;
	
	private String fileName;
	public void SetFileName(String FileName) 
	{
		this.fileName=FileName;
	}
	public LoadCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	@Override
	protected void execute(GameModel game, GameView view) throws CommandExecuteException  {
		try 
		{
			game.load(fileName);
			view.showGame();
		}
		catch(GameLoadException e) 
		{
			throw new CommandExecuteException(Messages.COMMADN_EXECUTE_PROBLEM,e);
		}
	}
	@Override
	public Command parse(String[] sa) {
		LoadCommand c= new LoadCommand();
		if(c.matchCommand(sa[0])) 
		{
			c.SetFileName(sa[1]);
			return c;
		}
		return null;
	}

}
