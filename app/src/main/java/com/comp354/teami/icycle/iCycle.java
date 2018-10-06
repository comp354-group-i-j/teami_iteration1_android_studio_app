package com.comp354.teami.icycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.moomeen.endo2java.EndomondoSession;
import com.moomeen.endo2java.error.LoginException;
import com.moomeen.endo2java.error.InvocationException;


import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View.OnClickListener;

public class iCycle extends AppCompatActivity {

    TextView textView;
    EditText username, password;
    Button button;
    String str0, str1;
    EndomondoSession session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i_cycle);

        textView = findViewById(R.id.textView);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        button = findViewById(R.id.button);

        /*This is just a test case. The idea here for now is similar to how the console application operates.
        Create an Endomondo session and then call login() method to authenticate login and scrape data.
        Then call getWorkouts() method to get all workout data as a string, and set that string to textView to display under the login prompt.
        Currently the app crashes when calling login() on the session object. */

        button.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view)
                    {
                        str0 = username.getText().toString();
                        str1 = password.getText().toString();


                        // Use "omarafarajat@gmail.com" as username and "Comp354Fall2018" as password to log into Endomondo account
                        session = new EndomondoSession(str0, str1);

                        try {
                            session.login();                    // ---> APP CRASHES HERE, no compile errors, no runtime errors, just crashes!!
                        } catch (LoginException e) {
                            e.printStackTrace();
                        }

                        try {
                            textView.setText(session.getWorkouts().toString());
                        } catch (InvocationException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}
