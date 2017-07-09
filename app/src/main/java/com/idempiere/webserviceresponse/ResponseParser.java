package com.idempiere.webserviceresponse;

import android.util.Log;

import com.idempiere.error.SalesAppException;
import com.idempiere.webservice.X_StandardResponse;
import com.idempiere.webservice.X_WindowTabData;

import org.ksoap2.serialization.AttributeContainer;

/**
 * @author Ben Parker
 * @created 22/5/17
 * @usage The super class of the Parser classes
 * Provides main functionality methods for parsing
 * responses from the SOAP web-service
 */
public class ResponseParser {

    protected static X_WindowTabData windowTabData;
    protected static X_StandardResponse standardResponse;

    public ResponseParser(AttributeContainer response){
        getResponseType(response);
        validateResponseData();
    }


    public void getResponseType(AttributeContainer response ){
        if (response instanceof X_WindowTabData){
            windowTabData = (X_WindowTabData) response;
        }
        else if (response instanceof X_StandardResponse){
            standardResponse = (X_StandardResponse) response;
        }
    }

    public void validateResponseData(){
        if (windowTabData.Error != null) {
            Log.v("Error", windowTabData.Error);
            throw new SalesAppException("Error : " + windowTabData.Error);
        }
        if (windowTabData.DataSet == null) {
            throw new SalesAppException("No Data returned from query ");
        }
    }

}
