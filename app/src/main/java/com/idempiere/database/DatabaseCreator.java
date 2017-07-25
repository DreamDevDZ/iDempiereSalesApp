package com.idempiere.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.idempiere.model.I_X_Action;
import com.idempiere.model.I_X_C_BPartner;
import com.idempiere.model.I_X_LoginDetail;

/**
 * Created by ben on 21/05/17.
 */

public class DatabaseCreator extends SQLiteOpenHelper  {

    private StringBuffer databaseCreation = new StringBuffer();
    private static final String SQLITE_DATABASE_NAME = "SalesApp_Database";


    public DatabaseCreator(Context context){
        super(context, SQLITE_DATABASE_NAME, null, 12);
    }

    public static StringBuffer generateDBCreationQuery() {
        StringBuffer createDB = new StringBuffer();
        createDB.append(I_X_LoginDetail.tableCreationSQL);
        createDB.append(I_X_Action.tableCreationSQL);
        Log.v("DatabaseCreation", createDB.toString());
        return createDB;
    }

    public static StringBuffer generateDBDeletionQuery(){
        StringBuffer deleteDB = new StringBuffer();
        deleteDB.append(I_X_LoginDetail.tableDeletionSQL);
        deleteDB.append(I_X_Action.tableDeletionSQL);
        Log.v("DatabaseUpgrade", deleteDB.toString());
        return deleteDB;
    }


    /** Called on the initial install of the app **/
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(I_X_Action.tableCreationSQL);
        db.execSQL(I_X_LoginDetail.tableCreationSQL);
        db.execSQL(I_X_C_BPartner.tableCreationSQL);
        Log.v("DatabaseCreation", "onCreate method called and ended" );
    }

    /** Called every time the app is called if database is a new version **/
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL(generateDBDeletionQuery().toString());
        db.execSQL(I_X_Action.tableDeletionSQL);
        db.execSQL(I_X_LoginDetail.tableDeletionSQL);
        db.execSQL(I_X_C_BPartner.tableDeletionSQL);
        Log.v("DatabaseUpgrade", "DatabaseHelper upgraded - Version : " + newVersion);
        Log.v("onCreateCall", "Calling onCreate method after upgrade ");
        onCreate(db);
    }
}
