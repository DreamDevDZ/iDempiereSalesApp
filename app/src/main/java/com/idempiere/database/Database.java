package com.idempiere.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.idempiere.error.SalesAppException;

/**
 * Created by ben on 09/07/17.
 */

public class Database {

    private static DatabaseCreator databaseCreator;
    private static Database database;
    private static final Object LOCK = new Object();

    private Database() {} ;

    public static Database getInstance(){
        synchronized (LOCK) {
            if (databaseCreator == null) {
                throw new SalesAppException(" Database does not yet exist. Create Database first. ");
            }
        }
        return database;
    }


    public static void createOrUpgradeDatabase(Context context){
        Log.v("DatabaseCreation", "createDatabase method called");
        databaseCreator = new DatabaseCreator(context);
        Log.v("DatabaseCreation", "Database created without errors");
    }

    public static SQLiteDatabase getQueryableDatabase(){
        return databaseCreator.getReadableDatabase();
    }

    public static SQLiteDatabase getUpdateableDatabase(){
        return databaseCreator.getReadableDatabase();
    }
}
