package view;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.util.List;

public class MyTableModel extends AbstractTableModel {
  private String[] columnNames =
          {
                  "Lp.",
                  "Wynik"
          };

  private List<String> list;
  public MyTableModel(List<String> list) {
    this.list = list;
  }

  @Override
  public int getRowCount() {
    return list.size();
  }

  @Override
  public int getColumnCount() {
    return this.columnNames.length;
  }

  @Override
  public String getColumnName(int column) {
    return columnNames[column];
  }


  @Override
  public boolean isCellEditable(int rowIndex, int columnIndex) {
    return false;
  }

  @Override
  public Object getValueAt(int row, int column) {
    String result = getResult(row);

    switch (column)
    {
      case 0: return row+1;
      case 1: return result;
      default: return null;
    }

  }

  private String getResult(int row) {
    return list.get(row);
  }

  @Override
  public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    fireTableStructureChanged();
  }
}
