/******************************************************************************
Program: HydronPrime Class (Wanimals)

Description: This is the HydronPrime class.

Date: June 1, 2022
*******************************************************************************/

package models.bosses.bosses;

import models.battles.attacks.Attack;
import models.bosses.Boss;
import models.player.Player;

public class HydronPrime extends Boss {
  protected static int experienceOffered = 400, requiredLevel = 10;

  /**
   * Constructor method: this overload of this method takes an argument for
   * every possible attribute and uses them to create a new boss
   *
   * @param name - the name with which to create the new boss
   * @param type - the type with which to create the new boss
   * @param level - the level with which to create the new boss
   * @param maxHitpoints - the max hitpoints with which to create the new
   *     boss
   * @param currentHitpoints - the current hitpoints with which to create the
   *     new boss
   * @param baseAttack - the base attack with which to create the new boss
   * @param maxArmor - the max armor with which to create the new boss
   * @param currentArmor - the current armor with which to create the new
   *     boss
   * @param owner - the owner with which to create the new boss
   * @param currentXP - the currentXP with which to create the new boss
   * @param maxXP - the maxXP with which to create the new boss
   * @param firstAttack - the firstAttack with which to create the new boss
   * @param secondAttack - the secondAttack with which to create the new boss
   */
  public HydronPrime(String name, String type, int level, int maxHitpoints,
                     int currentHitpoints, int baseAttack, int maxArmor,
                     int currentArmor, Player owner, int maxXP, int currentXP,
                     Attack firstAttack, Attack secondAttack) {
    super(name, type, level, maxHitpoints, currentHitpoints, baseAttack,
          maxArmor, currentArmor, owner, maxXP, currentXP, firstAttack,
          secondAttack); // call superconstructor
  }

  /**
   * Constructor method: this overload of this method takes no arguments and
   * creates a new boss with default values for each attribute
   */
  public HydronPrime() {
    this.name = "Hydron Prime";
    this.type = "water";
    this.level = 10;
    this.baseAttack = 40;
    this.maxHitpoints = 400;
    this.currentHitpoints = 400;
    this.maxArmor = 120;
    this.currentArmor = 120;
    this.owner = null; // bosses have no owner
    this.maxXP = 400;
    this.currentXP = 0;
    this.firstAttack = new Attack("Enhanced Drown", 1);
    this.secondAttack = new Attack("Mega Flood", 2);
  }
}
