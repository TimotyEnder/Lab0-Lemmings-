package tp1.control;

public class CommandGenerator {
	public static Command parse(String [] wordywords)
	{
		Command c=HelpCommand.parse(wordywords);
		if(c==null) 
		{
			c=ExitCommand.parse(wordywords);
		}
		return c;
	}
}
