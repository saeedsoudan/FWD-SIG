/**
 * @author Saeed H. Soudan
 */
package com.sig.view;

import javax.swing.*;
import java.awt.*;

public class InvoiceLineDialog extends JDialog {
    private JTextField itemNameField;
    private JTextField itemCountField;
    private JTextField itemPriceField;
    private JLabel itemNameLabel;
    private JLabel itemCountLabel;
    private JLabel itemPriceLabel;
    private JButton okBtn;
    private JButton cancelBtn;

    public InvoiceLineDialog(Jframe jF) {
        itemNameLabel = new JLabel("Item Name:");
        itemNameField = new JTextField(20);


        itemCountLabel = new JLabel("Item Count");
        itemCountField = new JTextField(20);

        itemPriceLabel = new JLabel("Item Price:");
        itemPriceField = new JTextField(20);

        okBtn = new JButton("OK");
        okBtn.addActionListener(jF);
        okBtn.setActionCommand("createLineOk");
        cancelBtn = new JButton("Cancel");
        cancelBtn.addActionListener(jF);
        cancelBtn.setActionCommand("createLineCancel");

        setLayout(new GridLayout(4, 2));
        add(itemNameLabel);
        add(itemNameField);
        add(itemCountLabel);
        add(itemCountField);
        add(itemPriceLabel);
        add(itemPriceField);
        add(okBtn);
        add(cancelBtn);
        pack();
        setLocation(250, 250);

    }

    public JTextField getItemNameField() {
        return itemNameField;
    }

    public JTextField getItemCountField() {
        return itemCountField;
    }

    public JTextField getItemPriceField() {
        return itemPriceField;
    }


}