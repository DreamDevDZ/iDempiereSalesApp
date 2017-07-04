package com.idempiere.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.iDempiere.R;
import com.idempiere.database.Database;
import com.idempiere.error.SalesAppException;
import com.idempiere.webserviceRequest.LoginRequest;
import com.idempiere.webserviceRequest.TestRequest;

import java.util.concurrent.ExecutionException;

import static java.security.AccessController.getContext;

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
    Database db;
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
        db = new Database(this);

        // TestRequest tr = new TestRequest();
        //tr.execute();
    }


    private void createLoginButtonClickListener(){
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createLoginRequest();
                if (authResponse == 1) {
                    Intent intent = new Intent(view.getContext(), MainMenu.class);
                    view.getContext().startActivity(intent);
                }
                else if (authResponse == -1){
                    Toast.makeText(getBaseContext(), "Incorrect log in details", Toast.LENGTH_SHORT).show();
                }
            }
        });

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
