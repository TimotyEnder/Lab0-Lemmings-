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
	
	public static Command parse(String [] wordywords) {
		Command c = null;
		for(Command d : AVAILABLE_COMMANDS) {
			d = ((NoParamsCommand) d).parse(wordywords);
			if(d != null){
				c = d;
			}
		}
		return c;
	}
	
	public static String commandHelp() {
		String s = "";
		for(Command c: AVAILABLE_COMMANDS) {
			s += c.GetDetails() + " :" + c.GetHelp() + "\n";
		}
		return s;
	}
}
