package tp1.control;

import tp1.logic.GameModel;
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
	@Override
	public void execute(GameModel mtg, GameView mtgview) 
	{
		System.out.println(CommandGenerator.commandHelp());
	}
	
	//We shall delete this (the CommandGenerator creates the same thing from each instruction (which seems more legal)
	public String helpText() {
		String s = "";
		for(String i: msg.HELP_LINES) 
		{
			s += i;
		}
		return s;
	}
}
