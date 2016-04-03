package view.utils.buttons;

import controller.ListController;
import view.TablePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetListButton extends MyButton {
  public ResetListButton() {
    super("Zresetuj listę", "resetList");
    onClickBehavior();
  }

  private void onClickBehavior() {
      addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          ListController.reset();
          TablePanel.setModel();
        }
      });
  }
}
