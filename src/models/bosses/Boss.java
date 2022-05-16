package models.bosses;

import models.battles.attacks.Attack;
import models.player.Player;
import models.wanimals.Wanimal;

public class Boss extends Wanimal {
  protected int experienceOffered, requiredLevel;

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
   * @param experienceOffered - the experienceOffered with which to create the
   *     new boss
   * @param requiredLevel - the requiredLevel with which to create the new
   *     boss
   */
  public Boss(String name, String type, int level, int maxHitpoints,
              int currentHitpoints, int baseAttack, int maxArmor,
              int currentArmor, Player owner, int maxXP, int currentXP,
              Attack firstAttack, Attack secondAttack, int experienceOffered,
              int requiredLevel) {
    super(name, type, level, maxHitpoints, currentHitpoints, baseAttack,
          maxArmor, currentArmor, owner, maxXP, currentXP, firstAttack,
          secondAttack); // call superconstructor
    this.experienceOffered = experienceOffered;
    this.requiredLevel = requiredLevel;
  }

  /**
   * Constructor method: this overload of this method takes no arguments and
   * creates a new boss with default values for each attribute
   */
  public Boss() {
    this.name = "no_name";
    this.type = "no_type";
    this.level = 1;
    this.baseAttack = 30;
    this.maxHitpoints = 200;
    this.currentHitpoints = 200;
    this.maxArmor = 60;
    this.currentArmor = 60;
    this.owner = null; // bosses have no owner
    this.experienceOffered = 300;
    this.requiredLevel = 5;
    this.maxXP = 200;
    this.currentXP = 0;
    this.firstAttack = null;
    this.secondAttack = null;
  }

  // getters and setters

  public int getExperienceOffered() { return experienceOffered; }

  public void setExperienceOffered(int experienceOffered) {
    this.experienceOffered = experienceOffered;
  }

  public int getRequiredLevel() { return requiredLevel; }

  public void setRequiredLevel(int requiredLevel) {
    this.requiredLevel = requiredLevel;
  }
}
