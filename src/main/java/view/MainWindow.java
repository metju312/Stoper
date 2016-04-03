package view;

import controller.ListController;
import controller.TimerController;
import de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaLookAndFeel;
import net.miginfocom.swing.MigLayout;
import view.utils.buttons.LapTimeButton;
import view.utils.buttons.ResetListButton;
import view.utils.buttons.StartStopButton;
import view.utils.buttons.RestartButton;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
  private static MainWindow instance = null;
  private static final int WIDTH = 500;
  private static final int HEIGHT = 400;

  static Label label;


  StartStopButton startStopButton;
  RestartButton restartButton;
  LapTimeButton lapTimeButton;
  ResetListButton resetListButton;


  public static MainWindow getInstance() {
    if (instance == null) {
      instance = new MainWindow();
    }
    return instance;
  }

  public MainWindow() {
    setLayout(new MigLayout());
    setMainWindowValues();

    TimerController timerController = new TimerController();
    ListController listController = new ListController();

    addLabelPanel();
    addButtonsPanel();
    addTablePanel();

    getContentPane().revalidate();
    getContentPane().repaint();

  }

  private void addTablePanel() {
    TablePanel panel = new TablePanel();
    add(panel);
  }

  private void addButtonsPanel() {
    JPanel panel = new JPanel();
    startStopButton = new StartStopButton();
    lapTimeButton = new LapTimeButton();
    restartButton = new RestartButton(startStopButton);
    resetListButton = new ResetListButton();
    panel.add(startStopButton);
    panel.add(lapTimeButton);
    panel.add(restartButton);
    panel.add(resetListButton);
    add(panel,"wrap");
  }

  private void addLabelPanel() {
    label = new Label();
    restartLabel();
    label.setFont(new Font("Serif", Font.PLAIN, 40));
    JPanel panel = new JPanel();
    panel.add(label);
    add(panel,"wrap");
  }

  private void setLookAndFeel() {
    try {

      UIManager.removeAuxiliaryLookAndFeel(UIManager.getLookAndFeel());
      SyntheticaLookAndFeel.setWindowsDecorated(false);
      UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel());
      SwingUtilities.updateComponentTreeUI(this);

    } catch (Exception ex) {
      try {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  private void setMainWindowValues() {
    setName("Stoper by Matthew");
    setLookAndFeel();
    setSize(new Dimension(WIDTH,HEIGHT));
    setResizable(false);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    ImageIcon img = new ImageIcon("src/images/timer.png");
    setIconImage(img.getImage());
  }

  public static void setLabelText(String text){
    label.setText(text);
  }

  public static void restartLabel(){
    label.setText("00:00:00.000");
  }
}
