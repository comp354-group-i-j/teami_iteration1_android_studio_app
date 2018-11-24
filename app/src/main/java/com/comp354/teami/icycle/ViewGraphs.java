package com.comp354.teami.icycle;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;

import java.util.LinkedList;
import java.util.Queue;

public class ViewGraphs extends AppCompatActivity {

    EditText min, max;
    double min1,max1;
    LineGraphSeries<DataPoint> series;
    LineGraphSeries<DataPoint> MA10;
    LineGraphSeries<DataPoint> MA20;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_graphs);

        setTitle("Graphs");

        min = findViewById(R.id.min);
        max = findViewById(R.id.max);



        GraphView graph = (GraphView) findViewById(R.id.Graph);
        graph.getGridLabelRenderer().setNumHorizontalLabels(iCycle.workouts.size());

        Button distance = findViewById(R.id.Distance);
        Button duration = findViewById(R.id.Duration);
        Button calories = findViewById(R.id.Calories);
        Button avgSpeed = findViewById(R.id.AvgSpeed);
        Button maxSpeed = findViewById(R.id.MaxSpeed);
        Button avgPace = findViewById(R.id.AvgPace);
        Button maxPace = findViewById(R.id.MaxPace);
        Button minAltitude = findViewById(R.id.MinAltitude);
        Button maxAltitude = findViewById(R.id.MaxAltitude);

        distance.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        setTitle("Distance vs. Time");

                        if (min.getText().toString().matches(""))
                            min1=0;
                        else
                            min1=Double.parseDouble(min.getText().toString());

                        if (max.getText().toString().matches(""))
                            max1=Double.MAX_VALUE;
                        else
                            max1=Double.parseDouble(max.getText().toString());
                        graph.removeAllSeries();
                        series = new LineGraphSeries<DataPoint>();
                        series.setColor(Color.BLUE);
                        MA10 = new LineGraphSeries<DataPoint>();
                        MA10.setColor(Color.GREEN);
                        MA20 = new LineGraphSeries<DataPoint>();
                        MA20.setColor(Color.RED);

                        int x = 0;
                        Double y = 0.0;

                        SimpleMovingAverage obj = new SimpleMovingAverage(2);
                        SimpleMovingAverage obj2 = new SimpleMovingAverage(3);

                        for(int i = 0; i < iCycle.workouts.size(); i++){

                            x = i;
                            y = iCycle.workouts.get(i).getDistance();
                            if (y>=min1 && y<=max1)
                            {
                                obj.addData(y);
                                obj.getMean();
                                obj2.addData(y);
                                obj2.getMean();
                                series.appendData(new DataPoint(x,y), true, iCycle.workouts.size());
                                MA10.appendData(new DataPoint(x,obj.getMean()), true, iCycle.workouts.size());
                                MA20.appendData(new DataPoint(x,obj2.getMean()), true, iCycle.workouts.size());
                            }

                        }
                        graph.addSeries(series);
                        graph.addSeries(MA10);
                        graph.addSeries(MA20);

                    }
                });

        duration.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        setTitle("Duration vs. Time");

                        if (min.getText().toString().matches(""))
                            min1=0;
                        else
                            min1=Double.parseDouble(min.getText().toString());

                        if (max.getText().toString().matches(""))
                            max1=Double.MAX_VALUE;
                        else
                            max1=Double.parseDouble(max.getText().toString());
                        graph.removeAllSeries();
                        series = new LineGraphSeries<DataPoint>();
                        series.setColor(Color.BLUE);
                        MA10 = new LineGraphSeries<DataPoint>();
                        MA10.setColor(Color.GREEN);
                        MA20 = new LineGraphSeries<DataPoint>();
                        MA20.setColor(Color.RED);

                        int x = 0;
                        Double y = 0.0;

                        SimpleMovingAverage obj = new SimpleMovingAverage(2);
                        SimpleMovingAverage obj2 = new SimpleMovingAverage(3);

                        for(int i = 0; i < iCycle.workouts.size(); i++){

                            x = i;
                            y = iCycle.workouts.get(i).getDuration().getStandardMinutes()+0.0;
                            if (y>=min1 && y<=max1)
                            {
                                obj.addData(y);
                                obj.getMean();
                                obj2.addData(y);
                                obj2.getMean();
                                series.appendData(new DataPoint(x,y), true, iCycle.workouts.size());
                                MA10.appendData(new DataPoint(x,obj.getMean()), true, iCycle.workouts.size());
                                MA20.appendData(new DataPoint(x,obj2.getMean()), true, iCycle.workouts.size());
                            }
                        }
                        graph.addSeries(series);
                        graph.addSeries(MA10);
                        graph.addSeries(MA20);

                    }
                });

        calories.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        setTitle("Calories vs. Time");

                        if (min.getText().toString().matches(""))
                            min1=0;
                        else
                            min1=Double.parseDouble(min.getText().toString());

                        if (max.getText().toString().matches(""))
                            max1=Double.MAX_VALUE;
                        else
                            max1=Double.parseDouble(max.getText().toString());
                        graph.removeAllSeries();
                        series = new LineGraphSeries<DataPoint>();
                        series.setColor(Color.BLUE);
                        MA10 = new LineGraphSeries<DataPoint>();
                        MA10.setColor(Color.GREEN);
                        MA20 = new LineGraphSeries<DataPoint>();
                        MA20.setColor(Color.RED);

                        int x = 0;
                        Double y = 0.0;

                        SimpleMovingAverage obj = new SimpleMovingAverage(2);
                        SimpleMovingAverage obj2 = new SimpleMovingAverage(3);

                        for(int i = 0; i < iCycle.workouts.size(); i++){

                            x = i;
                            y = iCycle.workouts.get(i).getCalories();
                            if (y>=min1 && y<=max1)
                            {
                                obj.addData(y);
                                obj.getMean();
                                obj2.addData(y);
                                obj2.getMean();
                                series.appendData(new DataPoint(x,y), true, iCycle.workouts.size());
                                MA10.appendData(new DataPoint(x,obj.getMean()), true, iCycle.workouts.size());
                                MA20.appendData(new DataPoint(x,obj2.getMean()), true, iCycle.workouts.size());
                            }
                        }
                        graph.addSeries(series);
                        graph.addSeries(MA10);
                        graph.addSeries(MA20);

                    }
                });

        avgSpeed.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        setTitle("Avg Speed vs. Time");

                        if (min.getText().toString().matches(""))
                            min1=0;
                        else
                            min1=Double.parseDouble(min.getText().toString());

                        if (max.getText().toString().matches(""))
                            max1=Double.MAX_VALUE;
                        else
                            max1=Double.parseDouble(max.getText().toString());
                        graph.removeAllSeries();
                        series = new LineGraphSeries<DataPoint>();
                        series.setColor(Color.BLUE);
                        MA10 = new LineGraphSeries<DataPoint>();
                        MA10.setColor(Color.GREEN);
                        MA20 = new LineGraphSeries<DataPoint>();
                        MA20.setColor(Color.RED);

                        int x = 0;
                        Double y = 0.0;

                        SimpleMovingAverage obj = new SimpleMovingAverage(2);
                        SimpleMovingAverage obj2 = new SimpleMovingAverage(3);

                        for(int i = 0; i < iCycle.workouts.size(); i++){
                            if(iCycle.workouts.get(i).getSpeedAvg() == null)
                                continue;
                            x = i;
                            y = iCycle.workouts.get(i).getSpeedAvg();
                            if (y>=min1 && y<=max1)
                            {
                                obj.addData(y);
                                obj.getMean();
                                obj2.addData(y);
                                obj2.getMean();
                                series.appendData(new DataPoint(x,y), true, iCycle.workouts.size());
                                MA10.appendData(new DataPoint(x,obj.getMean()), true, iCycle.workouts.size());
                                MA20.appendData(new DataPoint(x,obj2.getMean()), true, iCycle.workouts.size());
                            }
                        }
                        graph.addSeries(series);
                        graph.addSeries(MA10);
                        graph.addSeries(MA20);

                    }
                });

        maxSpeed.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        setTitle("Max Speed vs. Time");

                        if (min.getText().toString().matches(""))
                            min1=0;
                        else
                            min1=Double.parseDouble(min.getText().toString());

                        if (max.getText().toString().matches(""))
                            max1=Double.MAX_VALUE;
                        else
                            max1=Double.parseDouble(max.getText().toString());
                        graph.removeAllSeries();
                        series = new LineGraphSeries<DataPoint>();
                        series.setColor(Color.BLUE);
                        MA10 = new LineGraphSeries<DataPoint>();
                        MA10.setColor(Color.GREEN);
                        MA20 = new LineGraphSeries<DataPoint>();
                        MA20.setColor(Color.RED);

                        int x = 0;
                        Double y = 0.0;

                        SimpleMovingAverage obj = new SimpleMovingAverage(2);
                        SimpleMovingAverage obj2 = new SimpleMovingAverage(3);

                        for(int i = 0; i < iCycle.workouts.size(); i++){
                            if(iCycle.workouts.get(i).getSpeedMax() == null)
                                continue;
                            x = i;
                            y = iCycle.workouts.get(i).getSpeedMax();
                            if (y>=min1 && y<=max1)
                            {
                                obj.addData(y);
                                obj.getMean();
                                obj2.addData(y);
                                obj2.getMean();
                                series.appendData(new DataPoint(x,y), true, iCycle.workouts.size());
                                MA10.appendData(new DataPoint(x,obj.getMean()), true, iCycle.workouts.size());
                                MA20.appendData(new DataPoint(x,obj2.getMean()), true, iCycle.workouts.size());
                            }
                        }
                        graph.addSeries(series);
                        graph.addSeries(MA10);
                        graph.addSeries(MA20);

                    }
                });

        avgPace.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        setTitle("Avg Pace vs. Time");

                        if (min.getText().toString().matches(""))
                            min1=0;
                        else
                            min1=Double.parseDouble(min.getText().toString());

                        if (max.getText().toString().matches(""))
                            max1=Double.MAX_VALUE;
                        else
                            max1=Double.parseDouble(max.getText().toString());
                        graph.removeAllSeries();
                        series = new LineGraphSeries<DataPoint>();
                        series.setColor(Color.BLUE);
                        MA10 = new LineGraphSeries<DataPoint>();
                        MA10.setColor(Color.GREEN);
                        MA20 = new LineGraphSeries<DataPoint>();
                        MA20.setColor(Color.RED);

                        int x = 0;
                        Double y = 0.0;

                        SimpleMovingAverage obj = new SimpleMovingAverage(2);
                        SimpleMovingAverage obj2 = new SimpleMovingAverage(3);

                        for(int i = 0; i < iCycle.workouts.size(); i++){
                            if(iCycle.workouts.get(i).getSpeedAvg() == null)
                                continue;
                            x = i;
                            y = 1/iCycle.workouts.get(i).getSpeedAvg()*60;
                            if (y>=min1 && y<=max1)
                            {
                                obj.addData(y);
                                obj.getMean();
                                obj2.addData(y);
                                obj2.getMean();
                                series.appendData(new DataPoint(x,y), true, iCycle.workouts.size());
                                MA10.appendData(new DataPoint(x,obj.getMean()), true, iCycle.workouts.size());
                                MA20.appendData(new DataPoint(x,obj2.getMean()), true, iCycle.workouts.size());
                            }
                        }
                        graph.addSeries(series);
                        graph.addSeries(MA10);
                        graph.addSeries(MA20);

                    }
                });

        maxPace.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        setTitle("Max Pace vs. Time");

                        if (min.getText().toString().matches(""))
                            min1=0;
                        else
                            min1=Double.parseDouble(min.getText().toString());

                        if (max.getText().toString().matches(""))
                            max1=Double.MAX_VALUE;
                        else
                            max1=Double.parseDouble(max.getText().toString());
                        graph.removeAllSeries();
                        series = new LineGraphSeries<DataPoint>();
                        series.setColor(Color.BLUE);
                        MA10 = new LineGraphSeries<DataPoint>();
                        MA10.setColor(Color.GREEN);
                        MA20 = new LineGraphSeries<DataPoint>();
                        MA20.setColor(Color.RED);

                        int x = 0;
                        Double y = 0.0;

                        SimpleMovingAverage obj = new SimpleMovingAverage(2);
                        SimpleMovingAverage obj2 = new SimpleMovingAverage(3);

                        for(int i = 0; i < iCycle.workouts.size(); i++){
                            if(iCycle.workouts.get(i).getSpeedMax() == null)
                                continue;
                            x = i;
                            y = 1/iCycle.workouts.get(i).getSpeedMax()*60;
                            if (y>=min1 && y<=max1)
                            {
                                obj.addData(y);
                                obj.getMean();
                                obj2.addData(y);
                                obj2.getMean();
                                series.appendData(new DataPoint(x,y), true, iCycle.workouts.size());
                                MA10.appendData(new DataPoint(x,obj.getMean()), true, iCycle.workouts.size());
                                MA20.appendData(new DataPoint(x,obj2.getMean()), true, iCycle.workouts.size());
                            }
                        }
                        graph.addSeries(series);
                        graph.addSeries(MA10);
                        graph.addSeries(MA20);

                    }
                });

        minAltitude.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        setTitle("Min Altitude vs. Time");

                        if (min.getText().toString().matches(""))
                            min1=0;
                        else
                            min1=Double.parseDouble(min.getText().toString());

                        if (max.getText().toString().matches(""))
                            max1=Double.MAX_VALUE;
                        else
                            max1=Double.parseDouble(max.getText().toString());
                        graph.removeAllSeries();
                        series = new LineGraphSeries<DataPoint>();
                        series.setColor(Color.BLUE);
                        MA10 = new LineGraphSeries<DataPoint>();
                        MA10.setColor(Color.GREEN);
                        MA20 = new LineGraphSeries<DataPoint>();
                        MA20.setColor(Color.RED);

                        int x = 0;
                        Double y = 0.0;

                        SimpleMovingAverage obj = new SimpleMovingAverage(2);
                        SimpleMovingAverage obj2 = new SimpleMovingAverage(3);

                        for(int i = 0; i < iCycle.workouts.size(); i++){
                            if(iCycle.workouts.get(i).getAltitudeMin() == null)
                                continue;
                            x = i;
                            y = iCycle.workouts.get(i).getAltitudeMin();
                            if (y>=min1 && y<=max1)
                            {
                                obj.addData(y);
                                obj.getMean();
                                obj2.addData(y);
                                obj2.getMean();
                                series.appendData(new DataPoint(x,y), true, iCycle.workouts.size());
                                MA10.appendData(new DataPoint(x,obj.getMean()), true, iCycle.workouts.size());
                                MA20.appendData(new DataPoint(x,obj2.getMean()), true, iCycle.workouts.size());
                            }
                        }
                        graph.addSeries(series);
                        graph.addSeries(MA10);
                        graph.addSeries(MA20);

                    }
                });

        maxAltitude.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        setTitle("Max Altitude vs. Time");

                        if (min.getText().toString().matches(""))
                            min1=0;
                        else
                            min1=Double.parseDouble(min.getText().toString());

                        if (max.getText().toString().matches(""))
                            max1=Double.MAX_VALUE;
                        else
                            max1=Double.parseDouble(max.getText().toString());
                        graph.removeAllSeries();
                        series = new LineGraphSeries<DataPoint>();
                        series.setColor(Color.BLUE);
                        MA10 = new LineGraphSeries<DataPoint>();
                        MA10.setColor(Color.GREEN);
                        MA20 = new LineGraphSeries<DataPoint>();
                        MA20.setColor(Color.RED);

                        int x = 0;
                        Double y = 0.0;

                        SimpleMovingAverage obj = new SimpleMovingAverage(2);
                        SimpleMovingAverage obj2 = new SimpleMovingAverage(3);

                        for(int i = 0; i < iCycle.workouts.size(); i++){
                            if(iCycle.workouts.get(i).getAltitudeMax() == null)
                                continue;
                            x = i;
                            y = iCycle.workouts.get(i).getAltitudeMax();
                            if (y>=min1 && y<=max1)
                            {
                                obj.addData(y);
                                obj.getMean();
                                obj2.addData(y);
                                obj2.getMean();
                                series.appendData(new DataPoint(x,y), true, iCycle.workouts.size());
                                MA10.appendData(new DataPoint(x,obj.getMean()), true, iCycle.workouts.size());
                                MA20.appendData(new DataPoint(x,obj2.getMean()), true, iCycle.workouts.size());
                            }
                        }
                        graph.addSeries(series);
                        graph.addSeries(MA10);
                        graph.addSeries(MA20);

                    }
                });

    }


    //https://www.geeksforgeeks.org/program-find-simple-moving-average/
    public class SimpleMovingAverage {

        // queue used to store list so that we get the average
        private final Queue<Double> Dataset = new LinkedList<Double>();
        private final int period;
        private double sum;

        // constructor to initialize period
        public SimpleMovingAverage(int period)
        {
            this.period = period;
        }

        // function to add new data in the
        // list and update the sum so that
        // we get the new mean
        public void addData(double num)
        {
            sum += num;
            Dataset.add(num);

            // Updating size so that length
            // of data set should be equal
            // to period as a normal mean has
            if (Dataset.size() > period)
            {
                sum -= Dataset.remove();
            }
        }

        // function to calculate mean
        public double getMean()
        {
            return sum / period;
        }


    }
}
