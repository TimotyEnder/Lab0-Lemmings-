package tp1.control;

import tp1.exceptions.CommandParseException;
import tp1.logic.GameModel;
import tp1.view.GameView;
import tp1.view.Messages;

public class FastCommand extends Command{
	
	private static final String NAME = Messages.COMMAND_FAST_NAME;
	private static final String SHORTCUT = Messages.COMMAND_FAST_SHORTCUT;
	private static final String DETAILS = Messages.COMMAND_FAST_DETAILS;
	private static final String HELP = Messages.COMMAND_FAST_HELP;
	private int numCycles = 1;
	
	public FastCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
	@Override
	public void execute(GameModel mtg, GameView mtgview) 
	{
		for(int i = 0; i < numCycles; ++i) {
			mtg.update();
			mtgview.showGame();
		}
	}

	@Override
	public Command parse(String[] sa) throws CommandParseException {
		try {
			FastCommand f = new FastCommand();
			if(f.matchCommand(sa[0])) {
				if(sa.length == 2) {
					f.numCycles = (Integer.parseInt(sa[1]));
					return f;
				}
				else {
					throw new CommandParseException(Messages.INVALID_COMMAND_PARAMETERS); 
				}
			}
			else {
				return null;
			}
		}
		catch(Exception e){
			throw new CommandParseException(Messages.INVALID_COMMAND_PARAMETERS);
		}
	}
}
