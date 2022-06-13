package se.kth.iv1350.posvvik.view;

import se.kth.iv1350.posvvik.model.RevenueObserver;

/**
 *   Show the total income on the user interface
 */
public class TotalRevenueView implements RevenueObserver{
    private double totalRevenue;
    public TotalRevenueView(){
        this.totalRevenue = 0;
    }
    
    @Override
    public void newTotalRevenue(double amount){
        totalRevenue += amount;
        printTotalRevenue(totalRevenue);
    }
    
    private void printTotalRevenue(double revenue){
        System.out.println("--------------------------------------");
        System.out.println("--------------Total income------------");
        System.out.println("--------------" + revenue + "---------------");
        System.out.println("--------------------------------------");
    } 
}
