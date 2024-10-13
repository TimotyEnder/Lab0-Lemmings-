package tp1.logic;

import java.util.Iterator;
import java.util.Vector;

import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;
import tp1.view.Messages;

public class GameObjectContainer {
	//TODO fill your code
	private Vector<Lemming> Lemmings;
	private Vector<Wall> Walls;

	private ExitDoor dor;
	
	public GameObjectContainer() 
	{
		Lemmings = new Vector<Lemming>();
		Walls = new Vector<Wall>();
	}
	public void PrintArrays() 
	{
		for(Lemming i:Lemmings) 
		{
			System.out.println(i.GetPos().col+" " + i.GetPos().row);
		}
		for(Wall j:Walls) 
		{
			System.out.println(j.GetPos().col+" " + j.GetPos().row);
		}
		System.out.println(dor.GetPos().col +" "+ dor.GetPos().row);
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
	
	public String SearchForPos(Position pos) 
	{
		for(Lemming i:Lemmings) 
		{
			if(i.GetPos().Eq(pos)) 
			{
				if(i.isAlive()) 
				{
					if(i.GetDir()==Direction.LEFT) 
					{
						return Messages.LEMMING_LEFT;
					}
					else 
					{
						return Messages.LEMMING_RIGHT;
					}
				}
			}
		}
		for(Wall j:Walls) 
		{
			if(j.GetPos().Eq(pos)) 
			{
				return Messages.WALL;
			}
		}
		if(dor.GetPos().Eq(pos)) 
		{
			return Messages.EXIT_DOOR;
		}
		else 
		{
			return " ";
		}
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
			}
		}
		for(Wall i:Walls) 
		{
			i.update();
		}
	}

	public int numLemmingDead() {
		int dead = 0; 
		
		for(Lemming i: Lemmings) {
			if(!i.isAlive()) {
				dead++;
			}
		}
		
		return dead;
	}
	public int GetExit() 
	{
		return dor.GetExit();
	}
}
