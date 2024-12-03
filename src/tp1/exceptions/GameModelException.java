package tp1.exceptions;

public class GameModelException extends Exception{


	public GameModelException(String message) {
		super(message);
	}
	
	public GameModelException(String message, Throwable e) {
		super(message,e);
	}
}
