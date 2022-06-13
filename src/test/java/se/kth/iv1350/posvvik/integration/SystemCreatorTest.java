/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.posvvik.integration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.posvvik.controller.Controller;
import se.kth.iv1350.posvvik.model.ItemIdentifier;

/**
 *
 * @author ville
 */
public class SystemCreatorTest {
    
    @Test
    public void testSysCrtr() throws DBSException {
        
        try{
            
            SystemCreator sysCrtr = new SystemCreator();
            
        }
        catch(ExternalSystemFail e){
            fail("An external system fail!");
        }
        
    }

    
}
