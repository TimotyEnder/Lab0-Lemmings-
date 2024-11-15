package tp1.logic.LemmingsRole;

import java.util.Arrays;
import java.util.List;


public class LemmingRoleFactory {
	private static final List<LemmingRole> ROLES = Arrays.asList(
	        new Walker(),
	        new Parachuter());
	
	public static LemmingRole parse(String  wordywords) {
		LemmingRole lr = null;
		for(LemmingRole lrp : ROLES) {
			lrp = lrp.parse(wordywords);
			if(lrp != null){
				lr = lrp;
			}
		}
		return lr;
	}
	
	public static String getHelpRole() {
		String help = "";
		for(LemmingRole lr : ROLES) {
			help += "\n\t" + lr.getDetails();
		}
		return help;
	}
}

