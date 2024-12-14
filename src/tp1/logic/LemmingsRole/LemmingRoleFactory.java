package tp1.logic.LemmingsRole;

import java.util.Arrays;
import java.util.List;

import tp1.exceptions.RoleParseException;
import tp1.view.Messages;


public class LemmingRoleFactory {
	private static final List<LemmingRole> ROLES = Arrays.asList(
	        new Walker(),
	        new Parachuter(),
	        new DownCaver(),
	        new Drone());
	
	public static LemmingRole parse(String  wordywords,String argumentString) throws RoleParseException{
		LemmingRole lr;
		String[] dirs = new String[1];
		if(argumentString!=null) 
		{
		     dirs = (wordywords+","+argumentString.substring(1, argumentString.length() - 1)).split(",");
		}
		else 
		{
			dirs[0]=wordywords;
		}
		for(LemmingRole lrp : ROLES) {
			lrp=lrp.matchRole(dirs);
			if(lrp!=null){
				
				return lrp;
			}
		}
		throw new RoleParseException(Messages.UNKOWN_ROLE.formatted(wordywords));
	}
	
	public static String getHelpRole() {
		String help = "";
		for(LemmingRole lr : ROLES) {
			help += "\n\t" + lr.getDetails();
		}
		return help;
	}
}

