package models.battles;

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
}
