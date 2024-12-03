package tp1.exceptions;

public class GameModelException extends CommandException{

	private static final long serialVersionUID = 1L;

	public GameModelException(String message) {
		super(message);
	}
	
	public GameModelException(String message, Throwable e) {
		super(message,e);
	}
}
