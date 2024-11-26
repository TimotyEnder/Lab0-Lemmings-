package tp1.control;

import tp1.exceptions.*;
import tp1.logic.GameModel;
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
	protected boolean matchCommand(String c) 
	{
		return c.equalsIgnoreCase(this.GetName()) || c.equalsIgnoreCase(this.GetShortCut()); 
	} 
	protected abstract void execute(GameModel game, GameView view)throws CommandExecuteException;
	protected abstract Command parse(String[] sa) throws CommandParseException;
}
