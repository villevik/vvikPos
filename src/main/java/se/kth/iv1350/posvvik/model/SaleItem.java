package se.kth.iv1350.posvvik.model;

/**
 *  SaleItem is the items added to a sale and uses the required information from
 *  an item to add to a sale object
 * 
 */
public class SaleItem {
    private String name;
    private double vat;
    private double totalPrice;
    private int quantity;
    /**
     * Creates a new item that fits better to be put in the sale 
     * @param item  Used to get item info needed
     * @param quantity  The Quantity of the item
     */
    public SaleItem(ItemDTO item, int quantity){
        this.name = item.getName();
        this.totalPrice = item.getTotalPrice();
        this.quantity = quantity;
        this.vat = item.getVat();
    }
    /**
     * Get the name of the sale item
     * @return 
     */
    public String getName(){
        return name;
    }
    /**
     * Get the total price of the sale item
     * @return 
     */
    public double getTotalPrice(){
        return totalPrice;
    }
    /**
     * Get the quantity of the sale item
     * @return 
     */
    public int getQuantity(){
        return quantity;
    }
    /**
     * Get the vat of the sale item with respect ot the quantity.
     * @return 
     */
    public double getVat(){
        return quantity * vat;
    }
    /**
     * Increase the quantity of a sale item.
     */
    public void increaseQuantity(){
        quantity++;
    }
}
