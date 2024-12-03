package tp1.exceptions;

public class CommandParseException extends CommandException {
	

	public CommandParseException(String message) {
		super(message);
	}

	public CommandParseException(String message, Throwable nfe) {
		super(message, nfe);
	}

}
