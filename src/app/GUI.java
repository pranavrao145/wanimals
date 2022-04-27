package app;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

public class GUI {
  // the following set of fields represent the various GUI components used in
  // this app. To simplify the identification of components, all components are
  // named using this convention: componentType_panelNameComponentName
  // For example, a button to save on the add student panel would be named
  // btn_addStudentSave. Sometimes, to avoid duplication, the panel name is
  // omitted, such as in panel_title (instead of panel_titleTitle)

  private JFrame frame;
  private Container
      contentPane; // this is a special variable that will store the content
                   // pane of the frame so it does not need to be re-read every
                   // time we want to use it
  private CardLayout masterLayout; // this CardLayout is being stored because it
                                   // will be essential in switching views

  private JPanel panel_title;
  private JLabel lbl_title;
  private JLabel lbl_titleNames;
  private JButton btn_titleStart;
  private JButton btn_titleQuit;
  private JPanel panel_shutdown;
  private JLabel lbl_shutdownThanks;
  private JLabel lbl_shutdownMessage;
  private JPanel panel_battle;
  private JLabel lbl_battlePlayerArmor;
  private JLabel lbl_battleEnemyName;
  private JLabel lbl_battleEnemy;
  private JLabel lbl_battleEnemyHealth;
  private JLabel lbl_battleEnemyArmor;
  private JTextArea textArea_battleLog;
  private JLabel lblNewLabel_4;
  private JLabel lbl_battlePlayerName;
  private JLabel lbl_battlePlayer;
  private JLabel lbl_battlePlayerHealth;
  private JButton btn_battleAttack1;
  private JButton btn_battleAttack2;
  private JButton btn_battleInventory;
  private JButton btn_battleSwitch;
  private JButton btn_battleFlee;
  private JButton btn_battleCatch;

  public GUI() {
    setupGUI();
    attachListeners();
    frame.setVisible(true);
  }

