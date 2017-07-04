package com.idempiere.database;

import com.idempiere.model.X_Action;

/**
 * Created by ben on 21/05/17.
 */

public class DatabaseCreator {

      /**
     * Creates a StringBuffer object containing an SQL query for
     * creating the database on the first run if it doesn't exist
     * @return StringBuffer createDB - containing query
     */
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
}
