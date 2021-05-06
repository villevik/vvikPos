package se.kth.iv1350.posvvik.integration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.posvvik.model.ItemDTO;
import se.kth.iv1350.posvvik.model.ItemIdentifier;
import se.kth.iv1350.posvvik.model.Sale;


public class InventorySystemTest {
    @Test
    public void testRetrieveItemInfo() {
        System.out.println("retrieveItemInfo");
        ItemIdentifier itemId = new ItemIdentifier(1);
        InventorySystem instance = new InventorySystem();
        ItemDTO expResultItem = new ItemDTO(itemId);
        ItemDTO resultItem = instance.retrieveItemInfo(itemId);
        String expResult = expResultItem.getName();
        String result = resultItem.getName();
        assertEquals(expResult, result,"The items does not match!");
    }

    @Test
    public void testRemoveItems() {
        System.out.println("removeItems");
        Sale sale = new Sale();
        ItemIdentifier itemId = new ItemIdentifier(1);
        ItemDTO item = new ItemDTO(itemId);
        sale.registerItem(item);
        
        InventorySystem instance = new InventorySystem();
        instance.removeItems(sale);
        
        int result = instance.getInventory().size();
        int expResult = 3;
        assertEquals(expResult, result,"The size does not match!");
        
    }
    
}
