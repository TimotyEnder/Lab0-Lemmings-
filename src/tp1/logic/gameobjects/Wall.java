package tp1.logic.gameobjects;

import tp1.logic.Direction;
import tp1.logic.Game;
import tp1.logic.Position;
import tp1.logic.LemmingsRole.LemmingRole;
import tp1.view.Messages;
public class Wall extends GameObject
{
	public boolean isSolid() {
		return isAlive()? true:false;
	}
	public boolean isExit() {
		return false;
	}
 	public Wall( Game game, Position pos) 
	{
 		this.name="Wall";
		this.shortcut="W";
 		alive=true;
		setPos(pos);
	}
	public String toString() 
	{
		if(alive) 
		{
			return Messages.WALL;
		}
		return "";
	}
	@Override
	public boolean setRole(LemmingRole lr) {
		return false;
	}
	@Override
	public boolean receiveInteraction(GameItem other) {
		return other.interactWith(this);
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
		return pos.Eq(pos);
	}
	@Override
	public boolean isSoft() {
		return true;
	}
	@Override
	public Direction GetDir() {
		return Direction.NONE;
	}
	@Override
	public boolean hasExited() {
		// TODO Auto-generated method stub
		return false;
	}
}
