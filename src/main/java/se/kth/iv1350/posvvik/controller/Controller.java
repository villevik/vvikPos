/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.posvvik.controller;

import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.posvvik.integration.AccountingSystem;
import se.kth.iv1350.posvvik.integration.CashRegister;
import se.kth.iv1350.posvvik.integration.DBSException;
import se.kth.iv1350.posvvik.integration.DiscountCatalog;
import se.kth.iv1350.posvvik.integration.Display;
import se.kth.iv1350.posvvik.integration.InventorySystem;
import se.kth.iv1350.posvvik.integration.NoSuchItemIdentifierException;
import se.kth.iv1350.posvvik.integration.Printer;
import se.kth.iv1350.posvvik.integration.SystemCreator;
import se.kth.iv1350.posvvik.model.ItemDTO;
import se.kth.iv1350.posvvik.model.ItemIdentifier;
import se.kth.iv1350.posvvik.model.Payment;
import se.kth.iv1350.posvvik.model.Receipt;
import se.kth.iv1350.posvvik.model.RevenueObserver;
import se.kth.iv1350.posvvik.model.Sale;

/**
 *
 * This is the application's only controller. All calls to the model pass t
 * hrough this class
 */
public class Controller {
    private Printer printer;
    private Display disp;
    private DiscountCatalog discCat;
    private InventorySystem invSys;
    private AccountingSystem accSys;
    private CashRegister cashReg;
    private Sale sale;
    private Payment payment;
    private List<RevenueObserver> revenueObservers = new ArrayList<>();
    /**
     * Aquries all the systems from the integration layer
     * @param sysCrtr The object that initializes all external systems.
     */
    public Controller(SystemCreator sysCrtr){
        cashReg = new CashRegister();
        accSys = sysCrtr.getAccSys();
        disp = sysCrtr.getDisp();
        invSys = sysCrtr.getInvSys();
        printer = sysCrtr.getPrinter();
        discCat = sysCrtr.getDiscCat();
    }
    /**
     * Starts new sale. Must be executed when first starting a sale.
     */
    public void startSale(){
        sale = new Sale();
    }
    /**
     * Registers item and updates display with the sale.
     * @param itemId The itemId of the product
     * @throws NoSuchItemIdentifierException itemId not found
     * @throws OperationFailedException
     * @throws DBSException if system can't connect to Database Server
     */
    public void scanItem(ItemIdentifier itemId) throws OperationFailedException, DBSException{
        try{
            ItemDTO item = this.invSys.retrieveItemInfo(itemId);
            sale.registerItem(item);
            disp.displaySale(sale);
        }
        catch(NoSuchItemIdentifierException noItemId){
            throw new OperationFailedException("Operation failed", noItemId);
        }
    }
    /**
     * Makes the call to make a new payment and make a receipt out of it.
     * @param amountPaid The amount of cash from the customer
     */
    public void pay(double amountPaid){
        payment = new Payment(amountPaid,sale);
        paymentAddObservers();
        Receipt receipt = new Receipt(sale,payment);
        printer.print(receipt);
    }
    /**
     * Called after all the items are registered to update systems.
     */
    public void finishSale(){
        cashReg.updateCashRegister(payment);
        invSys.removeItems(sale);
        accSys.addSale(sale);
    }
    /**
     * Add a revenue observer
     * @param obs Observer added
     */
    public void addRevenueObserver(RevenueObserver obs){
        revenueObservers.add(obs);
        
    }
    public void paymentAddObservers(){
        payment.addRevenueObservers(revenueObservers);
    }
}
