package tp1.logic;

import java.util.Vector;

import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;

public class GameObjectContainer {
	//TODO fill your code
	private Vector<Lemming> Lemmings = new Vector<Lemming>();
	private Vector<Wall> Walls = new Vector<Wall>();
	private ExitDoor dor;
	
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
				return "l";
			}
		}
		for(Wall j:Walls) 
		{
			if(j.GetPos()==pos) 
			{
				return "w";
			}
		}
		return "n";
	}
	
	public void update() 
	{
		for(Lemming i:Lemmings) 
		{
			i.update();
		}
		for(Wall i:Walls) 
		{
			i.update();
		}
	}
}
