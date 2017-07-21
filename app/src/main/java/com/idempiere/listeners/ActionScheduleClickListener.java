package com.idempiere.listeners;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.design.widget.CoordinatorLayout;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.iDempiere.R;
import com.idempiere.activities.ActionSchedule;
import com.idempiere.error.SalesAppException;
import com.idempiere.utils.DisplayUtils;

/**
 * Created by benparker on 21/07/17.
 */

public class ActionScheduleClickListener extends OnClickListeners {

    /** The layout to add views to **/
    private CoordinatorLayout coorLayout;
    private Context context;
    private View v;

    private int topMarginCounter = 200;

    @Override
    public void handleClicks(View v) {
        context = v.getContext();
        this.v = v;
        handleButtonClicks();
    }

    public void setCoorLayout(CoordinatorLayout layout){
        this.coorLayout = layout;
    }


    private TextView createTextView(){
        Log.v("CreateTextView", "Another view created ");
        final TextView textView = new TextView(context);
        textView.setLayoutParams(createLayoutParams());
        textView.setBackground(getDrawableBorder());
        textView.set
        textView.setOnClickListener(this);
        textView.setText("Hello my name Ben how are you doing? Is this enough to take up that many pixels lalalalalalalala ");
        return textView;
    }


    private Drawable getDrawableBorder(){
        Resources res = v.getResources();
        Drawable drawable = res.getDrawable(R.drawable.border);
        return drawable;
    }


    private CoordinatorLayout.LayoutParams createLayoutParams(){
        int pxFromTop = DisplayUtils.getPixelFromDPS(150, v);
        topMarginCounter+= pxFromTop;
        int scrollViewPXWidth = DisplayUtils.getPixelFromDPS(520, v);
        int scrollViewPXHeight = DisplayUtils.getPixelFromDPS(150, v);
        final CoordinatorLayout.LayoutParams lparams = new CoordinatorLayout.LayoutParams(scrollViewPXWidth, scrollViewPXHeight);
        lparams.setMargins(0, topMarginCounter, 0, 0);
        return lparams;
    }


    private void handleButtonClicks(){
        if (coorLayout == null){
            throw new SalesAppException("You must set a Coordinator Layout to add views to first");
        }
        if (v.getId() == R.id.schedAllActionsBut) {
            Log.v("Schedul All Act", "Button Clicked");
            for (int i = 0; i < 10 ; i++){
                coorLayout.addView(createTextView());
            }
        }
        else if (v.getId() == R.id.schedTodaysActionBut) {

        }
        else if (v.getId() == R.id.schedTodaysRouteBut) {

        }
        else if (v instanceof Button){

        }
    }

}
