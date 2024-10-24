package tp1.control;

public abstract class NoParamsCommand extends Command{

	public NoParamsCommand(String name, String sc, String d, String h) {
		super(name, sc, d, h);
	}
	//command parse should be here (and inherited by all other classes)
}
