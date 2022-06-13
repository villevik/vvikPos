package se.kth.iv1350.posvvik.integration;

import java.util.logging.Level;
import java.util.logging.Logger;
import se.kth.iv1350.posvvik.controller.OperationFailedException;

/**
 *  SystemCreator is in charge of creating an object of all the external 
 *  systems and cointains methods for getting references to these.
 *  
 */
public class SystemCreator {
    private Printer printer;
    private Display disp;
    private DiscountCatalog discCat;
    private InventorySystem invSys;
    private AccountingSystem accSys;
    private ExternalSystemFail exSysFail;
    /**
     * creates instances of the external systems.
     * @throws ExternalSystemFail When system creator fails to create a system
     * @throws DBSException When system can't connect to Database Server
     */
    public SystemCreator() throws ExternalSystemFail, DBSException {
        
        printer = new Printer();
        disp = new Display();
        discCat = new DiscountCatalog();
        accSys = new AccountingSystem();
        try {               
            invSys = new InventorySystem();
        } catch (NoSuchItemIdentifierException ex) {
            throw new ExternalSystemFail("External system fail");
        }
    }
    /**
     * Gives a refernce to the external accounting system.
     * @return accSys A reference to the external accounting system
     */
    public AccountingSystem getAccSys(){
        return accSys;
    }
    /**
     * Gives a refernce to the display.
     * @return disp A refernce to the display at the cash register
     */
    public Display getDisp(){
        return disp;
    }
    /**
     * Gives a refernce to the external inventory system.
     * @return invSys A reference to the external inventory system
     */
    public InventorySystem getInvSys(){
        return invSys;
    }
    /**
     * Gives a refernce to the printer for the receipts.
     * @return printer A reference to the receipt-printer
     */
    public Printer getPrinter(){
        return printer;
    }
    /**
     * Gives a refernce to the discount catalog keeping track of available 
     * discounts.
     * @return discCat A refernce to the discount catalog
     */
    public DiscountCatalog getDiscCat(){
        return discCat;
    }
}
