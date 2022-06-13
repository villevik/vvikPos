package se.kth.iv1350.posvvik.controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.posvvik.integration.SystemCreator;
import se.kth.iv1350.posvvik.model.ItemIdentifier;

/**
 *
 * @author ville
 */
public class ControllerTest {

    @Test
    public void testFailScanItem() throws Exception {
        System.out.println("scanItem");
        ItemIdentifier itemId = new ItemIdentifier(5);
        SystemCreator sysCrtr = new SystemCreator();
        Controller instance = new Controller(sysCrtr);
        try{
            instance.scanItem(itemId);
            fail("Operation succeeded");
        }
        catch(OperationFailedException e){
            assertTrue(itemId.getItemNo() == 5);
        }
    }
    
}
