package tp1.logic.gameobjects;

import tp1.logic.Position;
import tp1.logic.LemmingsRole.LemmingRole;

public class MetalWall extends GameObject {

	@Override
	public boolean receiveInteraction(GameItem other) {
		return false;
	}

	@Override
	public boolean interactWith(Lemming lemming) {
		return false;
	}

	@Override
	public boolean interactWith(Wall wall) {
		return false;
	}

	@Override
	public boolean interactWith(ExitDoor door) {
		return false;
	}

	@Override
	public boolean isInPosition(Position pos) {
		return false;
	}

	@Override
	public boolean isSolid() {
		return true;
	}

	@Override
	public boolean isExit() {
		return false;
	}

	@Override
	public boolean setRole(LemmingRole lr) {
		return false;
	}

	@Override
	public boolean isSoft() {
		return false;
	}

}
