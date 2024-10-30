package tp1.control;

public abstract class NoParamsCommand extends Command{

	public NoParamsCommand(String name, String sc, String d, String h) {
		super(name, sc, d, h);
	}
	
	public abstract Command parse(String[] wordywords);
}
