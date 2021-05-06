package se.kth.iv1350.posvvik.integration;

import java.util.HashMap;
import se.kth.iv1350.posvvik.model.ItemDTO;
import se.kth.iv1350.posvvik.model.ItemIdentifier;
import se.kth.iv1350.posvvik.model.Sale;
import se.kth.iv1350.posvvik.model.SaleItem;

/**
 *  External inventory system
 * 
 */
public class InventorySystem {
    private HashMap<ItemIdentifier, ItemDTO> inventory = new HashMap<>();
    /**
     * Fills the inventory with some sample items and create an instance of inventory
     */
    public InventorySystem(){
        fillInventory();
    }
    /**
     * Called to get item information decided by the ItemIdentifier
     * @param itemId    Used to identify which item to get
     * @return item of the type ItemDTO
     */
    public ItemDTO retrieveItemInfo(ItemIdentifier itemId){
        
        ItemDTO item = new ItemDTO(itemId);
        return item;
    }
    /**
     * Fills inventory with example items
     */
    private void fillInventory(){
        ItemIdentifier itemIdA = new ItemIdentifier(1);
        ItemIdentifier itemIdF = new ItemIdentifier(2);
        ItemIdentifier itemIdC = new ItemIdentifier(3);
        inventory.put(itemIdA, retrieveItemInfo(itemIdA));
        inventory.put(itemIdF, retrieveItemInfo(itemIdF));
        inventory.put(itemIdF, retrieveItemInfo(itemIdF));
        inventory.put(itemIdC, retrieveItemInfo(itemIdC));
    }
    /**
     * Remove the items in sale from the inventory.
     * @param sale Needed to get the items in the sale
     */
    public void removeItems(Sale sale){
        sale.getItems().forEach((k,v) -> {
            inventory.remove(k);
        });   
    }
    /**
     * Get the hasmap containing all the items in the invetory
     * @return inventory Type HashMap<ItemIdentifier,ItemDTO>
     */
    public HashMap<ItemIdentifier, ItemDTO> getInventory(){
        return inventory;
    }
}
