package tp1.files;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import tp1.logic.Position;
import tp1.logic.Direction;
import tp1.logic.GameWorld;
import tp1.logic.LemmingsRole.LemmingRoleFactory;
import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.GameObject;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.MetalWall;
import tp1.logic.gameobjects.Wall;

public class GameObjectFactory {
	
	private Scanner scanner;
	private static final List<GameObject> GAME_OBJECTS = Arrays.asList(
	        new Lemming(null, null, null),
	        new Wall(null, null),
	        new MetalWall(null, null),
	        new ExitDoor(null, null)
	    );
	public GameObject parse(String line, GameWorld game) 
	{
		GameObject go;
		line = scanner.nextLine();
		String[] words = line.trim().split("\\s+");
		go = GetGo(words[1]);
		go.setAlive(true);
		
		go.setPos(getPositionFrom(words[0]));
		if(words.length>2) 
		{
			go.SetDir(getLemmingDirectionFrom(words[2]));
			go.SetFallF(Integer.parseInt(words[3]));
			go.setRole(LemmingRoleFactory.parse(words[4]));
		}
		
		return null;
	}
	
	private static Position getPositionFrom(String line)  
	{
		 String[] parts = line.substring(1, line.length() - 1).split(",");
	     int row = Integer.parseInt(parts[0].trim());
	     int col = Integer.parseInt(parts[1].trim());
	     Position returnPos= new Position(row,col);
		 return returnPos;
	}
	
	private GameObject  GetGo(String line)  
	{
		for(GameObject i: GAME_OBJECTS) 
		{
			if(i.MatchGo(line)) 
			{
				return i;
			}
		}
		return null;   //THROW EXCEPTION HERE LATER
	}
	
	private static Direction getLemmingDirectionFrom(String line)  
	{
		if(line.equalsIgnoreCase("up")) 
		{
			return Direction.UP;
		}
		else if(line.equalsIgnoreCase("down")) 
		{
			return Direction.DOWN;
		}
		else if(line.equalsIgnoreCase("left")) 
		{
			return Direction.LEFT;
		}
		else if(line.equalsIgnoreCase("right")) 
		{
			return Direction.RIGHT;
		}
		else 
		{
			return Direction.NONE;
		}
	}
}
