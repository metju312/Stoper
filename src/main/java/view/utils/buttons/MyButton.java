package view.utils.buttons;

import javax.swing.*;
import java.io.InputStream;

public class MyButton extends JButton {

  //private static final String ICON_PATH = MyButton.class.getResource("/app.properties").getPath();

  public MyButton(String name, String iconName) {
    super(name);
    setMyIcon(iconName);


    //InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(iconName + ".png");
    //setIcon(new ImageIcon(String.valueOf(MyButton.class.getResourceAsStream("./images/" +iconName+".png"))));
  }

  protected void setMyIcon(String iconName) {
    setIcon(new ImageIcon("src/images/" + iconName + ".png"));
  }


}
