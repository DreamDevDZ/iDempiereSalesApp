package com.idempiere.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.idempiere.error.SalesAppException;

import java.sql.Connection;

/**
 * @author Ben Parker
 * @created 21/05/17
 * @usage Class used as extension of SQLiteOpenHelper class
 * Handles creation of Database on first run of app and any
 * upgrades needed.
 * Also handles connection's to the database with a maximum of 5
 */
public class Database extends SQLiteOpenHelper {

    private static final int CONNECTION_LIMIT = 5;
    private static volatile int connectionCounter = 0;
    private static final String SQLITE_DATABASE_NAME = "SalesApp_Database";


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DatabaseCreator.generateDBCreationQuery().toString());
        Log.v("DatabaseCreation", "Database created without errors" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DatabaseCreator.generateDBDeletionQuery().toString());
        onCreate(db);
    }

    public Database(Context context){
        super(context, SQLITE_DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }


    /** Only return a new Connection object if the current
     *  connection counter is less than 5
     * @return Connection to the SQLite DB
     */
    public synchronized static Connection getConnection(){
        return createConnection();
    }


    /** Creates a Connection object for the local SQLite Database **/
    private static Connection createConnection() {
        if ((connectionCounter + 1) > CONNECTION_LIMIT){
            throw new SalesAppException("Connection Limit reached : No more connections available ");
        }

        /** TODO - Find out how to connect to local SQLite database **/
        /** First create authenticated connection to local database **/
        Connection conn = null;

        return conn;
    }

}
