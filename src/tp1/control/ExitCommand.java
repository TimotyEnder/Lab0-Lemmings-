package tp1.control;

import tp1.logic.Game;
import tp1.view.GameView;

public class ExitCommand extends NoParamsCommand{
	public ExitCommand(String name, String sc, String d, String h) {
		super(name, sc, d, h);
		// TODO Auto-generated constructor stub
	}

	protected boolean matchCommand(String c) 
	{
		return c.equalsIgnoreCase(this.GetName()) || c.equalsIgnoreCase(this.GetShortCut()); 
	} 
	public static Command parse(String[] sa) 
	{
		ExitCommand c= new ExitCommand("exit","e","Exits","Exit");
		if(c.matchCommand(sa[0])) 
		{
			return c;
		}
		else return null;
	}
	@Override
	public void execute(Game mtg, GameView mtgview) 
	{
		mtg.seFinito(true);
	}
}
