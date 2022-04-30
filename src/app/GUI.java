package app;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import utils.Utils;

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
  private JLabel lbl_battleTurn;
  private JLabel lbl_battlePlayerName;
  private JLabel lbl_battlePlayer;
  private JLabel lbl_battlePlayerHealth;
  private JButton btn_battleAttack1;
  private JButton btn_battleAttack2;
  private JButton btn_battleInventory;
  private JButton btn_battleSwitch;
  private JButton btn_battleFlee;
  private JButton btn_battleCatch;
  private JPanel panel_battleInventory;
  private JLabel lbl_battleInventoryWanimalHP;
  private JLabel lbl_battleInventoryWanimalArmor;
  private JLabel lbl_battleInventory;
  private JButton btn_battleInventoryUsePotion;
  private JButton btn_battleInventoryUseArmorPlate;
  private JLabel lbl_battleInventoryPotionsRemaining;
  private JLabel lbl_battleInventoryArmorPlatesRemaining;
  private JPanel panel_battleSwitch;
  private JLabel lbl_battleSwitch;
  private JLabel lbl_battleSwitchPrompt;
  private JComboBox<String> comboBox_battleSwitch;
  private JButton btn_battleSwitchAdvance;

  private DefaultComboBoxModel<String> defaultWanimalOptions;
  private JPanel panel_moveSelect;
  private JLabel lbl_moveSelect;
  private JButton btn_moveSelectAdvance;
  private JButton btn_moveSelectInventory;
  private JButton btn_moveSelectSaveAndQuit;

  public GUI() {
    initializeValues();
    setupGUI();
    attachListeners();
    frame.setVisible(true);
  }

  private void initializeValues() {
    defaultWanimalOptions = new DefaultComboBoxModel<String>(
        new String[] {"Wanimal 1", "Wanimal 2", "Wanimal 3", "Wanimal 4"});
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
    lbl_title.setFont(new Font("Dialog", Font.BOLD, 20));
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

    // show the title panel as the default panel when the app opens
    masterLayout.show(contentPane, "panel_title");

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
    lbl_battlePlayer.setBounds(57, 30, 60, 17);
    lbl_battlePlayer.setFont(new Font("Dialog", Font.BOLD, 14));
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
    lbl_battleEnemy.setBounds(320, 30, 60, 17);
    lbl_battleEnemy.setFont(new Font("Dialog", Font.BOLD, 14));
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

    lbl_battleTurn = new JLabel("Player's Turn");
    lbl_battleTurn.setBounds(170, 12, 112, 27);
    lbl_battleTurn.setFont(new Font("Dialog", Font.BOLD, 16));
    panel_battle.add(lbl_battleTurn);

    panel_battleInventory = new JPanel();
    frame.getContentPane().add(panel_battleInventory, "btn_battleInventory");
    panel_battleInventory.setLayout(null);

    lbl_battleInventory = new JLabel("Inventory");
    lbl_battleInventory.setBounds(177, 12, 84, 27);
    lbl_battleInventory.setFont(new Font("Dialog", Font.BOLD, 16));
    panel_battleInventory.add(lbl_battleInventory);

    btn_battleInventoryUsePotion = new JButton("Use Potion");
    btn_battleInventoryUsePotion.setBounds(40, 145, 144, 62);
    panel_battleInventory.add(btn_battleInventoryUsePotion);

    btn_battleInventoryUseArmorPlate = new JButton("Use Armor Plate");
    btn_battleInventoryUseArmorPlate.setBounds(252, 145, 144, 62);
    panel_battleInventory.add(btn_battleInventoryUseArmorPlate);

    lbl_battleInventoryPotionsRemaining = new JLabel("Potions remaining: 5");
    lbl_battleInventoryPotionsRemaining.setBounds(50, 219, 134, 17);
    panel_battleInventory.add(lbl_battleInventoryPotionsRemaining);

    lbl_battleInventoryArmorPlatesRemaining =
        new JLabel("Armor plates remaining: 5");
    lbl_battleInventoryArmorPlatesRemaining.setBounds(244, 219, 166, 17);
    panel_battleInventory.add(lbl_battleInventoryArmorPlatesRemaining);

    lbl_battleInventoryWanimalHP = new JLabel("Current wanimal's HP: 0");
    lbl_battleInventoryWanimalHP.setBounds(136, 60, 181, 17);
    lbl_battleInventoryWanimalHP.setFont(new Font("Dialog", Font.BOLD, 14));
    panel_battleInventory.add(lbl_battleInventoryWanimalHP);

    lbl_battleInventoryWanimalArmor = new JLabel("Current wanimal's armor: 0");
    lbl_battleInventoryWanimalArmor.setBounds(124, 89, 193, 17);
    lbl_battleInventoryWanimalArmor.setFont(new Font("Dialog", Font.BOLD, 14));
    panel_battleInventory.add(lbl_battleInventoryWanimalArmor);

    panel_battleSwitch = new JPanel();
    frame.getContentPane().add(panel_battleSwitch, "panel_battleSwitch");
    panel_battleSwitch.setLayout(null);

    lbl_battleSwitch = new JLabel("Switch Wanimal");
    lbl_battleSwitch.setFont(new Font("Dialog", Font.BOLD, 16));
    lbl_battleSwitch.setBounds(146, 12, 141, 27);
    panel_battleSwitch.add(lbl_battleSwitch);

    lbl_battleSwitchPrompt = new JLabel("Select a wanimal to switch to:");
    lbl_battleSwitchPrompt.setFont(new Font("Dialog", Font.BOLD, 14));
    lbl_battleSwitchPrompt.setBounds(113, 98, 214, 17);
    panel_battleSwitch.add(lbl_battleSwitchPrompt);

    comboBox_battleSwitch = new JComboBox<String>(defaultWanimalOptions);
    comboBox_battleSwitch.setBounds(113, 127, 214, 26);
    panel_battleSwitch.add(comboBox_battleSwitch);

    btn_battleSwitchAdvance = new JButton("Advance");
    btn_battleSwitchAdvance.setBounds(12, 231, 416, 27);
    panel_battleSwitch.add(btn_battleSwitchAdvance);

    panel_moveSelect = new JPanel();
    frame.getContentPane().add(panel_moveSelect, "panel_moveSelect");
    panel_moveSelect.setLayout(null);

    lbl_moveSelect = new JLabel("Select Next Move");
    lbl_moveSelect.setFont(new Font("Dialog", Font.BOLD, 16));
    lbl_moveSelect.setBounds(150, 37, 146, 17);
    panel_moveSelect.add(lbl_moveSelect);

    btn_moveSelectAdvance = new JButton("Advance");
    btn_moveSelectAdvance.setBounds(123, 85, 189, 60);
    panel_moveSelect.add(btn_moveSelectAdvance);

    btn_moveSelectInventory = new JButton("Inventory");
    btn_moveSelectInventory.setBounds(25, 179, 189, 60);
    panel_moveSelect.add(btn_moveSelectInventory);

    btn_moveSelectSaveAndQuit = new JButton("Save and Quit");
    btn_moveSelectSaveAndQuit.setBounds(226, 179, 189, 60);
    panel_moveSelect.add(btn_moveSelectSaveAndQuit);
  }

  /**
   * This method attaches the appropriate listeners to all components defined
   * above
   */
  private void attachListeners() {
    /*************************************************************************
     * GENERAL LISTENERS
     *************************************************************************/

    // listener to run the quit method when the user closes the window
    frame.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(final WindowEvent e) {
        quit();
      }
    });

    /************************************************************************
     * TITLE SCREEN LISTENERS
     *************************************************************************/

    // listener to run the quit method when the user presses the quit button
    btn_titleQuit.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        quit();
      }
    });

    /************************************************************************
     * MOVE SELECT SCREEN LISTENERS
     *************************************************************************/
    btn_moveSelectAdvance.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Utils.runMaybe(40, new Runnable() {
          @Override
          public void run() {
            // TODO: inform the user that they are going into a battle
            Engine.battle(); // start the battle
          }
        });
      }
    });

    /************************************************************************
     * BATTLE SCREEN LISTENERS
     *************************************************************************/

    // listener to show the battle inventory screen when the inventory
    // button is pressed on the battle screen
    btn_battleInventory.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        masterLayout.show(contentPane, "panel_battleInventory");
      }
    });

    // listener to show the battle switch screen when the switch button is
    // pressed on the battle screen
    btn_battleSwitch.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        masterLayout.show(contentPane, "panel_battleSwitch");
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
    // wait for 2 seconds, then quit the program
    Utils.delay(2000, new Runnable() {
      @Override
      public void run() {
        frame.dispose();
        System.exit(0);
      }
    });
  }
}
