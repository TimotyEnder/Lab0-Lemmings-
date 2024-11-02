package tp1.logic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import tp1.logic.gameobjects.GameObject;
//import tp1.logic.gameobjects.Lemming;
//import tp1.logic.gameobjects.Wall;
import tp1.view.Messages;

public class GameObjectContainer {
	//private Vector<Lemming> Lemmings;
	//private Vector<Wall> Walls;
	//private Boolean LemmingDied=false;
	//private ExitDoor dor;
	
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
	
	public void update() 
	{
		for(GameObject i:gameObjects) 
		{
			i.update();
		}
	}

	public int numLemmingDead() {
		int dead = 0; 
		
		for(GameObject i : gameObjects)
		{
			if(!i.isAlive() && !i.isSolid()){
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
	/*
	public GameObjectContainer() 
	{
		Lemmings = new Vector<Lemming>();
		Walls = new Vector<Wall>();
	}
	public void add(Lemming lemming) 
	{
		Lemmings.add(lemming);
	}
	
	public void add(Wall wall) 
	{
		Walls.add(wall);
	}
	
	public void add(ExitDoor exitDoor) 
	{
		 dor= exitDoor;
	}
	// get from toString() of object
	public String SearchForPos(Position pos) 
	{
		String obj = "";
		for(Lemming i:Lemmings) 
		{
			if(i.GetPos().Eq(pos)) 
			{
				obj+= i.toString();
			}
		}
		for(Wall j:Walls) 
		{
			if(j.GetPos().Eq(pos)) 
			{
				obj+= j.toString();
			}
		}
		if(dor.GetPos().Eq(pos)) 
		{
			obj+= dor.toString();
		}
		else 
		{
			obj+= " ";
		}
		return obj;
	}
	public Boolean isWall(Position pos) 
	{
		for(Wall i: Walls) 
		{
			if(i.GetPos().Eq(pos)) 
			{
				return true;
			}
		}
		return false;
	}
	public void update() 
	{
		Vector<Lemming> LemmingsDel;
		for(Iterator<Lemming> iterator = Lemmings.iterator(); iterator.hasNext();) 
		{
			Lemming LemmingIT=iterator.next();
			LemmingIT.update();
			if(LemmingIT.GetPos().Eq(dor.GetPos())) 
			{
				dor.Exit();
				iterator.remove();
				LemmingDied=true;
			}
		}
		for(Wall i:Walls) 
		{
			i.update();
		}
	}

	public int numLemmingDead() {
		int dead = 0; 
		
		if(LemmingDied){
			LemmingDied=false;
			for(Lemming i: Lemmings) {
				if(!i.isAlive()) 
				{
					dead++;
				}
			}
		}
		
		return dead;
	}
	public int GetExit() 
	{
		return dor.GetExit();
	}
	*/
}
