package util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import se.kth.iv1350.posvvik.model.RevenueObserver;

/**
 *
 * @author ville
 */
public class TotalRevenueFileOutput implements RevenueObserver{
    private PrintWriter logStream;
    private double totalRevenue;
    public TotalRevenueFileOutput(){
        try{
            logStream = new PrintWriter(new FileWriter("totalRevenue.txt"),true);
        }
        catch(IOException ioe){
            System.out.println("Unable to log!");
        }
    }
    @Override
    public void newTotalRevenue(double amount){
        totalRevenue += amount;
        StringBuilder sb = new StringBuilder();
        sb.append("Total revenue: ");
        sb.append(totalRevenue);

        log(sb.toString());
    }
    
    public void log(String message, double revenue){
        logStream.println(message + revenue);
    }

    //@Override
    public void log(String msg) {
        logStream.println(msg); 
    }

    
}
