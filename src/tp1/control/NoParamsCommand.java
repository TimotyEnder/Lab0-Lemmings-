package tp1.control;

public abstract class NoParamsCommand extends Command{

	public NoParamsCommand(String name, String sc, String d, String h) {
		super(name, sc, d, h);
	}
	
	public Command parse(String[] sa) 
	{
		if(sa.length == 1  && matchCommand(sa[0])) 
		{
			return this;
		}
		else return null;
	}
}
