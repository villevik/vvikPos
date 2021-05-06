package se.kth.iv1350.posvvik.model;

/**
 *  Handles all the data for specific item
 * 
 */
public class ItemDTO {
    private ItemIdentifier itemId;
    private double price;
    private double vat;
    private double totalPrice;
    private ItemDescription itemDscrpt;
    private String name;
    /**
     * Create an ItemDTO with required information about the item
     * @param itemId Decides what item it is.
     */
    public ItemDTO(ItemIdentifier itemId){
        this.itemId = itemId;
        this.itemDscrpt = new ItemDescription();
        this.price = setPrice(itemId);
        this.vat = itemDscrpt.getVatRate(itemId) * this.price;
        this.totalPrice = this.price + this.vat;
        this.name = itemDscrpt.getName();
    }
    /**
     * Depending on the item number the products have differnet prices.
     * @param itemId To get the itemNo
     * @return price of the item
     */
    private double setPrice(ItemIdentifier itemId){
        
        int itemNo = itemId.getItemNo();
        switch (itemNo) {
            case 1:
                return 10;
            case 2:
                return 20;
            default:
                return 30;
        }
    }
    /**
     * Get the totalPrice including vat
     * @return 
     */
    public double getTotalPrice(){
        return totalPrice;
    }
    /**
     * Get the vat of the item
     * @return 
     */
    public double getVat(){
        return vat;
    }
    /**
     * Get the name of the item
     * @return 
     */
    public String getName(){
        return name;
    }
    /**
     * Get the ItemId of the item
     * @return 
     */
    public ItemIdentifier getItemId(){
        return itemId;
    }
}
