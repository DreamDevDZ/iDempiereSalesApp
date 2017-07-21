package com.idempiere.utils;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;

/**
 * Created by benparker on 21/07/17.
 */

public class DisplayUtils {


    public static int getPixelFromDPS(int dps, View v){
        Resources r = v.getResources();
        int px = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dps, r.getDisplayMetrics());
        return px;
    }
}
