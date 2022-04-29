package utils;

import javax.swing.SwingWorker;

public class Utils {
  public static void delay(int ms, Runnable callback) {
    // using a SwingWorker object, asynchronously wait for 2 seconds and then
    // execute the given function
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
           * task is done. It will run the callback function given
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
}
