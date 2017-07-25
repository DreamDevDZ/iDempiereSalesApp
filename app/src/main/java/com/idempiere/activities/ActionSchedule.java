package com.idempiere.activities;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.iDempiere.R;
import com.idempiere.listeners.ActionScheduleClickListener;

/**
 * Created by benparker on 21/07/17.
 */

public class ActionSchedule extends AppCompatActivity {

    Button allActions;
    Button todaysActions;
    Button todaysRouteActions;
    ActionScheduleClickListener scheduleClickListener = new ActionScheduleClickListener();
    CoordinatorLayout coorLay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actionschedule);
        addActionListeners();
    }


    private void addActionListeners(){
        coorLay = (CoordinatorLayout)findViewById(R.id.actSchedCoorLayout);
        scheduleClickListener.setCoorLayout(coorLay);
        allActions = (Button)findViewById(R.id.schedAllActionsBut);
        allActions.setOnClickListener(scheduleClickListener);
        todaysActions = (Button)findViewById(R.id.schedTodaysActionBut);
        todaysActions.setOnClickListener(scheduleClickListener);
        todaysRouteActions = (Button)findViewById(R.id.schedTodaysRouteBut);
        todaysRouteActions.setOnClickListener(scheduleClickListener);
    }
}
