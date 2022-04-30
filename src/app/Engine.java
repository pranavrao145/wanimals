package app;

import models.player.Player;

public class Engine {
  private static GUI gui;
  private static Player player;

  private static void initialize(GUI currentGUI) { gui = currentGUI; }

  public static void run(GUI currentGUI) { initialize(currentGUI); }

  public static void battle() {
    throw new UnsupportedOperationException(
        "This operation has not been implemented yet.");
  }

  // getters and setters

  public static GUI getGui() { return gui; }

  public static Player getPlayer() { return player; }
}
