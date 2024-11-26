package tp1.exceptions;

public class CommandParseException extends CommandException {
	
	private static final long serialVersionUID = 01;

	public CommandParseException(String commandIncorrectParameterNumber) {
		gv.showError(commandIncorrectParameterNumber);
		
	}

	public CommandParseException(String formatted, NumberFormatException nfe) {
		gv.showError(formatted);
	}

}
