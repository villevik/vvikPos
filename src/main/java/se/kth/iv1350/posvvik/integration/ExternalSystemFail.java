package se.kth.iv1350.posvvik.integration;

/**
 *  Exception for when creating an external system fails
 * 
 */
public class ExternalSystemFail extends Exception{
    public ExternalSystemFail(String msg){
        super(msg);
    }
}
