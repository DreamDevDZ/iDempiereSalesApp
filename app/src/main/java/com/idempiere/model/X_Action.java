package com.idempiere.model;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.idempiere.database.DBQuery;
import com.idempiere.error.SalesAppException;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.sql.Timestamp;

import static android.R.attr.action;

/**
 * Created by ben on 21/05/17.
 */

public class X_Action extends DBObject implements I_X_Action {

    private int AD_Client_ID;
    private int AD_UserMail_ID;
    private int AD_Org_ID;
    private int C_BPartner_ID;
    private int X_Action_ID;
    private String isActive;
    private Timestamp created;
    private int createdBy;
    private String isComplete;
    private String isProcessGenerated;
    private String result;
    private String description;
    private Timestamp updated;
    private Timestamp startDate;
    private Timestamp endDate;
    private int updatedBy;
    private int AD_User_ID;
    private int salesRep_ID;
    private String contactActivityType;
    private String comments;
    private Timestamp dateActivityComplete;

    @Override
    public int getAD_Client_ID() {
        return AD_Client_ID;
    }

    @Override
    public void setAD_Org_ID(int AD_Org_ID) {
        this.AD_Org_ID = AD_Org_ID;
    }

    @Override
    public int getAD_Org_ID() {
        return AD_Org_ID;
    }

    @Override
    public void setAD_User_ID(int AD_User_ID) {
        this.AD_User_ID = AD_User_ID;
    }

    @Override
    public int getAD_User_ID() {
        return AD_User_ID;
    }

    @Override
    public void setAD_UserMail_ID(int AD_UserMail_ID) {
        this.AD_UserMail_ID = AD_UserMail_ID;
    }

    @Override
    public int getAD_UserMail_ID() {
        return AD_UserMail_ID;
    }

    @Override
    public void setC_BPartner_ID(int C_BPartner_ID) {
        this.C_BPartner_ID = C_BPartner_ID;
    }

    @Override
    public int getC_BPartner_ID() {
        return C_BPartner_ID;
    }

    @Override
    public void setComments(String Comments) {
        this.comments = comments;
    }

    @Override
    public String getComments() {
        return comments;
    }

    @Override
    public void setContactActivityType(String ContactActivityType) {
        this.contactActivityType = ContactActivityType;
    }

    @Override
    public String getContactActivityType() {
        return contactActivityType;
    }

    @Override
    public Timestamp getCreated() {
        return created;
    }

    @Override
    public int getCreatedBy() {
        return createdBy;
    }

    @Override
    public void setDateActivityComplete(Timestamp DateActivityComplete) {
        this.dateActivityComplete = DateActivityComplete;
    }

    @Override
    public Timestamp getDateActivityComplete() {
        return dateActivityComplete;
    }

