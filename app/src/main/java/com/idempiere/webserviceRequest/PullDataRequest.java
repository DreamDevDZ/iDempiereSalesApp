package com.idempiere.webserviceRequest;


/**
 * @author Ben Parker
 * @created 8/7/17
 * @usage Method used to pull all query information from the system
 */
public class PullDataRequest {

    private WebServiceRequest wsr;
    private static String viewName;

    public PullDataRequest(String viewName){
        this.viewName = viewName;
    }

    /** The method called to perform the pull operation **/
    public void performQuery(){

    }


}
