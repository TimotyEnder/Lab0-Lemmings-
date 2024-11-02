package tp1.control;

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
	
		    String[] userWords = view.getPrompt();
		    Command command = CommandGenerator.parse(userWords);
	
		    if (command != null) 
		        command.execute(game, view);
		    else 
		        view.showError(Messages.UNKNOWN_COMMAND);
		}
		view.showEndMessage();
	}
}
