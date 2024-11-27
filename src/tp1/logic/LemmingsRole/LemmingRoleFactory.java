package tp1.logic.LemmingsRole;

import java.util.Arrays;
import java.util.List;

import tp1.exceptions.CommandParseException;
import tp1.view.Messages;


public class LemmingRoleFactory {
	private static final List<LemmingRole> ROLES = Arrays.asList(
	        new Walker(),
	        new Parachuter(),
	        new DownCaver());
	
	public static LemmingRole parse(String  wordywords) throws CommandParseException{
		LemmingRole lr=null;
		for(LemmingRole lrp : ROLES) {
			if(lrp.matchRole(wordywords)){
				return lrp;
			}
		}
		throw new CommandParseException(Messages.UNKOWN_ROLE);
	}
	
	public static String getHelpRole() {
		String help = "";
		for(LemmingRole lr : ROLES) {
			help += "\n\t" + lr.getDetails();
		}
		return help;
	}
}

