package tp1.control;

import tp1.logic.Game;
import tp1.view.GameView;
import tp1.view.Messages;

public class UpdateCommand extends NoParamsCommand{
	
	private static final String NAME = Messages.COMMAND_UPDATE_NAME;
	private static final String SHORTCUT = Messages.COMMAND_UPDATE_SHORTCUT;
	private static final String DETAILS = Messages.COMMAND_UPDATE_DETAILS;
	private static final String HELP = Messages.COMMAND_UPDATE_HELP;
	
	public UpdateCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
	protected boolean matchCommand(String c) 
	{
		return c.equalsIgnoreCase(this.GetName()) || c.equalsIgnoreCase(this.GetShortCut()); 
	} 
	public static Command parse(String[] sa) 
	{
		UpdateCommand c= new UpdateCommand();
		if(c.matchCommand(sa[0])) 
		{
			return c;
		}
		else return null;
	}
	
	@Override
	public void execute(Game mtg, GameView mtgview) 
	{
		mtg.update();
		mtgview.showGame();
	}
}
