package tp1.logic;

import tp1.logic.gameobjects.GameItem;

public interface GameWorld {
	public static final int DIM_X = 10;
	public static final int DIM_Y = 10;
	public Boolean isSolid(Position pos);
	public boolean interactionRecieverCaller(GameItem obj) 
}
