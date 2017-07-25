package com.idempiere.utils;

import android.database.Cursor;
import android.support.design.widget.CoordinatorLayout;
import android.widget.TextView;

import com.idempiere.database.DBQuery;
import com.idempiere.model.I_X_Action;
import com.idempiere.model.I_X_LoginDetail;
import com.idempiere.model.X_Action;

import java.util.HashSet;

/**
 * Created by ben on 24/07/17.
 */

public class ActionScheduleUtils {

    public static HashSet<X_Action> getTodaysActions(){
        HashSet<X_Action> todaysActions = new HashSet<>();
        DBQuery query = new DBQuery("SELECT * FROM X_Action ");
        Cursor response = query.executeQuery();
        while (response.moveToNext()){
            X_Action action = new X_Action();
            action.setC_BPartner_ID(response.getInt(response.getColumnIndex(I_X_Action.COLUMNNAME_C_BPartner_ID)));
            action.setX_Action_ID(response.getInt(response.getColumnIndex(I_X_Action.COLUMNNAME_X_Action_ID)));
            todaysActions.add(action);
        }
        return todaysActions;
    }

    public static HashSet<X_Action> getTodaysRoutedActions(){
        HashSet<X_Action> todaysActions = new HashSet<>();
        DBQuery query = new DBQuery("SELECT * FROM X_Action ");
        Cursor response = query.executeQuery();
        while (response.moveToNext()){
            X_Action action = new X_Action();
            action.setC_BPartner_ID(response.getInt(response.getColumnIndex(I_X_LoginDetail.ColumnName_C_BPartner_ID)));
            todaysActions.add(action);
        }
        return todaysActions;
    }

    public static HashSet<X_Action> getAllActions(){
        HashSet<X_Action> todaysActions = new HashSet<>();
        DBQuery query = new DBQuery("SELECT * FROM X_Action ");
        Cursor response = query.executeQuery();
        while (response.moveToNext()){
            X_Action action = new X_Action();
            action.setC_BPartner_ID(response.getInt(response.getColumnIndex(I_X_LoginDetail.ColumnName_C_BPartner_ID)));
            todaysActions.add(action);
        }
        return todaysActions;
    }


    public static void clearCoordinatorLayoutOfTextView(CoordinatorLayout layout) {
        for (int i = 0; i < layout.getChildCount(); i++){
            if (layout.getChildAt(i) instanceof TextView && layout.getChildAt(i).getId() > 1000000 &&
                    layout.getChildAt(i).getId() < 9999999 ) {
                layout.removeViewAt(i);
            }
        }
    }


}
