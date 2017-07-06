package com.idempiere.calendar;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;

import com.iDempiere.R;
import com.idempiere.error.SalesAppException;


/**
 * @author BenParker
 * @created 6.7.17
 * @usage Class provides implementation for creating the
 * AlertDialog when 'Add Action' button is clicked on
 * MenuCalendarOptionPopup
 */
public class AddCalendarActionPopup extends DialogFragment {
    Context mainMenu;
    AppCompatActivity mainMenuAct;

    public void setContext(Context cont){
        this.mainMenu = cont;
    }

    public void setActivity(AppCompatActivity mainMenu) { this.mainMenuAct = mainMenu; }


    public void initialisePopup(){
        if (mainMenu == null){
            throw new SalesAppException("Activity context must be set before initialising pop-up ");
        }
        if (mainMenuAct == null){
            throw new SalesAppException("Calling Activity must be set before initialising pop-up ");
        }
        Log.v("InitAddCalendarActPopup", "Starting init");
        AlertDialog.Builder builder = new AlertDialog.Builder(mainMenu);
        LayoutInflater inflater = mainMenuAct.getLayoutInflater();
            builder.setView(inflater.inflate(R.layout.calendar_addactivity, null));
            builder.setTitle("Calendar Popup");
            builder.setPositiveButton("Add Activity", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                // Add the action to the database
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
                }
            });
        AlertDialog dialog = builder.create();
        dialog.show();

    }




}
