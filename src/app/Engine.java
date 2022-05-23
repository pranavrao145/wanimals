package app;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import models.battles.attacks.Attack;
import models.battles.battles.Battle;
import models.player.Player;
import models.wanimals.Wanimal;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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

  /**
   * This method saves all the information about the current game into a text
   * file so it may be loaded when necessary. Note: this method will overwrite
   * any previously saved data
   */
  public static void saveWriteToFile() {
    try {
      // Creating the file to write to
      final File saveDataFile = new File("saveData.txt");

      // Deleting old file as it is being overwritten
      saveDataFile.delete();

      // Select parent file
      saveDataFile.getParentFile().mkdirs();

      // Creating the new file
      saveDataFile.createNewFile();

      // Creating the file writer
      final PrintWriter saveDataWriter =
          new PrintWriter(new FileWriter(saveDataFile, true));

      // Creating a string that displays all the information on the player in
      // following format Name, realm number, potion number, armor plate number,
      // level, current XP, max XP
      String studentContent = String.format(
          "%s;%d;%d;%d;%d;%d;%d", Engine.getPlayer().getName(),
          Engine.getPlayer().getRealm(), Engine.getPlayer().getNumPotions(),
          Engine.getPlayer().getNumArmorPlates(), Engine.getPlayer().getLevel(),
          Engine.getPlayer().getCurrentXP(), Engine.getPlayer().getMaxXP());

      // Writing string to file
      saveDataWriter.println(studentContent);

      // Finding how many wanimals the player has
      int length = Engine.getPlayer().getWanimals().size();

      // For loop that runs as many times are there are wanimals in player
      // inventory
      for (int x = 0; x < length; x++) {
        Wanimal currentWanimal = Engine.getPlayer().getWanimals().get(x);

        // get the current wanimal
        // String of all info of the wanimal in following format
        // Name, type, level, current XP, max XP, current HP, max HP,
        // current armor, max armor, base attack stat, first attack name,
        // first attack type, second attack name, second attack type
        String wanimalContent = String.format(
            "%s;%d;%d;%d;%d;%d;%d;%d;%d;%d;%s;%d;%s;%d", currentWanimal.getName(),
            currentWanimal.getType(), currentWanimal.getLevel(),
            currentWanimal.getCurrentXP(), currentWanimal.getMaxXP(),
            currentWanimal.getCurrentHitpoints(),
            currentWanimal.getMaxHitpoints(), currentWanimal.getCurrentArmor(),
            currentWanimal.getMaxArmor(), currentWanimal.getBaseAttack(),
            currentWanimal.getFirstAttack().getName(),
            currentWanimal.getFirstAttack().getType(),
            currentWanimal.getSecondAttack().getName(),
            currentWanimal.getSecondAttack().getType());

        // Writing this wanimals info to file
        saveDataWriter.println(wanimalContent);
      }

      // Closing the writer
      saveDataWriter.close();
    } catch (final Exception e) { // Catch for any exceptions
      e.printStackTrace();        // print the error
    }
  }
  
  /*
   * This method takes the information from the saveData file and loads it into the game.
   * This allows the user to continue the game from where they left off tht last time they
   * ran the program.
   */
  public static void readFromSaveFile() {
  
	  //
	  BufferedReader objReader = null;
	  try {
	   String strCurrentLine;

	   objReader = new BufferedReader(new FileReader("saveData.txt"));
	   	   
	   int line = 1;
	   int infoComponent = 1;
	   int wanimalCounter = 0;

	   while ((strCurrentLine = objReader.readLine()) != null) {
		   		   
		   String masterStr = strCurrentLine;
		   int length = masterStr.length();
		   String componentStr = "";
		   String curStr = "";
		   
		   if (line == 1) {
			   
			   for (int x = 0; x < length; x ++) {
				   
				   char curChar = masterStr.charAt(x);
				   curStr += curChar;
				   
				   Wanimal insertedWanimal = new Wanimal ();
				   
				   if (curStr.equals(";")) {
					   
					   if (infoComponent == 1) { Engine.getPlayer().setName(componentStr); }
					   
					   else if (infoComponent == 2) { Engine.getPlayer().setRealm(Integer.parseInt(componentStr)); }
					   
					   else if (infoComponent == 3) { Engine.getPlayer().setNumPotions(Integer.parseInt(componentStr)); }
					   
					   else if (infoComponent == 3) { Engine.getPlayer().setNumArmorPlates(Integer.parseInt(componentStr)); }
					   
					   else if (infoComponent == 4) { Engine.getPlayer().setLevel(Integer.parseInt(componentStr)); }
					   
					   else if (infoComponent == 5) { Engine.getPlayer().setCurrentXP(Integer.parseInt(componentStr)); }
					   
					   else  { 
						   
						   Engine.getPlayer().setMaxXP(Integer.parseInt(componentStr));
						   
						   
						   }
					   
					   componentStr = "";
					   
				   }
				   
				   
				   else { componentStr += curChar; }
			   }
			   
		   }
		   
		   else {
			   
			   int level = 0, curXP = 0, maxXP = 0, curHP = 0, maxHP = 0, curArmor = 0, maxArmor = 0, firstAtkType = 0, secondAtkType, baseAtk = 0;
			   String wanimalName = null, type = null, firstAtkName = null, secondAtkName = null;
			   for (int x = 0; x < length; x ++) {
				   
				   char curChar = masterStr.charAt(x);
				   curStr += curChar;
				   
				   if (curStr.equals(";")) {
					   
					   if (infoComponent == 1) { wanimalName = componentStr; }
					   else if (infoComponent == 2) { type = componentStr; }
					   
					   else if (infoComponent == 3) { level = Integer.parseInt(componentStr);}
					   else if (infoComponent == 4) { curXP = Integer.parseInt(componentStr); }
					   else if (infoComponent == 5) { maxXP = Integer.parseInt(componentStr); }
					   
					   else if (infoComponent == 6) { curHP = Integer.parseInt(componentStr); }
					   else if (infoComponent == 7) { maxHP = Integer.parseInt(componentStr); }
					   
					   else if (infoComponent == 8) { curArmor  = Integer.parseInt(componentStr); }
					   else if (infoComponent == 9) { maxArmor  = Integer.parseInt(componentStr); }
					   
					   else if (infoComponent == 10) { baseAtk = Integer.parseInt(componentStr); }
					   
					   else if (infoComponent == 11) { firstAtkName = componentStr; }
					   else if (infoComponent == 12) { firstAtkType  = Integer.parseInt(componentStr); }
					   
					   else if (infoComponent == 13) { secondAtkName = componentStr; }
					   
					   else { 
						   
						   secondAtkType  = Integer.parseInt(componentStr); 
						   
						   Attack firstAtk = new Attack(firstAtkName, firstAtkType);
						   Attack secondAtk = new Attack(secondAtkName, secondAtkType);
						   
						   Wanimal readWanimal = new Wanimal (wanimalName, type, level, maxHP, curHP, baseAtk, maxArmor, curArmor, Engine.getPlayer(), maxXP, curXP, firstAtk, secondAtk);
						   
						   Engine.getPlayer().getWanimals().add(readWanimal);
						   
						   }
					   
					   componentStr = "";
   
				   }
				   
				   else { componentStr += curChar; }
			   }
		   }
		   
		   line++;
		   infoComponent = 1;
	   }

	  } catch (IOException e) {

	   e.printStackTrace();

	  } finally {

	   try {
	    if (objReader != null)
	     objReader.close();
	   } catch (IOException ex) {
	    ex.printStackTrace();
	   }
	  }
  }
}
