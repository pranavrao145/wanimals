package models.bosses.bosses;

import models.battles.BossAttack;
import models.bosses.Boss;

public class WumboPrime extends Boss {
  /**
   * Constructor method: this overload of this method takes an argument for
   * every possible attribute and uses them to create a new boss
   *
   * @param name - the name with which to create the new boss
   * @param type - the type with which to create the new boss
   * @param maxHitPoints - the max hit points with which to create the new boss
   * @param currentHitPoints - the current hit points with which to create the
   *     new boss
   * @param maxArmor - the max armor with which to create the new boss
   * @param currentArmor - the current armor with which to create the new boss
   * @param experienceOffered - the experience offered with which to create the
   *     new boss
   * @param requiredLevel - the required level with which to create the new boss
   * @param firstBossAttack - the firstBossAttack with which to create the new
   *     boss
   * @param secondBossAttack - the secondBossAttack with which to create the new
   *     boss
   */
  public WumboPrime(String name, String type, int maxHitPoints,
                    int currentHitPoints, int maxArmor, int currentArmor,
                    int experienceOffered, int requiredLevel,
                    BossAttack firstBossAttack, BossAttack secondBossAttack) {
    super(name, type, maxHitPoints, currentHitPoints, maxArmor, currentArmor,
          experienceOffered, requiredLevel, firstBossAttack,
          secondBossAttack); // call the superconstructor with the given values
  }

  /**
   * Constructor method: this overload of this method takes no arguments and
   * creates a new boss with default values for each attribute
   */
  public WumboPrime() {
    this.name = "Wumbo Prime";
    this.type = "normal";
    this.maxHitPoints = 200;
    this.currentHitPoints = 200;
    this.maxArmor = 60;
    this.currentArmor = 60;
    this.experienceOffered = 300;
    this.requiredLevel = 5;
    this.firstBossAttack = new BossAttack("Armed Assault", 1, 30);
    this.secondBossAttack = new BossAttack("Extreme Super Punch", 2, 45);
  }

  public void armedAssault() {}

  public void extremeSuperPunch() {}
}
