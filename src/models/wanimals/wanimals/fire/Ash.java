package models.wanimals.wanimals.fire;

import models.player.Player;
import models.wanimals.types.FireWanimal;

public class Ash extends FireWanimal {
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
   */
  public Ash(String name, String type, int level, int maxHitpoints,
             int currentHitpoints, int baseAttack, int maxArmor,
             int currentArmor, Player owner) {
    super(name, type, level, maxHitpoints, currentHitpoints, baseAttack,
          maxArmor, currentArmor,
          owner); // call the superconstructor with the given values
  }

  /**
   * Constructor method: this overload of this method takes no arguments and
   * creates a new wanimal with default values with each attribute
   */
  public Ash() {
    this.name = "Ash";
    this.type = "fire";
    this.level = 1;
    this.maxHitpoints = 100;
    this.currentHitpoints = 100;
    this.baseAttack = 15;
    this.maxArmor = 20;
    this.currentArmor = 20;
  }

  public void incinerate() {}
}
