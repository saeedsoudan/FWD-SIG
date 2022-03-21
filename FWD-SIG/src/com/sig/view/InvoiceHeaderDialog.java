/**
 * @author Saeed H. Soudan
 */
package com.sig.view;

import javax.swing.*;
import java.awt.*;


public class InvoiceHeaderDialog extends JDialog {
    private JTextField customerNameField;
    private JTextField dateField;
    private JLabel customerNameLabel;
    private JLabel dateLabel;
    private JButton okBtn;
    private JButton cancelBtn;

    public InvoiceHeaderDialog(Jframe frame1) {
        customerNameLabel = new JLabel("Customer Name:");
        customerNameField = new JTextField(20);
        dateLabel = new JLabel("Invoice Date:");
        dateField = new JTextField(20);
        okBtn = new JButton("OK");
        okBtn.addActionListener(frame1);
        okBtn.setActionCommand("createInvOk");
        cancelBtn = new JButton("Cancel");
        cancelBtn.addActionListener(frame1);
        cancelBtn.setActionCommand("createInvCancel");
        setLayout(new GridLayout(3, 2));
        add(dateLabel);
        add(dateField);
        add(customerNameLabel);
        add(customerNameField);
        add(okBtn);
        add(cancelBtn);
        pack();
        setLocation(250,250);
    }

    public JTextField getCustomerNameField() {
        return customerNameField;
    }

    public JTextField getDateField() {
        return dateField;
    }


}