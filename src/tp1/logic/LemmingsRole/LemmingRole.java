package tp1.logic.LemmingsRole;

import tp1.logic.gameobjects.Lemming;

public interface LemmingRole {
 public void start(Lemming l);
 public void advance(Lemming l);
 public String geticon(Lemming l);
public LemmingRole parse(String wordywords);
public String getDetails();
}
