package com.example.douglas.dicegame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Random;

public class RandomDice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_dice);
        RadioButton viewRadio6 = (RadioButton) findViewById(R.id.check6);
        viewRadio6.setChecked(true);

    }

    public void rollDice(View view) {

        TextView viewDice = (TextView) findViewById(R.id.dice);


               viewDice.setText("" + roll(checkAll()));



    }


    private int roll(int face) {

        Random random = new Random();
        int ran = random.nextInt(face + 1);
        while (ran == 0) {
            ran = random.nextInt(face + 1);
        }

        return ran;
    }


    private int checkAll() {

        RadioButton viewRadio2 = (RadioButton) findViewById(R.id.check2);
        RadioButton viewRadio4 = (RadioButton) findViewById(R.id.check4);
        RadioButton viewRadio6 = (RadioButton) findViewById(R.id.check6);
        RadioButton viewRadio8 = (RadioButton) findViewById(R.id.check8);
        RadioButton viewRadio12 = (RadioButton) findViewById(R.id.check12);
        RadioButton viewRadio20 = (RadioButton) findViewById(R.id.check20);


        if (viewRadio2.isChecked()) {

            return 2;
        }
        if (viewRadio4.isChecked()) {

            return 4;
        }
        if (viewRadio6.isChecked()) {

            return 6;
        }
        if (viewRadio8.isChecked()) {

            return 8;
        }
        if (viewRadio12.isChecked()) {

            return 12;
        }
        if (viewRadio20.isChecked()) {

            return 20;
        }

        return 0;
    }



}

