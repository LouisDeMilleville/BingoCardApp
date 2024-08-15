package com.LouisDeMilleville.bingo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Variables for the different elements of the interface
    private Button mButtonGrille;
    private Button mButtonTirage;

    private long pressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Binding the variables to the corresponding element in the layout
        mButtonGrille = findViewById(R.id.main_activity_button_grille);
        mButtonTirage = findViewById(R.id.main_activity_button_tirage);

        //Setting up on click listeners on the different buttons to execute code when the user clicks on it
        mButtonGrille.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent grilleActivityIntent = new Intent(MainActivity.this, GrilleActivity.class);
                startActivity(grilleActivityIntent);
            }
        });

        mButtonTirage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tirageActivityIntent = new Intent(MainActivity.this, TirageActivity.class);
                startActivity(tirageActivityIntent);
            }
        });

    }

    //Override on the back button to make sure the app doesn't close if the user press it by accident
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