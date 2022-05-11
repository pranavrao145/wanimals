package models.battles.battles;

import models.player.Player;
import models.wanimals.Wanimal;

public class Battle {
  protected Player player; // to keep track of which player is battling
  protected Wanimal
      playerWanimal;     // to keep track of which wanimal the player is using
  private Wanimal enemy; // to keep track of the the enemy wanimal
  protected volatile int currentTurn; // 1 for player turn, 0 for enemy turn
  protected boolean
      running; // to keep track of if the battle is currently running

  /**
   * Constructor method: this overload of the constructor takes the
   * attributes required to make a Battle object
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
    this.running = true;  // the battle is always running be defualt
  }

  /**
   * Constructor method: this overload of the constructor takes the
   * attributes required to make a Battle object, except the enemy. This method
   * is here so inherited classes can comfortably use this class as a parent.
   *
   * @param player - the player with which to create the battle
   * @param playerWanimal - the wanimal that the player is currently using
   */
  public Battle(Player player, Wanimal playerWanimal) {
    this.player = player; // set the player of the battle to the player given
    this.playerWanimal = playerWanimal; // set the player's wanimal of the
                                        // battle to the player's wanimal given
    this.currentTurn = 1;               // start with the player's turn
    this.running = true; // the battle is always running be defualt
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

  public boolean isRunning() { return running; }

  public void setIsRunning(boolean battleRunning) {
    this.running = battleRunning;
  }
}
