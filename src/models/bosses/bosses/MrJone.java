package models.bosses.bosses;

import models.battles.attacks.BossAttack;
import models.bosses.Boss;

public class MrJone extends Boss {
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
  public MrJone(String name, String type, int maxHitPoints,
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
  public MrJone() {
    this.name = "Mr. Jone";
    this.type = "normal";
    this.maxHitpoints = 600;
    this.currentHitpoints = 600;
    this.maxArmor = 180;
    this.currentArmor = 180;
    this.experienceOffered = 500;
    this.requiredLevel = 15;
    this.firstBossAttack = new BossAttack("Give Assignment", 1, 50);
    this.secondBossAttack = new BossAttack("Give Test", 2, 65);
  }

  public void giveAssignment() {}

  public void giveTest() {}
}
