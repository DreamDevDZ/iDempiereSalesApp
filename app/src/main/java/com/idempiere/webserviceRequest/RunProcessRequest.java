package com.idempiere.webserviceRequest;

import android.content.Context;
import android.os.AsyncTask;
import android.os.PowerManager;
import android.util.Base64;
import android.util.Log;

import com.idempiere.utils.WSRUtils;
import com.idempiere.webservice.X_ADLoginRequest;
import com.idempiere.webservice.X_DataField;
import com.idempiere.webservice.X_DataRow;
import com.idempiere.webservice.X_ModelRunProcess;
import com.idempiere.webservice.X_RunProcessResponse;

/**
 * Created by benparker on 11/07/17.
 */
public class RunProcessRequest extends AsyncTask<Void, Void, Void> {

    private Context context;

    public RunProcessRequest(Context context) {
        this.context = context;
    }
    private X_DataField datafield;
    WebServiceRequest wsr;
    private X_ModelRunProcess modelRunP;
    X_ADLoginRequest loginRequest;
    private String user;
    private String pass;


    public RunProcessRequest(String username, String password) {
        this.user = username;
        this.pass = password;
    }


    private void runProcessRequest() {
        modelRunP = WSRUtils.createModelRunProcess("SMAColumnGenerator", 1000173, 0);
        loginRequest = WSRUtils.createLoginRequest(user, pass);
        wsr = new WebServiceRequest(modelRunP, I_WebServiceRequest.RUN_PROCESS, loginRequest);
        X_RunProcessResponse response = wsr.runProcess();

        if (response.Error != null)
             Log.v("responseError", response.Error);

        if (response.Summary != null){
            Log.v("WhichHitResponse", "Summary");
            String respons = null;

            byte[] resp = Base64.decode(response.Summary.getBytes(), 0);
            try {
                respons = new String(resp, "UTF-8");
            }
            catch (Exception e){
                e.printStackTrace();
            }
            Log.v("ProcessSummary", respons);
        }

    }

    @Override
    protected Void doInBackground(Void... params) {
        runProcessRequest();
        return null;
    }
}

