package se.kth.iv1350.posvvik.model;

/**
 *  ItemIdentifier is used as a unique identifier for each single item. 
 * 
 */

public class ItemIdentifier {
    private int itemNo;
    private int vatIndex;
    /**
     * Create itemidentifier containing info about item number and vatRate
     * @param itemNo The number seen on the product and used to find the item
     */
    public ItemIdentifier(int itemNo){
        this.itemNo = itemNo;
        this.vatIndex = setVatIndex();
    }
    /**
     * Decides what the vatindex is which decides vatrate
     * @return the index of the vatrate.
     */
    private int setVatIndex(){
        return switch (this.itemNo) {
            case 1 -> 1;
            case 2 -> 2;
            default -> 3;
        };
    }
    /**
     * Get the vatindex of item
     * @return 
     */
    public int getVatIndex(){
        return this.vatIndex;
    }
    /**
     * Get the item number of the item
     * @return 
     */
    public int getItemNo(){
        return this.itemNo;
    }
}
