/******************************************************************************
Program: GUI Class (Wanimals)

Description: This is the GUI class. 

Date: June 1, 2022
*******************************************************************************/

package app;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import models.battles.attacks.Attack;
import models.battles.battles.Battle;
import models.bosses.Boss;
import models.bosses.bosses.HydronPrime;
import models.bosses.bosses.MrJone;
import models.bosses.bosses.WumboPrime;
import models.player.Player;
import models.wanimals.Wanimal;
import models.wanimals.wanimals.fire.Ash;
import models.wanimals.wanimals.grass.Plant;
import models.wanimals.wanimals.normal.Wumbo;
import models.wanimals.wanimals.water.Aqua;
import utils.BattleUtils;
import utils.GameUtils;
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
  private JButton btn_titleNewGame;
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
  private JScrollPane scrollPane_battleLog;
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
  private DefaultComboBoxModel<String> defaultWanimalOptions,
      starterWanimalOptions;
  private JPanel panel_moveSelect;
  private JLabel lbl_moveSelect;
  private JButton btn_moveSelectAdvance;
  private JButton btn_moveSelectInventory;
  private JButton btn_moveSelectSaveAndQuit;
  private JButton btn_moveSelectBattleBoss;
  private JButton btn_titleLoadGame;
  private JLabel lbl_moveSelectName;
  private JLabel lbl_moveSelectRealm;
  private JLabel lbl_moveSelectLevel;
  private JLabel lbl_moveSelectXP;
  private JPanel panel_moveSelectInventory;
  private JTable table_moveSelectInventory;
  private JLabel lbl_moveSelectInventoryPotions;
  private JLabel lbl_moveSelectInventoryArmorPlates;
  private JPanel panel_battleInform;
  private JLabel lbl_battleInformPlayerWanimalArmor;
  private JLabel lbl_battleInformPlayerWanimalBaseAttack;
  private JLabel lbl_battleInformEnemyWanimal;
  private JLabel lbl_battleInformEnemyWanimalLevel;
  private JLabel lbl_battleInformEnemyWanimalHP;
  private JLabel lbl_battleInformEnemyWanimalArmor;
  private JLabel lbl_battleInformEnemyWanimalBaseAttack;
  private JLabel lbl_battleInformVersus;
  private JLabel lbl_battleInform;
  private JLabel lbl_battleInformPlayerWanimal;
  private JLabel lbl_battleInformPlayerWanimalLevel;
  private JLabel lbl_battleInformPlayerWanimalHP;
  private JLabel lbl_moveSelectInventoryTitle;
  private JButton btn_moveSelectInventoryBack;
  private JPanel panel_characterCreate;
  private JLabel lbl_characterCreate;
  private JLabel lbl_characterCreateName;
  private JTextField textField_characterCreateName;
  private JComboBox<String> comboBox_characterCreateStarterWanimal;
  private JLabel lbl_characterCreateStarterWanimal;
  private JButton btn_characterCreateAdvance;
  private ArrayList<Class<? extends Boss>> bossList;

  /**
   * This is a constructor for the GUI. When the GUI is made in the App class,
   * this method will be called.
   */
  public GUI() {
    initializeValues();
    setupGUI();
    attachListeners();
    frame.setVisible(true);
  }

  /**
   * This method is responsible for setting intial values for some variables
   * above, specifically the option models for the comboBox components.
   */
  private void initializeValues() {
    defaultWanimalOptions = new DefaultComboBoxModel<String>(
        new String[] {"Wanimal 1", "Wanimal 2", "Wanimal 3", "Wanimal 4"});

    starterWanimalOptions = new DefaultComboBoxModel<String>(
        new String[] {"Wumbo", "Plant", "Ash", "Aqua"});

    // this list contains classes for all the bosses in this game (used in the
    // boss logic)
    bossList = new ArrayList<Class<? extends Boss>>(
        Arrays.asList(WumboPrime.class, HydronPrime.class, MrJone.class));
  }

  /**
   * This method draws the GUI itself (i.e. it initializes the components
   * above). It will essentially create various panels for each view and put
   * them all into a CardLayout (masterLayout variable above) so that it is
   * possible to easily switch between the panels
   */
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
    lbl_titleNames.setBounds(130, 136, 194, 17);
    panel_title.add(lbl_titleNames);

    btn_titleNewGame = new JButton("New Game");
    btn_titleNewGame.setBounds(57, 217, 105, 27);
    panel_title.add(btn_titleNewGame);

    btn_titleQuit = new JButton("Quit");
    btn_titleQuit.setBounds(285, 217, 105, 27);
    panel_title.add(btn_titleQuit);

    btn_titleLoadGame = new JButton("Load");
    btn_titleLoadGame.setBounds(171, 217, 105, 27);
    panel_title.add(btn_titleLoadGame);

    // show the title panel as the default panel when the app opens
    masterLayout.show(contentPane, "panel_title");

    panel_shutdown = new JPanel();
    panel_shutdown.setLayout(null);
    frame.getContentPane().add(panel_shutdown, "panel_shutdown");

    lbl_shutdownThanks = new JLabel("Thanks for playing!");
    lbl_shutdownThanks.setFont(new Font("Dialog", Font.BOLD, 20));
    lbl_shutdownThanks.setBounds(120, 97, 237, 26);
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
    textArea_battleLog.setEditable(false);

    scrollPane_battleLog = new JScrollPane(textArea_battleLog);
    scrollPane_battleLog.setSize(182, 105);
    scrollPane_battleLog.setLocation(246, 149);
    panel_battle.add(scrollPane_battleLog);

    lbl_battleTurn = new JLabel("Player's Turn");
    lbl_battleTurn.setBounds(157, 12, 129, 27);
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
    lbl_moveSelect.setBounds(25, 36, 146, 17);
    panel_moveSelect.add(lbl_moveSelect);

    btn_moveSelectAdvance = new JButton("Advance");
    btn_moveSelectAdvance.setBounds(25, 91, 189, 60);
    panel_moveSelect.add(btn_moveSelectAdvance);

    btn_moveSelectInventory = new JButton("Inventory");
    btn_moveSelectInventory.setBounds(25, 179, 189, 60);
    panel_moveSelect.add(btn_moveSelectInventory);

    btn_moveSelectSaveAndQuit = new JButton("Save and Quit");
    btn_moveSelectSaveAndQuit.setBounds(226, 179, 189, 60);
    panel_moveSelect.add(btn_moveSelectSaveAndQuit);

    btn_moveSelectBattleBoss = new JButton("Battle Boss");
    btn_moveSelectBattleBoss.setEnabled(false);
    btn_moveSelectBattleBoss.setBounds(226, 91, 189, 60);
    panel_moveSelect.add(btn_moveSelectBattleBoss);

    lbl_moveSelectName = new JLabel("Name");
    lbl_moveSelectName.setBounds(226, 23, 97, 17);
    panel_moveSelect.add(lbl_moveSelectName);

    lbl_moveSelectRealm = new JLabel("Realm");
    lbl_moveSelectRealm.setBounds(226, 50, 97, 17);
    panel_moveSelect.add(lbl_moveSelectRealm);

    lbl_moveSelectLevel = new JLabel("Level");
    lbl_moveSelectLevel.setBounds(339, 23, 97, 17);
    panel_moveSelect.add(lbl_moveSelectLevel);

    lbl_moveSelectXP = new JLabel("XP");
    lbl_moveSelectXP.setBounds(339, 50, 97, 17);
    panel_moveSelect.add(lbl_moveSelectXP);

    panel_moveSelectInventory = new JPanel();
    frame.getContentPane().add(panel_moveSelectInventory,
                               "panel_moveInventory");
    panel_moveSelectInventory.setLayout(null);

    DefaultTableModel moveSelectInventoryModel =
        new DefaultTableModel(new Object[] {"Name", "Level", "Type", "XP"}, 0) {
          // set this table as uneditable
          @Override
          public boolean isCellEditable(int row, int column) {
            return false;
          }
        };
    table_moveSelectInventory = new JTable(moveSelectInventoryModel);
    table_moveSelectInventory.setBounds(29, 69, 388, 109);
    moveSelectInventoryModel.addRow(
        new Object[] {"Name", "Level", "Type", "XP"});
    table_moveSelectInventory.setFont(new Font("Dialog", Font.BOLD, 12));
    panel_moveSelectInventory.add(table_moveSelectInventory);

    lbl_moveSelectInventoryPotions =
        new JLabel("Number of Potions Remaining: ");
    lbl_moveSelectInventoryPotions.setFont(new Font("Dialog", Font.BOLD, 14));
    lbl_moveSelectInventoryPotions.setBounds(52, 190, 365, 33);
    panel_moveSelectInventory.add(lbl_moveSelectInventoryPotions);

    lbl_moveSelectInventoryArmorPlates =
        new JLabel("Number of Armor Plates Remaining:");
    lbl_moveSelectInventoryArmorPlates.setFont(
        new Font("Dialog", Font.BOLD, 14));
    lbl_moveSelectInventoryArmorPlates.setBounds(52, 225, 365, 33);
    panel_moveSelectInventory.add(lbl_moveSelectInventoryArmorPlates);

    lbl_moveSelectInventoryTitle = new JLabel("Inventory");
    lbl_moveSelectInventoryTitle.setFont(new Font("Dialog", Font.BOLD, 16));
    lbl_moveSelectInventoryTitle.setBounds(174, 34, 98, 23);
    panel_moveSelectInventory.add(lbl_moveSelectInventoryTitle);

    btn_moveSelectInventoryBack = new JButton("Back");
    btn_moveSelectInventoryBack.setBounds(12, 12, 107, 27);
    panel_moveSelectInventory.add(btn_moveSelectInventoryBack);

    panel_battleInform = new JPanel();
    frame.getContentPane().add(panel_battleInform, "panel_battleInform");
    panel_battleInform.setLayout(null);

    lbl_battleInform = new JLabel("Battle Started!");
    lbl_battleInform.setBounds(171, 12, 91, 17);
    panel_battleInform.add(lbl_battleInform);

    lbl_battleInformPlayerWanimal = new JLabel("Player's Wanimal");
    lbl_battleInformPlayerWanimal.setBounds(34, 64, 110, 17);
    panel_battleInform.add(lbl_battleInformPlayerWanimal);

    lbl_battleInformPlayerWanimalLevel = new JLabel("Level: ");
    lbl_battleInformPlayerWanimalLevel.setBounds(34, 84, 110, 17);
    panel_battleInform.add(lbl_battleInformPlayerWanimalLevel);

    lbl_battleInformPlayerWanimalHP = new JLabel("HP:");
    lbl_battleInformPlayerWanimalHP.setBounds(34, 103, 110, 17);
    panel_battleInform.add(lbl_battleInformPlayerWanimalHP);

    lbl_battleInformPlayerWanimalArmor = new JLabel("Armor:");
    lbl_battleInformPlayerWanimalArmor.setBounds(34, 122, 110, 17);
    panel_battleInform.add(lbl_battleInformPlayerWanimalArmor);

    lbl_battleInformPlayerWanimalBaseAttack = new JLabel("Base Attack:");
    lbl_battleInformPlayerWanimalBaseAttack.setBounds(34, 141, 110, 17);
    panel_battleInform.add(lbl_battleInformPlayerWanimalBaseAttack);

    lbl_battleInformEnemyWanimal = new JLabel("Enemy Wanimal");
    lbl_battleInformEnemyWanimal.setBounds(285, 141, 110, 17);
    panel_battleInform.add(lbl_battleInformEnemyWanimal);

    lbl_battleInformEnemyWanimalLevel = new JLabel("Level: ");
    lbl_battleInformEnemyWanimalLevel.setBounds(285, 161, 110, 17);
    panel_battleInform.add(lbl_battleInformEnemyWanimalLevel);

    lbl_battleInformEnemyWanimalHP = new JLabel("HP:");
    lbl_battleInformEnemyWanimalHP.setBounds(285, 180, 110, 17);
    panel_battleInform.add(lbl_battleInformEnemyWanimalHP);

    lbl_battleInformEnemyWanimalArmor = new JLabel("Armor:");
    lbl_battleInformEnemyWanimalArmor.setBounds(285, 199, 110, 17);
    panel_battleInform.add(lbl_battleInformEnemyWanimalArmor);

    lbl_battleInformEnemyWanimalBaseAttack = new JLabel("Base Attack:");
    lbl_battleInformEnemyWanimalBaseAttack.setBounds(285, 218, 110, 17);
    panel_battleInform.add(lbl_battleInformEnemyWanimalBaseAttack);

    lbl_battleInformVersus = new JLabel("VS.");
    lbl_battleInformVersus.setBounds(200, 122, 31, 17);
    panel_battleInform.add(lbl_battleInformVersus);

    panel_characterCreate = new JPanel();
    frame.getContentPane().add(panel_characterCreate, "panel_characterCreate");
    panel_characterCreate.setLayout(null);

    lbl_characterCreate = new JLabel("Create Character");
    lbl_characterCreate.setFont(new Font("Dialog", Font.BOLD, 16));
    lbl_characterCreate.setBounds(147, 12, 149, 27);
    panel_characterCreate.add(lbl_characterCreate);

    lbl_characterCreateName = new JLabel("Name:");
    lbl_characterCreateName.setBounds(116, 88, 63, 17);
    panel_characterCreate.add(lbl_characterCreateName);

    textField_characterCreateName = new JTextField();
    textField_characterCreateName.setBounds(191, 86, 114, 21);
    panel_characterCreate.add(textField_characterCreateName);
    textField_characterCreateName.setColumns(10);

    comboBox_characterCreateStarterWanimal =
        new JComboBox<String>(starterWanimalOptions);
    comboBox_characterCreateStarterWanimal.setBounds(191, 130, 114, 26);
    panel_characterCreate.add(comboBox_characterCreateStarterWanimal);

    lbl_characterCreateStarterWanimal = new JLabel("Starter Wanimal:");
    lbl_characterCreateStarterWanimal.setBounds(65, 135, 114, 17);
    panel_characterCreate.add(lbl_characterCreateStarterWanimal);

    btn_characterCreateAdvance = new JButton("Advance");
    btn_characterCreateAdvance.setBounds(12, 231, 416, 27);
    panel_characterCreate.add(btn_characterCreateAdvance);
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
    btn_titleNewGame.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        masterLayout.show(contentPane, "panel_characterCreate");
      }
    });

    // listener to run the quit method when the user presses the quit button
    btn_titleLoadGame.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        masterLayout.show(contentPane, "panel_moveSelect");
      }
    });

    // listener to run the quit method when the user presses the quit button
    btn_titleQuit.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        quit();
      }
    });

    /************************************************************************
     * CHARACTER CREATION SCREEN LISTENERS
     *************************************************************************/

    btn_characterCreateAdvance.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        ArrayList<Class<? extends Wanimal>> wanimalList =
            new ArrayList<Class<? extends Wanimal>>(
                Arrays.asList(Wumbo.class, Plant.class, Ash.class, Aqua.class));

        String name = textField_characterCreateName
                          .getText(); // get the text from the text field

        int starterWanimalIndex =
            comboBox_characterCreateStarterWanimal
                .getSelectedIndex(); // get the text from the text field

        if (name.equals("")) { // if the name is empty
          btn_characterCreateAdvance.setText(
              "Please enter a valid name."); // change the text on the advance
                                             // button to inform the user of the
                                             // invalid entry for name

          // wait 1000 seconds
          Utils.delayRun(1000, new Runnable() {
            @Override
            public void run() {
              btn_characterCreateAdvance.setText(
                  "Advance"); // change the text on the advance button back to
                              // the default text
            }
          });
        } else { // if the text in the text field is NOT empty
          Player player = new Player();

          player.setName(name); // set the name of the player to the name given

          try { // attempt to add the wanimal that the user has selected to
                // their wanimals
            player.getWanimals().add(wanimalList.get(starterWanimalIndex)
                                         .getDeclaredConstructor()
                                         .newInstance());
          } catch (InstantiationException | IllegalAccessException |
                   IllegalArgumentException | InvocationTargetException |
                   NoSuchMethodException |
                   SecurityException e1) { // handle error
            e1.printStackTrace();          // print error
          }

          Engine.setPlayer(player);

          // after all character creation logic is done, proceed to the move
          // select screen
          masterLayout.show(contentPane, "panel_moveSelect");
        }
      }
    });

    /************************************************************************
     * MOVE SELECT SCREEN LISTENERS
     *************************************************************************/

    // listener to update the move select GUI every time it appears
    panel_moveSelect.addComponentListener(new ComponentListener() {
      // the three methods below do not need an implementation as we do not
      // want to do anything when those events are fired
      @Override
      public void componentHidden(ComponentEvent e) {}

      @Override
      public void componentMoved(ComponentEvent e) {}

      @Override
      public void componentResized(ComponentEvent e) {}

      @Override
      public void componentShown(
          ComponentEvent e) {   // when the move select panel is shown
        refreshMoveSelectGUI(); // refresh the move select panel
      }
    });

    // listener to potentially run a battle (40% chance) every time the
    // advance button is clicked
    btn_moveSelectAdvance.addActionListener(new ActionListener() {
      private boolean actionRun; // this boolean will hold if the action for
                                 // this listener has been run or not

      @Override
      public void actionPerformed(ActionEvent e) {
        actionRun = false; // start with this flag false (the task has not run)

        Utils.runMaybe(40, new Runnable() {
          @Override
          public void run() {
            actionRun = true; // mark the action as run using the actionRun flag

            textArea_battleLog.setText(
                ""); // clear the battle logs from previous battle

            BattleUtils.createBattle(GameUtils.generateRandomWanimal(
                Engine.getPlayer()
                    .getRealm())); // create a new battle between the player
                                   // and a random wanimal in this realm

            setBattleInformGUI(); // set up the battle information screen

            // show the panel informing the user of the battle
            masterLayout.show(contentPane, "panel_battleInform");

            // wait for 4 seconds, then prepare and switch to the actual
            // battle panel
            Utils.delayRun(4000, new Runnable() {
              @Override
              public void run() {
                Engine.getGui().refreshBattleGUI(
                    Engine.getCurrentBattle()); // refresh the battle GUI
              }
            });
          }
        });

        if (!actionRun) { // if the action was not run
          btn_moveSelectAdvance.setText("Nothing happened.");

          // wait for 1 second and then change the button text back to the
          // default
          Utils.delayRun(1000, new Runnable() {
            @Override
            public void run() {
              btn_moveSelectAdvance.setText("Advance");
            }
          });
        }
      }
    });

    // listener to go back to the title screen when the save and quit button
    // is clicked
    btn_moveSelectSaveAndQuit.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        masterLayout.show(contentPane, "panel_title");
      }
    });

    // listener to go display the user's inventory when the inventory button
    // is clicked

    btn_moveSelectInventory.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        refreshMoveSelectInventoryGUI(); // refresh the move select inventory
                                         // GUI
        masterLayout.show(
            contentPane,
            "panel_moveInventory"); // switch to the move select inventory panel
      }
    });

    // listener for the battle boss button (only works if this button is enabled
    // by the refreshMoveSelectGUI method (see below))
    btn_moveSelectBattleBoss.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Class<? extends Boss> currentBossClass =
            bossList.get(Engine.getPlayer().getRealm() - 1);

        // attempt to create a new boss and create a new battle with it
        try {
          BattleUtils.createBattle(
              currentBossClass.getDeclaredConstructor().newInstance());
        } catch (InstantiationException | IllegalAccessException |
                 IllegalArgumentException | InvocationTargetException |
                 NoSuchMethodException | SecurityException e1) {
          e1.printStackTrace();
        } // create a new battle between the player
          // and a random wanimal in this realm

        setBattleInformGUI(); // set up the battle information screen

        // show the panel informing the user of the battle
        masterLayout.show(contentPane, "panel_battleInform");

        // wait for 4 seconds, then prepare and switch to the actual
        // battle panel
        Utils.delayRun(4000, new Runnable() {
          @Override
          public void run() {
            Engine.getGui().refreshBattleGUI(
                Engine.getCurrentBattle()); // refresh the battle GUI
          }
        });
      }
    });

    /************************************************************************
     * MOVE SELECT INVENTORY SCREEN LISTENERS
     *************************************************************************/

    // listener to show the move select panel when the back button is
    // pressed on the move select inventory screen
    btn_moveSelectInventoryBack.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        masterLayout.show(contentPane, "panel_moveSelect");
      }
    });

    // this listener will wait until two table rows are selected on the wanimals
    // table in the move select inventory screen. When this happens, the
    // placements of two wanimals represented in the rows selected will be
    // swapped in the player's inventory
    table_moveSelectInventory.getSelectionModel().addListSelectionListener(
        new ListSelectionListener() {
          @Override
          public void valueChanged(ListSelectionEvent arg0) {
            int[] selectedRows =
                table_moveSelectInventory
                    .getSelectedRows(); // get the selected rows from the table

            if (selectedRows.length == 2) { // if there are two selected rows
              ArrayList<Wanimal> playerWanimals =
                  Engine.getPlayer().getWanimals();

              Collections.swap(
                  playerWanimals, selectedRows[0],
                  selectedRows[1]); // swap the first selected wanimal's
                                    // placement with the second wanimal's
                                    // placement in the player's inventory

              refreshMoveSelectInventoryGUI(); // refresh the move select
                                               // inventory GUI
            }
          }
        });

    /************************************************************************
     * BATTLE SCREEN LISTENERS
     *************************************************************************/

    // listener to run the current wanimal's attack 1 when the attack 1 button
    // is clicked
    btn_battleAttack1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // get the player's wanimal
        Wanimal playerWanimal = Engine.getCurrentBattle().getPlayerWanimal();

        Attack attackToExecute = playerWanimal.getFirstAttack();

        // execute the player's first attack on the enemy
        attackToExecute.execute(playerWanimal,
                                Engine.getCurrentBattle().getEnemy());

        Engine.getGui().addToBattleLog(playerWanimal.getName() + " used " +
                                       attackToExecute.getName() + ".");

        Engine.getCurrentBattle().setCurrentTurn(
            0); // set the turn to the enemy turn

        refreshBattleGUI(
            Engine.getCurrentBattle()); // update the GUI with the new
                                        // information about the battle
      }
    });

    // listener to run the current wanimal's attack 1 when the attack 1 button
    // is clicked
    btn_battleAttack2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // get the player's wanimal
        Wanimal playerWanimal = Engine.getCurrentBattle().getPlayerWanimal();

        Attack attackToExecute = playerWanimal.getSecondAttack();

        // execute the player's first attack on the enemy
        attackToExecute.execute(playerWanimal,
                                Engine.getCurrentBattle().getEnemy());

        Engine.getGui().addToBattleLog(playerWanimal.getName() + " used " +
                                       attackToExecute.getName() + ".");

        Engine.getCurrentBattle().setCurrentTurn(
            0); // set the turn to the enemy turn

        refreshBattleGUI(
            Engine.getCurrentBattle()); // update the GUI with the new
                                        // information about the battle
      }
    });

    // listener to show the battle inventory screen when the inventory
    // button is pressed on the battle screen
    btn_battleInventory.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        refreshBattleInventoryGUI(); // refresh the inventory GUI with the
                                     // latest information
        masterLayout.show(
            contentPane,
            "panel_battleInventory"); // switch to the battle inventory panel
      }
    });

    // listener to show the battle switch screen when the switch button is
    // pressed on the battle screen
    btn_battleSwitch.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        DefaultComboBoxModel<String> comboBoxModel =
            (DefaultComboBoxModel<String>)comboBox_battleSwitch
                .getModel(); // get the model for the battle switch combo box so
                             // it can be easily manipulated

        comboBoxModel.removeAllElements();

        // for each wanimal in the player's inventory
        for (Wanimal wanimal : Engine.getPlayer().getWanimals()) {
          comboBoxModel.addElement(
              wanimal.getName() + " (Lvl " + wanimal.getLevel() +
              ")"); // add the wanimal's name plus level to the comboBox
        }

        // show the battle switch panel
        masterLayout.show(contentPane, "panel_battleSwitch");
      }
    });

    // listener to attempt to flee from the enemy wanimal when the flee button
    // is clicked on the battle screen
    btn_battleFlee.addActionListener(new ActionListener() {
      private boolean actionRun; // this boolean will hold if the action for
                                 // this listener has been run or not
      @Override
      public void actionPerformed(ActionEvent e) {
        actionRun = false; // start with this flag false (the task has not run)

        int calculatedChance = (int)Math.round(
            (1 - (Engine.getCurrentBattle().getEnemy().getLevel() / 15.0)) *
            100); // get a percentage calculated chance for the flee to be
                  // successful

        // with a percentage success of the above calculated number, attempt to
        // flee the battle by setting the battle running to false
        Utils.runMaybe(calculatedChance, new Runnable() {
          @Override
          public void run() {
            actionRun = true; // mark that the action has been run

            Engine.getGui().addToBattleLog(
                "Player successfully fled from the enemy wanimal.");

            Engine.getCurrentBattle().setIsRunning(false);
          }
        });

        if (!actionRun) { // if the action was not run
          Engine.getGui().addToBattleLog(
              "Player failed to flee from the enemy wanimal.");
          Engine.getCurrentBattle().setCurrentTurn(
              0); // set the current turn to the enemy's turn, as a flee attempt
                  // takes up a turn
        }
      }
    });

    // listener to attempt to catch the enemy wanimal when the catch button is
    // clicked on the battle screen
    btn_battleCatch.addActionListener(new ActionListener() {
      private boolean actionRun; // this boolean will hold if the action for
                                 // this listener has been run or not
      @Override
      public void actionPerformed(ActionEvent e) {
        actionRun = false; // start with this flag false (the task has not run)

        int calculatedChance = (int)Math.round(
            (1 - (Engine.getCurrentBattle().getEnemy().getLevel() / 15.0)) *
            100); // get a percentage calculated chance for the flee to be
                  // successful

        // if the player has less than 4 wanimals in their inventory
        if (Engine.getCurrentBattle().getPlayer().getWanimals().size() < 4) {
          // with a percentage success of the above calculated number, attempt
          // to flee the battle by setting the battle running to false
          Utils.runMaybe(calculatedChance, new Runnable() {
            @Override
            public void run() {
              actionRun = true; // mark that the action has been run

              Engine.getCurrentBattle().getPlayer().getWanimals().add(
                  Engine.getCurrentBattle()
                      .getEnemy()); // add the enemy to the player's inventory

              Engine.getGui().addToBattleLog(
                  "Player successfully caught the enemy wanimal.");

              Engine.getCurrentBattle().setIsRunning(false); // stop the battle
            }
          });

          if (!actionRun) { // if the action was not run
            Engine.getGui().addToBattleLog(
                "Player failed to catch the enemy wanimal.");
            Engine.getCurrentBattle().setCurrentTurn(
                0); // set the current turn to the enemy's turn, as a flee
                    // attempt takes up a turn
          }
        } else { // if the player's wanimal slots are full
          btn_battleCatch.setText(
              "Wanimal slots full!"); // change the text of the catch button to
                                      // inform them their wanimals are full.

          // wait for one second then reset the catch button
          Utils.delayRun(1000, new Runnable() {
            @Override
            public void run() {
              btn_battleCatch.setText("Catch");
            }
          });
        }
      }
    });

    /************************************************************************
     * BATTLE SWITCH SCREEN LISTENERS
     *************************************************************************/

    // listener to show the move select panel when the back button is
    // pressed on the move select switch screen
    btn_battleSwitchAdvance.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Battle currentBattle =
            Engine.getCurrentBattle(); // get the current battle object

        Wanimal wanimalToSwitchTo = currentBattle.getPlayer().getWanimals().get(
            comboBox_battleSwitch
                .getSelectedIndex()); // get the selected wanimal from the
                                      // battle switch combo box

        currentBattle.setPlayerWanimal(
            wanimalToSwitchTo); // set the player's current wanimal as the
                                // wanimal to switch to

        Engine.getGui().addToBattleLog(
            "Player switched to " + currentBattle.getPlayerWanimal().getName() +
            ".");

        currentBattle.setCurrentTurn(
            0); // make it the enemy's turn (a switch takes up a turn)

        refreshBattleGUI(currentBattle);

        // go back to the move select panel
        masterLayout.show(contentPane, "panel_battle");
      }
    });

    /************************************************************************
     * BATTLE INVENTORY SCREEN LISTENERS
     *************************************************************************/

    // listener to apply a potion to the user's wanimal every time the use
    // potion button is clicked on the battle inventory screen
    btn_battleInventoryUsePotion.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Player player =
            Engine.getCurrentBattle().getPlayer(); // get the current player
        Wanimal playerWanimal =
            Engine.getCurrentBattle()
                .getPlayerWanimal(); // get the player's current wanimal

        Engine.getGui().addToBattleLog(
            "Player used a potion on " + playerWanimal.getName() +
            ". The wanimal was restored to full health.");

        player.setNumPotions(
            Engine.getPlayer().getNumPotions() -
            1); // deduct one potion from the player's inventory

        // restore the player's wanimal's health to full
        playerWanimal.setCurrentHitpoints(playerWanimal.getMaxHitpoints());
      }
    });

    // listener to apply a armor plate to the user's wanimal every time the use
    // armor plate button is clicked on the battle inventory screen
    btn_battleInventoryUseArmorPlate.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Player player =
            Engine.getCurrentBattle().getPlayer(); // get the current player
        Wanimal playerWanimal =
            Engine.getCurrentBattle()
                .getPlayerWanimal(); // get the player's current wanimal

        Engine.getGui().addToBattleLog(
            "Player used an armor plate on " + playerWanimal.getName() +
            ". The wanimal was restored to full armor.");

        player.setNumArmorPlates(
            Engine.getPlayer().getNumArmorPlates() -
            1); // deduct one armor plate from the player's inventory

        // restore the player's wanimal's armor to full
        playerWanimal.setCurrentArmor(playerWanimal.getMaxArmor());
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
    Utils.delayRun(2000, new Runnable() {
      @Override
      public void run() {
        frame.dispose();
        System.exit(0);
      }
    });
  }

  /**
   * This method will enable or disable all the buttons on the player's battle
   * screen, depending on the enabled flag given
   *
   * @param enabled - whether to enable or disable all the buttons on the battle
   *     screen
   */
  public void setBattleButtonsEnabled(boolean enabled) {
    // list of all buttons on the battle screen (to be used to dynamically
    // enable or disable buttons depending on enabled flag given)
    JButton[] battleButtons = {btn_battleAttack1,   btn_battleAttack2,
                               btn_battleInventory, btn_battleSwitch,
                               btn_battleCatch,     btn_battleFlee};

    // set each button disabled or enabled based on the enabled flag given
    for (JButton battleButton : battleButtons) {
      battleButton.setEnabled(enabled);
    }
  }

  /**
   * This method refreshes the GUI at the beginning of a battle turn. This
   * method will be called by the Engine during a battle.
   *
   * @param battle - the battle object with which to refresh the GUI
   */
  public void refreshBattleGUI(Battle battle) {
    if (!Engine.getCurrentBattle()
             .isRunning()) { // if the battle is not running, no need to
                             // update the GUI
      return;                // return immediately
    }

    // set all the labels with their updated values
    lbl_battlePlayer.setText(battle.getPlayer().getName());

    Wanimal playerWanimal = battle.getPlayerWanimal(),
            enemy = battle.getEnemy(); // get the player and enemy wanimals
                                       // for later use

    // update player information
    lbl_battlePlayerName.setText(playerWanimal.getName() + " (Lvl " +
                                 String.valueOf(playerWanimal.getLevel()) +
                                 ")");
    lbl_battlePlayerArmor.setText(
        "Armor: " + String.valueOf(playerWanimal.getCurrentArmor()) + "/" +
        String.valueOf(playerWanimal.getMaxArmor()));
    lbl_battlePlayerHealth.setText(
        "HP: " + String.valueOf(playerWanimal.getCurrentHitpoints()) + "/" +
        String.valueOf(playerWanimal.getMaxHitpoints()));

    // update enemy information
    lbl_battleEnemyName.setText(enemy.getName() + " (Lvl " +
                                String.valueOf(enemy.getLevel()) + ")");
    lbl_battleEnemyArmor.setText(
        "Armor: " + String.valueOf(enemy.getCurrentArmor()) + "/" +
        String.valueOf(enemy.getMaxArmor()));
    lbl_battleEnemyHealth.setText(
        "HP: " + String.valueOf(enemy.getCurrentHitpoints()) + "/" +
        String.valueOf(enemy.getMaxHitpoints()));

    // set the turn label with the correct turn
    lbl_battleTurn.setText(battle.getCurrentTurn() == 1 ? "Player's Turn"
                                                        : "Enemy's Turn");

    if (battle.getCurrentTurn() == 0) { // if it is the enemy's turn
      setBattleButtonsEnabled(false);
    } else { // if it is the player's turn
      setBattleButtonsEnabled(true);
    }

    // if the player's wanimal is less than level 5 (they haven't unlocked
    // their second attack yet)
    if (battle.getPlayerWanimal().getLevel() < 5) {
      btn_battleAttack2.setEnabled(
          false); // re-disable the second attack button

      // if the enemy wanimal is a boss, do not allow the player to catch or
      // escape the boss
      if (battle.getEnemy().getClass() == Boss.class) {
        btn_battleCatch.setEnabled(false); // set the catch button to disabled
        btn_battleFlee.setEnabled(false);  // set the flee button to disabled
      }
    }

    // show the battle panel
    masterLayout.show(contentPane, "panel_battle");
  }

  /**
   * This method refreshes the GUI whenever the move select menu is supposed to
   * show up. This method will be called by the engine whenever the move select
   * menu is supposed to appear.
   */
  public void refreshMoveSelectGUI() {
    // Refreshes all the information in the menu labels
    lbl_moveSelectName.setText("Name: " + Engine.getPlayer().getName());
    lbl_moveSelectLevel.setText("Level: " +
                                String.valueOf(Engine.getPlayer().getLevel()));
    lbl_moveSelectRealm.setText("Realm: " +
                                String.valueOf(Engine.getPlayer().getRealm()));

    // Displays the users current XP out of the total XP needed to level up
    lbl_moveSelectXP.setText(
        "XP: " + String.valueOf(Engine.getPlayer().getCurrentXP()) + "/" +
        String.valueOf(Engine.getPlayer().getMaxXP()));

    // get the boss for the current realm
    Class<? extends Boss> currentBossClass =
        bossList.get(Engine.getPlayer().getRealm() - 1);

    // this variable will store the required level for the current boss
    int currentRequiredLevel = 0;

    // attempt to get the required level for this boss and store it in the above
    // variable
    try {
      currentRequiredLevel =
          (int)currentBossClass.getMethod("getRequiredLevel").invoke(null);
    } catch (IllegalAccessException | InvocationTargetException |
             NoSuchMethodException |
             SecurityException e) { // if the operation fails
      e.printStackTrace();          // print the error
    }

    // if the player has met the minimum required level to fight the boss for
    // this realm
    if (Engine.getPlayer().getLevel() >= currentRequiredLevel) {
      btn_moveSelectBattleBoss.setEnabled(
          true); // enable the boss battle button
    } else {
      btn_moveSelectBattleBoss.setEnabled(
          false); // disable the boss battle button
    }
  }

  /**
   * This method will update the battle inform panel with with the information
   * from the current battle. To be used when a battle is create and set in the
   * engine.
   */
  public void setBattleInformGUI() {
    Wanimal playerWanimal = Engine.getCurrentBattle().getPlayerWanimal(),
            enemyWanimal = Engine.getCurrentBattle()
                               .getEnemy(); // get the player and enemy wanimals
                                            // ready for later usage

    // set player information
    lbl_battleInformPlayerWanimal.setText(playerWanimal.getName());
    lbl_battleInformPlayerWanimalLevel.setText(
        String.valueOf("Level: " + playerWanimal.getLevel()));
    lbl_battleInformPlayerWanimalHP.setText(
        "HP: " + String.valueOf(playerWanimal.getCurrentHitpoints()) + "/" +
        String.valueOf(playerWanimal.getMaxHitpoints()));
    lbl_battleInformPlayerWanimalArmor.setText(
        "Armor: " + String.valueOf(playerWanimal.getCurrentArmor()) + "/" +
        String.valueOf(playerWanimal.getMaxArmor()));
    lbl_battleInformPlayerWanimalBaseAttack.setText(
        String.valueOf("Base Attack: " + playerWanimal.getBaseAttack()));

    // set enemy information
    lbl_battleInformEnemyWanimal.setText(enemyWanimal.getName());
    lbl_battleInformEnemyWanimalLevel.setText(
        String.valueOf("Level: " + enemyWanimal.getLevel()));
    lbl_battleInformEnemyWanimalHP.setText(
        "HP: " + String.valueOf(enemyWanimal.getCurrentHitpoints()) + "/" +
        String.valueOf(enemyWanimal.getMaxHitpoints()));
    lbl_battleInformEnemyWanimalArmor.setText(
        "Armor: " + String.valueOf(enemyWanimal.getCurrentArmor()) + "/" +
        String.valueOf(enemyWanimal.getMaxArmor()));
    lbl_battleInformEnemyWanimalBaseAttack.setText(
        String.valueOf("Base Attack: " + enemyWanimal.getBaseAttack()));
  }

  /**
   * This method refreshes the battle inventory GUI according to the information
   * in the current battle object.
   */
  private void refreshBattleInventoryGUI() {
    Battle currentBattle = Engine.getCurrentBattle(); // get the current battle

    lbl_battleInventoryWanimalHP.setText(
        "Current wanimal's HP: " +
        currentBattle.getPlayerWanimal().getCurrentHitpoints());
    lbl_battleInventoryWanimalArmor.setText(
        "Current wanimal's armor: " +
        currentBattle.getPlayerWanimal().getCurrentArmor());
    lbl_battleInventoryPotionsRemaining.setText(
        "Potions remaining: " +
        String.valueOf(currentBattle.getPlayer().getNumPotions()));
    lbl_battleInventoryArmorPlatesRemaining.setText(
        "Armor Plates remaining: " +
        String.valueOf(currentBattle.getPlayer().getNumArmorPlates()));

    // if the player has no more potions left
    if (Engine.getPlayer().getNumPotions() == 0) {
      btn_battleInventoryUsePotion.setEnabled(
          false); // disable the option to use a potion
    }

    // if the player has no more armor plates left
    if (Engine.getPlayer().getNumArmorPlates() == 0) {
      btn_battleInventoryUseArmorPlate.setEnabled(
          false); // disable the option to use an armor plate
    }
  }

  /**
   * This method takes in some text and adds it to the battle log
   *
   * @param text - the text to add to the battle log
   */
  public void addToBattleLog(String text) {
    // if there is already text in the battle log
    if (!textArea_battleLog.getText().equals(""))
      textArea_battleLog.setText(
          textArea_battleLog.getText() + "\n" +
          text); // add a new line then add the given text
    else         // if the battle log is empty
      textArea_battleLog.setText(
          text); // set the full text of the battle log as the text given
  }

  /**
   * This method refreshes the move select inventory GUI.
   */
  public void refreshMoveSelectInventoryGUI() {
    Player currentPlayer = Engine.getPlayer(); // get the current player

    // update potion and armor labels
    lbl_moveSelectInventoryPotions.setText("Number of Potions Remaining: " +
                                           currentPlayer.getNumPotions());
    lbl_moveSelectInventoryArmorPlates.setText(
        "Number of Armor Plates Remaining: " +
        currentPlayer.getNumArmorPlates());

    DefaultTableModel moveSelectInventoryModel =
        (DefaultTableModel)table_moveSelectInventory
            .getModel(); // get the table model for the table on the move select
                         // inventory screen so the table data can be
                         // manipulated

    moveSelectInventoryModel.setRowCount(0); // remove all rows from table

    // for each wanimal in the player's inventory
    for (Wanimal wanimal : currentPlayer.getWanimals()) {
      String wanimalType =
          wanimal.getType(); // get wanimal type and store in variable (as it is
                             // used multiple times below)

      // add a row containing this wanimal's information to the table on the
      // move select inventory screen
      moveSelectInventoryModel.addRow(new Object[] {
          wanimal.getName(), wanimal.getLevel(),
          wanimalType.toUpperCase().charAt(0) + wanimalType.substring(1),
          wanimal.getCurrentXP()});
    }
  }

  // getters and setters

  public CardLayout getMasterLayout() { return this.masterLayout; }

  public Container getContentPane() { return this.contentPane; }
}
