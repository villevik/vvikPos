package se.kth.iv1350.posvvik.integration;

/**
 *  Exception for when given itemidentifier does not exist
 * 
 */
public class NoSuchItemIdentifierException extends Exception{
    public NoSuchItemIdentifierException(String errorMessage){
        super(errorMessage);
    }
}
