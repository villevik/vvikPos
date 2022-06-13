package se.kth.iv1350.posvvik.model;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *  Holds information about payment mad by customer
 */
public class Payment {
    Sale sale;
    private double amountPaid;
    private double change;
    private double revenue;
    private List<RevenueObserver> revenueObservers = new ArrayList<>();
    private Logger logger;
    /**
     * Sets the amounts of money paid and gathers information about the sale
     * @param amountPaid    Made by customer
     * @param sale  The finished sale object
     */
    public Payment(double amountPaid, Sale sale){
        this.amountPaid = amountPaid;
        this.sale = sale;
        this.revenue = sale.getTotalPrice();
    }
    
    /**
     * For other classes to receive the amount paid
     * @return amountPaid as a double
     */
    public double getAmountPaid(){
        return amountPaid;
    }
    /**
     * How much change is given to the customer
     * @return change as a double
     */
    public double getChange(){
        change = calculateChange();
        return change;
    }
    /**
     * Calculates the change from how much is paid and what the price is
     * @return amountPaid - totalPrice 
     */
    private double calculateChange(){
        return amountPaid - revenue;
    }
    /**
     * Adds all the observers from the list observers. Also notifies them,
     * this might not be the best spot to do so but in this case there's no call
     * to Payment after this one. Bad encapsulation.
     * @param observers 
     */
    public void addRevenueObservers(List<RevenueObserver> observers){
        revenueObservers.addAll(observers);
        notifyObservers();
        
    }
    /**
     * Notifies the observers there has been a payment done.
     */
    private void notifyObservers(){
        for(RevenueObserver obs : revenueObservers){
            obs.newTotalRevenue(amountPaid);
        }
    }
}
