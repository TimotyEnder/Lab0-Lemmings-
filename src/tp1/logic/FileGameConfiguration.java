package tp1.logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import tp1.exceptions.GameLoadException;
import tp1.exceptions.GameParseException;
import tp1.exceptions.ObjectParseException;
import tp1.exceptions.OffBoardException;
import tp1.exceptions.RoleParseException;
import tp1.files.GameObjectFactory;
import tp1.logic.gameobjects.GameObject;
import tp1.view.Messages;

public class FileGameConfiguration {
	public FileGameConfiguration(String fileName, GameWorld game) throws  GameLoadException 
	{
		 try (
				BufferedReader br = new BufferedReader(new FileReader(fileName))) {
	            String line;
	            GameObjectFactory gof=new GameObjectFactory();
	            GameObjectContainer gameCon;
	            line = br.readLine();
	    		String[] attributes = line.trim().split("\\s+");
	    		if(attributes.length==5) 
	    		{
	    			game.setCycle(Integer.parseInt(attributes[0]));
		    		game.setnumLemmingsInBoard(Integer.parseInt(attributes[1]));
		    		game.setnumLemmingsDead(Integer.parseInt(attributes[2]));
		    		game.setnumLemmingsExit(Integer.parseInt(attributes[3]));
		    		game.setnumLemmingsToWin(Integer.parseInt(attributes[4]));
	    		}
	    		else 
	    		{
	    			throw new GameLoadException(Messages.GAME_LOAD_INCORRECTGAMESTATUS.formatted(line));
	    		}
	            while ((line = br.readLine()) != null) {
	                GameObject goLoaded = gof.parse(line, game);
	                gameCon=game.getGameObjects();
	                gameCon.add(goLoaded);
	          }
	        } catch (GameLoadException e) { 
	        	throw new GameLoadException(Messages.INCORRECT_FILE.formatted(fileName),e);
	        }
		     catch (Exception e) 
		 	{
		    	 throw new GameLoadException(Messages.LOAD_FILE_ERROR,e);
		 	}
	}
}
