/******************************************************************************
Program: Player Class (Wanimals)

Description: This is the Player class.

Date: June 1, 2022
*******************************************************************************/

package models.player;

import java.util.ArrayList;
import models.wanimals.Wanimal;

public class Player {
  private String name;
  private int level, realm, numPotions, numArmorPlates, currentXP, maxXP;
  private ArrayList<Wanimal> wanimals;

  /**
   * Constructor method: this overload of this method takes an argument for
   * every possible attribute and uses them to create a new player
   *
   * @param name - the name with which to create the new player
   * @param level - the level with which to create the new player
   * @param realm - the realm with which to create the new player
   * @param numPotions - the number of potions with which to create the new
   *     player
   * @param numArmorPlates - the number of armor plates with which to create the
   *     new player
   * @param wanimals - the wanimals with which to create the new player
   * @param maxXP - the maxXP with which to create the new player
   * @param currentXP - the currentXP with which to create the new player
   */
  public Player(String name, int level, int realm, int numPotions,
                int numArmorPlates, ArrayList<Wanimal> wanimals, int currentXP,
                int maxXP) {
    this.name = name;   // set the name of this player to the name given
    this.level = level; // set the level of this player to the level given
    this.realm = realm; // set the realm of this player to the realm given
    this.numPotions = numPotions; // set the numPotions of this player to the
                                  // numPotions given
    this.numArmorPlates = numArmorPlates; // set the numArmorPlates of this
                                          // wanimal to the numArmorPlates given
    this.wanimals = wanimals;             // set the wanimals of this
                                          // player to the wanimals given
    this.maxXP = maxXP;                   // set the maxXP of this
                                          // player to the maxXP given
    this.currentXP = currentXP;           // set the currentXP of this
                                          // player to the currentXP given
  }

  /**
   * Constructor method: this overload of this method takes no arguments and
   * creates a new player with default values for each attribute
   */
  public Player() {
    this.name = "no_name";
    this.level = 1;
    this.realm = 1;
    this.numPotions = 5;
    this.numArmorPlates = 5;
    this.wanimals = new ArrayList<Wanimal>();
    this.maxXP = 200;
    this.currentXP = 0;
  }

  // getters and setters

  public String getName() { return name; }

  public void setName(String name) { this.name = name; }

  public int getLevel() { return level; }

  public void setLevel(int level) { this.level = level; }

  public int getRealm() { return realm; }

  public void setRealm(int realm) { this.realm = realm; }

  public int getNumPotions() { return numPotions; }

  public void setNumPotions(int numPotions) { this.numPotions = numPotions; }

  public int getNumArmorPlates() { return numArmorPlates; }

  public void setNumArmorPlates(int numArmorPlates) {
    this.numArmorPlates = numArmorPlates;
  }

  public ArrayList<Wanimal> getWanimals() { return wanimals; }

  public void setWanimals(ArrayList<Wanimal> wanimals) {
    this.wanimals = wanimals;
  }

  public int getCurrentXP() { return currentXP; }

  public void setCurrentXP(int currentXP) { this.currentXP = currentXP; }

  public int getMaxXP() { return maxXP; }

  public void setMaxXP(int maxXP) { this.maxXP = maxXP; }
}
