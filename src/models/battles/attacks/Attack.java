/******************************************************************************
Program: Attack Class (Wanimals)

Description: This is the Attack class.

Date: June 1, 2022
*******************************************************************************/

package models.battles.attacks;

import java.util.concurrent.ThreadLocalRandom;

import app.Engine;
import models.wanimals.Wanimal;
import utils.GameUtils;

public class Attack {
  protected String name; // the name of the attack
  protected int type;    // the type of attack (1 or 2)

  /**
   * Constructor method: this overload of this method takes an argument for
   * every possible attribute and uses them to create a new attack
   *
   * @param name - the name with which to create the new attack
   * @param type - the type with which to create the new attack
   */
  public Attack(final String name, final int type) {
    this.name = name; // set the name of this attack to the name given
    this.type = type; // set the type of this attack to the type given
  }

  /**
   * Constructor method: this overload of this method takes no arguments and
   * creates a new attack with default values for each attribute
   */
  public Attack() {
    this.name = "no_name";
    this.type = 1;
  }

  /**
   * This method executes the attack, applying the appropriate damage to the
   * enemy wanimal based on the current wanimal's base attack stat. This is an
   * overload of the below method, which deals with wanimal vs. boss.
   *
   * @param currentWanimal - the wanimal whose turn it currently is
   * @param enemyWanimal - the enemy wanimal on to which to execute the attack
   */
  public void execute(final Wanimal currentWanimal, final Wanimal enemyWanimal) {
    // calculate the amount of damage to do to the enemy wanimal, depeding on if
    // the attacks is type 1 or 2
    int damageToDo =
        (int)(this.type == 1 ? currentWanimal.getBaseAttack()
                             : currentWanimal.getBaseAttack() * 1.10);

    // if the enemy wanimal is vulnerable to the current wanimal
    if (GameUtils.getVulnerabilities().get(currentWanimal.getType()) ==
        enemyWanimal.getType()) {
      // get a random number from 10 to 20 (inclusive) and store it in a
      // variable to calculate how much more damage must be done to the
      // vulnerable wanimal
      final int addedDamage = ThreadLocalRandom.current().nextInt(10, 21);

      // update the damage to do with the new damage added
      damageToDo *= (1.0 + addedDamage / 100.0);

      Engine.getGui().addToBattleLog("The attack was very effective.");
    }

    if (damageToDo >=
        enemyWanimal
            .getCurrentArmor()) { // if the damage to do is greater than or
                                  // equal to the enemy wanimal's armor
      final int remainingDamage =
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

  // getters and setters

  public String getName() { return name; }

  public void setName(final String name) { this.name = name; }

  public int getType() { return type; }

  public void setType(final int type) { this.type = type; }
}
