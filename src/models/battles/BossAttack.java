package models.battles;

import models.wanimals.Wanimal;

public class BossAttack extends Attack {
  int damage; // set damage for this boss attack

  /**
   * Constructor method: this overload of this method takes an argument for
   * every possible attribute and uses them to create a new attack
   *
   * @param name - the name with which to create the new attack
   * @param type - the type with which to create the new attack
   * @param damage - the damage with which to create the new attack
   */
  public BossAttack(String name, int type, int damage) {
    super(name, type); // call superconstructor
    this.damage =
        damage; // set the damage of this boss attack to the damage given
  }

  /**
   * Constructor method: this overload of this method takes no arguments and
   * creates a new attack with default values for each attribute
   */
  public BossAttack() {
    super();
    this.damage = 40;
  }

  /**
   * This function executes the attack, applying the appropriate damage to the
   * enemy wanimal. This method overrides the execute defined by the Attack
   * class
   *
   * @param currentBoss - the boss whose turn it currently is
   * @param enemyWanimal - the enemy wanimal on to which to execute the attack
   */
  @Override
  public void execute(Wanimal currentBoss, Wanimal enemyWanimal) {
    // calculate the amount of damage to do to the enemy wanimal,
    int damageToDo = this.damage;

    if (damageToDo >=
        enemyWanimal
            .getCurrentArmor()) { // if the damage to do is greater than or
                                  // equal to the enemy wanimal's armor
      int remainingDamage =
          damageToDo -
          enemyWanimal.getCurrentArmor(); // calculate the amount of damage that
                                          // would remain after the enemy is
                                          // stripped of their armor

      enemyWanimal.setCurrentArmor(0); // set the enemy wanimal's armor to 0
      enemyWanimal.setCurrentHitpoints(
          enemyWanimal.getCurrentHitpoints() -
          remainingDamage); // take the remaning damage off of the enemy's HP
    } else { // else, if the amount of damage to do is less than the enemy
             // wanimal's armor
      enemyWanimal.setCurrentArmor(
          enemyWanimal.getCurrentArmor() -
          damageToDo); // take all the damage off the enemy wanimal's armor,
                       // leaving their health alone
    }

    // finally, if the enemy wanimal's health is lower than 0, set their health
    // back to 0
    enemyWanimal.setCurrentHitpoints(enemyWanimal.getCurrentHitpoints() < 0
                                         ? 0
                                         : enemyWanimal.getCurrentHitpoints());
  }
}
