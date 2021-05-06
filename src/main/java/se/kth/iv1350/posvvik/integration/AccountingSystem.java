package se.kth.iv1350.posvvik.integration;

import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.posvvik.model.Sale;

/**
 *  AccountingSystem keeps track of all the sales
 */
public class AccountingSystem {
    private List<Sale> sales = new ArrayList<Sale>();
    /**
     * Adds sale to list of sales
     * @param sale The specific sale added
     */
    public void addSale(Sale sale){
        sales.add(sale);
    }
    /**
     * Get the list of sales made
     * @return sales 
     */
    public List<Sale> getSales(){
        return sales;
    }
}
