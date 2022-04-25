package models.bosses.bosses;

import models.bosses.Boss;

public class HydronPrime extends Boss {
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
   */
  public HydronPrime(String name, String type, int maxHitPoints,
                     int currentHitPoints, int maxArmor, int currentArmor,
                     int experienceOffered, int requiredLevel) {
    super(name, type, maxHitPoints, currentHitPoints, maxArmor, currentArmor,
          experienceOffered,
          requiredLevel); // call the superconstructor with the given values
  }

  /**
   * Constructor method: this overload of this method takes no arguments and
   * creates a new boss with default values with each attribute
   */
  public HydronPrime() {
    this.name = "Hydron Prime";
    this.type = "water";
    this.maxHitPoints = 400;
    this.currentHitPoints = 400;
    this.maxArmor = 120;
    this.currentArmor = 120;
    this.experienceOffered = 400;
    this.requiredLevel = 10;
  }

  public void enhancedDrown() {}

  public void megaFlood() {}
}
