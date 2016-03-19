package com.example.douglas.dicegame;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class CrapsSecondActivity extends AppCompatActivity {

    int valueAnterior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_craps_second);
        TextView resulAnt = (TextView) findViewById(R.id.resulAnterior);


        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();

        valueAnterior = bundle.getInt("valor");

        resulAnt.setText("Valor Tirado: " + valueAnterior);
    }



    public void rollDice(View view) {

        TextView viewDice = (TextView) findViewById(R.id.dice);

        int resul = roll(12);
        viewDice.setText(""+resul);

        checkGame(resul);


    }

    private void checkGame(int value) {
        Button rollButton = (Button) findViewById(R.id.rollIdButton);
        TextView resul = (TextView) findViewById(R.id.ganharOuPerder);

        if (value == valueAnterior) {

            resul.setText("GANHOU !!!");
            resul.setTextColor(Color.GREEN);
            rollButton.setEnabled(false);


        }
        if (value == 7) {

            resul.setText("PERDEU :(");
            resul.setTextColor(Color.RED);
            rollButton.setEnabled(false);


        }
    }


    private int roll(int face) {

        Random random = new Random();
        int ran = random.nextInt(face + 1);
        while (ran == 0 || ran == 1) {
            ran = random.nextInt(face + 1);
        }

        return ran;
    }


    public void reset(View view){

        Intent secondActivity = new Intent(this, CrapsActivity.class);
        startActivity(secondActivity);

    }

    public void onBackPressed(){

        Intent secondActivity = new Intent(this, MainActivity.class);
        startActivity(secondActivity);

    }

}
