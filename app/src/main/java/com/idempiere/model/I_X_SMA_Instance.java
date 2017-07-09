package com.idempiere.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by ben on 08/07/17.
 */

public interface I_X_SMA_Instance {

    static final String Table_Name = "SMA_Instance";
    static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";
    int getAD_Client_ID();

    static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";
    void setAD_Org_ID (int AD_Org_ID);
    int getAD_Org_ID();

    static final String COLUMNNAME_AD_User_ID = "AD_User_ID";
    void setAD_User_ID (int AD_User_ID);
    int getAD_User_ID();

    public static final String COLUMNNAME_Created = "Created";
    public Timestamp getCreated();

    public static final String COLUMNNAME_CreatedBy = "CreatedBy";
    public int getCreatedBy();

    public static final String COLUMNNAME_IsActive = "IsActive";
    public void setIsActive (boolean IsActive);
    public boolean isActive();

    public static final String COLUMNNAME_IMEI = "IMEI";
    public void setIMEI (String IMEI);
    public String getIMEI();

    static final String COLUMNNAME_SMA_Application_ID = "SMA_Application_ID";
    void setSMA_Application_ID (int SMA_Application_ID);
    int getSMA_Application_ID();

    static final String COLUMNNAME_Updated = "Updated";
    Timestamp getUpdated();

    static final String COLUMNNAME_UpdatedBy = "UpdatedBy";
    int getUpdatedBy();

    static final String COLUMNNAME_SMA_Instance_ID = "SMA_Instance_ID";
    void setSMA_Instance_ID (int SMA_Instance_ID);
    int getSMA_Instance_ID();

    static final String COLUMNNAME_SMA_Instance_UU = "SMA_Instance_UU";
    void setSMA_Instance_UU (String SMA_Instance_UU);
    String getSMA_Instance_UU();

    /**static String tableCreationSQL = "CREATE TABLE " + Table_Name + " ( " + COLUMNNAME_X_Action_ID + " "
            + " INTEGER PRIMARY KEY, " + COLUMNNAME_AD_Org_ID + " INTEGER, " + COLUMNNAME_AD_User_ID + " INTEGER ); " ;
    **/
    static String tableDeletionSQL = "DROP TABLE IF EXISTS " + Table_Name;
}
