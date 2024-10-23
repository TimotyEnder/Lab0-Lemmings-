package tp1.control;

import tp1.logic.Game;
import tp1.view.GameView;
import tp1.view.Messages;

public class HelpCommand extends NoParamsCommand{
	private Messages msg;
	public HelpCommand(String name, String sc, String d, String h) {
		super(name, sc, d, h);
		// TODO Auto-generated constructor stub
	}

	protected  boolean matchCommand(String c) 
	{
		return c.equalsIgnoreCase(this.GetName()) || c.equalsIgnoreCase(this.GetShortCut()); 
	} 
	public static  Command parse(String[] sa) 
	{
		HelpCommand c= new HelpCommand("help","h", "Helps","Help");
		if(c.matchCommand(sa[0])) 
		{
			return c;
		}
		else return null;
	}
	@Override
	public void execute(Game mtg, GameView mtgview) 
	{
		for(String i: msg.HELP_LINES) 
		{
			System.out.println(i);
		}
	}
}
