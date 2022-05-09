package models.bosses;

import models.battles.attacks.BossAttack;

public class Boss {
  protected String name, type;
  protected int maxHitpoints, currentHitpoints, maxArmor, currentArmor,
      experienceOffered, requiredLevel;
  protected BossAttack firstBossAttack, secondBossAttack;

  /**
   * Constructor method: this overload of this method takes an argument for
   * every possible attribute and uses them to create a new boss
   *
   * @param name - the name with which to create the new boss
   * @param type - the type with which to create the new boss
   * @param maxHitpoints - the max hit points with which to create the new boss
   * @param currentHitpoints - the current hit points with which to create the
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
  public Boss(String name, String type, int maxHitpoints, int currentHitpoints,
              int maxArmor, int currentArmor, int experienceOffered,
              int requiredLevel, BossAttack firstBossAttack,
              BossAttack secondBossAttack) {
    this.name = name; // set the name of this boss to the name given
    this.type = type; // set the type of this boss to the type given
    this.maxHitpoints = maxHitpoints; // set the maxHitPoints of this boss to
                                      // the maxHitPoints given
    this.currentHitpoints =
        currentHitpoints; // set the currentHitPoints of this boss to the
                          // currentHitPoints given
    this.maxArmor =
        maxArmor; // set the maxArmor of this boss to the maxArmor given
    this.currentArmor = currentArmor; // set the currentArmor of this boss to
                                      // the currentArmor given
    this.experienceOffered =
        experienceOffered; // set the experienceOffered of this boss to the
                           // experienceOffered given
    this.requiredLevel = requiredLevel; // set the requiredLevel of this boss to
                                        // the requiredLevel given
    this.firstBossAttack = firstBossAttack; // set the firstBossAttack of this
                                            // boss to the firstBossAttack given
    this.secondBossAttack =
        secondBossAttack; // set the secondBossAttack of this boss to
                          // the secondBossAttack given
  }

  /**
   * Constructor method: this overload of this method takes no arguments and
   * creates a new boss with default values for each attribute
   */
  public Boss() {
    this.name = "no_name";
    this.type = "no_type";
    this.maxHitpoints = 200;
    this.currentHitpoints = 200;
    this.maxArmor = 60;
    this.currentArmor = 60;
    this.experienceOffered = 300;
    this.requiredLevel = 5;
    this.firstBossAttack = null;
    this.secondBossAttack = null;
  }

  // getters and setters

  public String getName() { return name; }

  public void setName(String name) { this.name = name; }

  public String getType() { return type; }

  public void setType(String type) { this.type = type; }

  public int getMaxHitpoints() { return maxHitpoints; }

  public void setMaxHitpoints(int maxHitPoints) {
    this.maxHitpoints = maxHitPoints;
  }

  public int getCurrentHitpoints() { return currentHitpoints; }

  public void setCurrentHitpoints(int currentHitPoints) {
    this.currentHitpoints = currentHitPoints;
  }

  public int getMaxArmor() { return maxArmor; }

  public void setMaxArmor(int maxArmor) { this.maxArmor = maxArmor; }

  public int getCurrentArmor() { return currentArmor; }

  public void setCurrentArmor(int currentArmor) {
    this.currentArmor = currentArmor;
  }

  public int getExperienceOffered() { return experienceOffered; }

  public void setExperienceOffered(int experienceOffered) {
    this.experienceOffered = experienceOffered;
  }

  public int getRequiredLevel() { return requiredLevel; }

  public void setRequiredLevel(int requiredLevel) {
    this.requiredLevel = requiredLevel;
  }

  public BossAttack getFirstBossAttack() { return firstBossAttack; }

  public void setFirstBossAttack(BossAttack firstBossAttack) {
    this.firstBossAttack = firstBossAttack;
  }

  public BossAttack getSecondBossAttack() { return secondBossAttack; }

  public void setSecondBossAttack(BossAttack secondBossAttack) {
    this.secondBossAttack = secondBossAttack;
  }
}
