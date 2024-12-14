package tp1.logic.LemmingsRole;

import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.GameItem;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;

public interface LemmingRole {
 public void start(Lemming l);
 public void advance(Lemming l);
 public String geticon(Lemming l);
 public int FallForce(int ff);
 public String getDetails();
 public  LemmingRole matchRole(String c);
 
 public boolean receiveInteraction(GameItem other, Lemming lemming);
 public boolean interactWith(Lemming receiver, Lemming lemming);
 public boolean interactWith(Wall wall, Lemming lemming);
 public boolean interactWith(ExitDoor door, Lemming lemming);
public String GetName();
public String GetSc();
}
