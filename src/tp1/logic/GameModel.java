package tp1.logic;

import tp1.exceptions.OffBoardException;
import tp1.logic.LemmingsRole.LemmingRole;

public interface GameModel  {
    public boolean seFinito(boolean exiting);
    public void update();
    public void reset(int lvl);
    public boolean LemmingRoleAssign(Position pos, LemmingRole lr) throws OffBoardException;
}
