package se.kth.iv1350.posvvik.view;

import se.kth.iv1350.posvvik.controller.Controller;
import se.kth.iv1350.posvvik.model.ItemDTO;
import se.kth.iv1350.posvvik.model.ItemIdentifier;

/**
 *
 * This is a placeholder for the real view. It contains a hardocded execution 
 * with calls to all system operations in the controller.
 */
public class View {
    private Controller contr;
    /**
     * Makes sure View has the controller
     * @param contr The controller making calls
     */
    public View(Controller contr){
        this.contr = contr;
    }
    /**
     * A hardcoded execution of a sample sale
     */
    public void sampleSale(){
        this.contr.startSale();
        ItemIdentifier itemIdA = new ItemIdentifier(1);
        ItemIdentifier itemIdF = new ItemIdentifier(2);
        ItemIdentifier itemIdC = new ItemIdentifier(3);
        
        this.contr.scanItem(itemIdA);
        this.contr.scanItem(itemIdF);
        this.contr.scanItem(itemIdF);
        this.contr.scanItem(itemIdC);
        contr.pay(100.00);
        contr.finishSale();
    }
}
