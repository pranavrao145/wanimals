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

    Timer timer = new Timer();

    timer.scheduleAtFixedRate(new TimerTask() {
      @Override
      public void run() {
        if (!(Engine.getCurrentBattle() != null &&
              Engine.getCurrentBattle()
                  .isRunning())) { // if there isn't a battle or if it's not
                                   // running
          timer.cancel();          // cancel the current timer
        }
      }
    }, new Date(), 2000);
  }
}
