package com.idempiere.listeners;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.design.widget.CoordinatorLayout;
import android.view.View;
import android.widget.TextView;

import com.iDempiere.R;
import com.idempiere.database.DBQuery;
import com.idempiere.error.SalesAppException;
import com.idempiere.model.X_Action;
import com.idempiere.utils.ActionScheduleUtils;
import com.idempiere.utils.DisplayUtils;

import java.util.HashSet;

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


    private void handleButtonClicks(){
        if (coorLayout == null){
            throw new SalesAppException("You must set a Coordinator Layout to add views to first");
        }
        if (v.getId() == R.id.schedAllActionsBut) {
            clearAndRePopulateTextViews(ActionScheduleUtils.getAllActions());
        }
        else if (v.getId() == R.id.schedTodaysActionBut) {
            clearAndRePopulateTextViews(ActionScheduleUtils.getTodaysActions());
        }
        else if (v.getId() == R.id.schedTodaysRouteBut) {
            clearAndRePopulateTextViews(ActionScheduleUtils.getTodaysRoutedActions());
        }
        /** Must be last in the list **/
        else if (v instanceof TextView){
            int x_Action_ID = v.getId();
            DBQuery getActionDetails = new DBQuery();
            getActionDetails.setSql(" SELECT * FROM X_Action LEFT JOIN X_Business Partner ");
        }
    }


    private void clearAndRePopulateTextViews(HashSet<X_Action> actions){
        ActionScheduleUtils.clearCoordinatorLayoutOfTextView(coorLayout);
        topMarginCounter = 200;
        for (X_Action action : actions){
            coorLayout.addView(createTextView(action));
        }
    }


    public void setCoorLayout(CoordinatorLayout layout){
        this.coorLayout = layout;
    }


    private TextView createTextView(X_Action action){
        final TextView textView = new TextView(context);
        textView.setLayoutParams(createLayoutParams());
        textView.setBackground(getDrawableBorder());
        textView.setOnClickListener(this);
        textView.setId(action.getX_Action_ID());
        textView.setVisibility(View.VISIBLE);
        textView.setText(String.valueOf(action.getC_BPartner_ID()));
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

}
