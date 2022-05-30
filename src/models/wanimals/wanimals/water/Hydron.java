/******************************************************************************
Program: Hydron Class (Wanimals)

Description: This is the Hydron class. It inherits from the WaterWanimal class
and represents the information associated with the Hydron wanimal in the game.

Date: June 1, 2022
*******************************************************************************/

package models.wanimals.wanimals.water;

import models.battles.attacks.Attack;
import models.player.Player;
import models.wanimals.types.WaterWanimal;

public class Hydron extends WaterWanimal {
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
  public Hydron(final String name, final String type, final int level, final int maxHitpoints,
                final int currentHitpoints, final int baseAttack, final int maxArmor,
                final int currentArmor, final Player owner, final int maxXP, final int currentXP,
                final Attack firstAttack, final Attack secondAttack) {
    super(name, type, level, maxHitpoints, currentHitpoints, baseAttack,
          maxArmor, currentArmor, owner, maxXP, currentXP, firstAttack,
          secondAttack); // call the superconstructor with the given values
  }

  /**
   * Constructor method: this overload of this method takes no arguments and
   * creates a new wanimal with default values for each attribute
   */
  public Hydron() {
    this.name = "Hydron";
    this.type = "water";
    this.level = 1;
    this.maxHitpoints = 120;
    this.currentHitpoints = 120;
    this.baseAttack = 13;
    this.maxArmor = 24;
    this.currentArmor = 24;
    this.firstAttack = new Attack("Drown", 1);
    this.secondAttack = new Attack("Crushing Current", 2);
  }
}
