package tp1.exceptions;

public class GameParseException extends Exception {

	public GameParseException(String message) 
	{
		super(message);
	}
	public GameParseException(String message, Throwable cause) {
		super(message,cause);
	}

}
