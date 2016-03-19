package com.example.douglas.dicegame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void randomDice(View view){

        Intent secondActivity = new Intent(this, RandomDice.class);
        startActivity(secondActivity);

    }

    public void duelDice(View view){

        Intent secondActivity = new Intent(this, diceDuel.class);
        startActivity(secondActivity);


    }

    public void craps(View view){

        Intent secondActivity = new Intent(this, CrapsActivity.class);
        startActivity(secondActivity);

    }

    public void infoApp(View view){

        Intent secondActivity = new Intent(this, InfoActivity.class);
        startActivity(secondActivity);

    }

}
