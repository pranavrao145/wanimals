package models.battles.battles;

import models.bosses.Boss;
import models.player.Player;
import models.wanimals.Wanimal;

public class BossBattle extends Battle {
  private Boss enemyBoss; // this enemyBoss attribute will be set instead of the
                          // enemy attribute in the parent class

  /**
   * Constructor method: this overload of the constructor takes the
   * attributes required to make a Battle object. It also specially takes a Boss
   * to set as the enemy of this battle, rather than just a regular wanimal.
   *
   * @param player - the player with which to create the battle
   * @param playerWanimal - the wanimal that the player is currently using
   * @param enemyBoss - the enemy boss with which to create the battle
   */
  public BossBattle(Player player, Wanimal playerWanimal, Boss enemyBoss) {
    super(player,
          playerWanimal); // create the battle as if it was a regular battle
    this.enemyBoss =
        enemyBoss; // set the enemy of this battle to the boss given
  }

  // getters and setters

  public Boss getEnemyBoss() { return enemyBoss; }

  public void setEnemyBoss(Boss enemyBoss) { this.enemyBoss = enemyBoss; }
}
