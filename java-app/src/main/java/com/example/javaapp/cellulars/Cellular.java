package com.example.javaapp.cellulars;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Cellular {
    private String cellularNumber;
    private String billNumber;

    public Cellular() {

    }

    public Cellular(String cellularNumber, String billNumber) {
        this.cellularNumber = cellularNumber;
        this.billNumber = billNumber;
    }

    public Cellular(String cellularNumber) {
        this.cellularNumber = cellularNumber;
    }

    public String getCellularNumber() {
        return cellularNumber;
    }

    public void setCellularNumber(String cellularNumber) {
        this.cellularNumber = cellularNumber;
    }

    public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    @Override
    public String toString() {
        return "Cellular [cellularNumber=" + cellularNumber + ", billNumber=" + billNumber + "]";
    }

}
