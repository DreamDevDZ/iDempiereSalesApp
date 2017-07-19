package com.idempiere.webserviceresponse;

import android.database.Cursor;
import android.util.Base64;
import android.util.Log;

import com.idempiere.database.DBQuery;
import com.idempiere.error.SalesAppException;
import com.idempiere.model.DBObject;
import com.idempiere.model.I_X_ADUser;
import com.idempiere.model.I_X_Action;
import com.idempiere.model.I_X_C_BPartner;
import com.idempiere.model.I_X_C_Invoice;
import com.idempiere.model.X_AD_User;
import com.idempiere.model.X_Action;
import com.idempiere.model.X_C_BPartner;
import com.idempiere.model.X_C_Invoice;
import com.idempiere.webservice.X_RunProcessResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by benparker on 13/07/17.
 */

public class JSONResponseParser {

    private static DBObject modelToCreate;

    public static String parseProcessResponseToString(X_RunProcessResponse response){
        if (response.Summary == null){
            throw new SalesAppException("Process summary is null. Cannot parse ");
        }
        String respons = null;
        byte[] resp = Base64.decode(response.Summary.getBytes(), 0);
        try {
            respons = new String(resp, "UTF-8");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return respons;
    }


    public static void parseProcessResponseToModel(DBObject object, X_RunProcessResponse response){
        if (response.Summary == null){
            throw new SalesAppException("Process summary is null. Cannot parse ");
        }
        JSONObject responseObject = null;
        byte[] resp = Base64.decode(response.Summary.getBytes(), 0);
        try {
            Log.v("Parsed", new String(resp, "UTF-8"));
            responseObject = new JSONObject(new String(resp, "UTF-8"));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        getTypeOfDBObject(object, responseObject);
    }


    private static void getTypeOfDBObject(DBObject object, JSONObject responseObject){
        try {
            String tableName = null;
            if (object instanceof X_Action) {
                tableName = I_X_Action.Table_Name;
                createX_ActionObject(responseObject);
            }
            else if (object instanceof X_AD_User) {
                tableName = I_X_ADUser.Table_Name;
            }
            else if (object instanceof X_C_BPartner) {
                tableName = I_X_C_BPartner.Table_Name;
            }
            else if (object instanceof X_C_Invoice) {
                tableName = I_X_C_Invoice.Table_Name;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    private static void createX_ActionObject(JSONObject responseObject) throws Exception {
        List<JSONObject> allActions = parseJsonData(responseObject, "Actions");
        for (JSONObject action : allActions){
            X_Action actionRecord = new X_Action();
            actionRecord.fromJson(action);
            Log.v("InsertingActionFromJSON", "" + actionRecord.getX_Action_ID() + " Saved ");
        }
    }



    private static List<JSONObject> parseJsonData(JSONObject obj, String pattern) throws JSONException {
        List<JSONObject> listOfModelObjects = new ArrayList<JSONObject>();
        JSONArray modelArray = obj.getJSONArray(pattern);
        for (int i = 0; i < modelArray.length(); ++i) {
            final JSONObject model = modelArray.getJSONObject(i);
            Log.v("X_Action_ID", String.valueOf(model.getInt("x_action_id")));
            listOfModelObjects.add(model);
        }
        return listOfModelObjects;
    }
}
