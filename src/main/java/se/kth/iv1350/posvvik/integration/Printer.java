package se.kth.iv1350.posvvik.integration;

import se.kth.iv1350.posvvik.model.Receipt;

/**
 * Printer for receipts
 */
public class Printer {
    public Printer(){
        
    }
    /**
     * Prints the finished receipt
     * @param receipt Uses receipt.toString() for contents of the receipt
     */
    public void print(Receipt receipt){
        System.out.println(receipt.toString());
    }
}
