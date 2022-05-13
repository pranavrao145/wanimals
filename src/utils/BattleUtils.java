package utils;

import app.Engine;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import models.battles.attacks.Attack;
import models.battles.attacks.BossAttack;
import models.battles.battles.Battle;
import models.battles.battles.BossBattle;
import models.bosses.Boss;
import models.wanimals.Wanimal;

public class BattleUtils {
  /**
   * This method starts a battle with the given enemy.
   *
   * @param enemy - the enemy with which to start the new battle
   */
  public static void createBattle(Wanimal enemy) {
    // TODO: change playerWanimal to actual player Wanimal
    Engine.setCurrentBattle(
        new Battle(Engine.getPlayer(), GameUtils.generateRandomWanimal(1),
                   enemy)); // set the current battle to a battle between the
    // player's first wanimal and the enemy given

    Timer timer = new Timer(); // create a new timer object. This will be used
    // to check any condition that must be repeatedly
    // check during the battle

    // every two seconds, execute the run method defined below. This is where
    // any condition that needs to repeatedly be checked for the duration of the
    // battle will be checked.
    timer.scheduleAtFixedRate(new TimerTask() {
      @Override
      public void run() {
        if (!(Engine.getCurrentBattle() != null &&
              Engine.getCurrentBattle()
                  .isRunning())) { // if there isn't a battle or if it's not
          // running
          timer.cancel(); // cancel the current timer immediately
        }
      }
    }, new Date(), 2000);
  }

  /**
   * This method takes a battle and makes the enemy in that battle attack the
   * player's current active wanimal in that battle
   *
   * @param battle - the battle information to use to execute the attack
   */
  public static void enemyAttack(Battle battle) {
    Wanimal enemy = battle.getEnemy(); // get and store the enemy in a variable
    // for easier access
    Attack attackToExecute =
        enemy.getFirstAttack(); // this variable stores the attack to execute.
    // Set the attack to execute to the first attack
    // of the enemy by default (this may change
    // later)
    int[] percentageChancesForSecondAttack = {50, 65, 80};

    if (enemy.getLevel() >=
        5) { // if the enemy has a level greater than or equal to 5 (meaning
      // they have both attacks avaialable to them. Note that this part
      // part will never execute for enemy under level 5 because they do
      // not have their seocnd attack available
      double randomNum = Math.random(); // get a random number from 0.0 to 1.0

      if (randomNum <
          percentageChancesForSecondAttack[battle.getPlayer().getRealm() - 1] /
              100.0) { // if the random number is less than the second attack
        // percentage chance for this realm
        attackToExecute =
            enemy.getSecondAttack(); // set the attack to execute to the enemy's
        // second attack instead of the default
        // first attack
      }
    }

    attackToExecute.execute(
        enemy,
        Engine.getCurrentBattle()
            .getPlayerWanimal()); // execute the attack on the player's wanimal
  }

  /**
   * This method takes a boss battle and makes the boss in that battle attack
   * the player's current active wanimal in that battle
   *
   * @param battle - the boss battle information to use to execute the attack
   */
  public static void bossEnemyAttack(BossBattle battle) {
    Boss boss = battle.getEnemyBoss(); // get and store the boss in a variable
    // for easier access
    BossAttack attackToExecute =
        boss.getFirstBossAttack(); // this variable stores the attack to
    // execute. Set the attack to execute to the
    // first attack of the boss by default
    // (this may change later)

    double randomNum = Math.random(); // get a random number from 0.0 to 1.0

    if (randomNum < 90.0 / 100.0) { // if the 90% chance of the boss using their
      // second attack is satisfied
      attackToExecute =
          boss.getSecondBossAttack(); // set the attack to execute to the
      // boss's second attack instead of the
      // default first attack
    }

    attackToExecute.execute(boss,
                            Engine.getCurrentBattle()
                                .getPlayerWanimal()); // execute the boss attack
    // on the player's wanimal
  }

  /**
   * This method ends the battle currently in progress
   */
  public static void endCurrentBattle() {
    Engine.setCurrentBattle(null); // set the current battle to null (discarding
    // of the info about the current battle
  }
}
