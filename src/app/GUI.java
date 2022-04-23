package app;

import javax.swing.JFrame;

public class GUI {
  private JFrame frame;

  public GUI() {
    setupGUI();
    frame.setVisible(true);
  }

  private void setupGUI() {
    frame = new JFrame();
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
