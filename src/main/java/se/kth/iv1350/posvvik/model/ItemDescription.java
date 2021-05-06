package se.kth.iv1350.posvvik.model;

/**
 *  ItemDescription contains information about vat 
 * 
 */
public class ItemDescription {
    
    private ItemIdentifier itemId;
    private String name;
    private final double highVat = 0.25;
    private final double middleVat = 0.12;
    private final double lowVat = 0.06;
    public ItemDescription(){
        
    }
    /**
     * Get the vat rate of specific item.
     * @param itemId To decide what the vatrate is
     * @return vatrate depending on vatindex
     */
    public double getVatRate(ItemIdentifier itemId){
        this.itemId = itemId;
        switch(itemId.getVatIndex()){
            case 1:
                return lowVat;
                
            case 2:
                return middleVat;
                
            case 3:
                return highVat;
                
            default:
                System.out.println("Vat index does not exist");
                return 0;
        }
    }
    /**
     * Get the name of the item
     * @return Name of the item
     */
    public String getName(){
        switch (this.itemId.getItemNo()) {
            case 1:
                name = "Apple";
                break;
            case 2:
                name = "Fanta";
                break;
            default:
                name = "Coffee";
                break;
        }
        
        return this.name;
    }
}
