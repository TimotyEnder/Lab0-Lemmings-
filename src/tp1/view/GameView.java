package tp1.view;

import tp1.logic.Game;

public abstract class GameView {

	protected Game game;
	
	public GameView(Game game) {
		this.game = game;
	}
	
	// show methods
	public abstract void showWelcome();
	public abstract void showGame();
	public abstract void showEndMessage();
	public abstract void showError(String message);
	public abstract void showMessage(String message);

	// get data from view methods
	public abstract String[] getPrompt();
	public final static void clearConsole()
	{
	    try
	    {
	        final String os = System.getProperty("os.name");
	        
	        if (os.contains("Windows"))
	        {
	            Runtime.getRuntime().exec("cls");
	        }
	        else
	        {
	            Runtime.getRuntime().exec("clear");
	        }
	    }
	    catch (final Exception e)
	    {
	        //  Handle any exceptions.
	    }
	}
}
