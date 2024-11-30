package tp1.files;

import tp1.logic.GameObjectContainer;

public interface GameConfiguration {
	 // game status
	   public int getCycle();
	   public int numLemmingsInBoard();
	   public int numLemmingsDead();
	   public int numLemingsExit();
	   public int numLemmingToWin();
	   // game objects
	   public GameObjectContainer getGameObjects();
}
