package com.example.douglas.dicegame;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class CrapsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_craps);
    }

    static int valor;


    public void rollDice(View view) {

        TextView viewDice = (TextView) findViewById(R.id.dice);
        int resul = roll(12);

        viewDice.setText("" + resul);
        checkGame(resul);

    }

    private int roll(int face) {

        Random random = new Random();
        int ran = random.nextInt(face + 1);
        while (ran == 0 || ran == 1) {
            ran = random.nextInt(face + 1);
        }

        return ran;
    }

    private void checkGame(int value) {
        Button rollButton = (Button) findViewById(R.id.rollIdButton);
        TextView resul = (TextView) findViewById(R.id.resul);
        if (value == 7 || value == 11) {

            resul.setText("GANHOU !!!");
            resul.setTextColor(Color.GREEN);
           rollButton.setEnabled(false);


        }
        if (value == 2 || value == 3 || value == 12) {

            resul.setText("PERDEU :(");
            resul.setTextColor(Color.RED);
            rollButton.setEnabled(false);


        }
        if (value == 4 || value == 5 || value == 6 || value == 8 || value == 10) {


            Intent secondActivity = new Intent(this, CrapsSecondActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("valor", value);
            secondActivity.putExtras(bundle);
            startActivity(secondActivity);

        }


    }

    public void reset(View view) {

        TextView viewDice = (TextView) findViewById(R.id.dice);
        TextView resul = (TextView) findViewById(R.id.resul);
        Button rollButton = (Button) findViewById(R.id.rollIdButton);

        viewDice.setText("0");
        resul.setText("Resultado");
        resul.setTextColor(Color.BLACK);
        rollButton.setEnabled(true);

    }


    public void onBackPressed(){

        Intent secondActivity = new Intent(this, MainActivity.class);
        startActivity(secondActivity);

    }

}
