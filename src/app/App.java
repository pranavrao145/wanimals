/******************************************************************************
Program: App Class (Wanimals)

Description: This is the file containing to main method, runs a new iteration
				of the game by running a Engine.run() command

Date: June 1, 2022
*******************************************************************************/

package app;

import java.awt.EventQueue;

public class App {
  public static void main(final String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Engine.run(new GUI());
        } catch (final Exception e) {
          e.printStackTrace();
        }
      }
    });
  }
}
