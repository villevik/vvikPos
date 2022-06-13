package se.kth.iv1350.posvvik.controller;

/**
 *  General exception for when an operation fails
 * 
 */
public class OperationFailedException extends Exception{
    public OperationFailedException(String msg, Exception cause){
        super(msg,cause);
    }
}
