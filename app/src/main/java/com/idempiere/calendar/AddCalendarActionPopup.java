package com.idempiere.calendar;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;

/**
 * Created by benparker on 05/07/17.
 */

public class AddCalendarActionPopup {



    Context mainMenu;

    public AddCalendarActionPopup(Context mainMenu){
        this.mainMenu = mainMenu;
    }


    public void initialisePopup(){
        Log.v("InitialisePopup called", "Starting method");
        AlertDialog.Builder builder = new AlertDialog.Builder(mainMenu);
        builder.setMessage("Please fill out the details below before adding")
                .setTitle("Add Activity");
        builder.setPositiveButton("Add Activity", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button
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
