/**
 * @author Saeed H. Soudan
 */
package com.sig.model;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class HeaderTableModel extends DefaultTableModel {
    private String[] columnsNames = {"invoiceID", "invoiceDate", "CustName", "total"};
    private ArrayList<InvoiceHeader> invoices;

    public HeaderTableModel(ArrayList<InvoiceHeader> invoices) {
        this.invoices = invoices;
        this.columnsNames = columnsNames;
    }

    @Override
    public int getColumnCount() {
        // TODO Auto-generated method stub
        return columnsNames.length;
    }

    @Override
    public String getColumnName(int column) {
        // TODO Auto-generated method stub
        return columnsNames[column];
    }

    @Override
    public int getRowCount() {
        // TODO Auto-generated method stub
        if (this.invoices == null) {
            invoices = new ArrayList<>();
        }
        return invoices.size();
    }
    public ArrayList<InvoiceHeader> getInvoices() {
        return invoices;
    }
    @Override
    public void removeRow(int row) {
        invoices.remove(row);
    }



    public Object getValueAt(int row, int column) {
        InvoiceHeader inv = invoices.get(row);
        switch (column) {
            case 0: {
                return inv.getInvoiceID();
            }
            case 1: {
                return inv.getInvoiceDate();
            }
            case 2: {
                return inv.getInvoiceCustName();
            }
            case 3: {
                return inv.getInvoiceTotal();
            }

        }
        return null;
    }

}


