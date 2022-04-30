package models.wanimals.wanimals.grass;

import models.player.Player;
import models.wanimals.types.GrassWanimal;

public class Tryone extends GrassWanimal {
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
   */
  public Tryone(String name, String type, int level, int maxHitpoints,
                int currentHitpoints, int baseAttack, int maxArmor,
                int currentArmor, Player owner, int maxXP, int currentXP) {
    super(name, type, level, maxHitpoints, currentHitpoints, baseAttack,
          maxArmor, currentArmor, owner, maxXP,
          currentXP); // call the superconstructor with the given values
  }

  /**
   * Constructor method: this overload of this method takes no arguments and
   * creates a new wanimal with default values with each attribute
   */
  public Tryone() {
    this.name = "Tryone";
    this.type = "grass";
    this.level = 1;
    this.maxHitpoints = 90;
    this.currentHitpoints = 90;
    this.baseAttack = 16;
    this.maxArmor = 18;
    this.currentArmor = 18;
  }

  public void grassBlade() {}
}
