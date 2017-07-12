package com.idempiere.webserviceRequest;

import android.content.Context;
import android.os.AsyncTask;
import android.os.PowerManager;
import android.util.Base64;

import com.idempiere.utils.WSRUtils;
import com.idempiere.webservice.X_ADLoginRequest;
import com.idempiere.webservice.X_DataField;
import com.idempiere.webservice.X_DataRow;
import com.idempiere.webservice.X_ModelCRUD;
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
    private X_ModelCRUD modelCRUD;
    X_ADLoginRequest loginRequest;
    private String user;
    private String pass;


    public RunProcessRequest(String username, String password) {
        this.user = username;
        this.pass = password;
    }


    private void runProcessRequest() {
        modelCRUD = new X_ModelCRUD();
        modelCRUD.setServiceType("SMAColumnGenerator");
        X_DataRow params = new X_DataRow();
        X_DataField processID = new X_DataField();
        processID.setColumn("AD_Process_ID");
        processID.setVal("1000173");
        params.add(processID);
        modelCRUD.setDataRow(params);


        wsr = new WebServiceRequest(modelCRUD, I_WebServiceRequest.RUN_PROCESS);
        loginRequest = WSRUtils.createLoginRequest(user, pass);
        wsr.setLoginRequest(loginRequest);
        X_RunProcessResponse response = wsr.runProcess();
        byte[] resp = Base64.decode(response.LogInfo.getBytes(), 0);
        try {
            String str = new String(resp, "UTF-8");
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }

    @Override
    protected Void doInBackground(Void... params) {
        runProcessRequest();
        return null;
    }
}

