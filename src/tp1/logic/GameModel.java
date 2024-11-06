package tp1.logic;

public interface GameModel  {
    public boolean seFinito(boolean exiting);
    public void update();
    public void reset();
    public boolean playerWins();
	public boolean playerLoses();
}
