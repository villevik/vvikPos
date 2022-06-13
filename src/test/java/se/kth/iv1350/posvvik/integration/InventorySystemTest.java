package se.kth.iv1350.posvvik.integration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.posvvik.model.ItemDTO;
import se.kth.iv1350.posvvik.model.ItemIdentifier;
import se.kth.iv1350.posvvik.model.Sale;


public class InventorySystemTest {
    @Test
    public void testRetrieveItemInfo() throws NoSuchItemIdentifierException, DBSException {

        ItemIdentifier itemId = new ItemIdentifier(1);
        ItemDTO expResultItem = new ItemDTO(itemId);
        try{
            InventorySystem instance = new InventorySystem();
            ItemDTO resultItem = instance.retrieveItemInfo(itemId);
        }
        catch(NoSuchItemIdentifierException e){
            fail("Item identifier not found");
        }
        catch(DBSException e){
            fail("Could not connect to database server");
        }
    }
    @Test
    public void testRetriveNonExistentItemInfo(){
        ItemIdentifier itemId = new ItemIdentifier(5);
        ItemDTO expResultItem = new ItemDTO(itemId);
        try{
            InventorySystem instance = new InventorySystem();
            ItemDTO resultItem = instance.retrieveItemInfo(itemId);
            fail("Could rettrieve non existent item info!");
        }
        catch(NoSuchItemIdentifierException e){
            assertTrue(itemId.getItemNo() > 4 || itemId.getItemNo() < 1);
        }
        catch(DBSException e){
            fail("Could not connect to database server");
        }
    }
    @Test
    public void testRetriveItemInfoDBSExc(){
        ItemIdentifier itemId = new ItemIdentifier(4);
        ItemDTO expResultItem = new ItemDTO(itemId);
        try{
            InventorySystem instance = new InventorySystem();
            ItemDTO resultItem = instance.retrieveItemInfo(itemId);
            fail("Could connect to database server!");
        }
        catch(NoSuchItemIdentifierException e){
            fail("Item identifier not found");
        }
        catch(DBSException e){
            assertTrue(itemId.getItemNo() == 4);
        }
    }
    @Test
    public void testRemoveItems() throws NoSuchItemIdentifierException, DBSException {
        //System.out.println("removeItems");
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
