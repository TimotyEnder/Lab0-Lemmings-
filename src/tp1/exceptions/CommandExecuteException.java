package tp1.exceptions;

public class CommandExecuteException extends CommandException{
	public CommandExecuteException(String message) {
		super(message);
	}
	public CommandExecuteException() 
	{
		super("Command execute problem");
	}

	private static final long serialVersionUID = 02;

}
