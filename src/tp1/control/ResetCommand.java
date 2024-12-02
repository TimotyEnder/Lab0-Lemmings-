package tp1.control;

import tp1.logic.Game;
import tp1.logic.GameModel;
import tp1.view.GameView;
import tp1.view.Messages;

public class ResetCommand extends Command{
	
	private static final String NAME = Messages.COMMAND_RESET_NAME;
	private static final String SHORTCUT = Messages.COMMAND_RESET_SHORTCUT;
	private static final String DETAILS = Messages.COMMAND_RESET_DETAILS;
	private static final String HELP = Messages.COMMAND_RESET_HELP;
	
	private int level=-1;
	public ResetCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
	@Override
	protected void execute(GameModel game, GameView view) {
		if(level>0 && level<= Game.MaxLevels)
		{
			game.reset(level);
			view.showGame();
		}
		else if(level ==-1) 
		{
			game.reset(level);
			view.showGame();
		}
		else 
		{
			view.showError(Messages.LEVEL_INVALID);
		}
	}
	public void setLevel(int lvl) 
	{
		this.level=lvl;
	}
	@Override
	protected Command parse(String[] sa) {
		ResetCommand c= new ResetCommand();
		if(c.matchCommand(sa[0])) 
		{
			if(sa.length>1) 
			{
				c.setLevel(Integer.parseInt(sa[1]));
			}
			return c;
		}
		return null;
	}

}
