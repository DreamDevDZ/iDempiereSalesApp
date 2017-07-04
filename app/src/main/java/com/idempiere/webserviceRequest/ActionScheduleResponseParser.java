package com.idempiere.webserviceRequest;

import android.util.Log;

import com.idempiere.webservice.X_DataField;
import com.idempiere.webservice.X_DataRow;
import com.idempiere.webservice.X_DataSet;

import org.ksoap2.serialization.AttributeContainer;

/**
 * Created by ben on 22/05/17.
 */

public class ActionScheduleResponseParser extends ResponseParser {


    public ActionScheduleResponseParser(AttributeContainer response) {
        super(response);
    }

    public void parseAllMonthlyActionsResponse(){
        X_DataSet allData = windowTabData.DataSet;
        for (int i = 0 ; i < allData.size() ; i++){
            X_DataRow dataRow = allData.get(i);
            for (int j = 0 ; j < dataRow.size() ; j++) {
                X_DataField dataField = dataRow.get(j);
                /** Column name **/
                Log.v("dataColumnName", dataField.column);
                if (dataField.val != null){
                    /** Column value **/
                    Log.v("DataValue", dataField.val);
                }
                else {
                    Log.v("DataValue" , "null");
                }
            }
        }
    }
}
