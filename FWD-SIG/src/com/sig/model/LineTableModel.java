/**
 * @author Saeed H. Soudan
 */
package com.sig.model;


import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;


public class LineTableModel extends DefaultTableModel {
    private String[] columnsNames = {"Item Name", "Item Price", "Item Count", "Items Total"};
    private ArrayList<InvoiceLine> lines;

    public LineTableModel(ArrayList<InvoiceLine> lines) {
        this.lines = lines;
    }

    @Override
    public int getColumnCount() {
        // TODO Auto-generated method stub
        return columnsNames.length;
    }

    @Override
    public String getColumnName(int column) {
        // TODO Auto-generated method stub
        System.out.println("Column named is called");
        return columnsNames[column];
    }

    @Override
    public int getRowCount() {
        // TODO Auto-generated method stub
        if (this.lines == null) {
            lines = new ArrayList<>();
        }
        return lines.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceLine row = lines.get(rowIndex);
        switch (columnIndex) {
            case 0: {
                return row.getItemName();
            }
            case 1: {
                return row.getItemPrice();
            }
            case 2: {
                return row.getItemCount();
            }
            case 3: {
                return row.getitemTotal();
            }
        }
        return "";
    }

    public ArrayList<InvoiceLine> getLines() {

        return lines;
    }

    @Override
    public void removeRow(int r) {

        lines.remove(r);

    }
}
