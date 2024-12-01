package tp1.logic.gameobjects;

import tp1.logic.Direction;
import tp1.logic.Position;
import tp1.logic.LemmingsRole.LemmingRole;

public interface GameItem {
	public boolean receiveInteraction(GameItem other);

	public boolean interactWith(Lemming lemming);
	public boolean interactWith(Wall wall);
	public boolean interactWith(ExitDoor door);

	public boolean isSolid();
	public boolean isAlive();
	public boolean isExit();
	public boolean isInPosition(Position pos);

	public Position GetPos();

	public boolean setRole(LemmingRole lr);

	public void update();

	public int GetExit();

	public Direction GetDir();
	
	public boolean hasExited();

	public boolean isSoft();
	
	public void SetExit(int ExitNum);
}