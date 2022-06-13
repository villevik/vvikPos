/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.posvvik.startup;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.posvvik.integration.DBSException;
import se.kth.iv1350.posvvik.integration.ExternalSystemFail;

/**
 *
 * @author ville
 */
public class MainTest {

    @Test
    public void testMain() throws ExternalSystemFail, DBSException {
        String[] args = null;
        Main.main(args);
    }
    
}
