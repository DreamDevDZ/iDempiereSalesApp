package com.idempiere.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.iDempiere.R;
import com.idempiere.database.Database;
import com.idempiere.listeners.MainMenuClickListener;
import com.idempiere.listeners.OnClickListeners;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by benparker on 03/07/17.
 */

public class MainMenu extends AppCompatActivity {

    private TextView greeting;
    private OnClickListeners mainMenuClick = new MainMenuClickListener();
    private Button actionScheduleBut;
    private Button todayScheduleBut;
    private Button customerInfoBut;
    private Button routePlanBut;
    private Button requestBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);
        greeting = (TextView)findViewById(R.id.greetingText);
        String userName = getIntent().getStringExtra("Username");
        createGreetingMessage(userName);
        addActionListeners();
    }


    private void createGreetingMessage(String username){
        try {
            Calendar nowTime = Calendar.getInstance();
            nowTime.setTime(new Timestamp(System.currentTimeMillis()));
            Calendar afterNoonCal = Calendar.getInstance();

            String afterNoonStart = "12:00:01";
            Date afterNoonDate = new SimpleDateFormat("HH:mm:ss").parse(afterNoonStart);
            afterNoonCal.setTime(afterNoonDate);

            if (username != null) {
                String name = username.split(" ")[0];
                if (nowTime.getTime().before(afterNoonCal.getTime())) {
                    greeting.setText("Good Morning " + name);
                }
                else {
                    greeting.setText("Good Afternoon " + name);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    private void addActionListeners() {
        actionScheduleBut = (Button)findViewById(R.id.actionScheduleBut);
        actionScheduleBut.setOnClickListener(mainMenuClick);
        todayScheduleBut = (Button)findViewById(R.id.todaysActionsBut);
        todayScheduleBut.setOnClickListener(mainMenuClick);
        customerInfoBut = (Button)findViewById(R.id.custInfoBut);
        customerInfoBut.setOnClickListener(mainMenuClick);
        routePlanBut = (Button)findViewById(R.id.routePlanBut);
        routePlanBut.setOnClickListener(mainMenuClick);
        requestBut = (Button)findViewById(R.id.requestBut);
        requestBut.setOnClickListener(mainMenuClick);
    }

}

