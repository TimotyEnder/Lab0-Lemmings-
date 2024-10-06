package tp1.control;

import tp1.logic.Game;
import tp1.view.GameView;

/**
 *  Accepts user input and coordinates the game execution logic
 */
public class Controller {

	private Game game;
	private GameView view;

	public Controller(Game game, GameView view) {
		this.game = game;
		this.view = view;
	}


	/**
	 * Runs the game logic, coordinate Model(game) and View(view)
	 * 
	 */
	public void run() {
		view.showWelcome();
		//TODO fill your code: The main loop that displays the game, asks the user for input, and executes the action.
		
		while(!game.playerWins() || !game.playerLooses()) {
			//Request orders from user
			game.update();															//Updates state of game
			view.showGame(); 														//Show updated game
			System.out.println("The number of cycles is " + game.getCycle());		//Shows the number of turns the player has
		}
		
		view.showEndMessage();
	}

}
