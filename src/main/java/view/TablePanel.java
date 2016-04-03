package view;

import controller.ListController;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TablePanel extends JPanel{
  private static JTable table;
  private JScrollPane listScroller;

  public TablePanel() {
    setLayout(new MigLayout());
    generateTable();
    generateAndAddListScroller();
    setModel();
  }

  private void generateTable() {
    table = new JTable();
    table.setAutoCreateRowSorter(false);

  }

  private void generateAndAddListScroller() {
    listScroller = new JScrollPane(table);
    //listScroller.setPreferredSize(new Dimension(100, 200));
    add(listScroller);
  }

  public static void setModel(){
    table.setModel(new MyTableModel(ListController.getResultList()));
  }
}