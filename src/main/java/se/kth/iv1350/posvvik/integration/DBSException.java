package se.kth.iv1350.posvvik.integration;

/**
 *  Exception for when call to database server does not work
 * 
 */
public class DBSException extends Exception{
    /**
     * 
     * @param msg 
     */
    public DBSException(String msg){
        super(msg);
    }
}
