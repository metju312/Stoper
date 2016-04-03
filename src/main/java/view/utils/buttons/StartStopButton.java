package view.utils.buttons;

import controller.TimerController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartStopButton extends MyButton {
  boolean isPaused;
  public StartStopButton() {
    super("Start/Stop", "start");
    isPaused = true;
    onClickBehavior();


  }

  private void onClickBehavior() {
    addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        onClick();
      }
    });
  }

  private void onClick() {
    if (isPaused) {
      start();
    } else {
      stop();
    }
  }

  private void start() {
    setStopIcon();
    TimerController.start();
    isPaused = false;
  }

  protected void stop() {
    setStartIcon();
    TimerController.stop();
    isPaused = true;
  }

  private void setStartIcon() {
    setMyIcon("start");
  }

  private void setStopIcon() {
    setMyIcon("stop");
  }


}
