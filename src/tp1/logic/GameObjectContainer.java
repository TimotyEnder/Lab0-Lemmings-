package tp1.logic;

import java.util.Vector;

import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;
import tp1.view.Messages;

public class GameObjectContainer {
	//TODO fill your code
	private Vector<Lemming> Lemmings = new Vector<Lemming>();
	private Vector<Wall> Walls = new Vector<Wall>();

	private ExitDoor dor= new ExitDoor(new Position(0,0));
	
	private Messages msg= new Messages();
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
			if(i.GetPos()==pos) 
			{
				if(i.GetDir()==Direction.RIGHT) 
				{
					return msg.LEMMING_RIGHT;
				}
				else 
				{
					return msg.LEMMING_LEFT;
				}
			}
		}
		for(Wall j:Walls) 
		{
			if(j.GetPos()==pos) 
			{
				return msg.WALL;
			}
		}
		if(pos==dor.GetPos()) 
		{
			return msg.EXIT_DOOR;
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
			if(i.GetPos()==pos) 
			{
				return true;
			}
		}
		return false;
	}
	public void update() 
	{
		for(Lemming i:Lemmings) 
		{
			i.update();
			if(i.GetPos().equals(dor.GetPos())) 
			{
				dor.Exit();
				Lemmings.remove(i);
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
