/******************************************************************************
Program: BattleUtils Class (Wanimals)

Description: This is the BattleUtils class.

Date: June 1, 2022
*******************************************************************************/

package utils;

import app.Engine;
import app.GUI;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import models.battles.attacks.Attack;
import models.battles.battles.Battle;
import models.bosses.Boss;
import models.player.Player;
import models.wanimals.Wanimal;

public class BattleUtils {
  /**
   * This method starts a battle with the given enemy.
   *
   * @param enemy - the enemy with which to start the new battle
   */
  public static void createBattle(final Wanimal enemy) {
    final Player player = Engine.getPlayer(); // get the player of the current game

    Engine.setCurrentBattle(
        new Battle(player, player.getWanimals().get(0),
                   enemy)); // set the current battle to a battle between the
                            // player's first wanimal and the enemy given

    Engine.getGui().addToBattleLog("Battle has started.");

    final Timer timer = new Timer(); // create a new timer object. This will be used
                               // to check any condition that must be repeatedly
                               // check during the battle

    // every two seconds, execute the run method defined below. This is where
    // any condition that needs to repeatedly be checked for the duration of the
    // battle will be checked.
    timer.scheduleAtFixedRate(new TimerTask() {
      @Override
      public void run() {
        final Battle currentBattle = Engine.getCurrentBattle();

        if (!(currentBattle != null &&
              currentBattle.isRunning())) { // if there isn't a battle or if
                                            // it's not running
          Engine.getGui().addToBattleLog("Battle is ending.");

          timer.cancel(); // cancel the current timer immediately
          BattleUtils.endCurrentBattle(); // end the current battle
        }

        if (currentBattle.getCurrentTurn() ==
            0) { // if the battle is running and it is the enemy's turn
          currentBattle.setCurrentTurn(
              1); // revert to the player's turn as fast as possible so nothing
                  // runs more than it has to

          // wait one second and execute the enemy attack. The wait will give
          // time for adding to the battle logs
          Utils.delayRun(1000, new Runnable() {
            @Override
            public void run() {
              BattleUtils.enemyAttack(currentBattle);
              Engine.getGui().refreshBattleGUI(
                  currentBattle); // refresh the battle GUI
            }
          });
        }

        if (currentBattle.getPlayerWanimal().getCurrentHitpoints() ==
            0) { // if at any point the health of the player's wanimal  is
                 // depleted
          Engine.getGui().addToBattleLog(
              currentBattle.getPlayerWanimal().getName() + " fainted!");
          Engine.getCurrentBattle().setIsRunning(
              false); // end the battle immediately
        }

        if (currentBattle.getEnemy().getCurrentHitpoints() ==
            0) { // if at any point the health of the the enemy is depleted
          Engine.getGui().addToBattleLog("The enemy has been defeated!");
          Engine.getCurrentBattle().setIsRunning(
              false); // end the battle immediately
        }
      }
    }, new Date(), 1000);
  }

