package com.idempiere.listeners;

import android.content.Intent;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.iDempiere.R;

/**
 * Created by benparker on 04/07/17.
 */

public class MainMenuClickListener extends OnClickListeners {

    /** All clicks for main_Menu activity **/
    public void handleClicks(View v){
        handleButtonClicks(v);
    }


    private void handleButtonClicks(View v){
        if (v.getId() == R.id.actionScheduleBut) {

        }
        else if (v.getId() == R.id.todaysActionsBut) {

        }
        else if (v.getId() == R.id.routePlanBut) {

        }
        else if (v.getId() == R.id.custInfoBut) {

        }
        else if (v.getId() == R.id.requestBut) {

        }
    }

}
