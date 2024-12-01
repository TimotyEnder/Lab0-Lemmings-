package tp1.logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import tp1.files.GameObjectFactory;
import tp1.logic.gameobjects.GameObject;

public class FileGameConfiguration {
	Scanner scanner;
	public FileGameConfiguration(String fileName, GameWorld game) 
	{
		 try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
	            String line;
	            GameObjectFactory gof=new GameObjectFactory();
	            GameObjectContainer gameCon;
	            line = br.readLine();
	            line = scanner.nextLine();
	    		String[] attributes = line.trim().split("\\s+");
	    		game.setCycle(Integer.parseInt(attributes[0]));
	    		game.setnumLemmingsInBoard(Integer.parseInt(attributes[0]));
	    		game.setnumLemmingsDead(Integer.parseInt(attributes[1]));
	    		game.setnumLemmingsExit(Integer.parseInt(attributes[2]));
	    		game.setnumLemmingsToWin(Integer.parseInt(attributes[3]));
	            while ((line = br.readLine()) != null) {
	                GameObject goLoaded = gof.parse(line, game);
	                gameCon=game.getGameObjects();
	                gameCon.add(goLoaded);
	            }
	        } catch (IOException e) { //change this to correct exception handling
	            e.printStackTrace();
	        }
	}
}
