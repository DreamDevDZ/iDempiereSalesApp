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
    private PowerManager.WakeLock mWakeLock;

    public RunProcessRequest(Context context) {
        this.context = context;
    }

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
        modelRunP = new X_ModelRunProcess();
        modelRunP.setServiceType("SMAColumnGenerator");
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
        if (response.LogInfo != null){
            Log.v("WhichHitResponse", "LogInfo");
            String respons = null;
            byte[] resp = Base64.decode(response.LogInfo.getBytes(), 0);
            try {
                respons = new String(resp, "UTF-8");
            }
            catch (Exception e){
                e.printStackTrace();
            }
            Log.v("ProcessLogInfo", respons);
        }

        if (response.Data != null){
            Log.v("WhichHitResponse", "Data");
            String respons = null;
            byte[] resp = Base64.decode(response.Data.getBytes(), 0);
            try {
                respons = new String(resp, "UTF-8");
            }
            catch (Exception e){
                e.printStackTrace();
            }
            Log.v("ProcessData", respons);
        }

        if (response.ADLoginResponse != null){
            Log.v("WhichHitResponse", "ADLoginResponse");
            String respons = response.ADLoginResponse.langs;
            Log.v("ADLoginResponse", respons);
        }



    }

    @Override
    protected Void doInBackground(Void... params) {
        runProcessRequest();
        return null;
    }
}

