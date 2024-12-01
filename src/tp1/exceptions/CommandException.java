package tp1.exceptions;


public class CommandException extends Throwable {
	public CommandException(String message) {
		super(message);
	}
	
	public CommandException(String message, Throwable cause) {
		super(message,cause);
	}
	private static final long serialVersionUID = 00;
}