  private void setupGUI() {
    frame = new JFrame();
    contentPane = frame.getContentPane();
    masterLayout = new CardLayout();

    frame.setResizable(false);
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(
        JFrame.DO_NOTHING_ON_CLOSE); // overriding default close behaviour so
                                     // custom close methods can run

    contentPane.setLayout(masterLayout);

    panel_title = new JPanel();
    frame.getContentPane().add(panel_title, "panel_title");
    panel_title.setLayout(null);

    lbl_title = new JLabel("Wanimals");
    lbl_title.setBounds(171, 99, 112, 17);
    lbl_title.setFont(new Font("Dialog", 1, 20));
    panel_title.add(lbl_title);

    lbl_titleNames = new JLabel("Pranav, Haseeb, Carson, Preet");
    lbl_titleNames.setBounds(136, 137, 185, 17);
    panel_title.add(lbl_titleNames);

    btn_titleStart = new JButton("Start");
    btn_titleStart.setBounds(57, 217, 105, 27);
    panel_title.add(btn_titleStart);

    btn_titleQuit = new JButton("Quit");
    btn_titleQuit.setBounds(285, 217, 105, 27);
    panel_title.add(btn_titleQuit);

    panel_shutdown = new JPanel();
    panel_shutdown.setLayout(null);
    frame.getContentPane().add(panel_shutdown, "panel_shutdown");

    lbl_shutdownThanks = new JLabel("Thanks for playing!");
    lbl_shutdownThanks.setFont(new Font("Dialog", Font.BOLD, 20));
    lbl_shutdownThanks.setBounds(125, 99, 197, 26);
    panel_shutdown.add(lbl_shutdownThanks);

    lbl_shutdownMessage = new JLabel("Shutting down...");
    lbl_shutdownMessage.setBounds(171, 137, 110, 17);
    panel_shutdown.add(lbl_shutdownMessage);

    panel_battle = new JPanel();
    frame.getContentPane().add(panel_battle, "panel_battle");
    panel_battle.setLayout(null);

    lbl_battlePlayerName = new JLabel("Wanimal Name");
    lbl_battlePlayerName.setBounds(38, 55, 93, 17);
    panel_battle.add(lbl_battlePlayerName);

    lbl_battlePlayer = new JLabel("PLAYER");
    lbl_battlePlayer.setBounds(57, 26, 60, 17);
    panel_battle.add(lbl_battlePlayer);

    lbl_battlePlayerHealth = new JLabel("Wanimal Health");
    lbl_battlePlayerHealth.setBounds(38, 73, 93, 17);
    panel_battle.add(lbl_battlePlayerHealth);

    lbl_battlePlayerArmor = new JLabel("Wanimal Armor");
    lbl_battlePlayerArmor.setBounds(38, 92, 93, 17);
    panel_battle.add(lbl_battlePlayerArmor);

    lbl_battleEnemyName = new JLabel("Wanimal Name");
    lbl_battleEnemyName.setBounds(301, 55, 93, 17);
    panel_battle.add(lbl_battleEnemyName);

    lbl_battleEnemy = new JLabel("ENEMY");
    lbl_battleEnemy.setBounds(320, 26, 60, 17);
    panel_battle.add(lbl_battleEnemy);

    lbl_battleEnemyHealth = new JLabel("Wanimal Health");
    lbl_battleEnemyHealth.setBounds(301, 73, 93, 17);
    panel_battle.add(lbl_battleEnemyHealth);

    lbl_battleEnemyArmor = new JLabel("Wanimal Armor");
    lbl_battleEnemyArmor.setBounds(301, 92, 93, 17);
    panel_battle.add(lbl_battleEnemyArmor);

    btn_battleAttack1 = new JButton("Attack 1");
    btn_battleAttack1.setBounds(12, 149, 105, 27);
    panel_battle.add(btn_battleAttack1);

    btn_battleAttack2 = new JButton("Attack 2");
    btn_battleAttack2.setBounds(129, 149, 105, 27);
    panel_battle.add(btn_battleAttack2);

    btn_battleInventory = new JButton("Inventory");
    btn_battleInventory.setBounds(129, 188, 105, 27);
    panel_battle.add(btn_battleInventory);

    btn_battleSwitch = new JButton("Switch");
    btn_battleSwitch.setBounds(12, 188, 105, 27);
    panel_battle.add(btn_battleSwitch);

    btn_battleFlee = new JButton("Flee");
    btn_battleFlee.setBounds(129, 227, 105, 27);
    panel_battle.add(btn_battleFlee);

    btn_battleCatch = new JButton("Catch");
    btn_battleCatch.setBounds(12, 227, 105, 27);
    panel_battle.add(btn_battleCatch);

    textArea_battleLog = new JTextArea();
    textArea_battleLog.setBounds(246, 149, 182, 105);
    panel_battle.add(textArea_battleLog);

    lblNewLabel_4 = new JLabel("Player's Turn");
    lblNewLabel_4.setBounds(178, 12, 93, 17);
    panel_battle.add(lblNewLabel_4);
  }

  /**
   * This method attaches the appropriate listeners to all components defined
   * above
   */
  private void attachListeners() {
    /*************************************************************************
     * GENERAL LISTENERS
     *************************************************************************/

    // listener to run the quit function when the user closes the window
    frame.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(final WindowEvent e) {
        quit();
      }
    });

    /************************************************************************
     * TITLE SCREEN LISTENERS
     *************************************************************************/

    // listener to run the quit function when the user presses the quit button
    btn_titleQuit.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        quit();
      }
    });
  }

  /**
   * This method will be run when the program is going to quit, either by
   * closing the window or by pressing the quit button
   */
  private void quit() {
    masterLayout.show(contentPane,
                      "panel_shutdown"); // switch to the shutdown panel

    // using a SwingWorker object, asynchronously wait for 2 seconds and then
    // quit the program
    final SwingWorker<Object, Object> worker =
        new SwingWorker<Object, Object>() {
          /**
           * This method sleeps for 1000 milliseconds in a separate thread
           *
           * @return - this method returns a generic Object
           * @throws - this method throws an exception if it fails
           */
          @Override
          protected Object doInBackground() throws Exception {
            Thread.sleep(2000);
            return null;
          }

          /**
           * This method will automatically fire when the above background
           * task is done. It will set the label back to the old text.
           */
          @Override
          protected void done() {
            frame.dispose();
            System.exit(0);
            super.done();
          }
        };

    worker.execute(); // this method call executes the SwingWorker and the
                      // declared methods
  }
}
