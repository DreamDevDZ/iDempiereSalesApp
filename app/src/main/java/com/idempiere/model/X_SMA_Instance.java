package com.idempiere.model;

import java.sql.Timestamp;

/**
 * @author Ben Parker
 * @created 8/7/17
 * @usage The model class for SMA_Instance table
 */
public class X_SMA_Instance implements I_X_SMA_Instance{

    private int SMA_Instance_ID;
    private int SMA_Application_ID;
    private int AD_Org_ID;
    private String SMA_Instance_UU;
    private int AD_User_ID;
    private int AD_Client_ID;
    private Timestamp created;
    private int createdBy;
    private Timestamp updated;
    private int updatedBy;
    private boolean isActive;
    private String IMEI;


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
    public Timestamp getCreated() {
        return created;
    }

    @Override
    public int getCreatedBy() {
        return createdBy;
    }

    @Override
    public void setIsActive(boolean IsActive) {
        this.isActive = isActive;
    }

    @Override
    public boolean isActive() {
        return isActive;
    }

    @Override
    public void setIMEI(String IMEI) {
        this.IMEI = IMEI;
    }

    @Override
    public String getIMEI() {
        return IMEI;
    }

    @Override
    public void setSMA_Application_ID(int SMA_Application_ID) {
        this.SMA_Application_ID = SMA_Application_ID;
    }

    @Override
    public int getSMA_Application_ID() {
        return SMA_Application_ID;
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
    public int getSMA_Instance_ID() {
        return SMA_Instance_ID;
    }

    @Override
    public void setSMA_Instance_ID(int SMA_Instance_ID){
        this.SMA_Instance_ID = SMA_Instance_ID;
    }

    @Override
    public String getSMA_Instance_UU() {
        return SMA_Instance_UU;
    }

    @Override
    public void setSMA_Instance_UU(String SMA_Instance_UU) {
        this.SMA_Instance_UU = SMA_Instance_UU;
    }
}
