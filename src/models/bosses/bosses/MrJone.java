/******************************************************************************
Program: MrJone Class (Wanimals)

Description: This is the MrJone class.

Date: June 1, 2022
*******************************************************************************/

package models.bosses.bosses;

import models.battles.attacks.Attack;
import models.bosses.Boss;
import models.player.Player;

public class MrJone extends Boss {
  protected static int experienceOffered = 500, requiredLevel = 15;

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
  public MrJone(final String name, final String type, final int level, final int maxHitpoints,
                final int currentHitpoints, final int baseAttack, final int maxArmor,
                final int currentArmor, final Player owner, final int maxXP, final int currentXP,
                final Attack firstAttack, final Attack secondAttack) {
    super(name, type, level, maxHitpoints, currentHitpoints, baseAttack,
          maxArmor, currentArmor, owner, maxXP, currentXP, firstAttack,
          secondAttack); // call superconstructor
  }

  /**
   * Constructor method: this overload of this method takes no arguments and
   * creates a new boss with default values for each attribute
   */
  public MrJone() {
    this.name = "Mr. Jone";
    this.type = "normal";
    this.level = 10;
    this.baseAttack = 50;
    this.maxHitpoints = 600;
    this.currentHitpoints = 600;
    this.maxArmor = 180;
    this.currentArmor = 180;
    this.owner = null; // bosses have no owner
    this.maxXP = 600;
    this.currentXP = 0;
    this.firstAttack = new Attack("Give Assignment", 1);
    this.secondAttack = new Attack("Give Test", 2);
  }
}
