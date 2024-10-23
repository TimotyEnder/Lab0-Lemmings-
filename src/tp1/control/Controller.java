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


	// add reset option after loss or win
	/*public void run() {
		int state=-1; // 0 continue/ 1 end/ 2 reset	
		view.showWelcome();
		view.showGame();
		while(state<=0 && (game.seFinito(false))) {
			String[] ans;
			GameView.clearConsole();
			ans=view.getPrompt();
			switch(ans[0].toLowerCase()) {
			case "h":
			case"help":
				state=-1;
				for(String i: msg.HELP_LINES) 
				{
					System.out.println(i);
				}
				break;
			case"r":
			case"reset":
				state=2;
				break;
			case "e":
			case "exit":
				state=1;
				break;
			case "n": 
			case "none":
			case"":
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
	}*/
public void run() {
		while (!game.seFinito(false)) {
	
		    String[] userWords = view.getPrompt();
		    Command command = CommandGenerator.parse(userWords);
	
		    if (command != null) 
		        command.execute(game, view);
		    else 
		        view.showError(Messages.UNKNOWN_COMMAND);
		}
	}
}
