/******************************************************************************
Program: App Class (Wanimals)

Description: This is the driver code for this student database. This class' main
method will start the entire program.

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
