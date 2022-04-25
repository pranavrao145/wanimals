package models.bosses;

public class Boss {
  protected String name, type;
  protected int maxHitPoints, currentHitPoints, maxArmor, currentArmor,
      experienceOffered, requiredLevel;

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
  public Boss(String name, String type, int maxHitPoints, int currentHitPoints,
              int maxArmor, int currentArmor, int experienceOffered,
              int requiredLevel) {
    this.name = name; // set the name of this boss to the name given
    this.type = type; // set the type of this boss to the type given
    this.maxHitPoints = maxHitPoints; // set the maxHitPoints of this boss to
                                      // the maxHitPoints given
    this.currentHitPoints =
        currentHitPoints; // set the currentHitPoints of this boss to the
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
  }

  /**
   * Constructor method: this overload of this method takes no arguments and
   * creates a new boss with default values with each attribute
   */
  public Boss() {
    this.name = "no_name";
    this.type = "no_type";
    this.maxHitPoints = 200;
    this.currentHitPoints = 200;
    this.maxArmor = 60;
    this.currentArmor = 60;
    this.experienceOffered = 300;
    this.requiredLevel = 5;
  }

  // getters and setters

  public String getName() { return name; }

  public void setName(String name) { this.name = name; }

  public String getType() { return type; }

  public void setType(String type) { this.type = type; }

  public int getMaxHitPoints() { return maxHitPoints; }

  public void setMaxHitPoints(int maxHitPoints) {
    this.maxHitPoints = maxHitPoints;
  }

  public int getCurrentHitPoints() { return currentHitPoints; }

  public void setCurrentHitPoints(int currentHitPoints) {
    this.currentHitPoints = currentHitPoints;
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
}
