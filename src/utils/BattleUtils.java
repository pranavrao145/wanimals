package utils;

import app.Engine;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import models.battles.battles.Battle;
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

    timer.scheduleAtFixedRate(new TimerTask() {
      @Override
      public void run() {
        if (!(Engine.getCurrentBattle() != null &&
              Engine.getCurrentBattle()
                  .isRunning())) { // if there isn't a battle or if it's not
                                   // running
          timer.cancel();          // cancel the current timer immediately
        }
      }
    }, new Date(), 2000);
  }

  /**
   * This method ends the battle currently in progress
   */
  public static void endBattle() {
    Engine.setCurrentBattle(null); // set the current battle to null (discarding
                                   // of the info about the current battle
  }
}
