package com.idempiere.listeners;

import android.view.View;

import com.iDempiere.R;

/**
 * Created by benparker on 04/07/17.
 */

public abstract class OnClickListeners implements View.OnClickListener {


    @Override
    public void onClick(View v) {
        handleClicks(v);
    }

    /** All sub types must implement this method and provide their own implementation **/
    public abstract void handleClicks(View v);
}