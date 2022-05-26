/******************************************************************************
Program: Engine Class (Wanimals)

Description: This is the Engine class.

Date: June 1, 2022
*******************************************************************************/

package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import models.battles.attacks.Attack;
import models.battles.battles.Battle;
import models.player.Player;
import models.wanimals.Wanimal;

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
      final File saveDataFile = new File("data/saveData.txt");

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
            "%s;%s;%d;%d;%d;%d;%d;%d;%d;%d;%s;%d;%s;%d",
            currentWanimal.getName(), currentWanimal.getType(),
            currentWanimal.getLevel(), currentWanimal.getCurrentXP(),
            currentWanimal.getMaxXP(), currentWanimal.getCurrentHitpoints(),
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
   * This method takes the information from the saveData file and loads it into
   * the game. This allows the user to continue the game from where they left
   * off the last time they ran the program.
   */
  public static void readFromSaveFile() {

    // Setting the reader to null
    Engine.setPlayer(new Player());
    BufferedReader objReader = null;

    // Try
    try {
      // Creates a string that will be the current line the reader is on
      String strCurrentLine;

      // Creating a new reader
      objReader = new BufferedReader(new FileReader("data/saveData.txt"));

      // Predefining the line number which eventually dictates if the reader is
      // reading user or wanimal info
      int line = 1;

      // Predefining the component value so the reader knows which part of the
      // wanimal the data is defining
      int infoComponent = 1;

      // Keeps reading the next line until it returns null
      while ((strCurrentLine = objReader.readLine()) != null) {

        // Finding the length of the line to know how many iterations of the for
        // loop to run
        int length = strCurrentLine.length();

        // Predefining the component string as it is the data that will
        // eventually make up the data of the character or their wanimals
        String componentStr = "";

        // Predefining the string that the curChar variable will add to, will
        // only ever have one character but is needed as char and string data
        // types can't be compared
        String curStr = "";

        // If the line is 1 (character information)
        if (line == 1) {

          // For loop for the length of the line
          for (int x = 0; x < length; x++) {

            // Char curChar is the character at the character at the current
            // iteration of the loop
            char curChar = strCurrentLine.charAt(x);

            // Adding it to the curStr variable
            curStr += curChar;

            // If the current String is a ; (separator of information about the
            // character):
            if (curStr.equals(";")) {

              // Sets the character info to the corresponding setter depending
              // on the component counter
              if (infoComponent == 1) {
                Engine.getPlayer().setName(componentStr);
              }

              else if (infoComponent == 2) {
                Engine.getPlayer().setRealm(Integer.parseInt(componentStr));
              }

              else if (infoComponent == 3) {
                Engine.getPlayer().setNumPotions(
                    Integer.parseInt(componentStr));
              }

              else if (infoComponent == 3) {
                Engine.getPlayer().setNumArmorPlates(
                    Integer.parseInt(componentStr));
              }

              else if (infoComponent == 4) {
                Engine.getPlayer().setLevel(Integer.parseInt(componentStr));
              }

              else if (infoComponent == 5) {
                Engine.getPlayer().setCurrentXP(Integer.parseInt(componentStr));
              }

              else {
                Engine.getPlayer().setMaxXP(Integer.parseInt(componentStr));
              }

              // Resets the component string so new information can be formed
              componentStr = "";

              // Increases the info component counter by 1
              infoComponent++;

            } // End of If

            // Else add the character to the component string
            else {
              componentStr += curChar;
            }

            // Resets curStr
            curStr = "";

          } // End of For

        } // End of If

        // Else (line > 1, wanimal information):
        else {

          // Defining all the parameters used to create a new wanimal
          int level = 0, curXP = 0, maxXP = 0, curHP = 0, maxHP = 0,
              curArmor = 0, maxArmor = 0, firstAtkType = 0, secondAtkType,
              baseAtk = 0;
          String wanimalName = null, type = null, firstAtkName = null,
                 secondAtkName = null;

          // For loops running for as many iterations as there are characters in
          // the string
          for (int x = 0; x < length; x++) {

            // Char curChar is the character at the character at the current
            // iteration of the loop
            char curChar = strCurrentLine.charAt(x);

            // Adding it to the curStr variable
            curStr += curChar;

            // If the current String is a ; (separator of information about the
            // character):
            if (curStr.equals(";")) {

              // Sets the character info to the corresponding setter depending
              // on the component counter
              if (infoComponent == 1) {
                wanimalName = componentStr;
              } else if (infoComponent == 2) {
                type = componentStr;
              }

              else if (infoComponent == 3) {
                level = Integer.parseInt(componentStr);
              } else if (infoComponent == 4) {
                curXP = Integer.parseInt(componentStr);
              } else if (infoComponent == 5) {
                maxXP = Integer.parseInt(componentStr);
              } else if (infoComponent == 6) {
                curHP = Integer.parseInt(componentStr);
              } else if (infoComponent == 7) {
                maxHP = Integer.parseInt(componentStr);
              } else if (infoComponent == 8) {
                curArmor = Integer.parseInt(componentStr);
              } else if (infoComponent == 9) {
                maxArmor = Integer.parseInt(componentStr);
              } else if (infoComponent == 10) {
                baseAtk = Integer.parseInt(componentStr);
              } else if (infoComponent == 11) {
                firstAtkName = componentStr;
              } else if (infoComponent == 12) {
                firstAtkType = Integer.parseInt(componentStr);
              } else if (infoComponent == 13) {
                secondAtkName = componentStr;
              } else {
                // Creates the two attack needed as parameters
                Attack firstAtk = new Attack(firstAtkName, firstAtkType);
                Attack secondAtk =
                    new Attack(secondAtkName, Integer.parseInt(componentStr));

                // Creates the wanimal from read information
                Wanimal readWanimal =
                    new Wanimal(wanimalName, type, level, maxHP, curHP, baseAtk,
                                maxArmor, curArmor, Engine.getPlayer(), maxXP,
                                curXP, firstAtk, secondAtk);

                // Adds the wanimal to the party
                Engine.getPlayer().getWanimals().add(readWanimal);
              }
              // Reset the component string
              componentStr = "";
              // Increases info component by 1
              infoComponent++;
            } // End of If
            // Else add the character to the component string
            else {
              componentStr += curChar;
            }
            // Resets curStr
            curStr = "";
          } // End of For
        }   // End of Else

        // Increases line counter by 1
        line++;

        // Resets the info component
        infoComponent = 1;
      } // End of While

      // Catching the exception
    } catch (IOException e) {

      // Prints the error
      e.printStackTrace();

    } finally {

      try {

        // If the reader reads nothing
        if (objReader != null)

          // Closes reader
          objReader.close();

        // Catching and printing exception
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
  } // End of readFromSaveFile method
}
