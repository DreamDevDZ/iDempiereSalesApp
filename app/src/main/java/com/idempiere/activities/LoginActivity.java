package com.idempiere.activities;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.iDempiere.R;
import com.idempiere.database.DBQuery;
import com.idempiere.database.Database;
import com.idempiere.model.I_X_Action;
import com.idempiere.model.X_Login_Detail;
import com.idempiere.webserviceRequest.LoginRequest;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import static android.view.View.X;
import static com.idempiere.utils.WSRUtils.createLoginRequest;

/**
 * @author Ben Parker
 * @created 21/05/17
 * @usage
 * IF Connection exists THEN performs web service login request
 *      IF return type is correct THEN load main menu
 *      ELSE invalid login
 * ELSE check local database for existing record of login details
 *      IF match then load main menu
 *      ELSE invalid login
 */
public class LoginActivity extends AppCompatActivity {
    public EditText username;
    public EditText password;
    public Button logIn;
    int authResponse = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText)findViewById(R.id.usernameText);
        password = (EditText)findViewById(R.id.passwordText);
        logIn = (Button)findViewById(R.id.loginButton);
        createLoginButtonClickListener();

        /** Create a new database instance if one doesn't already exist **/
        Database.createOrUpgradeDatabase(this);

        /**
        DBQuery query = new DBQuery("SELECT * FROM X_Action");
        Cursor response = query.executeQuery();
        ArrayList<String> results = new ArrayList<>();
        while (response.moveToNext()){
            results.add(response.getString(response.getColumnIndex(I_X_Action.COLUMNNAME_AD_Org_ID)));
        }
         **/
    }


    private void createLoginButtonClickListener(){
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createLoginRequest();
                /** User has been authenticated successfully **/
                if (authResponse == 1) {


                    createLoginDetailsRecord();

                    Log.v("Loadingmaimenuintent", "MainMenu");
                    Intent intent = new Intent(view.getContext(), MainMenu.class);
                    intent.putExtra("Username", username.getText().toString());
                    view.getContext().startActivity(intent);
                }
                else if (authResponse == -1){
                    Toast.makeText(getBaseContext(), "Incorrect log in details", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    private long createLoginDetailsRecord(){
        try {
            X_Login_Detail loginDetail = new X_Login_Detail();
            loginDetail.setUsername(username.getText().toString());
            loginDetail.setPassword(password.getText().toString());
            return loginDetail.save();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }


    private void createLoginRequest(){
        String user = username.getText().toString();
        String pass = password.getText().toString();
        if (user != null && pass != null) {
            LoginRequest loginDetails = new LoginRequest(username.getText().toString(), password.getText().toString());
            try {
                authResponse = loginDetails.execute().get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        else {
            Log.v("MandatoryLoginFields", "Must fill in username and password before logging in");
            Toast.makeText(getBaseContext(), "Must fill in username and password before logging in", Toast.LENGTH_SHORT).show();
        }
    }
}
