package se.kth.iv1350.posvvik.integration;

import se.kth.iv1350.posvvik.model.Sale;

/**
 *  Display is a physical object that presents information about the active sale
 * 
 */
public class Display {
    /**
     * Displays running sale 
     * @param sale Used to get the sale info
     */
    public void displaySale(Sale sale){
        System.out.print(sale.toString());
    }
}
