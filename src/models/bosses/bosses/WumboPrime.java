package models.bosses.bosses;

import models.battles.attacks.Attack;
import models.bosses.Boss;
import models.player.Player;

public class WumboPrime extends Boss {
  protected static int experienceOffered = 300, requiredLevel = 5;

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
  public WumboPrime(String name, String type, int level, int maxHitpoints,
                    int currentHitpoints, int baseAttack, int maxArmor,
                    int currentArmor, Player owner, int maxXP, int currentXP,
                    Attack firstAttack, Attack secondAttack,
                    int experienceOffered, int requiredLevel) {
    super(name, type, level, maxHitpoints, currentHitpoints, baseAttack,
          maxArmor, currentArmor, owner, maxXP, currentXP, firstAttack,
          secondAttack); // call superconstructor
  }

  /**
   * Constructor method: this overload of this method takes no arguments and
   * creates a new boss with default values for each attribute
   */
  public WumboPrime() {
    this.name = "Wumbo Prime";
    this.type = "normal";
    this.level = 10;
    this.baseAttack = 30;
    this.maxHitpoints = 200;
    this.currentHitpoints = 200;
    this.maxArmor = 60;
    this.currentArmor = 60;
    this.owner = null; // bosses have no owner
    this.maxXP = 200;
    this.currentXP = 0;
    this.firstAttack = new Attack("Armed Assault", 1);
    this.secondAttack = new Attack("Extreme Super Punch", 2);
  }
}
