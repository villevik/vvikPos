package se.kth.iv1350.posvvik.model;

/**
 *  
 * @author ville
 */
public interface RevenueObserver {
    /**
     * Invoked when a new payment is made.
     * @param amount Amount added to total revenue
     */
    void newTotalRevenue(double amount);
}
