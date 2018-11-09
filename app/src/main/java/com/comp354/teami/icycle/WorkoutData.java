package com.comp354.teami.icycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class WorkoutData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_data);


        Intent intent = getIntent();
        String temp = intent.getStringExtra(ViewWorkouts.EXTRA_MESSAGE).replaceAll("\\s+","");
        int listPos = Integer.parseInt(temp);

        setTitle(iCycle.workouts.get(listPos).getStartTime().toString().substring(0,10) + " " + iCycle.workouts.get(listPos).getStartTime().toString().substring(11,19));

        TextView distance = findViewById(R.id.Distance);
        if(iCycle.workouts.get(listPos).getSpeedAvg() == null)
            distance.setText("Avg Pace\n"+"n/a");
        else
            distance.setText("Distance\n"+String.format("%.2f",iCycle.workouts.get(listPos).getDistance())+" km");

        TextView calories = findViewById(R.id.Calories);
        if(iCycle.workouts.get(listPos).getCalories() == null)
            calories.setText("Calories\n"+"n/a");
        else
            calories.setText("Calories\n"+String.format("%.0f",iCycle.workouts.get(listPos).getCalories())+" kcal");

        TextView duration = findViewById(R.id.Duration);
        if(iCycle.workouts.get(listPos).getDuration() == null)
            duration.setText("Duration\n"+"n/a");
        else
            duration.setText("Duration\n"+iCycle.workouts.get(listPos).getDuration().getStandardMinutes()+" minutes");

        TextView avgSpeed = findViewById(R.id.AvgSpeed);
        if(iCycle.workouts.get(listPos).getSpeedAvg() == null)
            avgSpeed.setText("Avg Speed\n"+"n/a");
        else
        avgSpeed.setText("Avg Speed\n"+String.format("%.2f",iCycle.workouts.get(listPos).getSpeedAvg())+" km/h");

        TextView maxSpeed = findViewById(R.id.MaxSpeed);
        if(iCycle.workouts.get(listPos).getSpeedMax() == null)
            maxSpeed.setText("Max Speed\n"+"n/a");
        else
            maxSpeed.setText("Max Speed\n"+String.format("%.2f",iCycle.workouts.get(listPos).getSpeedMax())+" km/h");

        TextView avgPace = findViewById(R.id.AvgPace);
        if(iCycle.workouts.get(listPos).getSpeedAvg() == null)
            avgPace.setText("Avg Pace\n"+"n/a");
        else
        avgPace.setText("Avg Pace\n"+String.format("%.2f",(1/iCycle.workouts.get(listPos).getSpeedAvg()*60))+" min/km");

        TextView maxPace = findViewById(R.id.MaxPace);
        if(iCycle.workouts.get(listPos).getSpeedMax() == null)
            maxPace.setText("Max Pace\n"+"n/a");
        else
            maxPace.setText("Max Pace\n"+String.format("%.2f",(1/iCycle.workouts.get(listPos).getSpeedMax()*60))+" min/km");

        TextView minAltitude = findViewById(R.id.MinAltitude);
        if(iCycle.workouts.get(listPos).getAltitudeMin() == null)
            minAltitude.setText("Min Altitude\n"+"n/a");
        else
            minAltitude.setText("Min Altitude\n"+String.format("%.0f",iCycle.workouts.get(listPos).getAltitudeMin())+" m");

        TextView maxAltitude = findViewById(R.id.MaxAltitude);
        if(iCycle.workouts.get(listPos).getAltitudeMin() == null)
            maxAltitude.setText("Max Altitude\n"+"n/a");
        else
            maxAltitude.setText("Max Altitude\n"+String.format("%.0f",iCycle.workouts.get(listPos).getAltitudeMax())+" m");
    }
}
