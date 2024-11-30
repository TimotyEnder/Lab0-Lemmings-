package tp1.logic;
import tp1.exceptions.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import tp1.logic.LemmingsRole.LemmingRole;
import tp1.logic.gameobjects.GameItem;
import tp1.logic.gameobjects.GameObject;

public class GameObjectContainer {
	
	 private List<GameItem> gameObjects;

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
		for(GameItem i:gameObjects) 
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
		for(GameItem i: gameObjects) 
		{
			if(i.GetPos().Eq(pos) && i.isSolid()) 
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean LemmingRoleAssigner(Position pos, LemmingRole lr) throws OffBoardException, CommandExecuteException
	{
		for(GameItem i: gameObjects) 
		{
			if(i.GetPos().Eq(pos) && !i.isSolid() && !i.isExit()) 
			{
				 return i.setRole(lr);
			}
		}
		if(pos.GetCol()<0 || pos.GetCol()>Game.DIM_X || pos.GetRow()<0 || pos.GetRow()>Game.DIM_X) 
		{
			throw new OffBoardException("Position ("+pos.GetCol()+","+pos.GetRow()+") off the board");	
		}
		else throw new CommandExecuteException ("No lemming in position ("+pos.GetCol()+","+pos.GetRow()+") admits role "+lr.GetName());
	}
	
	public void update() {
        for (Iterator<GameItem> iterator = gameObjects.iterator(); iterator.hasNext();) {
        {
            GameItem goIt= iterator.next();
            receiveInteractionsFrom(goIt);
            if(goIt.hasExited()) 
            {
                iterator.remove();
            }
            else
            {
                goIt.update();
            }
        } 
    }
        
}
	  public boolean receiveInteractionsFrom(GameItem obj) 
	  {
		  Position downPos=new Position(obj.GetPos().GetCol(), obj.GetPos().GetRow()+1);
		  Position forwardPos= new Position(obj.GetPos().GetCol()+obj.GetDir().getX(), obj.GetPos().GetRow());
		  for(GameItem i: gameObjects) 
		  {
			  if(i.GetPos().Eq(forwardPos) || i.GetPos().Eq(downPos) || i.GetPos().Eq(obj.GetPos())) 
			  {
				  i.receiveInteraction(obj);
			  }
		  }
		  return true;
	  }

	public int numLemmingDead() {
		int dead = 0; 
		for(GameItem i : gameObjects)
		{
			if(!i.isAlive() && !i.isSolid() && !i.isExit() && !i.isSoft()){
				dead++;
			}
		}
		
		return dead;
	}
	
	public int GetExit() 
	{
		int c = -1;
		for(GameItem i : gameObjects)
		{
			if(i.isExit()){
				c = i.GetExit();
			}
		}
		return c;
	}
	//R.I.P here lies Lemmings 1.0 code. It served us well. Farewell, friend.
}
