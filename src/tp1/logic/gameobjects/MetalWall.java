package tp1.logic.gameobjects;

import tp1.logic.Direction;
import tp1.logic.GameWorld;
import tp1.logic.Position;
import tp1.logic.LemmingsRole.LemmingRole;
import tp1.view.Messages;

public class MetalWall extends GameObject {

	public MetalWall(GameWorld game,Position pos) 
	{
		this.game=game;
		this.pos=pos;
	}
	@Override
	public String toString() 
	{
		return Messages.METALWALL;
	}
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
		return pos.Eq(pos);
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
	@Override
	public Direction GetDir() {
		return Direction.NONE;
	}
	@Override
	public boolean hasExited() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public GameItem Clone() {
		GameItem clone= new MetalWall(this.game,this.pos);
		clone.setAlive(this.alive);
		return clone;
	}
	@Override
	public void setPrevDir(Direction dir) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String stringify() {
		String out="";
		out+= "("+this.pos.GetRow()+","+this.pos.GetCol()+")"+" MetalWall"+"\n";
		return out;
	}

}
