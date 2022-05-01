package app;

import models.player.Player;
import models.wanimals.Wanimal;

public class Battle {
  private Player player; // to keep track of which player is battling
  private Wanimal playerWanimal,
      enemy; // to keep track of which wanimal the player is using, as well as
             // the enemy wanimal
  private int currentTurn; // 1 for player, 0 for enemy
  private boolean
      battleRunning; // to keep track of if the battle is currently running

  /**
   * Constructor method: this is the only overload of the constructor because
   * the attributes accepted are required to make a Battle object
   *
   * @param player - the player with which to create the battle
   * @param playerWanimal - the wanimal that the player is currently using
   * @param enemy - the enemy with which to create the battle
   */
  public Battle(Player player, Wanimal playerWanimal, Wanimal enemy) {
    this.player = player; // set the player of the battle to the player given
    this.playerWanimal = playerWanimal; // set the player's wanimal of the
                                        // battle to the player's wanimal given
    this.enemy = enemy;   // set the enemy of the wanimal to the enemy given
    this.currentTurn = 1; // start with the player's turn
    this.battleRunning = true; // the battle is always running be defualt
  }

  public Player getPlayer() { return player; }

  public void setPlayer(Player player) { this.player = player; }

  public Wanimal getPlayerWanimal() { return playerWanimal; }

  public void setPlayerWanimal(Wanimal playerWanimal) {
    this.playerWanimal = playerWanimal;
  }

  public Wanimal getEnemy() { return enemy; }

  public void setEnemy(Wanimal enemy) { this.enemy = enemy; }

  public int getCurrentTurn() { return currentTurn; }

  public void setCurrentTurn(int currentTurn) {
    this.currentTurn = currentTurn;
  }

  public boolean isBattleRunning() { return battleRunning; }

  public void setBattleRunning(boolean battleRunning) {
    this.battleRunning = battleRunning;
  }
}
