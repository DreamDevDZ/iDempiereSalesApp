package com.idempiere.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by ben on 21/05/17.
 */

public class X_Action implements I_X_Action {

    private int AD_Client_ID;
    private int AD_UserMail_ID;
    private int AD_Org_ID;
    private int C_BPartner_ID;
    private int X_Action_ID;
    private boolean IsActive;
    private Timestamp created;
    private int createdBy;
    private boolean isComplete;
    private boolean isProcessGenerated;
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
    public void setIsActive(boolean IsActive) {
        this.IsActive = IsActive;
    }

    @Override
    public boolean isActive() {
        return IsActive;
    }

    @Override
    public void setIsComplete(boolean IsComplete) {
        this.isComplete = isComplete;
    }

    @Override
    public boolean isComplete() {
        return isComplete;
    }

    @Override
    public void setISObjectiveSuccess(boolean ISObjectiveSuccess) {

    }

    @Override
    public boolean isObjectiveSuccess() {
        return false;
    }

    @Override
    public void setIsProcessGenerated(boolean IsProcessGenerated) {
        this.isProcessGenerated = IsProcessGenerated;
    }

    @Override
    public boolean isProcessGenerated() {
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

    /** TODO - Need to find out relevance of UU column and decide if needed **/
    @Override
    public void setX_Action_UU(String X_Action_UU) {

    }

    @Override
    public String getX_Action_UU() {
        return null;
    }
}
