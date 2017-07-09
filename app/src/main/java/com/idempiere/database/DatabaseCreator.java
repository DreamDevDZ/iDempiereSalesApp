package com.idempiere.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.idempiere.model.X_Action;

/**
 * Created by ben on 21/05/17.
 */

public class DatabaseCreator extends SQLiteOpenHelper  {

    private StringBuffer databaseCreation = new StringBuffer();
    private static final String SQLITE_DATABASE_NAME = "SalesApp_Database";


    public DatabaseCreator(Context context){
        super(context, SQLITE_DATABASE_NAME, null, 3);
    }

    public static StringBuffer generateDBCreationQuery() {
        StringBuffer createDB = new StringBuffer();
        createDB.append(X_Action.tableCreationSQL);
        return createDB;
    }

    public static StringBuffer generateDBDeletionQuery(){
        StringBuffer deleteDB = new StringBuffer();
        deleteDB.append(X_Action.tableDeletionSQL);
        return deleteDB;
    }


    /** Called on the initial install of the app **/
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DatabaseCreator.generateDBCreationQuery().toString());
        Log.v("DatabaseCreation", "DatabaseHelper created without errors" );
    }

    /** Called every time the app is called if database is a new version **/
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.v("DatabaseUpgrade", "DatabaseHelper upgraded - Version : " + newVersion);
        db.execSQL(DatabaseCreator.generateDBDeletionQuery().toString());
        onCreate(db);
    }
}
