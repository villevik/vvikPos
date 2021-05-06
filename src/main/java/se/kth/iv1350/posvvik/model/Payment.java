package se.kth.iv1350.posvvik.model;

/**
 *  Holds information about payment mad by customer
 */
public class Payment {
    Sale sale;
    private double amountPaid;
    private double change;
    /**
     * Sets the amounts of money paid and gathers information about the sale
     * @param amountPaid    Made by customer
     * @param sale  The finished sale object
     */
    public Payment(double amountPaid, Sale sale){
        this.amountPaid = amountPaid;
        this.sale = sale;
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
        return amountPaid - sale.getTotalPrice();
    }
}
