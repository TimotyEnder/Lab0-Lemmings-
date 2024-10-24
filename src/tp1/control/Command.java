package tp1.control;

import tp1.logic.Game;
import tp1.view.GameView;

public abstract class Command {
	private String name, shortcut,details,help;
	public Command(String name,String sc, String d, String h ) 
	{
		this.name=name;
		this.shortcut=sc; 
		this.details= d;
		this.help=h;
	}
	public  String GetName() 
	{
		return name;
	}
	public  String GetShortCut() 
	{
		return shortcut;
	}
	public  String GetDetails() 
	{
		return details;
	}
	public  String GetHelp() 
	{
		return help;
	}
	protected abstract void execute(Game game, GameView view);
}
