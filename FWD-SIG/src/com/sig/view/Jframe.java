package com.sig.view;
/**
 * @author Saeed H. Soudan
 */
import com.sig.model.HeaderTableModel;
import com.sig.model.InvoiceHeader;
import com.sig.model.InvoiceLine;
import com.sig.model.LineTableModel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Jframe extends javax.swing.JFrame implements ActionListener, ListSelectionListener {

    // Variables declaration - do not modify//GEN-BEGIN:variables

    private javax.swing.JTextField InvoiceDatejTextField;
    private javax.swing.JLabel InvoiceItemsTable;
    private javax.swing.JTable InvoiceItemsjTable;
    private javax.swing.JLabel InvoiceNumberDisplayjLabel;
    private javax.swing.JLabel InvoiceNumberjLabel;
    private javax.swing.JLabel InvoiceTablejLabel;
    private javax.swing.JTable InvoiceTablejTable;
    private javax.swing.JButton AddItemBtn;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel_OfInvoiceTable;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton saveBtn;
    private javax.swing.JMenuItem saveFileMenuItem;
    private ArrayList<InvoiceHeader> InvoiceData = new ArrayList<>();
    private com.sig.model.HeaderTableModel HeaderTableModel;
    private com.sig.model.LineTableModel LineTableModel;
    private javax.swing.JButton CreateNewInvoiceBtn;
    private javax.swing.JLabel CustomerNamejLabel;
    private javax.swing.JTextField CustomerNamejTextField;
    private javax.swing.JButton DeleteInvoiceBtn;
    private javax.swing.JButton DeleteItemBtn;
    private javax.swing.JLabel InviceTotaljLabel;
    private javax.swing.JLabel InvoiceDatejLabel;
    private javax.swing.JMenuItem LoadFile;
    private javax.swing.JMenuItem SaveFile;
    private javax.swing.JLabel jLabel_InvoiceTotalDisplay;
    private javax.swing.JMenu jMenu1;

    private InvoiceHeaderDialog HeaderDialog;
    private InvoiceLineDialog LineDialog;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");

    public Jframe() {
        initComponents();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Jframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Jframe().setVisible(true);
            }
        });
    }

    private void initComponents() {

        InvoiceTablejLabel = new javax.swing.JLabel();
        jPanel_OfInvoiceTable = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        InvoiceTablejTable = new javax.swing.JTable();
        InvoiceTablejTable.getSelectionModel().addListSelectionListener(this);
        jScrollPane3 = new javax.swing.JScrollPane();
        InvoiceItemsjTable = new javax.swing.JTable();
        InvoiceNumberDisplayjLabel = new javax.swing.JLabel();
        InvoiceDatejLabel = new javax.swing.JLabel();
        CustomerNamejLabel = new javax.swing.JLabel();
        jLabel_InvoiceTotalDisplay = new javax.swing.JLabel();
        InvoiceItemsTable = new javax.swing.JLabel();
        InvoiceDatejTextField = new javax.swing.JTextField();
        CustomerNamejTextField = new javax.swing.JTextField();
        InvoiceNumberjLabel = new javax.swing.JLabel();
        InviceTotaljLabel = new javax.swing.JLabel();
        CreateNewInvoiceBtn = new javax.swing.JButton();
        CreateNewInvoiceBtn.addActionListener(this);
        CreateNewInvoiceBtn.setActionCommand("CreateNewInv");
        saveBtn = new javax.swing.JButton();
        DeleteInvoiceBtn = new javax.swing.JButton();
        DeleteInvoiceBtn.addActionListener(this);
        DeleteInvoiceBtn.setActionCommand("DelInvoice");
        AddItemBtn = new javax.swing.JButton();
        AddItemBtn.addActionListener(this);
        AddItemBtn.setActionCommand("Add");
        DeleteItemBtn = new javax.swing.JButton();
        DeleteItemBtn.addActionListener(this);
        DeleteItemBtn.setActionCommand("DelItem");
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        LoadFile = new javax.swing.JMenuItem();
        LoadFile.addActionListener(this);
        LoadFile.setActionCommand("load");
        saveFileMenuItem = new javax.swing.JMenuItem();
        SaveFile = new javax.swing.JMenuItem();
        SaveFile.addActionListener(this);
        SaveFile.setActionCommand("save");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        InvoiceTablejLabel.setText("InvoiceTable");

        InvoiceTablejTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "#", "Date", "Customer", "Total"
                }
        ));
        InvoiceTablejTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(InvoiceTablejTable);

        InvoiceItemsjTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null}
                },
                new String[]{
                        "#", "Item Name", "Item Price", "Count", "Item Total"
                }
        ));
        InvoiceItemsjTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(InvoiceItemsjTable);

        InvoiceNumberDisplayjLabel.setText("Invoice #");

        InvoiceDatejLabel.setText("Invoice Date");

        CustomerNamejLabel.setText("Customer Name");

        jLabel_InvoiceTotalDisplay.setText("InvoiceTotal");

        InvoiceItemsTable.setText("Invoice Items");

        CustomerNamejTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerNamejTextFieldActionPerformed(evt);
            }
        });

        InvoiceNumberjLabel.setText("Invoice #");

        InviceTotaljLabel.setText("Invoice Total");

        CreateNewInvoiceBtn.setText("Create New Invoice");
        CreateNewInvoiceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateNewInvoiceBtnActionPerformed(evt);
            }
        });
        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        DeleteInvoiceBtn.setText("Delete Invoice");
        DeleteInvoiceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteInvoiceBtnActionPerformed(evt);
            }
        });

        AddItemBtn.setText("Add Item");
        AddItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddItemBtnActionPerformed(evt);
            }
        });

        DeleteItemBtn.setText("Delete Item");
        DeleteItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteItemBtnActionPerformed(evt);
            }
        });
        jMenu1.setText("File");

        saveFileMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        saveFileMenuItem.setText("Save File");
        saveFileMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFileMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(saveFileMenuItem);
        javax.swing.GroupLayout jPanel_OfInvoiceTableLayout = new javax.swing.GroupLayout(jPanel_OfInvoiceTable);
        jPanel_OfInvoiceTable.setLayout(jPanel_OfInvoiceTableLayout);
        jPanel_OfInvoiceTableLayout.setHorizontalGroup(jPanel_OfInvoiceTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel_OfInvoiceTableLayout.createSequentialGroup().addGroup(jPanel_OfInvoiceTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel_OfInvoiceTableLayout.createSequentialGroup().addGap(30, 30, 30).addComponent(CreateNewInvoiceBtn).addGap(74, 74, 74).addComponent(DeleteInvoiceBtn)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_OfInvoiceTableLayout.createSequentialGroup().addContainerGap().addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))).addGroup(jPanel_OfInvoiceTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel_OfInvoiceTableLayout.createSequentialGroup().addGap(18, 18, 18).addGroup(jPanel_OfInvoiceTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_OfInvoiceTableLayout.createSequentialGroup().addGap(0, 15, Short.MAX_VALUE).addGroup(jPanel_OfInvoiceTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel_OfInvoiceTableLayout.createSequentialGroup().addGroup(jPanel_OfInvoiceTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(CustomerNamejLabel).addComponent(InvoiceDatejLabel).addComponent(InviceTotaljLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel_OfInvoiceTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel_InvoiceTotalDisplay).addComponent(CustomerNamejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(InvoiceDatejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))).addGroup(jPanel_OfInvoiceTableLayout.createSequentialGroup().addComponent(InvoiceNumberjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(InvoiceNumberDisplayjLabel))).addGap(96, 96, 96)).addGroup(jPanel_OfInvoiceTableLayout.createSequentialGroup().addGroup(jPanel_OfInvoiceTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(InvoiceItemsTable).addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))).addGroup(jPanel_OfInvoiceTableLayout.createSequentialGroup().addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(AddItemBtn).addGap(76, 76, 76).addComponent(saveBtn).addGap(96, 96, 96).addComponent(DeleteItemBtn).addGap(113, 113, 113)))));
        jPanel_OfInvoiceTableLayout.setVerticalGroup(jPanel_OfInvoiceTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_OfInvoiceTableLayout.createSequentialGroup().addGroup(jPanel_OfInvoiceTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE).addGroup(jPanel_OfInvoiceTableLayout.createSequentialGroup().addContainerGap().addGroup(jPanel_OfInvoiceTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(InvoiceNumberjLabel).addComponent(InvoiceNumberDisplayjLabel)).addGap(21, 21, 21).addGroup(jPanel_OfInvoiceTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(InvoiceDatejLabel).addComponent(InvoiceDatejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(15, 15, 15).addGroup(jPanel_OfInvoiceTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(CustomerNamejLabel).addComponent(CustomerNamejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(27, 27, 27).addGroup(jPanel_OfInvoiceTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel_InvoiceTotalDisplay).addComponent(InviceTotaljLabel)).addGap(18, 18, 18).addComponent(InvoiceItemsTable).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))).addGroup(jPanel_OfInvoiceTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_OfInvoiceTableLayout.createSequentialGroup().addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE).addGroup(jPanel_OfInvoiceTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(AddItemBtn).addComponent(saveBtn).addComponent(DeleteItemBtn)).addGap(29, 29, 29)).addGroup(jPanel_OfInvoiceTableLayout.createSequentialGroup().addGap(18, 18, 18).addGroup(jPanel_OfInvoiceTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(DeleteInvoiceBtn).addComponent(CreateNewInvoiceBtn)).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))));

        jMenu1.setText("File");

        LoadFile.setText("Load File");
        jMenu1.add(LoadFile);

      /*SaveFile.setText("Save File");
        SaveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveFileActionPerformed(evt);
            }
        });
        jMenu1.add(SaveFile);*/

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(InvoiceTablejLabel)
                                        .addComponent(jPanel_OfInvoiceTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(InvoiceTablejLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel_OfInvoiceTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CreateNewInvoiceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateNewInvoiceBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CreateNewInvoiceBtnActionPerformed

    private void DeleteInvoiceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteInvoiceBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteInvoiceBtnActionPerformed
    // End of variables declaration//GEN-END:variables

    private void CustomerNamejTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerNamejTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CustomerNamejTextFieldActionPerformed

    private void SaveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SaveFileActionPerformed

    private void AddItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddItemBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddItemBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // TODO add your handling code here:
        saveChange();
    }//GEN-LAST:event_saveBtnActionPerformed

    private void saveFileMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFileMenuItemActionPerformed
        // TODO add your handling code here:
        saveFile();
    }//GEN-LAST:event_saveFileMenuItemActionPerformed

    private void DeleteItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteItemBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteItemBtnActionPerformed

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("load")) {
            System.out.println("load clicked");
            try {
                loadFile();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (e.getActionCommand().equals("CreateNewInv")) {

            createInv();
        } else if (e.getActionCommand().equals("DelInvoice")) {

            deleteInv();
        } else if (e.getActionCommand().equals("Add")) {

            addItem();
        } else if (e.getActionCommand().equals("DelItem")) {

            deleteItem();
        } else if (e.getActionCommand().equals("createInvOk")) {

            createInvOk();
        } else if (e.getActionCommand().equals("createInvCancel")) {
            createInvCancel();
        } else if (e.getActionCommand().equals("createLineOk")) {
            createLineOk();
        } else if (e.getActionCommand().equals("createLineCancel")) {
            createLineCancel();
        }


    }

    private void loadFile() throws Exception {

        JOptionPane.showMessageDialog(this, "please select header file", "invoice header", JOptionPane.WARNING_MESSAGE);
        JFileChooser fc = new JFileChooser();
        int result = fc.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectFile = fc.getSelectedFile();
            FileReader fr = new FileReader(selectFile);
            BufferedReader br = new BufferedReader(fr);
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] headerSegments = line.split(",");
                String invIDStr = headerSegments[0];
                String invDateStr = headerSegments[1];
                String invoiceCustName = headerSegments[2];
                int invoiceID = Integer.parseInt(invIDStr);
                Date invoiceDate = dateFormat.parse(invDateStr);
                InvoiceHeader header = new InvoiceHeader(invoiceID, invoiceDate, invoiceCustName);
                InvoiceData.add(header);
            }
            br.close();
            fr.close();


            JOptionPane.showMessageDialog(this, "please select Invoice line file", "invoice line", JOptionPane.WARNING_MESSAGE);
            result = fc.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                selectFile = fc.getSelectedFile();
                fr = new FileReader(selectFile);
                br = new BufferedReader(fr);
                line = null;
                while ((line = br.readLine()) != null) {
                    String[] lineSegments = line.split(",");
                    String invIDStr = lineSegments[0];
                    String itemName = lineSegments[1];
                    String pricestr = lineSegments[2];
                    String countstr = lineSegments[3];
                    int invoiceID = Integer.parseInt(invIDStr);
                    double itemPrice = Double.parseDouble(pricestr);
                    int itemCount = Integer.parseInt(countstr);
                    InvoiceHeader header = findByNum(invoiceID);
                    InvoiceLine invline = new InvoiceLine(itemName, itemPrice, itemCount, header);
                    header.addLine(invline);
                }
                br.close();
                fr.close();

                HeaderTableModel = new HeaderTableModel(InvoiceData);
                InvoiceTablejTable.setModel(HeaderTableModel);
                InvoiceTablejTable.validate();


            }

        }
    }

    private InvoiceHeader findByNum(int num) {
        for (InvoiceHeader header : InvoiceData) {
            if (header.getInvoiceID() == num) {
                return header;
            }
        }
        return null;
    }


    @Override
    public void valueChanged(ListSelectionEvent e) {
        HeaderTableRowSelected();

    }

    private void HeaderTableRowSelected() {

        int selectedRowIndex = InvoiceTablejTable.getSelectedRow();
        if (selectedRowIndex >= 0) {
            InvoiceHeader row = HeaderTableModel.getInvoices().get(selectedRowIndex);

            CustomerNamejTextField.setText(row.getInvoiceCustName());
            InvoiceDatejTextField.setText(row.getInvoiceDate().toString());
            InvoiceNumberDisplayjLabel.setText("" + row.getInvoiceID());
            jLabel_InvoiceTotalDisplay.setText("" + row.getInvoiceTotal());
            ArrayList<InvoiceLine> lines = row.getLines();
            LineTableModel = new LineTableModel(lines);
            InvoiceItemsjTable.setModel(LineTableModel);
            LineTableModel.fireTableDataChanged();
        }
    }

  /*  private void saveData() throws Exception {

        JOptionPane.showMessageDialog(this, "Please choose file Header to Save", "Invoice Header", JOptionPane.WARNING_MESSAGE);
        JFileChooser fileChoosers = new JFileChooser();
        int option = fileChoosers.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File Csvfile = fileChoosers.getSelectedFile();
            PrintWriter out = new PrintWriter(Csvfile);

            for (InvoiceHeader header : InvoiceData) {

                out.printf("%d ,%s,%s", header.getInvoiceID(), header.getInvoiceDate().toString(), header.getInvoiceCustName());
                out.println();
            }
            out.close();
            JOptionPane.showMessageDialog(this, "Header Saved Successfully", "Info", JOptionPane.INFORMATION_MESSAGE);
        }

        JOptionPane.showMessageDialog(this, "Please choose file Line to Save", "Invoice Line", JOptionPane.WARNING_MESSAGE);
        fileChoosers = new JFileChooser();
        option = fileChoosers.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File Csvfilee = fileChoosers.getSelectedFile();
            PrintWriter outt = new PrintWriter(Csvfilee);


            for (InvoiceHeader header : InvoiceData) {
                for (InvoiceLine Lines : header.getLines()) {

                    outt.printf("%s ,%s,%d", Lines.getItemName(), "" + Lines.getItemPrice(), Lines.getItemCount());
                    outt.println();
                }
            }
            outt.close();
            JOptionPane.showMessageDialog(this, "Lines Saved Successfully", "Info", JOptionPane.INFORMATION_MESSAGE);
        }

    }

*/
    private void createInv() {
        HeaderDialog = new InvoiceHeaderDialog(this);
        HeaderDialog.setVisible(true);
    }

    private void deleteInv() {
        int row = InvoiceTablejTable.getSelectedRow();
        HeaderTableModel.removeRow(row);
        HeaderTableModel.fireTableDataChanged();
        LineTableModel.fireTableDataChanged();


    }

    private void addItem() {
        LineDialog = new InvoiceLineDialog(this);
        LineDialog.setVisible(true);
    }

    private void deleteItem() {
        int row = InvoiceItemsjTable.getSelectedRow();
        LineTableModel.removeRow(row);
        LineTableModel.fireTableDataChanged();
        HeaderTableModel.fireTableDataChanged();
    }

    private void createInvOk() {
        String customerName = HeaderDialog.getCustomerNameField().getText();
        String invDateStr = HeaderDialog.getDateField().getText();
        Date invDate = new Date();
        try {
            invDate = dateFormat.parse(invDateStr);

        } catch (ParseException ex) {

        }

        HeaderDialog.setVisible(false);
        int num = getMaxInvNum() + 1;
        InvoiceHeader newInvoiceHeader = new InvoiceHeader(num, invDate, customerName);
        InvoiceData.add(newInvoiceHeader);
        HeaderTableModel.fireTableDataChanged();


    }

    private void createInvCancel() {
        HeaderDialog.setVisible(false);
    }

    private int getMaxInvNum() {
        int num = 0;
        for (InvoiceHeader headr : InvoiceData) {
            if (headr.getInvoiceID() > num) {
                num = headr.getInvoiceID();
            }
        }
        return num;
    }

    private void createLineOk() {
        String itemName = LineDialog.getItemNameField().getText();
        String itemCountStr = LineDialog.getItemCountField().getText();
        String itemPriceStr = LineDialog.getItemPriceField().getText();
        LineDialog.setVisible(false);

        int itemCount = Integer.parseInt(itemCountStr);
        double itemPrice = Double.parseDouble(itemPriceStr);


        InvoiceHeader invoiceHeader = InvoiceData.get(InvoiceTablejTable.getSelectedRow());
        InvoiceLine line = new InvoiceLine(itemName, itemPrice, itemCount, invoiceHeader);
        invoiceHeader.addLine(line);
        LineTableModel.fireTableDataChanged();
        HeaderTableModel.fireTableDataChanged();
    }

    private void saveChange() {
        saveHeaderChange();
        saveLineChange();
    }

    private void saveHeaderChange() {
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("File Save");
        if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File savedFile = fc.getSelectedFile();

            try {
                FileWriter fw = new FileWriter(savedFile);
                BufferedWriter bw = new BufferedWriter(fw);
                for (int i = 0; i < HeaderTableModel.getRowCount(); i++) {
                    for (int j = 0; j < HeaderTableModel.getColumnCount(); j++) {
                        bw.write(HeaderTableModel.getValueAt(i, j).toString() + ",");
                    }
                    bw.newLine();
                }
                JOptionPane.showMessageDialog(this, "Header Table Saved",
                        "Save Info", JOptionPane.INFORMATION_MESSAGE);
                bw.close();
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(Jframe.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error",
                        "Error Info", JOptionPane.ERROR_MESSAGE);
            }

        }

    }

    private void saveLineChange() {
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("File Save");
        if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File savedFile = fc.getSelectedFile();

            try {
                FileWriter fw = new FileWriter(savedFile + ".csv");
                BufferedWriter bw = new BufferedWriter(fw);
                for (InvoiceHeader inv : InvoiceData) {
                    for (InvoiceLine item : inv.getLines()) {
                        bw.write(inv.getInvoiceID() + "," + item.getItemName() + "," + item.getItemPrice() + "," + item.getItemCount());

                    }
                    bw.newLine();
                }

                JOptionPane.showMessageDialog(this, "Line Table Saved", "Save Info", JOptionPane.INFORMATION_MESSAGE);
                bw.close();
                fw.close();

            } catch (IOException ex) {
                Logger.getLogger(Jframe.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error",
                        "Error Info", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    private void saveFile() {

        saveChange();
    }

    private void createLineCancel() {
        LineDialog.setVisible(false);
    }

}