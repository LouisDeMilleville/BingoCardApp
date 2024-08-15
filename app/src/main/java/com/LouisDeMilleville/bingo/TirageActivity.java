package com.LouisDeMilleville.bingo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class TirageActivity extends AppCompatActivity {

    //Creating variables for each element of the interface
    private TextView mNumberDisplay;
    private EditText mSaisieVerif;
    private Button mBoutonVerif;
    private TextView mVerifDisplay;
    private Button mBoutonGen;

    public int[] nbAEx = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,};
    public int i, nbExclus = 0;

    //Function to generate numbers excluding those generated previously
    public int genNumWithEx (int min, int max, int[] aEx, int nbAEx)
    {
        int nbRandom = 0, i;
        int estPareil;
        Random rnd = new Random();
        do {
            nbRandom = rnd.nextInt(max - min + 1) + min;
            estPareil = 1;
            for (i = 0; i<nbAEx ; i++)
            {
                if (nbRandom == aEx[i])
                {
                    estPareil = 0;
                }
            }
        }while (estPareil == 0);

        return nbRandom;
    }

    //Function to check if a number has already been chosen or no
    public int checkNum (int[] tabNums, int nbNum, int numACheck)
    {
        int etatNb = 1, i;
        for (i=0;i<nbNum;i++)
        {
            if (tabNums[i] == numACheck)
            {
                etatNb = 0;
            }
        }
        return etatNb;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tirage);

        //Associating variables with their corresponding elements of the interface
        mNumberDisplay = findViewById(R.id.tirage_activity_number_display);
        mSaisieVerif = findViewById(R.id.tirage_activity_saisie_verif);
        mBoutonVerif = findViewById(R.id.tirage_activity_bouton_verif);
        mVerifDisplay = findViewById(R.id.tirage_activity_display_verif);
        mBoutonGen = findViewById(R.id.tirage_activity_bouton_gen);


        mBoutonVerif.setEnabled(false);

        //TextWatcher to enable/disable a button depending on the lenght of the input
        mSaisieVerif.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mBoutonVerif.setEnabled(!s.toString().isEmpty());
            }
        });

        //Onclick listeners for the different buttons of the interface
        mBoutonVerif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numAVerif = Integer.parseInt(mSaisieVerif.getText().toString());
                mSaisieVerif.getText().clear();
                int validNum = checkNum(nbAEx, nbExclus, numAVerif);
                if (validNum == 0)
                {
                    mVerifDisplay.setBackgroundColor(Color.parseColor("#34EB4F"));
                    mVerifDisplay.setText(numAVerif + " a été tiré !");
                }
                if (validNum == 1)
                {
                    mVerifDisplay.setBackgroundColor(Color.parseColor("#ff0000"));
                    mVerifDisplay.setText(numAVerif + " n'a pas été tiré !");
                }

            }
        });

        mBoutonGen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nbGen = genNumWithEx(1, 90, nbAEx, nbExclus);
                nbAEx[nbExclus] = nbGen;
                nbExclus++;
                mNumberDisplay.setText(nbGen + "");
                mVerifDisplay.setBackgroundColor(Color.parseColor("#1B659E"));
                mVerifDisplay.setText("Saisissez un nombre pour le vérifier");
            }
        });
    }

    //Override on back button to prevent unwanted app quitting
    private long pressedTime;
    @Override
    public void onBackPressed() {

        if (pressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            finish();
        } else {
            Toast.makeText(getBaseContext(), "Appuyez encore pour quitter", Toast.LENGTH_SHORT).show();
        }
        pressedTime = System.currentTimeMillis();
    }
}