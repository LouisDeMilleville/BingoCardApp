package com.LouisDeMilleville.bingo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class GrilleActivity extends AppCompatActivity {

    //Variables for each element on the interface
    private Button mButtonC1L1;
    private Button mButtonC1L2;
    private Button mButtonC1L3;
    private Button mButtonC1L4;
    private Button mButtonC1L5;

    private Button mButtonC2L1;
    private Button mButtonC2L2;
    private Button mButtonC2L3;
    private Button mButtonC2L4;
    private Button mButtonC2L5;

    private Button mButtonC3L1;
    private Button mButtonC3L2;
    private Button mButtonC3L3;
    private Button mButtonC3L4;
    private Button mButtonC3L5;

    private long pressedTime;

    //State variables for each element of the grid
    private int state_c1_l1 = 0;
    private int state_c1_l2 = 0;
    private int state_c1_l3 = 0;
    private int state_c1_l4 = 0;
    private int state_c1_l5 = 0;

    private int state_c2_l1 = 0;
    private int state_c2_l2 = 0;
    private int state_c2_l3 = 0;
    private int state_c2_l4 = 0;
    private int state_c2_l5 = 0;

    private int state_c3_l1 = 0;
    private int state_c3_l2 = 0;
    private int state_c3_l3 = 0;
    private int state_c3_l4 = 0;
    private int state_c3_l5 = 0;

    private int nbEx = 0;

    int[] exclude = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};


    //Function to generate a number excluding the one chosed previously
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grille);

        //Binding each variable to the corresponding element of the interface
        mButtonC1L1 = findViewById(R.id.grille_activity_button_c1_l1);
        mButtonC1L2 = findViewById(R.id.grille_activity_button_c1_l2);
        mButtonC1L3 = findViewById(R.id.grille_activity_button_c1_l3);
        mButtonC1L4 = findViewById(R.id.grille_activity_button_c1_l4);
        mButtonC1L5 = findViewById(R.id.grille_activity_button_c1_l5);

        mButtonC2L1 = findViewById(R.id.grille_activity_button_c2_l1);
        mButtonC2L2 = findViewById(R.id.grille_activity_button_c2_l2);
        mButtonC2L3 = findViewById(R.id.grille_activity_button_c2_l3);
        mButtonC2L4 = findViewById(R.id.grille_activity_button_c2_l4);
        mButtonC2L5 = findViewById(R.id.grille_activity_button_c2_l5);

        mButtonC3L1 = findViewById(R.id.grille_activity_button_c3_l1);
        mButtonC3L2 = findViewById(R.id.grille_activity_button_c3_l2);
        mButtonC3L3 = findViewById(R.id.grille_activity_button_c3_l3);
        mButtonC3L4 = findViewById(R.id.grille_activity_button_c3_l4);
        mButtonC3L5 = findViewById(R.id.grille_activity_button_c3_l5);

        Random rnd = new Random();
        String txt;

        //Initialzing the numbers of the grid
        int val = genNumWithEx(1, 90, exclude, nbEx);
        exclude[nbEx] = val;
        nbEx++;
        mButtonC1L1.setText(val + "");

        val = genNumWithEx(1, 90, exclude, nbEx);
        exclude[nbEx] = val;
        nbEx++;
        mButtonC1L2.setText(val + "");

        val = genNumWithEx(1, 90, exclude, nbEx);
        exclude[nbEx] = val;
        nbEx++;
        mButtonC1L3.setText(val + "");

        val = genNumWithEx(1, 90, exclude, nbEx);
        exclude[nbEx] = val;
        nbEx++;
        mButtonC1L4.setText(val + "");

        val = genNumWithEx(1, 90, exclude, nbEx);
        exclude[nbEx] = val;
        nbEx++;
        mButtonC1L5.setText(val + "");

        val = genNumWithEx(1, 90, exclude, nbEx);
        exclude[nbEx] = val;
        nbEx++;
        mButtonC2L1.setText(val + "");

        val = genNumWithEx(1, 90, exclude, nbEx);
        exclude[nbEx] = val;
        nbEx++;
        mButtonC2L2.setText(val + "");

        val = genNumWithEx(1, 90, exclude, nbEx);
        exclude[nbEx] = val;
        nbEx++;
        mButtonC2L3.setText(val + "");

        val = genNumWithEx(1, 90, exclude, nbEx);
        exclude[nbEx] = val;
        nbEx++;
        mButtonC2L4.setText(val + "");

        val = genNumWithEx(1, 90, exclude, nbEx);
        exclude[nbEx] = val;
        nbEx++;
        mButtonC2L5.setText(val + "");

        val = genNumWithEx(1, 90, exclude, nbEx);
        exclude[nbEx] = val;
        nbEx++;
        mButtonC3L1.setText(val + "");

        val = genNumWithEx(1, 90, exclude, nbEx);
        exclude[nbEx] = val;
        nbEx++;
        mButtonC3L2.setText(val + "");

        val = genNumWithEx(1, 90, exclude, nbEx);
        exclude[nbEx] = val;
        nbEx++;
        mButtonC3L3.setText(val + "");

        val = genNumWithEx(1, 90, exclude, nbEx);
        exclude[nbEx] = val;
        nbEx++;
        mButtonC3L4.setText(val + "");

        val = genNumWithEx(1, 90, exclude, nbEx);
        exclude[nbEx] = val;
        nbEx++;
        mButtonC3L5.setText(val + "");


        //Setting up on click listener for each element of the grid so the user can select / unselect each of them independantly

        mButtonC1L1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (state_c1_l1 == 0)
                {
                    mButtonC1L1.setBackgroundColor(Color.parseColor("#0d912a"));
                    state_c1_l1 = 1;
                }
                else
                {
                    mButtonC1L1.setBackgroundColor(Color.parseColor("#1B659E"));
                    state_c1_l1 = 0;
                }
            }
        });

        mButtonC1L2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (state_c1_l2 == 0)
                {
                    mButtonC1L2.setBackgroundColor(Color.parseColor("#0d912a"));
                    state_c1_l2 = 1;
                }
                else
                {
                    mButtonC1L2.setBackgroundColor(Color.parseColor("#1B659E"));
                    state_c1_l2 = 0;
                }
            }
        });

        mButtonC1L3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (state_c1_l3 == 0)
                {
                    mButtonC1L3.setBackgroundColor(Color.parseColor("#0d912a"));
                    state_c1_l3 = 1;
                }
                else
                {
                    mButtonC1L3.setBackgroundColor(Color.parseColor("#1B659E"));
                    state_c1_l3 = 0;
                }
            }
        });

        mButtonC1L4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (state_c1_l4 == 0)
                {
                    mButtonC1L4.setBackgroundColor(Color.parseColor("#0d912a"));
                    state_c1_l4 = 1;
                }
                else
                {
                    mButtonC1L4.setBackgroundColor(Color.parseColor("#1B659E"));
                    state_c1_l4 = 0;
                }
            }
        });

        mButtonC1L5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (state_c1_l5 == 0)
                {
                    mButtonC1L5.setBackgroundColor(Color.parseColor("#0d912a"));
                    state_c1_l5 = 1;
                }
                else
                {
                    mButtonC1L5.setBackgroundColor(Color.parseColor("#1B659E"));
                    state_c1_l5 = 0;
                }

            }
        });

        mButtonC2L1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (state_c2_l1 == 0)
                {
                    mButtonC2L1.setBackgroundColor(Color.parseColor("#0d912a"));
                    state_c2_l1 = 1;
                }
                else
                {
                    mButtonC2L1.setBackgroundColor(Color.parseColor("#630E26"));
                    state_c2_l1 = 0;
                }
            }
        });

        mButtonC2L2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (state_c2_l2 == 0)
                {
                    mButtonC2L2.setBackgroundColor(Color.parseColor("#0d912a"));
                    state_c2_l2 = 1;
                }
                else
                {
                    mButtonC2L2.setBackgroundColor(Color.parseColor("#630E26"));
                    state_c2_l2 = 0;
                }

            }
        });

        mButtonC2L3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (state_c2_l3 == 0)
                {
                    mButtonC2L3.setBackgroundColor(Color.parseColor("#0d912a"));
                    state_c2_l3 = 1;
                }
                else
                {
                    mButtonC2L3.setBackgroundColor(Color.parseColor("#630E26"));
                    state_c2_l3 = 0;
                }

            }
        });

        mButtonC2L4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (state_c2_l4 == 0)
                {
                    mButtonC2L4.setBackgroundColor(Color.parseColor("#0d912a"));
                    state_c2_l4 = 1;
                }
                else
                {
                    mButtonC2L4.setBackgroundColor(Color.parseColor("#630E26"));
                    state_c2_l4 = 0;
                }

            }
        });

        mButtonC2L5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (state_c2_l5 == 0)
                {
                    mButtonC2L5.setBackgroundColor(Color.parseColor("#0d912a"));
                    state_c2_l5 = 1;
                }
                else
                {
                    mButtonC2L5.setBackgroundColor(Color.parseColor("#630E26"));
                    state_c2_l5 = 0;
                }

            }
        });

        mButtonC3L1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (state_c3_l1 == 0)
                {
                    mButtonC3L1.setBackgroundColor(Color.parseColor("#0d912a"));
                    state_c3_l1 = 1;
                }
                else
                {
                    mButtonC3L1.setBackgroundColor(Color.parseColor("#1B659E"));
                    state_c3_l1 = 0;
                }

            }
        });

        mButtonC3L2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (state_c3_l2 == 0)
                {
                    mButtonC3L2.setBackgroundColor(Color.parseColor("#0d912a"));
                    state_c3_l2 = 1;
                }
                else
                {
                    mButtonC3L2.setBackgroundColor(Color.parseColor("#1B659E"));
                    state_c3_l2 = 0;
                }

            }
        });

        mButtonC3L3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (state_c3_l3 == 0)
                {
                    mButtonC3L3.setBackgroundColor(Color.parseColor("#0d912a"));
                    state_c3_l3 = 1;
                }
                else
                {
                    mButtonC3L3.setBackgroundColor(Color.parseColor("#1B659E"));
                    state_c3_l3 = 0;
                }

            }
        });

        mButtonC3L4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (state_c3_l4 == 0)
                {
                    mButtonC3L4.setBackgroundColor(Color.parseColor("#0d912a"));
                    state_c3_l4 = 1;
                }
                else
                {
                    mButtonC3L4.setBackgroundColor(Color.parseColor("#1B659E"));
                    state_c3_l4 = 0;
                }

            }
        });

        mButtonC3L5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (state_c3_l5 == 0)
                {
                    mButtonC3L5.setBackgroundColor(Color.parseColor("#0d912a"));
                    state_c3_l5 = 1;
                }
                else
                {
                    mButtonC3L5.setBackgroundColor(Color.parseColor("#1B659E"));
                    state_c3_l5 = 0;
                }

            }
        });
    }

    //Override on the back button to prevent unwanted app quitting
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