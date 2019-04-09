package com.example.quicksum;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //declare the variables
    private TextView numDisplay;
    private double calculatedValue = 0;
    private ArrayList<Double> history = new ArrayList<>();

    private boolean otherStatus = false;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button clear;
    private Button undo;
    private Button other;
    private Button color;

    private SharedPreferences preferences;
    private int theme;
    private LinearLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences("value", MODE_PRIVATE);

        numDisplay = findViewById(R.id.numDisplay);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        clear = findViewById(R.id.clearButton);
        undo = findViewById(R.id.undoButton);
        other = findViewById(R.id.otherButton);
        color = findViewById(R.id.colourChange);

        mainLayout = findViewById(R.id.mainLayout);
        numDisplay.setText(String.format("%d",0));
    }

    @SuppressLint("DefaultLocale")
    @Override
    protected void onStart() {
        super.onStart();
        theme = preferences.getInt("theme number", 0);
        if (theme == 0){
            mainLayout.setBackgroundResource(R.color.defaultBackground);
            button1.setBackgroundResource(R.color.defaultButton1);
            button2.setBackgroundResource(R.color.defaultButton1);
            button3.setBackgroundResource(R.color.defaultButton1);
            button4.setBackgroundResource(R.color.defaultButton1);
            button5.setBackgroundResource(R.color.defaultButton1);
            button6.setBackgroundResource(R.color.defaultButton1);
            button7.setBackgroundResource(R.color.defaultButton1);
            button8.setBackgroundResource(R.color.defaultButton1);
            button9.setBackgroundResource(R.color.defaultButton1);
            undo.setBackgroundResource(R.color.defaultButton2);
            clear.setBackgroundResource(R.color.defaultButton2);
            other.setBackgroundResource(R.color.defaultButton2);
        }
        else if (theme == 1){
            mainLayout.setBackgroundResource(R.color.galaxyBackground);
            button1.setBackgroundResource(R.color.galaxyButton1);
            button2.setBackgroundResource(R.color.galaxyButton1);
            button3.setBackgroundResource(R.color.galaxyButton1);
            button4.setBackgroundResource(R.color.galaxyButton1);
            button5.setBackgroundResource(R.color.galaxyButton1);
            button6.setBackgroundResource(R.color.galaxyButton1);
            button7.setBackgroundResource(R.color.galaxyButton1);
            button8.setBackgroundResource(R.color.galaxyButton1);
            button9.setBackgroundResource(R.color.galaxyButton1);
            undo.setBackgroundResource(R.color.galaxyButton2);
            clear.setBackgroundResource(R.color.galaxyButton2);
            other.setBackgroundResource(R.color.galaxyButton2);
        }
        else if (theme == 2){
            mainLayout.setBackgroundResource(R.color.neutralBackground);
            button1.setBackgroundResource(R.color.neutralButton1);
            button2.setBackgroundResource(R.color.neutralButton1);
            button3.setBackgroundResource(R.color.neutralButton1);
            button4.setBackgroundResource(R.color.neutralButton1);
            button5.setBackgroundResource(R.color.neutralButton1);
            button6.setBackgroundResource(R.color.neutralButton1);
            button7.setBackgroundResource(R.color.neutralButton1);
            button8.setBackgroundResource(R.color.neutralButton1);
            button9.setBackgroundResource(R.color.neutralButton1);
            undo.setBackgroundResource(R.color.neutralButton2);
            clear.setBackgroundResource(R.color.neutralButton2);
            other.setBackgroundResource(R.color.neutralButton2);
        }
        else if (theme == 3){
            mainLayout.setBackgroundResource(R.color.modernBackground);
            button1.setBackgroundResource(R.color.modernButton1);
            button2.setBackgroundResource(R.color.modernButton1);
            button3.setBackgroundResource(R.color.modernButton1);
            button4.setBackgroundResource(R.color.modernButton1);
            button5.setBackgroundResource(R.color.modernButton1);
            button6.setBackgroundResource(R.color.modernButton1);
            button7.setBackgroundResource(R.color.modernButton1);
            button8.setBackgroundResource(R.color.modernButton1);
            button9.setBackgroundResource(R.color.modernButton1);
            undo.setBackgroundResource(R.color.modernButton2);
            clear.setBackgroundResource(R.color.modernButton2);
            other.setBackgroundResource(R.color.modernButton2);
        }
        else if (theme == 4){
            mainLayout.setBackgroundResource(R.color.sunBackground);
            button1.setBackgroundResource(R.color.sunButton1);
            button2.setBackgroundResource(R.color.sunButton1);
            button3.setBackgroundResource(R.color.sunButton1);
            button4.setBackgroundResource(R.color.sunButton1);
            button5.setBackgroundResource(R.color.sunButton1);
            button6.setBackgroundResource(R.color.sunButton1);
            button7.setBackgroundResource(R.color.sunButton1);
            button8.setBackgroundResource(R.color.sunButton1);
            button9.setBackgroundResource(R.color.sunButton1);
            undo.setBackgroundResource(R.color.sunButton2);
            clear.setBackgroundResource(R.color.sunButton2);
            other.setBackgroundResource(R.color.sunButton2);
        }

    }

    //add number buttons
    @SuppressLint("DefaultLocale")
    public void add1(View view){
        if (otherStatus){
            //update history
            history.add(calculatedValue);

            calculatedValue = calculatedValue + 0.5;

            //reset all the states to before "other" is pressed
            otherStatus = false;
            button1.setText("1");
            button2.setText("2");
            button3.setText("3");
        }
        else{
            //update history
            history.add(calculatedValue);

            calculatedValue = calculatedValue + 1;
        }

        numDisplay.setText(String.format("%.3f", calculatedValue));
    }

    @SuppressLint("DefaultLocale")
    public void add2(View view){
        if (otherStatus){
            //update history
            history.add(calculatedValue);

            calculatedValue = calculatedValue + (0.333);

            //reset all the states to before "other" is pressed
            otherStatus = false;
            button1.setText("1");
            button2.setText("2");
            button3.setText("3");
        }
        else {
            //update history
            history.add(calculatedValue);

            calculatedValue = calculatedValue + 2;
        }

        numDisplay.setText(String.format("%.3f", calculatedValue));
    }

    @SuppressLint("DefaultLocale")
    public void add3(View view){
        if (otherStatus){
            //update history
            history.add(calculatedValue);

            calculatedValue = calculatedValue + (0.25);

            //reset all the states to before "other" is pressed
            otherStatus = false;
            button1.setText("1");
            button2.setText("2");
            button3.setText("3");
        }
        else {
            //update history
            history.add(calculatedValue);

            calculatedValue = calculatedValue + 3;
        }

        numDisplay.setText(String.format("%.3f", calculatedValue));
    }

    @SuppressLint("DefaultLocale")
    public void add4(View view){
        //update history
        history.add(calculatedValue);

        calculatedValue = calculatedValue + 4;
        numDisplay.setText(String.format("%.3f", calculatedValue));
    }

    @SuppressLint("DefaultLocale")
    public void add5(View view){
        //update history
        history.add(calculatedValue);

        calculatedValue = calculatedValue + 5;
        numDisplay.setText(String.format("%.3f", calculatedValue));
    }

    @SuppressLint("DefaultLocale")
    public void add6(View view){
        //update history
        history.add(calculatedValue);

        calculatedValue = calculatedValue + 6;
        numDisplay.setText(String.format("%.3f", calculatedValue));
    }

    @SuppressLint("DefaultLocale")
    public void add7(View view){
        //update history
        history.add(calculatedValue);

        calculatedValue = calculatedValue + 7;
        numDisplay.setText(String.format("%.3f", calculatedValue));
    }

    @SuppressLint("DefaultLocale")
    public void add8(View view){
        //update history
        history.add(calculatedValue);

        calculatedValue = calculatedValue + 8;
        numDisplay.setText(String.format("%.3f", calculatedValue));
    }

    @SuppressLint("DefaultLocale")
    public void add9(View view){
        //update history
        history.add(calculatedValue);

        calculatedValue = calculatedValue + 9;
        numDisplay.setText(String.format("%.3f", calculatedValue));
    }

    // on clear, reassign the calculated value to 0
    public void clear(View view){
        history.clear();
        calculatedValue = 0;
        numDisplay.setText(String.format("%s", calculatedValue));
    }

    // other button
    public void other(View view){
        if (!otherStatus) {
            otherStatus = true;
            button1.setText("1/2");
            button2.setText("1/3");
            button3.setText("1/4");
        }
        else{
            otherStatus = false;
            button1.setText("1");
            button2.setText("2");
            button3.setText("3");
        }
    }

    //undo button
    @SuppressLint("DefaultLocale")
    public void undo(View view) {
        try {
            calculatedValue = history.get(history.size() - 1);
            numDisplay.setText(String.format("%.3f", calculatedValue));

            //update history by removing one
            history.remove(history.size() - 1);
        }
        catch(Exception e){
            //
        }

    }

    public void goToColorSettings(View view){
        Intent intent = new Intent(this, ColorActivity.class );
        startActivity(intent);
    }

    protected void onStop(){
        super.onStop();

    }
    protected void onDestroy(){
        super.onDestroy();
    }
}
