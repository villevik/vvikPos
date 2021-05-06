/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.posvvik.startup;

import se.kth.iv1350.posvvik.controller.Controller;
import se.kth.iv1350.posvvik.integration.SystemCreator;
import se.kth.iv1350.posvvik.view.View;

/**
 *
 * @author ville
 */
public class Main {
    /**
     * The main method used to start the entire application.
     * 
     * @param args The application does not take any command line parameters.
     */
    public static void main(String[] args){
        SystemCreator sysCrtr = new SystemCreator();
        Controller contr = new Controller(sysCrtr);
        View view = new View(contr);
        
        view.sampleSale();
    }
}
