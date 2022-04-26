package app;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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

  public GUI() {
    setupGUI();
    frame.setVisible(true);
  }

  private void setupGUI() {
    frame = new JFrame();
    contentPane = frame.getContentPane();
    masterLayout = new CardLayout();

    frame.setResizable(false);
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(
        JFrame.EXIT_ON_CLOSE); // overriding default close behaviour so
                               // custom close methods can run

    contentPane.setLayout(masterLayout);

    panel_title = new JPanel();
    frame.getContentPane().add(panel_title, "name_12198361239532");
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
    frame.getContentPane().add(panel_shutdown, "name_13245493571907");

    lbl_shutdownThanks = new JLabel("Thanks for playing!");
    lbl_shutdownThanks.setFont(new Font("Dialog", Font.BOLD, 20));
    lbl_shutdownThanks.setBounds(125, 99, 197, 26);
    panel_shutdown.add(lbl_shutdownThanks);

    lbl_shutdownMessage = new JLabel("Shutting down...");
    lbl_shutdownMessage.setBounds(171, 137, 110, 17);
    panel_shutdown.add(lbl_shutdownMessage);
  }
}
