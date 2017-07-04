package com.idempiere.error;

/**
 * @author Ben Parker
 * @created 19/05/17
 * @usage Used instead of RuntimeException as the SalesApp equivalent
 */

public class SalesAppException extends RuntimeException{

    public SalesAppException(String messageToDisplay){
        super(messageToDisplay);
    }

}
