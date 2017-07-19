package com.idempiere.webserviceRequest;

import android.os.AsyncTask;
import android.util.Log;

import com.idempiere.error.SalesAppException;
import com.idempiere.utils.WSRUtils;
import com.idempiere.webservice.X_ADLoginRequest;
import com.idempiere.webservice.X_DataField;
import com.idempiere.webservice.X_DataRow;
import com.idempiere.webservice.X_DataSet;
import com.idempiere.webservice.X_Enums;
import com.idempiere.webservice.X_ModelADServiceSoapBinding;
import com.idempiere.webservice.X_ModelCRUD;
import com.idempiere.webservice.X_ModelCRUDRequest;
import com.idempiere.webservice.X_StandardResponse;
import com.idempiere.webservice.X_WindowTabData;


public class TestRequest extends AsyncTask<Void, Void, Void>{

    /** Create a ModelCRUD - which holds details of which service to call and which action to perform **/
    /** Create a data row which holds Data Field objects which themselves contain column-value pairs **/
    /** Create a login request which holds all the data required for login **/
    /** Create a modelCRUD_Request which contains modelCRUD and loginDEtails **/
    /** Create a SoapBindingService which is used to sent the request specifed in the modelCRUD_Request **/
    public void createDataWebServiceTest() {
        try {
            X_ModelCRUD modelCRUD = new X_ModelCRUD();
            modelCRUD.setServiceType("CreateTestBPartner");
            modelCRUD.setTableName("C_BPartner");
            modelCRUD.setRecordID(0);
            modelCRUD.setAction(X_Enums.ModelCRUD_Action.Create);

            X_DataRow dataRow = new X_DataRow();

            int counter = 1;
            X_DataField value = new X_DataField();
            value.setColumn("Value");
            value.setVal("BenTestWeb");
            dataRow.add(value);

            X_DataField name = new X_DataField();
            name.setColumn("Name");
            name.setVal("BenTestWeb");
            dataRow.add(name);

            X_DataField TaxID = new X_DataField();
            TaxID.setColumn("TaxID");
            TaxID.setVal("");
            dataRow.add(TaxID);

            X_DataField IsVendor = new X_DataField();
            IsVendor.setColumn("IsVendor");
            IsVendor.setVal("Y");
            dataRow.add(IsVendor);

            X_DataField IsCustomer = new X_DataField();
            IsCustomer.setColumn("IsCustomer");
            IsCustomer.setVal("Y");
            dataRow.add(IsCustomer);

            X_DataField IsTaxExempt = new X_DataField();
            IsTaxExempt.setColumn("IsTaxExempt");
            IsTaxExempt.setVal("Y");
            dataRow.add(IsTaxExempt);

            X_DataField Name2 = new X_DataField();
            Name2.setColumn("Name2");
            Name2.setVal("Ben Steak");
            dataRow.add(Name2);

            X_DataField C_BP_Group_ID = new X_DataField();
            C_BP_Group_ID.setColumn("C_BP_Group_ID");
            C_BP_Group_ID.setVal("105");
            dataRow.add(C_BP_Group_ID);

            modelCRUD.setDataRow(dataRow);

            X_ADLoginRequest aDLoginRequest = new X_ADLoginRequest("WebService", null, "WebService", "192", 1000000, 1000002, 1000000,
                    1000000, 0);
            X_ModelCRUDRequest req = new X_ModelCRUDRequest(modelCRUD, aDLoginRequest);
            /** Live database **/
            //X_ModelADServiceSoapBinding prox = new X_ModelADServiceSoapBinding("http://n1.suthbros.co.uk:8080/ADInterface/services/ModelADService/createData");
            /** Local test database **/
            X_ModelADServiceSoapBinding prox = new X_ModelADServiceSoapBinding("http://10.0.2.2:8080/ADInterface/services/ModelADService/createData");

            X_StandardResponse window = prox.createData(req);
        }
        catch(Exception e){
          e.printStackTrace();
        }
    }



    public X_ModelCRUD createModelCRUD(){
        X_ModelCRUD readAllActionData = new X_ModelCRUD();
        readAllActionData.setServiceType("GetIncompleteActions");
        readAllActionData.setAction(X_Enums.ModelCRUD_Action.Read);
        readAllActionData.setTableName("SB_IncompMonthlyAction_V");
        readAllActionData.setFilter("SalesRep_ID");

        X_DataField salesRep_ID = new X_DataField();
        salesRep_ID.setColumn("SalesRep_ID");
        salesRep_ID.setVal("1000017");

        X_DataRow rowData = new X_DataRow();
        rowData.add(salesRep_ID);

        readAllActionData.setDataRow(rowData);
        return readAllActionData;
    }


    public void createReadData(){
        WebServiceRequest wsr = new WebServiceRequest(createModelCRUD(), I_WebServiceRequest.READ_DATA, WSRUtils.createLoginRequest(null, null));
        X_WindowTabData actionData = wsr.queryData();

        if (actionData.Error != null) {
            Log.v("Error", actionData.Error);
            throw new SalesAppException("Error : " + actionData.Error);
        }
        X_DataSet allData = actionData.DataSet;
        if (allData == null) {
            throw new SalesAppException("No Data returned from query ");
        }
        for (int i = 0 ; i < allData.size() ; i++){
            X_DataRow dataRow = allData.get(i);
            for (int j = 0 ; j < dataRow.size() ; j++) {
                X_DataField dataField = dataRow.get(j);
                Log.v("dataColumnName", dataField.column);
                if (dataField.val != null){
                    Log.v("DataValue", dataField.val);
                }
                else {
                    Log.v("DataValue" , "null");
                }
            }
        }
    }


    @Override
    protected Void doInBackground(Void... params) {
        createDataWebServiceTest();
        //createReadData();
        return null;
    }
}
