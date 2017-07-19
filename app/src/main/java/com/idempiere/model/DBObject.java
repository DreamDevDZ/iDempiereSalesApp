package com.idempiere.model;

import android.content.ContentValues;
import android.database.Cursor;

import com.idempiere.database.DBQuery;
import com.idempiere.utils.DBUtils;

import org.json.JSONObject;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;


/**
 * Created by benparker on 10/07/17.
 */

public abstract class DBObject implements I_Saveable, Serializable {


    private final static int AD_Client_ID = 1000000;
    private final static int AD_Org_ID = 1000000;
    private final static String isActive = "Y";


    public ContentValues getMandatoryContentValues(){
        Timestamp created = new Timestamp(System.currentTimeMillis());
        int ad_User_ID = DBUtils.getLoggedInUser().getAd_User_ID();
        ContentValues values = new ContentValues();
            values.put(I_Saveable.ColumnName_AD_CLIENT_ID, AD_Client_ID);
            values.put(I_Saveable.ColumnName_AD_ORG_ID, AD_Org_ID);
            values.put(I_Saveable.ColumnName_CREATED, String.valueOf(created));
            values.put(I_Saveable.ColumnName_CREATEDBY, ad_User_ID);
            values.put(I_Saveable.ColumnName_UPDATED, String.valueOf(created));
            values.put(I_Saveable.ColumnName_UPDATEDBY, ad_User_ID);
            values.put(I_Saveable.ColumnName_ISACTIVE, isActive);
        return values;
    }


    public abstract void fromJson(JSONObject responseObject);


}
