package com.idempiere.model;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * @author Ben Parker
 * @created 21/5/17
 * @usage Used as the Interface for the X_Action model
 * Specifies the column names and getter/setter methods
 */
public interface I_X_Action {
        static final String Table_Name = "X_Action";
        static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";
        int getAD_Client_ID();



        static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";
        void setAD_Org_ID (int AD_Org_ID);
        int getAD_Org_ID();

        static final String COLUMNNAME_AD_User_ID = "AD_User_ID";
        void setAD_User_ID (int AD_User_ID);
        int getAD_User_ID();

        public static final String COLUMNNAME_AD_UserMail_ID = "AD_UserMail_ID";
        public void setAD_UserMail_ID (int AD_UserMail_ID);
        public int getAD_UserMail_ID();

        public static final String COLUMNNAME_C_BPartner_ID = "C_BPartner_ID";
        public void setC_BPartner_ID (int C_BPartner_ID);
        public int getC_BPartner_ID();

        public static final String COLUMNNAME_Comments = "Comments";
        public void setComments (String Comments);
        public String getComments();

        public static final String COLUMNNAME_ContactActivityType = "ContactActivityType";
        public void setContactActivityType (String ContactActivityType);
        public String getContactActivityType();

        public static final String COLUMNNAME_Created = "Created";
        public Timestamp getCreated();

        public static final String COLUMNNAME_CreatedBy = "CreatedBy";
        public int getCreatedBy();

        public static final String COLUMNNAME_DateActivityComplete = "DateActivityComplete";
        public void setDateActivityComplete (Timestamp DateActivityComplete);
        public Timestamp getDateActivityComplete();

        public static final String COLUMNNAME_Description = "Description";
        public void setDescription (String Description);
        public String getDescription();

        public static final String COLUMNNAME_Duration = "Duration";
        public void setDuration (BigDecimal Duration);
        public BigDecimal getDuration();

        public static final String COLUMNNAME_EndDate = "EndDate";
        public void setEndDate (Timestamp EndDate);
        public Timestamp getEndDate();

        public static final String COLUMNNAME_IsActive = "IsActive";
        public void setIsActive (boolean IsActive);
        public boolean isActive();

        public static final String COLUMNNAME_IsComplete = "IsComplete";
        public void setIsComplete (boolean IsComplete);
        public boolean isComplete();

        public static final String COLUMNNAME_ISObjectiveSuccess = "ISObjectiveSuccess";
        public void setISObjectiveSuccess (boolean ISObjectiveSuccess);
        public boolean isObjectiveSuccess();

        static final String COLUMNNAME_IsProcessGenerated = "IsProcessGenerated";
        void setIsProcessGenerated (boolean IsProcessGenerated);
        boolean isProcessGenerated();

        static final String COLUMNNAME_Result = "Result";
        void setResult (String Result);
        String getResult();

        static final String COLUMNNAME_SalesRep_ID = "SalesRep_ID";
        void setSalesRep_ID (int SalesRep_ID);
        int getSalesRep_ID();

        static final String COLUMNNAME_StartDate = "StartDate";
        void setStartDate (Timestamp StartDate);
        Timestamp getStartDate();

        static final String COLUMNNAME_Updated = "Updated";
        Timestamp getUpdated();

        static final String COLUMNNAME_UpdatedBy = "UpdatedBy";
        int getUpdatedBy();

        static final String COLUMNNAME_X_Action_ID = "X_Action_ID";
        void setX_Action_ID (int X_Action_ID);
        int getX_Action_ID();

        static final String COLUMNNAME_X_Action_UU = "X_Action_UU";
        void setX_Action_UU (String X_Action_UU);
        String getX_Action_UU();

        /** TODO - Update tableCreationSQL to include all columns **/
        static String tableCreationSQL = "CREATE TABLE " + Table_Name + " ( "
                + COLUMNNAME_X_Action_ID + " INTEGER PRIMARY KEY, "
                + COLUMNNAME_AD_Client_ID + " INTEGER, "
                + COLUMNNAME_AD_Org_ID + " INTEGER, "
                + COLUMNNAME_AD_User_ID + " INTEGER, "
                + COLUMNNAME_C_BPartner_ID + " INTEGER, "
                + COLUMNNAME_Description + " VARCHAR(500), "
                + COLUMNNAME_StartDate + " TIMESTAMP, "
                + COLUMNNAME_Created + " TIMESTAMP, "
                + COLUMNNAME_CreatedBy + " INTEGER, "
                + COLUMNNAME_Updated + " TIMESTAMP, "
                + COLUMNNAME_UpdatedBy + " INTEGER, "
                + COLUMNNAME_IsActive + " BOOLEAN "
                + "); " ;

        static String tableDeletionSQL = "DROP TABLE IF EXISTS " + Table_Name;
}
