package tp1.logic;
import tp1.exceptions.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import tp1.logic.LemmingsRole.LemmingRole;
import tp1.logic.gameobjects.GameItem;

public class GameObjectContainer {
	
	 private List<GameItem> gameObjects;

	public GameObjectContainer() {
		gameObjects = new ArrayList<>();
	}
	public GameObjectContainer(GameObjectContainer gc) 
	{
		this.gameObjects=new ArrayList<>();
		for(GameItem i: gc.gameObjects) 
		{
			this.add(i.Clone());
		}
	}
	public void add(GameItem object) 
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
			if(i.GetPos().Eq(pos)) 
			{
				 if(i.setRole(lr)) 
				 {
					 return true;
				 }
			}
		}
		if(pos.GetCol()<0 || pos.GetCol()>Game.DIM_X || pos.GetRow()<0 || pos.GetRow()>Game.DIM_X) 
		{
			throw new OffBoardException("Position ("+pos.GetCol()+","+pos.GetRow()+") off the board");	
		}
		else throw new CommandExecuteException ("No lemming in position ("+pos.GetRow()+","+pos.GetCol()+") admits role "+lr.GetName());
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
	public void SetExit(int ExitNum) 
	{
		for(GameItem i : gameObjects)
		{
			if(i.isExit()){
				i.SetExit(ExitNum);
			}
		}
	}
	public String stringify() 
	{
		String out = "";
		for(GameItem i: gameObjects) 
		{
			out+=i.stringify();
		}
		return out;
	}
	//R.I.P here lies Lemmings 1.0 code. It served us well. Farewell, friend.
}
