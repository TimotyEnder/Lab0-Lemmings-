package tp1.control;

import tp1.logic.GameModel;
import tp1.view.GameView;
import tp1.view.Messages;

public class NoneCommand extends NoParamsCommand{
	private static final String NAME = Messages.COMMAND_NONE_NAME;
	private static final String SHORTCUT = Messages.COMMAND_NONE_SHORTCUT;
	private static final String DETAILS = Messages.COMMAND_NONE_DETAILS;
	private static final String HELP = Messages.COMMAND_NONE_HELP;
	
	public NoneCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	@Override
	public void execute(GameModel mtg, GameView mtgview) 
	{
		//mtg.update();
		mtgview.showGame();
	}
}
