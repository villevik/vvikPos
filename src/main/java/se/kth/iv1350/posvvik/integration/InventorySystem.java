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
     * @throws NoSuchItemIdentifierException Item identifier does not exist
     * @throws DBSException tells that Database Server could not be reached(hardcoded)
     */
    public InventorySystem() throws NoSuchItemIdentifierException, DBSException{
        fillInventory();
        System.out.println("Inventory filled!");
    }
    /**
     * Called to get item information decided by the ItemIdentifier
     * @param itemId    Used to identify which item to get
     * @return item of the type ItemDTO
     * @throws NoSuchItemIdentifierException tells that no such itemId exists in inventory
     * @throws DBSException tells that Database Server could not be reached(hardcoded)
     */
    public ItemDTO retrieveItemInfo(ItemIdentifier itemId)throws NoSuchItemIdentifierException,DBSException{
        if(itemId.getItemNo() > 0 && itemId.getItemNo() < 4){
            ItemDTO item = new ItemDTO(itemId);
            return item;
        }
        if(itemId.getItemNo() == 4) throw new DBSException("External inventory system could not be reached");
        throw new NoSuchItemIdentifierException("Item identifier " + itemId.getItemNo() + " does not exist.");
    }
    /**
     * Fills inventory with example items
     */
    private void fillInventory() throws NoSuchItemIdentifierException, DBSException{
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
