package com.example.douglas.dicegame;

import android.app.DownloadManager;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class diceDuel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_duel);
    }

    int placarA;
    int placarB;

    public void rollDice(View view){

        TextView winA = (TextView) findViewById(R.id.winPlayerA);
        TextView winB = (TextView) findViewById(R.id.winPlayerB);
        winA.setText("WIN");
        winB.setText("WIN");
        winA.setTextColor(Color.parseColor("#32CD32"));
        winB.setTextColor(Color.parseColor("#32CD32"));
        int scoreA = roll();
        int scoreB = roll();

        if(scoreA > scoreB){

            winA.setVisibility(View.VISIBLE);
            winB.setVisibility(View.INVISIBLE);
            placarA++;
            displayScore();
            diceNumber(scoreA, scoreB);

        }
        if(scoreA < scoreB){

            winB.setVisibility(View.VISIBLE);
            winA.setVisibility(View.INVISIBLE);
            placarB++;
            displayScore();
            diceNumber(scoreA, scoreB);
        }
        if(scoreA == scoreB){
            winA.setText("Empate");
            winB.setText("Empate");
            winA.setTextColor(Color.parseColor("#ec0e16"));
            winB.setTextColor(Color.parseColor("#ec0e16"));
            winA.setVisibility(View.VISIBLE);
            winB.setVisibility(View.VISIBLE);
            diceNumber(scoreA, scoreB);

        }
    }

    private int roll(){

        Random random = new Random();
        int ran = random.nextInt(7);
        while(ran == 0){
            ran = random.nextInt(7);
        }

        return ran;
    }

    private void displayScore(){

        TextView viewA = (TextView) findViewById(R.id.scoreCounterA);
        TextView viewB = (TextView) findViewById(R.id.scoreCounterB);

        viewA.setText(String.valueOf(placarA));
        viewB.setText(String.valueOf(placarB));
    }

    private void diceNumber(int diceA, int diceB){

        TextView viewA = (TextView) findViewById(R.id.score_A);
        TextView viewB = (TextView) findViewById(R.id.score_B);

        viewA.setText(String.valueOf(diceA));
        viewB.setText(String.valueOf(diceB));

    }

    public void resetScore(View view){

        TextView winA = (TextView) findViewById(R.id.winPlayerA);
        TextView winB = (TextView) findViewById(R.id.winPlayerB);
        winA.setVisibility(View.INVISIBLE);
        winB.setVisibility(View.INVISIBLE);

        placarA = 0;
        placarB = 0;

        TextView viewA = (TextView) findViewById(R.id.scoreCounterA);
        TextView viewB = (TextView) findViewById(R.id.scoreCounterB);

        viewA.setText(String.valueOf(placarA));
        viewB.setText(String.valueOf(placarB));

        TextView viewScoreA = (TextView) findViewById(R.id.score_A);
        TextView viewScoreB = (TextView) findViewById(R.id.score_B);

        viewScoreA.setText("0");
        viewScoreB.setText("0");
    }

}
