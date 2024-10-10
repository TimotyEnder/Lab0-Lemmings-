package tp1.control;

import tp1.logic.Game;
import tp1.view.GameView;
import tp1.view.Messages;

/**
 *  Accepts user input and coordinates the game execution logic
 */
public class Controller {

	private Game game;
	private GameView view;
	private Messages msg;
	public Controller(Game game, GameView view) {
		this.game = game;
		this.view = view;
	}


	/**
	 * Runs the game logic, coordinate Model(game) and View(view)
	 * 
	 */
	public void run() {
		int state=-1; // 0 continue/ 1 end/ 2 reset	
		view.showWelcome();
		view.showGame();
		while(state<=0 && (!game.playerWins() || !game.playerLooses())) {
			String[] ans;
			GameView.clearConsole();
			ans=view.getPrompt();
			switch(ans[0].toLowerCase()) {
			case "h":
				state=-1;
				for(String i: msg.HELP_LINES) 
				{
					System.out.println(i);
				}
				break;
			case"r":
				state=2;
				break;
			case "e":
				state=1;
				break;
			case "n": 
				state=0;
				break;
			default:
				view.showError(msg.INVALID_COMMAND);
				state=-1;
				break;
			}
			if(state==2) 
			{
				state = 0;
				game.Reset();
				view.showWelcome();
				view.showGame();
			}
			else if(state==0) 
			{
				game.update();	
				view.showGame();
			}
		}
		view.showEndMessage();
	}
}
