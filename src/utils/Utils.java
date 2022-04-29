package utils;

import javax.swing.SwingWorker;

public class Utils {
  public static void delay(int ms, Runnable callback) {
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

  public static void runMaybe(int percentageChance, Runnable callback) {
    double randomNum = Math.random(); // get a random number from 0.0 to 1.0
    if (randomNum <
        percentageChance /
            100) {    // if the random number is less than the number given
      callback.run(); // then run the given method
    }
  }
}
