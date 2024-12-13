package tp1.control;


import tp1.exceptions.CommandException;
import tp1.exceptions.CommandExecuteException;
import tp1.exceptions.CommandParseException;
import tp1.exceptions.GameModelException;
import tp1.exceptions.OffBoardException;
import tp1.logic.Game;
import tp1.logic.GameModel;
import tp1.view.GameView;
import tp1.view.Messages;

/**
 *  Accepts user input and coordinates the game execution logic
 */
public class Controller {

	private GameModel game;
	private GameView view;
	public Controller(GameModel game, GameView view) {
		this.game = game;
		this.view = view;
	}
	
public void run() {
		while (!game.seFinito(false)) {
		    try {
		    	String[] userWords = view.getPrompt();
			    Command command = CommandGenerator.parse(userWords);
		
			    if (command != null) 
			        command.execute(game, view);
			    else 
			        view.showError(Messages.UNKNOWN_COMMAND);
		    }
		    catch( CommandException e) 
		    {
		    	view.showError(e.getMessage());
                Throwable wrapped = e;
                while ( (wrapped = wrapped.getCause()) != null )
                    view.showError(wrapped.getMessage());
		    }
		}
		view.showEndMessage();
		
	}
}
