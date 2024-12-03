package tp1.files;


import tp1.logic.Position;
import tp1.exceptions.CommandParseException;
import tp1.exceptions.ObjectParseException;
import tp1.exceptions.OffBoardException;
import tp1.exceptions.RoleParseException;
import tp1.logic.Direction;
import tp1.logic.Game;
import tp1.logic.GameWorld;
import tp1.logic.LemmingsRole.LemmingRoleFactory;
import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.GameObject;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.MetalWall;
import tp1.logic.gameobjects.Wall;
import tp1.view.Messages;

public class GameObjectFactory {
	
	public GameObject parse(String line, GameWorld game) throws RoleParseException, OffBoardException, ObjectParseException
	{
		GameObject go;
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
		else 
		{
			go.SetDir(Direction.NONE);
		}
		go.SetGame(game);
		
		return  go;
	}
	
	private static Position getPositionFrom(String line) throws OffBoardException  
	{
		 String[] parts = line.substring(1, line.length() - 1).split(",");
	     int row = Integer.parseInt(parts[0].trim());
	     int col = Integer.parseInt(parts[1].trim());
	     Position returnPos= new Position(col,row);
	     if(returnPos.GetCol()<0 || returnPos.GetCol()>Game.DIM_X || returnPos.GetRow()<0 || returnPos.GetRow()>Game.DIM_X) 
			{
				throw new OffBoardException("Position ("+returnPos.GetCol()+","+returnPos.GetRow()+") off the board");	
			}
		 return returnPos;
	}
	
	private GameObject  GetGo(String line) throws ObjectParseException  
	{
		GameObject go = null;
		if(line.equalsIgnoreCase("lemming")||line.equalsIgnoreCase("l")) 
		{
			go= new Lemming(null,null,null);
			return go;
		}
		else if(line.equalsIgnoreCase("exitdoor")||line.equalsIgnoreCase("ED")) 
		{
			go= new ExitDoor(null,null);
			return go;
		}
		else if(line.equalsIgnoreCase("wall")||line.equalsIgnoreCase("w")) 
		{
			go= new Wall(null,null);
			return go;
		}
		else if(line.equalsIgnoreCase("metalwall")||line.equalsIgnoreCase("mw")) 
		{
			go= new MetalWall(null,null);
			return go;
		}
		throw new ObjectParseException(Messages.INVALID_OBJECT.formatted(line));
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
