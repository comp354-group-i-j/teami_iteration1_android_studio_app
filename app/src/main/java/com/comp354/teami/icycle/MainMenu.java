package com.comp354.teami.icycle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        //
        setTitle("Welcome!");
        // Get the Intent that started this activity and extract the string
        //Intent intent = getIntent();
       // String message = intent.getStringExtra(iCycle.EXTRA_MESSAGE);

        //TextView loginMessage = findViewById(R.id.LoginMessage);
        //loginMessage.setText(message);

        //
        Button viewWorkouts = findViewById(R.id.viewWorkouts);

        viewWorkouts.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view) {

                        goToViewWorkouts(view);


                    }
                });


        //


        Button viewGraphs = findViewById(R.id.viewGraphs);

        viewGraphs.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view) {
                        goToViewGraphs(view);

                    }
                });


    }

    public void goToViewWorkouts(View view) {
        Intent intent = new Intent(this, ViewWorkouts.class);
        startActivity(intent);
    }

    public void goToViewGraphs(View view) {
        Intent intent = new Intent(this, ViewGraphs.class);
        startActivity(intent);
    }


}
