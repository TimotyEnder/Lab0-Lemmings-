package tp1.control;

import java.util.Arrays;
import java.util.List;

import tp1.view.Messages;

public class CommandGenerator {
	
	private static final List<Command> AVAILABLE_COMMANDS = Arrays.asList(
	        new UpdateCommand(),
	        new ResetCommand(),
	        new HelpCommand(),
	        new ExitCommand(),
	        new NoneCommand()
	    );
	
	public static Command parse(String [] wordywords)
	{
		/*
		Command c=HelpCommand.parse(wordywords);
		if(c==null) 
		{
			c=ExitCommand.parse(wordywords);
		}
		
		return c;
		*/
		
		//I have to fix this
		Command c = null;
		c = parse(wordywords);
		return c;
	}
	
	public static String commandHelp() {
		//I am still figuring out how the hell I do this function.
		for(Command c: AVAILABLE_COMMANDS) {
			c.GetHelp();
		}
		return null;
	}
}
