package app;

import models.player.Player;
import models.wanimals.Wanimal;

public class Engine {
  private static GUI gui;
  private static Player player;

  private static void initialize(GUI currentGUI) { gui = currentGUI; }

  public static void run(GUI currentGUI) { initialize(currentGUI); }

  /**
   * This method starts a battle with the given enemy.
   *
   * @param enemy - the enemy with which to start the new battle
   */
  public static void battle(Wanimal enemy) {
    throw new UnsupportedOperationException(
        "This operation has not been implemented yet.");
  }

  // getters and setters

  public static GUI getGui() { return gui; }

  public static Player getPlayer() { return player; }

  public static void setPlayer(Player player) { Engine.player = player; }
}
