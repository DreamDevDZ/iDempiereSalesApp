package com.idempiere.utils;

import android.os.AsyncTask;

import com.idempiere.error.SalesAppException;
import com.idempiere.model.I_X_ADUser;
import com.idempiere.model.I_X_LoginDetail;
import com.idempiere.model.X_Login_Detail;
import com.idempiere.webservice.X_ADLoginRequest;
import com.idempiere.webservice.X_DataField;
import com.idempiere.webservice.X_DataRow;
import com.idempiere.webservice.X_DataSet;
import com.idempiere.webservice.X_Enums;
import com.idempiere.webservice.X_ModelCRUD;
import com.idempiere.webservice.X_WindowTabData;
import com.idempiere.webserviceRequest.I_WebServiceConstants;
import com.idempiere.webserviceRequest.WebServiceRequest;

/**
 * Created by benparker on 10/07/17.
 */


/** Defining new methods in this Utils class to create a web service
 * request can use :
 * createModelCRUD()
 * createUserDetailsParameters()
 * createLoginRequest();
 */
public class WSRUtils {

    private static X_ModelCRUD modelCRUD;

    private static X_DataRow parameters;
    private static X_ADLoginRequest loginRequest;


    public static X_ModelCRUD createModelCRUD(String serviceType, String tableName, X_Enums.ModelCRUD_Action action){
        modelCRUD = new X_ModelCRUD();
        modelCRUD.setServiceType(serviceType);
        if (tableName != null)
             modelCRUD.setTableName(tableName);
        if (action != null)
            modelCRUD.setAction(action);

        return modelCRUD;
    }

    public static X_ADLoginRequest createLoginRequest(String user, String pass){
        if (user == null || pass == null) {
            X_Login_Detail details = DBUtils.getLoggedInUser();
            if (details.getUsername() == null){
                throw new SalesAppException(" No Username/password passed to WSRUtils AND No Login_Detail record saved for current logged in user ");
            }
            user = details.getUsername();
            pass = details.getPassword();
        }
        X_ADLoginRequest aDLoginRequest = new X_ADLoginRequest(user, null, pass , "192", 1000000, 1000027, 1000000,
                1000000, 0);
        return aDLoginRequest;
    }


    public void setParameters(X_DataRow parameters) {
        this.parameters = parameters;
    }

}
