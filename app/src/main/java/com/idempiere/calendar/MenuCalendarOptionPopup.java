package com.idempiere.calendar;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.iDempiere.R;

/**
 * @author BenParker
 * @created 5/7/17
 * @usage This class will hold logic for creating actions on
 * the users schedule, when a date is long pressed on the
 * main menu calendar
 */
public class MenuCalendarOptionPopup {

    Context mainMenu;
    AppCompatActivity mainMenuAct;

    public MenuCalendarOptionPopup(Context mainMenu, AppCompatActivity mainMenuAct ){
        this.mainMenu = mainMenu;
        this.mainMenuAct = mainMenuAct;
    }


    public void initialisePopup(){
        Log.v("InitialisePopup called", "Starting method");
        AlertDialog.Builder builder = new AlertDialog.Builder(mainMenu);
        builder.setMessage("Which action would you like to perform?")
                .setTitle("Calendar Popup");
        builder.setPositiveButton("Add Activity", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

              AddCalendarActionPopup addActionPopup = new AddCalendarActionPopup();
                addActionPopup.setActivity(mainMenuAct);
                addActionPopup.setContext(mainMenu);
                addActionPopup.initialisePopup();
            }
        });
        builder.setNeutralButton("View Schedule", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
        dialog.getWindow().setLayout(1000, 400);
    }



}
