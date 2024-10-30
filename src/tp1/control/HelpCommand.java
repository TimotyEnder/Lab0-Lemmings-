package tp1.control;

import tp1.logic.Game;
import tp1.view.GameView;
import tp1.view.Messages;

public class HelpCommand extends NoParamsCommand{
	private Messages msg;			
	private static final String NAME = Messages.COMMAND_HELP_NAME;
	private static final String SHORTCUT = Messages.COMMAND_HELP_SHORTCUT;
	private static final String DETAILS = Messages.COMMAND_HELP_DETAILS;
	private static final String HELP = Messages.COMMAND_HELP_HELP;

	public HelpCommand(){
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	protected  boolean matchCommand(String c) 
	{
		return c.equalsIgnoreCase(this.GetName()) || c.equalsIgnoreCase(this.GetShortCut()); 
	} 
	public Command parse(String[] sa) 
	{
		HelpCommand c= new HelpCommand();
		if(c.matchCommand(sa[0])) 
		{
			return c;
		}
		else return null;
	}
	@Override
	public void execute(Game mtg, GameView mtgview) 
	{
		System.out.println(CommandGenerator.commandHelp());
	}
	public String helpText() {
		String s ;
		for(String i: msg.HELP_LINES) 
		{
			s += i;
		}
		return s;
	}
}
