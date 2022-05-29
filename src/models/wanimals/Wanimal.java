/******************************************************************************
Program: Wanimal Class (Wanimals)

Description: This is the Wanimal class. It is the base class for every wanimal
in this game and contains fields for attributes that every wanimal in the game,
including player, wild, and boss wanimals, will have.

Date: June 1, 2022
*******************************************************************************/

package models.wanimals;

import models.battles.attacks.Attack;
import models.player.Player;

public class Wanimal {
  protected String name, type;
  protected int level, maxHitpoints, currentHitpoints, baseAttack, maxArmor,
      currentArmor, maxXP, currentXP;
  protected Player owner;
  protected Attack firstAttack, secondAttack;

  /**
   * Constructor method: this overload of this method takes an argument for
   * every possible attribute and uses them to create a new wanimal
   *
   * @param name - the name with which to create the new wanimal
   * @param type - the type with which to create the new wanimal
   * @param level - the level with which to create the new wanimal
   * @param maxHitpoints - the max hitpoints with which to create the new
   *     wanimal
   * @param currentHitpoints - the current hitpoints with which to create the
   *     new wanimal
   * @param baseAttack - the base attack with which to create the new wanimal
   * @param maxArmor - the max armor with which to create the new wanimal
   * @param currentArmor - the current armor with which to create the new
   *     wanimal
   * @param owner - the owner with which to create the new wanimal
   * @param currentXP - the currentXP with which to create the new wanimal
   * @param maxXP - the maxXP with which to create the new wanimal
   * @param firstAttack - the firstAttack with which to create the new wanimal
   * @param secondAttack - the secondAttack with which to create the new wanimal
   */
  public Wanimal(String name, String type, int level, int maxHitpoints,
                 int currentHitpoints, int baseAttack, int maxArmor,
                 int currentArmor, Player owner, int maxXP, int currentXP,
                 Attack firstAttack, Attack secondAttack) {
    this.name = name;   // set the name of this wanimal to the name given
    this.type = type;   // set the type of this wanimal to the type given
    this.level = level; // set the level of this wanimal to the level given
    this.maxHitpoints = maxHitpoints; // set the maxHitpoints of this wanimal to
                                      // the maxHitpoints given
    this.currentHitpoints =
        currentHitpoints; // set the currentHitpoints of this wanimal to the
                          // currentHitpoints given
    this.baseAttack = baseAttack; // set the baseAttack of this wanimal to the
                                  // baseAttack given
    this.maxArmor =
        maxArmor; // set the maxArmor of this wanimal to the maxArmor given
    this.currentArmor = currentArmor; // set the currentArmor of this wanimal to
                                      // the currentArmor given
    this.owner = owner;               // set the owner of this wanimal to
                                      // the owner given
    this.maxXP = maxXP;               // set the maxXP of this
                                      // wanimal to the maxXP given
    this.currentXP = currentXP;       // set the currentXP of this
                                      // wanimal to the currentXP given
    this.firstAttack = firstAttack;   // set the firstAttack of this
                                      // wanimal to the firstAttack given
    this.secondAttack = secondAttack; // set the secondAttack of this
                                      // wanimal to the secondAttack given
  }

  /**
   * Constructor method: this overload of this method takes no arguments and
   * creates a new wanimal with default values for each attribute
   */
  public Wanimal() {
    this.name = "no_name";
    this.type = "no_type";
    this.level = 1;
    this.maxHitpoints = 100;
    this.currentHitpoints = 100;
    this.baseAttack = 10;
    this.maxArmor = 20;
    this.currentArmor = 20;
    this.owner = null; // by default, a wanimal has no owner
    this.maxXP = 200;
    this.currentXP = 0;
    this.firstAttack = null;
    this.secondAttack = null;
  }

  // getters and setters

  public String getName() { return name; }

  public void setName(String name) { this.name = name; }

  public String getType() { return type; }

  public void setType(String type) { this.type = type; }

  public int getLevel() { return level; }

  public void setLevel(int level) { this.level = level; }

  public int getMaxHitpoints() { return maxHitpoints; }

  public void setMaxHitpoints(int maxHitpoints) {
    this.maxHitpoints = maxHitpoints;
  }

  public int getCurrentHitpoints() { return currentHitpoints; }

  public void setCurrentHitpoints(int currentHitpoints) {
    this.currentHitpoints = currentHitpoints;
  }

  public int getBaseAttack() { return baseAttack; }

  public void setBaseAttack(int baseAttack) { this.baseAttack = baseAttack; }

  public int getMaxArmor() { return maxArmor; }

  public void setMaxArmor(int maxArmor) { this.maxArmor = maxArmor; }

  public int getCurrentArmor() { return currentArmor; }

  public void setCurrentArmor(int currentArmor) {
    this.currentArmor = currentArmor;
  }

  public Player getOwner() { return owner; }

  public void setOwner(Player owner) { this.owner = owner; }

  public int getMaxXP() { return maxXP; }

  public void setMaxXP(int maxXP) { this.maxXP = maxXP; }

  public int getCurrentXP() { return currentXP; }

  public void setCurrentXP(int currentXP) { this.currentXP = currentXP; }

  public Attack getFirstAttack() { return firstAttack; }

  public void setFirstAttack(Attack firstAttack) {
    this.firstAttack = firstAttack;
  }

  public Attack getSecondAttack() { return secondAttack; }

  public void setSecondAttack(Attack secondAttack) {
    this.secondAttack = secondAttack;
  }
}
