package com.example.quicksum;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class ColorActivity extends AppCompatActivity {
    private Button toMain;
    private SharedPreferences preferences;
    private LinearLayout colorLayout;
    int theme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        preferences = getSharedPreferences("value", MODE_PRIVATE);

        //assign
        toMain = findViewById(R.id.toMain);
        colorLayout = findViewById(R.id.colorLayout);

    }


    @SuppressLint("DefaultLocale")
    @Override
    protected void onStart() {
        super.onStart();
        theme = preferences.getInt("theme number", 0);
        if (theme == 0){
            colorLayout.setBackgroundResource(R.color.defaultBackground);
        }
        else if (theme == 1){
            colorLayout.setBackgroundResource(R.color.galaxyBackground);
        }
        else if (theme == 2){
            colorLayout.setBackgroundResource(R.color.neutralBackground);
        }
        else if (theme == 3){
            colorLayout.setBackgroundResource(R.color.modernBackground);
        }
        else if (theme == 4){
            colorLayout.setBackgroundResource(R.color.sunBackground);
        }
    }

    public void changeToDefault(View view){
        colorLayout.setBackgroundResource(R.color.defaultBackground);
        preferences.edit().putInt("theme number", 0).apply();
    }

    public void changeToGalaxy(View view){
        colorLayout.setBackgroundResource(R.color.galaxyBackground);
        preferences.edit().putInt("theme number", 1).apply();
    }


    public void changeToNeutral(View view){
        colorLayout.setBackgroundResource(R.color.neutralBackground);
        preferences.edit().putInt("theme number", 2).apply();
    }

    public void changeToModern(View view){
        colorLayout.setBackgroundResource(R.color.modernBackground);
        preferences.edit().putInt("theme number", 3).apply();
    }

    public void changeToSun(View view){
        colorLayout.setBackgroundResource(R.color.sunBackground);
        preferences.edit().putInt("theme number", 4).apply();
    }

    public void goBackToMain(View view){
        Intent intent = new Intent(this, MainActivity.class );
        startActivity(intent);
    }

    protected void onStop(){
        super.onStop();

    }
    protected void onDestroy(){
        super.onDestroy();
    }
}

