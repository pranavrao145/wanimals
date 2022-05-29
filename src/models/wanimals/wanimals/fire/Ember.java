/******************************************************************************
Program: Ember Class (Wanimals)

Description: This is the Ember class. It inherits from the FireWanimal class and
represents the information associated with the Ember wanimal in the game.

Date: June 1, 2022
*******************************************************************************/

package models.wanimals.wanimals.fire;

import models.battles.attacks.Attack;
import models.player.Player;
import models.wanimals.types.FireWanimal;

public class Ember extends FireWanimal {
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
  public Ember(String name, String type, int level, int maxHitpoints,
               int currentHitpoints, int baseAttack, int maxArmor,
               int currentArmor, Player owner, int maxXP, int currentXP,
               Attack firstAttack, Attack secondAttack) {
    super(name, type, level, maxHitpoints, currentHitpoints, baseAttack,
          maxArmor, currentArmor, owner, maxXP, currentXP, firstAttack,
          secondAttack); // call the superconstructor with the given values
  }

  /**
   * Constructor method: this overload of this method takes no arguments and
   * creates a new wanimal with default values for each attribute
   */
  public Ember() {
    this.name = "Ember";
    this.type = "fire";
    this.level = 1;
    this.maxHitpoints = 80;
    this.currentHitpoints = 80;
    this.baseAttack = 17;
    this.maxArmor = 16;
    this.currentArmor = 16;
    this.firstAttack = new Attack("Fire Blast", 1);
    this.secondAttack = new Attack("Burn", 2);
  }
}
