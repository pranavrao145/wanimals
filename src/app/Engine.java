package app;

import models.battles.battles.Battle;
import models.player.Player;

public class Engine {
  private static GUI gui;
  private static Player player;
  private static Battle currentBattle;

  private static void initialize(GUI currentGUI) { gui = currentGUI; }

  public static void run(GUI currentGUI) { initialize(currentGUI); }

  // getters and setters

  public static GUI getGui() { return gui; }

  public static Player getPlayer() { return player; }

  public static void setPlayer(Player player) { Engine.player = player; }

  public static Battle getCurrentBattle() { return currentBattle; }

  public static void setCurrentBattle(Battle currentBattle) {
    Engine.currentBattle = currentBattle;
  }
}
