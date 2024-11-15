package tp1.logic;

import tp1.logic.LemmingsRole.LemmingRole;

public interface GameModel  {
    public boolean seFinito(boolean exiting);
    public void update();
    public void reset();
    public void LemmingRoleAssign(Position pos, LemmingRole lr);
}
