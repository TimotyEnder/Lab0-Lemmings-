package tp1.control;

import tp1.logic.GameModel;
import tp1.view.GameView;
import tp1.view.Messages;

public class ExitCommand extends NoParamsCommand{
	private static final String NAME = Messages.COMMAND_EXIT_NAME;
	private static final String SHORTCUT = Messages.COMMAND_EXIT_SHORTCUT;
	private static final String DETAILS = Messages.COMMAND_EXIT_DETAILS;
	private static final String HELP = Messages.COMMAND_EXIT_HELP;

	public ExitCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

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
	@Override
	public void execute(GameModel mtg, GameView mtgview) 
	{
		mtg.seFinito(true);
	}
}
