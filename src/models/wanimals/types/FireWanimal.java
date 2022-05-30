/******************************************************************************
Program: FireWanimal Class (Wanimals)

Description: This is the FireWanimal class. It inherits from the Wanimal class
and contains the information associated with any wanimal of type fire in the
game.

Date: June 1, 2022
*******************************************************************************/

package models.wanimals.types;

import models.battles.attacks.Attack;
import models.player.Player;
import models.wanimals.Wanimal;

public class FireWanimal extends Wanimal {
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
   */
  public FireWanimal(final String name, final String type, final int level,
                     final int maxHitpoints, final int currentHitpoints,
                     final int baseAttack, final int maxArmor,
                     final int currentArmor, final Player owner,
                     final int maxXP, final int currentXP,
                     final Attack firstAttack, final Attack secondAttack) {
    super(name, type, level, maxHitpoints, currentHitpoints, baseAttack,
          maxArmor, currentArmor, owner, maxXP, currentXP, firstAttack,
          secondAttack); // call the superconstructor with the given values
  }

  /**
   * Constructor method: this overload of this method takes no arguments and
   * creates a new wanimal with default values for each attribute
   */
  public FireWanimal() {
    this.name = "no_name";
    this.type = "fire";
    this.level = 1;
    this.maxHitpoints = 100;
    this.currentHitpoints = 100;
    this.baseAttack = 10;
    this.maxArmor = 20;
    this.currentArmor = 20;
    this.maxXP = 200;
    this.currentXP = 0;
    this.firstAttack = new Attack("Fire Blast", 1);
    this.secondAttack = null;
  }
}
