package utils;

import javax.swing.SwingWorker;

public class Utils {
  /**
   * This method waits asynchronously a certain number of milliseconds before
   * running the method given
   *
   * @param ms - the number of milliseconds for which to wait
   * @param callback - the callback to run after the delay is done
   */
  public static void delayRun(int ms, Runnable callback) {
    // using a SwingWorker object, asynchronously wait for 2 seconds and then
    // execute the given method
    final SwingWorker<Object, Object> worker =
        new SwingWorker<Object, Object>() {
          /**
           * This method sleeps for the milliseconds given in a separate thread
           *
           * @return - this method returns a generic Object
           * @throws - this method throws an exception if it fails
           */
          @Override
          protected Object doInBackground() throws Exception {
            Thread.sleep(ms);
            return null;
          }

          /**
           * This method will automatically fire when the above background
           * task is done. It will run the callback method given
           */
          @Override
          protected void done() {
            callback.run();
            super.done();
          }
        };

    worker.execute(); // this method call executes the SwingWorker and the
                      // declared methods
  }

  /**
   * This method takes a percentage chance, and potentially runs the method.
   * The higher the percentage chance is, the higher the chance of the method.
   * running
   *
   * @param percentageChance - the percentage chance to follow for if the method
   *     should be run or not
   * @param callback - the method to execute if the percentage chance is
   *     triggered
   */
  public static void runMaybe(int percentageChance, Runnable callback) {
    double randomNum = Math.random(); // get a random number from 0.0 to 1.0
    if (randomNum <
        percentageChance /
            100.0) { // if the random number is less than the number given
      System.out.println("Utils#runMaybe#if"); // __AUTO_GENERATED_PRINTF__
      callback.run();                          // then run the given method
    }
  }
}
