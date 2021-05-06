package se.kth.iv1350.posvvik.integration;

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
    /**
     * creates instances of the external systems.
     */
    public SystemCreator(){
        printer = new Printer();
        disp = new Display();
        discCat = new DiscountCatalog();
        invSys = new InventorySystem();
        accSys = new AccountingSystem();
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
