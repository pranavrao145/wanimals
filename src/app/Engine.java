package app;

public class Engine {
  private static GUI gui;

  private static void initialize(GUI currentGUI) { gui = currentGUI; }

  public static void run(GUI currentGUI) { initialize(currentGUI); }

  public static GUI getGui() { return gui; }
}
