package se.kth.iv1350.posvvik.model;

import java.time.LocalTime;
import java.util.HashMap;

/**
 *  Contains the information about the sale handed to the customer
 */
public class Receipt {
    private LocalTime saleTime;
    private String store;
    private String saleInfo;
    private double totalVat;
    private double amountPaid;
    private double change;
    /**
     * Creates a new receipt, in this case the store is final
     * @param sale Gathers information the receipt need from sale
     * @param payment Information about payment
     */
    public Receipt(Sale sale,Payment payment){
        this.saleTime = sale.getSaleTime();
        this.store = "Samplestore @ samplestreet 1";
        this.saleInfo = sale.toString();
        calculateTotalVat(sale.getItems());
        this.amountPaid = payment.getAmountPaid();
        this.change = payment.getChange();
    }
    /**
     * Calculate the total vat using the items from sale and uses the method getVat()
     * to add everything up.
     * @param saleItems The HashMap containg all items in sale.
     */
    private void calculateTotalVat(HashMap<ItemIdentifier,SaleItem> saleItems){
        saleItems.forEach((k,v) -> {
            this.totalVat += v.getVat();
        });
    }
    /**
     * Returning a readable version of the receipt.
     * @return string version of receipt
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(saleTime.toString()).append("\n");
        sb.append(store).append("\n");
        sb.append(saleInfo).append("\n");
        sb.append(totalVat).append("\n");
        sb.append(amountPaid).append("\t").append(change);

        return sb.toString();
    }
}
