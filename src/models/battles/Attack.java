package models.battles;

public class Attack {
  private String name; // the name of the attack
  private int type;    // the type of attack (1 or 2)

  /**
   * Constructor method: this overload of this method takes an argument for
   * every possible attribute and uses them to create a new attack
   *
   * @param name - the name with which to create the new attack
   * @param type - the type with which to create the new attack
   */
  public Attack(String name, int type) {
    this.name = name;
    this.type = type;
  }

  /**
   * Constructor method: this overload of this method takes no arguments and
   * creates a new attack with default values for each attribute
   */
  public Attack() {
    this.name = "no_name";
    this.type = 1;
  }

  // getters and setters

  public String getName() { return name; }

  public void setName(String name) { this.name = name; }

  public int getType() { return type; }

  public void setType(int type) { this.type = type; }
}
