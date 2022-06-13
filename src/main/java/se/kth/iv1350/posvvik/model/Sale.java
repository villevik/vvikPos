package se.kth.iv1350.posvvik.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * Single sale mad by a customer.
 */
public class Sale {
    private LocalTime saleTime;
    
    private HashMap<ItemIdentifier, SaleItem> items = new HashMap<>();
    private double totalPrice;
    /**
     * Creates new sale and defines the current time
     */
    public Sale(){
        saleTime = LocalTime.now();
    }
    /**
     * Gets the current time
     * @return saleTime The time sale starts
     */
    public LocalTime getSaleTime(){
        return saleTime;
    }
    /**
     * Registers item in sale, puts it in the HashMap
     * @param item ItemDTO to be put in the sale
     */
    public void registerItem(ItemDTO item){
        if(checkIfScanned(item.getItemId())){
            SaleItem existingItem = items.get(item.getItemId());
            existingItem.increaseQuantity();
            totalPrice += item.getTotalPrice();
        }
        else{
            SaleItem saleItem = new SaleItem(item,1);
            items.put(item.getItemId(), saleItem);
            totalPrice += item.getTotalPrice();
        }
        
    }
    /**
     * Checks if item is already scanned or not
     * @param itemId Used to compare to other items in the HashMap
     * @return boolean of whether the item is scanned(true if scanned already)
     */
    private boolean checkIfScanned(ItemIdentifier itemId){
        return items.containsKey(itemId);
    }
    /**
     * Called to get the current total price of the sale
     * @return totalPrice double
     */
    public double getTotalPrice(){
        return totalPrice;
    }
    /**
     * Get a hashmap of all items in sale
     * @return HashMap items
     */
    public HashMap<ItemIdentifier,SaleItem> getItems(){
        return items;
    }
            
    /**
     * Converts the sale object to a readable string
     * @return saleInfo.toString() stringbuilder as a string
     */
    @Override
    public String toString(){
        StringBuilder saleInfo = new StringBuilder();
        items.forEach((k,v) -> {
            saleInfo.append(v.getName()).append("\tQty:");
            saleInfo.append(v.getQuantity()).append("\tTotPrice:");
            saleInfo.append(v.getQuantity()*v.getTotalPrice()).append("\n");
        });
        saleInfo.append(getTotalPrice()).append("\n");
        return saleInfo.toString();
    }
}