  /**
   * This method takes a battle and makes the enemy in that battle attack the
   * player's current active wanimal in that battle
   *
   * @param battle - the battle information to use to execute the attack
   */
  public static void enemyAttack(final Battle battle) {
    final Wanimal enemy = battle.getEnemy(); // get and store the enemy in a variable
    // for easier access
    Attack attackToExecute =
        enemy.getFirstAttack(); // this variable stores the attack to execute.
    // Set the attack to execute to the first attack
    // of the enemy by default (this may change
    // later)
    final int[] percentageChancesForSecondAttack = {50, 65, 80};

    if (enemy.getLevel() >=
        5) { // if the enemy has a level greater than or equal to 5 (meaning
      // they have both attacks avaialable to them. Note that this part
      // part will never execute for enemy under level 5 because they do
      // not have their seocnd attack available
      final double randomNum = Math.random(); // get a random number from 0.0 to 1.0

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

    Engine.getGui().addToBattleLog("The enemy used " +
                                   attackToExecute.getName() + ".");

    attackToExecute.execute(
        enemy,
        Engine.getCurrentBattle()
            .getPlayerWanimal()); // execute the attack on the player's wanimal
  }

  /**
   * Applies the given amount of XP to the given wanimal, factoring in leveling
   * up.
   *
   * @param xp - the amount of XP to apply
   * @param wanimal - the wanimal to which the XP must be applied
   */
  private static void applyXPtoWanimal(final int xp, final Wanimal wanimal) {
    Engine.getGui().addToBattleLog(wanimal.getName() + " gained " + xp +
                                   " xp.");
    for (int i = 0; i < xp; i++) { // for the number of XP there are
      wanimal.setCurrentXP(wanimal.getCurrentXP() + 1); // add one to the XP

      if (wanimal.getCurrentXP() ==
          wanimal.getMaxXP()) { // if the wanimal has reached enough XP for the
                                // next level
        GameUtils.levelUpWanimal(wanimal);
      }
    }
  }

  /**
   * Applies the given amount of XP to the given player, factoring in leveling
   * up.
   *
   * @param xp - the amount of XP to apply
   * @param player - the player to which the XP must be applied
   */
  private static void applyXPtoPlayer(final int xp, final Player player) {
    Engine.getGui().addToBattleLog(player.getName() + " gained " + xp + " xp.");

    for (int i = 0; i < xp; i++) { // for the number of XP there are
      player.setCurrentXP(player.getCurrentXP() + 1); // add one to the XP

      if (player.getCurrentXP() ==
          player.getMaxXP()) { // if the player has reached enough XP for the
                               // next level
        GameUtils.levelUpPlayer(player);
      }
    }
  }

  /**
   * This method gives the correct XP to all entities in a given battle
   *
   * @param battle - the battle whose entities to which the XP must be granted
   */
  private static void giveBattleXP(final Battle battle) {
    int xpToFulfill = 0; // this variable will store the XP that needs to be
                         // granted based on the calculations below

    final Player player = battle.getPlayer();
    if (battle.getEnemy().getClass() ==
        Boss.class) { // if the enemy wanimal is a boss
                      // the player's inventory
      // attempt to get the experience that this boss offers and store it in
      // the xpToFulfill variable
      try {
        xpToFulfill = (int)battle.getEnemy()
                          .getClass()
                          .getMethod("getExperienceOffered")
                          .invoke(null);
      } catch (IllegalAccessException | InvocationTargetException |
               NoSuchMethodException |
               SecurityException e) { // if the operation fails
        e.printStackTrace();          // print the error message
      };
    } else { // if the enemy wanimal is a regular wild wanimal
      final Wanimal enemy = battle.getEnemy(); // get the enemy for this battle

      xpToFulfill =
          100; // set a default value of 100 for the XP needed to be fulfilled

      if (player.getLevel() <
          enemy.getLevel()) { // if the player's level is less than
                              // that of the wanimal
        xpToFulfill +=
            25 * (enemy.getLevel() -
                  player.getLevel()); // add XP based on how many levels more
                                      // the enemy is than the player
      } else { // if the player is of a greater level than the enemy wanimal
        xpToFulfill -=
            10 * (player.getLevel() -
                  enemy.getLevel()); // remove XP based on how many levels
                                     // less the enemy is than the player
      }
    }

    // apply the XP calculated to each of the player's wanimals
    for (final Wanimal wanimal : player.getWanimals()) {
      applyXPtoWanimal(xpToFulfill, wanimal);
    }

    // apply 80% of total XP applied to ALL wanimals to the player themselves
    applyXPtoPlayer(xpToFulfill * player.getWanimals().size(), player);
  }

  /**
   * Restores the health and armor for the player's wanimals in the battle
   * given.
   *
   * @param currentBattle - the battle containing the player whose wanimals must
   *     be restored to full health and armor
   */
  public static void restoreHPAndArmor(final Battle currentBattle) {
    for (final Wanimal wanimal : currentBattle.getPlayer().getWanimals()) {
      wanimal.setCurrentHitpoints(wanimal.getMaxHitpoints());
      wanimal.setCurrentArmor(wanimal.getMaxArmor());
    }

    Engine.getGui().addToBattleLog(
        "Player's wanimals were restored to full health and armor.");
  }

  /**
   * This method ends the battle currently in progress. It will deal with
   * resetting the Engine, with what to do with the player's wanimals, and with
   * XP assignment
   */
  public static void endCurrentBattle() {
    final GUI gui = Engine.getGui(); // get the current GUI

    gui.setBattleButtonsEnabled(
        false); // set all buttons on the battle screen to disabled if
                // they are not already disabled

    final Battle currentBattle = Engine.getCurrentBattle();

    // Determine the situation for the battle ending:
    // 1. Did the player win? (XP + health restored)
    // 2. Did the player lose? (health restored)
    // 3. Did the player catch or flee? (nothing, implicit condition)

    // if the enemy's health is depleted (the player won)
    if (currentBattle.getEnemy().getCurrentHitpoints() == 0) {
      // set the HP of each wanimal back to full
      BattleUtils.restoreHPAndArmor(currentBattle);

      // give the correct amount of XP to battle entities
      BattleUtils.giveBattleXP(currentBattle);
    } else if (currentBattle.getPlayerWanimal().getCurrentHitpoints() ==
               0) { // if the player's health is depleted (the player lost)
      // set the HP of each wanimal back to full, but don't give XP
      BattleUtils.restoreHPAndArmor(currentBattle);
    }

    // wait two seconds
    Utils.delayRun(4000, new Runnable() {
      @Override
      public void run() {
        // go back to the move select screen
        gui.getMasterLayout().show(gui.getContentPane(), "panel_moveSelect");
      }
    });

    Engine.setCurrentBattle(null); // set the current battle to null (discarding
                                   // of the info about the current battle
  }
}
