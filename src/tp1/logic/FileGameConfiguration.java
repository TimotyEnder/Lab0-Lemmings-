package tp1.logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import tp1.files.GameObjectFactory;
import tp1.logic.gameobjects.GameObject;

public class FileGameConfiguration {
	public FileGameConfiguration(String fileName, GameWorld game) 
	{
		 try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
	            String line;
	            GameObjectFactory gof=new GameObjectFactory();
	            GameObjectContainer gameCon;
	            line = br.readLine();
	            //System.out.println(line); DEBUG
	    		String[] attributes = line.trim().split("\\s+");
	    		game.setCycle(Integer.parseInt(attributes[0]));
	    		game.setnumLemmingsInBoard(Integer.parseInt(attributes[1]));
	    		game.setnumLemmingsDead(Integer.parseInt(attributes[2]));
	    		game.setnumLemmingsExit(Integer.parseInt(attributes[3]));
	    		game.setnumLemmingsToWin(Integer.parseInt(attributes[4]));
	            while ((line = br.readLine()) != null) {
	            	//System.out.println(line); DEBUG
	                GameObject goLoaded = gof.parse(line, game);
	                gameCon=game.getGameObjects();
	                gameCon.add(goLoaded);
	            }
	        } catch (IOException e) { //change this to correct exception handling
	            e.printStackTrace();
	        }
	}
}
