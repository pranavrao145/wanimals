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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import models.battles.battles.Battle;
import models.player.Player;
import models.wanimals.Wanimal;
import models.wanimals.wanimals.normal.Norman;
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
  private JButton btn_moveSelectBattleBoss;
  private JButton btn_titleLoadGame;
  private JLabel lbl_moveSelectName;
  private JLabel lbl_moveSelectRealm;
  private JLabel lbl_moveSelectLevel;
  private JLabel lbl_moveSelectXP;
  private JPanel panel_moveInventory;
  private JTable table_moveInventory;
  private JLabel lbl_moveInventoryPotions;
  private JLabel lbl_moveInventoryArmourPlates;
  private JScrollPane scrollPane_moveInventoryTable;
  private JPanel panel_battleInform;
  private JLabel lbl_battleInformPlayerWanimalArmor;
  private JLabel lbl_battleInformPlayerWanimalBaseAttack;
  private JLabel lbl_battleInformEnemyWanimal;
  private JLabel lbl_battleInformEnemyWanimalLevel;
  private JLabel lbl_battleInformEnemyWanimalHP;
  private JLabel lbl_battleInformEnemyWanimalArmor;
  private JLabel lbl_battleInformEnemyBaseAttack;
  private JLabel lbl_battleInformVersus;
  private JLabel lbl_battleInform;
  private JLabel lbl_battleInformPlayerWanimal;
  private JLabel lbl_battleInformPlayerWanimalLevel;
  private JLabel lbl_battleInformPlayerWanimalHP;
  private JLabel lbl_moveInventoryTitle;
  private JButton btn_moveInventoryBack;

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

    panel_moveInventory = new JPanel();
    frame.getContentPane().add(panel_moveInventory, "panel_moveInventory");
    panel_moveInventory.setLayout(null);

    scrollPane_moveInventoryTable = new JScrollPane();
    scrollPane_moveInventoryTable.setBounds(52, 69, 348, 91);
    panel_moveInventory.add(scrollPane_moveInventoryTable);

    table_moveInventory = new JTable();
    table_moveInventory.setModel(new DefaultTableModel(
        new Object[][] {
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
        },
        new String[] {"Name", "Level", "XP"}));
    table_moveInventory.setFont(new Font("Dialog", Font.BOLD, 12));
    scrollPane_moveInventoryTable.setViewportView(table_moveInventory);

    lbl_moveInventoryPotions = new JLabel("Number of Potions: ");
    lbl_moveInventoryPotions.setFont(new Font("Dialog", Font.BOLD, 14));
    lbl_moveInventoryPotions.setBounds(52, 172, 213, 33);
    panel_moveInventory.add(lbl_moveInventoryPotions);

    lbl_moveInventoryArmourPlates = new JLabel("Number of Armour Plates:");
    lbl_moveInventoryArmourPlates.setFont(new Font("Dialog", Font.BOLD, 14));
    lbl_moveInventoryArmourPlates.setBounds(52, 207, 262, 33);
    panel_moveInventory.add(lbl_moveInventoryArmourPlates);

    lbl_moveInventoryTitle = new JLabel("Inventory");
    lbl_moveInventoryTitle.setFont(new Font("Dialog", Font.BOLD, 16));
    lbl_moveInventoryTitle.setBounds(174, 34, 98, 23);
    panel_moveInventory.add(lbl_moveInventoryTitle);

    btn_moveInventoryBack = new JButton("Back");
    btn_moveInventoryBack.setBounds(12, 12, 107, 27);
    panel_moveInventory.add(btn_moveInventoryBack);

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

    lbl_battleInformEnemyBaseAttack = new JLabel("Base Attack:");
    lbl_battleInformEnemyBaseAttack.setBounds(285, 218, 110, 17);
    panel_battleInform.add(lbl_battleInformEnemyBaseAttack);

    lbl_battleInformVersus = new JLabel("VS.");
    lbl_battleInformVersus.setBounds(200, 122, 31, 17);
    panel_battleInform.add(lbl_battleInformVersus);
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
        // TODO: add logic for new character creation instead of hardcoding
        // player
        Player player = new Player(); // create new player
        player.setName(
            "Player 1"); // set the name of the player to the name provided
        player.getWanimals().add(
            new Norman()); // give the player a default wanimal
        Engine.setPlayer(
            player); // set the player of the current game to the new player

        lbl_moveSelectName.setText("Name: " + player.getName());
        lbl_moveSelectRealm.setText("Realm: " + player.getRealm());
        lbl_moveSelectLevel.setText("Level: " + player.getLevel());
        lbl_moveSelectXP.setText("XP: " + player.getCurrentXP() + "/" +
                                 player.getmaxXP());

        masterLayout.show(contentPane, "panel_moveSelect");
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
     * MOVE SELECT SCREEN LISTENERS
     *************************************************************************/

    // listener to potentially run a battle (40% chance) every time the advance
    // button is clicked
    btn_moveSelectAdvance.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Utils.runMaybe(40, new Runnable() {
          @Override
          public void run() {
            // show the panel informing the user of the battle
            masterLayout.show(contentPane, "panel_battleInform");

            // wait for 4 seconds, then prepare and switch to the actual battle
            // panel
            Utils.delayRun(4000, new Runnable() {
              @Override
              public void run() {
                masterLayout.show(contentPane, "panel_battle");
              }
            });

            Engine.createBattle(
                GameUtils.generateRandomWanimal(Engine.getPlayer().getRealm()));
          }
        });
      }
    });

    // listener to go back to the title screen when the save and quit button is
    // clicked
    btn_moveSelectSaveAndQuit.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        masterLayout.show(contentPane, "panel_title");
      }
    });

    // listener to go display the user's inventory when the inventory button is
    // clicked
    btn_moveSelectInventory.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // TODO: code the logic to display all the wanimals owned by the user
        lbl_moveInventoryPotions.setText("Number of Potions: " +
                                         Engine.getPlayer().getNumPotions());
        lbl_moveInventoryArmourPlates.setText(
            "Number of Armour Plates: " +
            Engine.getPlayer().getNumArmorPlates());
        masterLayout.show(contentPane, "panel_moveInventory");
      }
    });

    // listener for the battle boss button
    btn_moveSelectBattleBoss.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {}
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

    /************************************************************************
     * MOVE INVENTORY SCREEN LISTENERS
     *************************************************************************/

    // listener to show the move select panel when the back button is
    // pressed on the move inventory screen
    btn_moveInventoryBack.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        masterLayout.show(contentPane, "panel_moveSelect");
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

        // execute the player's first attack on the enemy
        playerWanimal.getFirstAttack().execute(
            playerWanimal, Engine.getCurrentBattle().getEnemy());

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

        // execute the player's first attack on the enemy
        playerWanimal.getSecondAttack().execute(
            playerWanimal, Engine.getCurrentBattle().getEnemy());

        refreshBattleGUI(
            Engine.getCurrentBattle()); // update the GUI with the new
                                        // information about the battle
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
   * This method refreshes the GUI at the beginning of a battle turn. This
   * method will be called by the Engine during a battle.
   *
   * @param battle - the battle object with which to refresh the GUI
   */
  public void refreshBattleGUI(Battle battle) {
    throw new UnsupportedOperationException(
        "This operation has not been implemented yet.");
  }

  // getters and setters
  public CardLayout getMasterLayout() { return this.masterLayout; }

  public Container getContentPane() { return this.contentPane; }
}