    @Override
    public void setDescription(String Description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDuration(BigDecimal Duration) { }

    @Override
    public BigDecimal getDuration() {
        return null;
    }

    @Override
    public void setEndDate(Timestamp EndDate) {
        this.endDate = endDate;
    }

    @Override
    public Timestamp getEndDate() {
        return endDate;
    }

    @Override
    public void setIsActive(String IsActive) {
        this.isActive = IsActive;
    }

    @Override
    public String isActive() {
        return isActive;
    }

    @Override
    public void setIsComplete(String IsComplete) {
        this.isComplete = isComplete;
    }

    @Override
    public String isComplete() {
        return isComplete;
    }

    @Override
    public void setIsProcessGenerated(String IsProcessGenerated) {
        this.isProcessGenerated = IsProcessGenerated;
    }

    @Override
    public String isProcessGenerated() {
        return isProcessGenerated;
    }

    @Override
    public void setResult(String Result) {
        this.result = Result;
    }

    @Override
    public String getResult() {
        return result;
    }

    @Override
    public void setSalesRep_ID(int SalesRep_ID) {
        this.salesRep_ID = SalesRep_ID;
    }

    @Override
    public int getSalesRep_ID() {
        return salesRep_ID;
    }

    @Override
    public void setStartDate(Timestamp StartDate) {
        this.startDate = startDate;
    }

    @Override
    public Timestamp getStartDate() {
        return startDate;
    }

    @Override
    public Timestamp getUpdated() {
        return updated;
    }

    @Override
    public int getUpdatedBy() {
        return updatedBy;
    }

    @Override
    public void setX_Action_ID(int X_Action_ID) {
        this.X_Action_ID = X_Action_ID;
    }

    @Override
    public int getX_Action_ID() {
        return X_Action_ID;
    }

    @Override
    public void setX_Action_UU(String X_Action_UU) { }

    @Override
    public String getX_Action_UU() {
        return null;
    }

    /** Insert a record into the local database table **/
    @Override
    public long save() throws Exception{
        ContentValues contentValues = getMandatoryContentValues();
        contentValues.put(COLUMNNAME_AD_User_ID, AD_User_ID);
        contentValues.put(COLUMNNAME_C_BPartner_ID, C_BPartner_ID);
        contentValues.put(COLUMNNAME_Comments, comments);
        contentValues.put(COLUMNNAME_ContactActivityType, contactActivityType);
        contentValues.put(COLUMNNAME_Description, description);
        contentValues.put(COLUMNNAME_DateActivityComplete, String.valueOf(dateActivityComplete));
        contentValues.put(COLUMNNAME_IsComplete, isComplete);
        contentValues.put(COLUMNNAME_IsProcessGenerated, isProcessGenerated);
        contentValues.put(COLUMNNAME_SalesRep_ID, salesRep_ID);
        contentValues.put(COLUMNNAME_Result, result);
        contentValues.put(COLUMNNAME_StartDate, String.valueOf(startDate));
        contentValues.put(COLUMNNAME_X_Action_ID, X_Action_ID);
        return DBQuery.insertValues(I_X_Action.Table_Name, contentValues);
    }


    @Override
    public void fromJson(JSONObject responseObject) {
        Log.v("fromJsonMethod", "Starting fromJson method");
        try {
            setAD_Org_ID(responseObject.getInt(I_X_Action.COLUMNNAME_AD_Org_ID.toLowerCase()));
            if (responseObject.getInt(I_X_Action.COLUMNNAME_X_Action_ID.toLowerCase()) != 0) {
                Log.v("FromJsonAction", String.valueOf(responseObject.getInt(I_X_Action.COLUMNNAME_X_Action_ID.toLowerCase())));
                setX_Action_ID(responseObject.getInt(I_X_Action.COLUMNNAME_X_Action_ID.toLowerCase()));
            }
            else {
                throw new SalesAppException("X_Action_ID Cannot be null ");
            }
            setC_BPartner_ID(responseObject.getInt(I_X_Action.COLUMNNAME_C_BPartner_ID.toLowerCase()));
            if (responseObject.getString(I_X_Action.COLUMNNAME_Comments.toLowerCase()) != "0") {
                setComments(responseObject.getString(I_X_Action.COLUMNNAME_Comments.toLowerCase()));
            }
            setContactActivityType(responseObject.getString(I_X_Action.COLUMNNAME_ContactActivityType.toLowerCase()));
            setDescription(responseObject.getString(I_X_Action.COLUMNNAME_Description.toLowerCase()));
            setIsComplete(String.valueOf(responseObject.getString(I_X_Action.COLUMNNAME_IsComplete.toLowerCase())));
            setIsProcessGenerated(responseObject.getString(I_X_Action.COLUMNNAME_IsProcessGenerated.toLowerCase()));
            if (responseObject.getString(I_X_Action.COLUMNNAME_Result.toLowerCase()) != "0"){
                setResult(responseObject.getString(I_X_Action.COLUMNNAME_Result.toLowerCase()));
            }
            if (responseObject.getInt(I_X_Action.COLUMNNAME_SalesRep_ID.toLowerCase()) != 0){
                setSalesRep_ID(responseObject.getInt(I_X_Action.COLUMNNAME_SalesRep_ID.toLowerCase()));
            }
            if (responseObject.getInt(I_X_Action.COLUMNNAME_AD_User_ID.toLowerCase()) != 0){
                setAD_User_ID(responseObject.getInt(I_X_Action.COLUMNNAME_AD_User_ID.toLowerCase()));
            }
            save();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
