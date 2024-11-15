package tp1.logic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import tp1.logic.LemmingsRole.LemmingRole;
import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.GameObject;
import tp1.logic.gameobjects.Lemming;
//import tp1.logic.gameobjects.Wall;
import tp1.view.Messages;

public class GameObjectContainer {
	
	 private List<GameObject> gameObjects;

	public GameObjectContainer() {
		gameObjects = new ArrayList<>();
	}
	
	public void add(GameObject object) 
	{
		gameObjects.add(object);
	}
	
	public String SearchForPos(Position pos) 
	{
		String obj = "";
		for(GameObject i:gameObjects) 
		{
			if(i.GetPos().Eq(pos)) 
			{
				obj += i.toString();
			}
		}
		return obj;
	}
	
	public boolean isSolid(Position pos) 
	{
		for(GameObject i: gameObjects) 
		{
			if(i.GetPos().Eq(pos) && i.isSolid()) 
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean LemmingRoleAssigner(Position pos, LemmingRole lr) 
	{
		for(GameObject i: gameObjects) 
		{
			if(i.GetPos().Eq(pos) && !i.isSolid() && !i.isExit()) 
			{
				 return i.setRole(lr);
			}
		}
		return false;
	}
	
	public void update() {
		GameObject d = null;
        for(GameObject i : gameObjects)
        {
            if(i.isExit()){
                d = i;
            }
        }

        for (Iterator<GameObject> iterator = gameObjects.iterator(); iterator.hasNext();) {
        {
            GameObject goIt= iterator.next();

            if(!goIt.isExit()&& d.GetPos().Eq(goIt.GetPos())) 
            {
                ((ExitDoor) d).Exit();
                iterator.remove();
            }
            else
            {
                goIt.update();
            }
        }
     }
}


	public int numLemmingDead() {
		int dead = 0; 
		
		for(GameObject i : gameObjects)
		{
			if(!i.isAlive() && !i.isSolid() && !i.isExit()){
				dead++;
			}
		}
		
		return dead;
	}
	
	public int GetExit() 
	{
		int c = -1;
		for(GameObject i : gameObjects)
		{
			if(i.isExit()){
				c = i.GetExit();
			}
		}
		return c;
	}
	//R.I.P here lies Lemmings 1.0 code. It served us well. Farewell, friend.
}
