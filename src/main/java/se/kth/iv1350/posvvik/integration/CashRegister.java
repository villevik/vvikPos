package se.kth.iv1350.posvvik.integration;

import se.kth.iv1350.posvvik.model.Payment;

/**
 *  CashRegister is keeping track of the cash 
 */
public class CashRegister {
    private double amountInRegister;
    /**
     * Updates the cash register with customers money and removes the change given
     * @param payment Holds information about the payment
     */
    public void updateCashRegister(Payment payment){
        amountInRegister += payment.getAmountPaid() - payment.getChange();
    }
}
