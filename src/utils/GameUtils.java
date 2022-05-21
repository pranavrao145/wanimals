package utils;

import static java.util.Map.entry;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import models.player.Player;
import models.wanimals.Wanimal;
import models.wanimals.wanimals.fire.Ash;
import models.wanimals.wanimals.fire.Ember;
import models.wanimals.wanimals.grass.Plant;
import models.wanimals.wanimals.grass.Tryone;
import models.wanimals.wanimals.normal.Norman;
import models.wanimals.wanimals.normal.Wumbo;
import models.wanimals.wanimals.water.Aqua;
import models.wanimals.wanimals.water.Hydron;

public class GameUtils {
  // this HashMap contains String keys, which represent the four types in this
  // game. Each key has String values. The value of a key is the wanimal type
  // against which a wanimal of the current type (the key) is strong.
  private static HashMap<String, String> vulnerabilities =
      new HashMap<String, String>(
          Map.ofEntries(entry("normal", "none"), entry("water", "fire"),
                        entry("grass", "water"), entry("fire", "grass")));

  // this is a list of all of the wanimal classes available. It will be used to
  // randomly generate a wanimal
  private static ArrayList<Class<? extends Wanimal>> wanimalList =
      new ArrayList<Class<? extends Wanimal>>(
          Arrays.asList(Ash.class, Ember.class, Plant.class, Tryone.class,
                        Norman.class, Wumbo.class, Aqua.class, Hydron.class));

  /**
   * This method generates a new random wanimal given a realm and returns it.
   *
   * @param realm - the realm to follow when generating this wanimal
   * @return - the randomly generated wanimal
   */
  public static Wanimal generateRandomWanimal(int realm) {
    Class<? extends Wanimal> randomWanimalClass =
        wanimalList.get(ThreadLocalRandom.current().nextInt(
            wanimalList
                .size())); // get a random wanimal class from the list above

    Wanimal randomWanimal =
        new Wanimal(); // variable to store random wanimal created below

    try { // attempt to create the new wanimal, else handle the exception
      randomWanimal = randomWanimalClass.getDeclaredConstructor()
                          .newInstance(); // this special way of initializing
                                          // the wanimal must be used because
                                          // the class' constructor is ambiguous
    } catch (InstantiationException | IllegalAccessException |
             IllegalArgumentException | InvocationTargetException |
             NoSuchMethodException | SecurityException e) {
      System.out.println(
          "Failed to create random wanimal. The error message is below: ");
      e.printStackTrace();
      System.exit(0); // exit immediately, or the app will not work properly
    }

    switch (realm) { // depending on the realm the user is in
    case 1:          // if the user is in the first realm
      randomWanimal.setLevel(
          ThreadLocalRandom.current().nextInt(1, 6)); // assign a level from 1-5
      break;
    case 2: // if the user is in the second realm
      randomWanimal.setLevel(ThreadLocalRandom.current().nextInt(
          5, 11)); // assign a level from 6-10
      break;
    case 3: // if the user is in the third realm
      randomWanimal.setLevel(ThreadLocalRandom.current().nextInt(
          11, 16)); // assign a level from 11-15
      break;
    }

    // update the base attack to match the level of the new wanimal
    for (int i = 0; i < randomWanimal.getLevel() - 1; i++) {
      randomWanimal.setBaseAttack((int)(randomWanimal.getBaseAttack() * 1.10));
    }

    // update the max hitpoints to match the level of the new wanimal
    for (int i = 0; i < randomWanimal.getLevel() - 1; i++) {
      randomWanimal.setMaxHitpoints(
          (int)(randomWanimal.getMaxHitpoints() * 1.10));
    }

    // update the armor to the armor for the wanimal's level
    randomWanimal.setMaxArmor(
        (int)Math.round(0.20 * randomWanimal.getMaxHitpoints()));

    // restore health and armor to full
    randomWanimal.setCurrentHitpoints(randomWanimal.getMaxHitpoints());
    randomWanimal.setCurrentArmor(randomWanimal.getMaxArmor());

    return randomWanimal; // return the newly created random wanimal back to the
                          // caller
  }

  /**
   * This method takes a wanimal object and levels it up by one, adjusting its
   * attributes accordingly
   *
   * @param wanimal - the wanimal to level up
   */
  public static void levelUpWanimal(Wanimal wanimal) {
    wanimal.setLevel(wanimal.getLevel() +
                     1); // add one to the level of the wanimal

    wanimal.setCurrentXP(0); // set the current XP back to 0
    wanimal.setMaxXP((wanimal.getLevel() + 1) *
                     100); // increase the max XP required for this wanimal

    wanimal.setMaxHitpoints((int)Math.round(
        (1.20 * wanimal.getMaxHitpoints()))); // increase hitpoints by 20%
    wanimal.setCurrentHitpoints(
        wanimal.getMaxHitpoints()); // restore full health

    wanimal.setMaxArmor((int)Math.round(
        (1.20 * wanimal.getMaxArmor())));           // increase armor by 20%
    wanimal.setCurrentArmor(wanimal.getMaxArmor()); // restore full armor

    wanimal.setBaseAttack((int)Math.round(
        (1.10 * wanimal.getBaseAttack()))); // increase base attack by 10%
    wanimal.setBaseAttack(wanimal.getBaseAttack()); // restore full base attack
  }

  /**
   * This method takes a player object and levels it up by one
   *
   * @param player - the player to level up
   */
  public static void levelUpPlayer(Player player) {
    player.setLevel(player.getLevel() +
                    1); // add one to the level of the player
  }

  // getters and setters

  public static HashMap<String, String> getVulnerabilities() {
    return vulnerabilities;
  }

  public static void
  setVulnerabilities(HashMap<String, String> vulnerabilities) {
    GameUtils.vulnerabilities = vulnerabilities;
  }
}
