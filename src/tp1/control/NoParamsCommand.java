package tp1.control;

import tp1.view.Messages;
import tp1.exceptions.*;
public abstract class NoParamsCommand extends Command{

	public NoParamsCommand(String name, String sc, String d, String h) {
		super(name, sc, d, h);
	}
	
	public Command parse(String[] sa) throws CommandParseException 
	{
		if (sa.length < 1 || !matchCommand(sa[0])) 
		{
		      return null;
		}
		            
		if (sa.length == 1 && matchCommand(sa[0])) 
		{
		      return this;
		}
		throw new CommandParseException(Messages.COMMAND_INCORRECT_PARAMETER_NUMBER);
	}
}
