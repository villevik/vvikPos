package se.kth.iv1350.posvvik.model;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ville
 */
public class SaleTest {

    @Test
    public void testRegisterItem() {
        System.out.println("registerItem");
        ItemIdentifier itemId = new ItemIdentifier(1);
        ItemDTO item = new ItemDTO(itemId);
        Sale instance = new Sale();
        instance.registerItem(item);
        int result = 0;
        if(instance.getItems().containsKey(itemId)){
            result = 1;
        }
        System.out.println(result);
        int expResult = 1;
        assertEquals(expResult,result, "The sale object does not contain the expected item.");
    }


    @Test
    public void testToString() {
        System.out.println("toString");
        ItemIdentifier itemId = new ItemIdentifier(1);
        ItemDTO item = new ItemDTO(itemId);
        Sale instance = new Sale();
        instance.registerItem(item);
        StringBuilder sb = new StringBuilder();
        String name = "Apple";
        int qty = 1;
        double totPrice = 10.6;
        sb.append(name).append("\tQty:");
        sb.append(qty).append("\tTotPrice:");
        sb.append(qty * totPrice).append("\n");
        sb.append(totPrice).append("\n");
        String expResult = sb.toString();
        String result = instance.toString();
        assertEquals(expResult, result,"Strings does not match");
    }
    
}
