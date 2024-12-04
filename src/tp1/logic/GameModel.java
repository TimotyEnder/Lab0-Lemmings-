package tp1.logic;


import tp1.exceptions.CommandExecuteException;
import tp1.exceptions.GameLoadException;
import tp1.exceptions.GameModelException;
import tp1.exceptions.OffBoardException;
import tp1.logic.LemmingsRole.LemmingRole;

public interface GameModel  {
    public boolean seFinito(boolean exiting);
    public void update();
    public void reset(int lvl);
    public boolean LemmingRoleAssign(Position pos, LemmingRole lr) throws OffBoardException, CommandExecuteException;
	public void load(String fileName) throws GameLoadException;
	public void save(String fileName) throws GameModelException;
}
