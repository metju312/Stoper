package view.utils.buttons;

import controller.ListController;
import controller.TimerController;
import view.TablePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LapTimeButton extends MyButton {
  public LapTimeButton() {
    super("Lap Time", "lapTime");

    addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        TimerController.addLapResult();
      }
    });
  }
}
