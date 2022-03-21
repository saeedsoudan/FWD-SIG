/**
 * @author Saeed H. Soudan
 */
package com.sig.model;


import java.util.ArrayList;
import java.util.Date;


public class InvoiceHeader {

    private int invoiceID;
    private Date invoiceDate;
    private String invoiceCustName;
    private double invoiceTotal;
    private ArrayList<InvoiceLine> lines;


    public InvoiceHeader(int invoiceID, Date invoiceDate, String invoiceCustName) {
        this.invoiceID = invoiceID;
        this.invoiceDate = invoiceDate;
        this.invoiceCustName = invoiceCustName;
    }

    public int getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getInvoiceCustName() {
        return invoiceCustName;
    }

    public void setInvoiceCustName(String invoiceCustName) {
        this.invoiceCustName = invoiceCustName;
    }

    public double getInvoiceTotal() {
        return invoiceTotal;
    }

    public void setInvoiceTotal(double invoiceTotal) {
        this.invoiceTotal = invoiceTotal;
    }


    public ArrayList<InvoiceLine> getLines() {
        if (lines == null) {
            lines = new ArrayList<>();
        }
        return lines;
    }

    public void setLines(ArrayList<InvoiceLine> lines) {
        this.lines = lines;
    }

    public void addLine(InvoiceLine l) {
        getLines().add(l);
        setInvoiceTotal(getInvoiceTotal() + l.getitemTotal());
    }
    public void removeLine(InvoiceLine l) {
        getLines().remove(l);

    }

}
