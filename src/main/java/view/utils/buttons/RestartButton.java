package view.utils.buttons;

import controller.TimerController;
import view.MainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestartButton extends MyButton {
  private StartStopButton startStopButton;

  public RestartButton(StartStopButton startStopButton) {
    super("restart", "restart");
    this.startStopButton = startStopButton;
    onClickBehavior();
  }

  private void onClickBehavior() {
    addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        MainWindow.restartLabel();
        TimerController.reset();
        startStopButton.stop();
      }
    });
  }
}
