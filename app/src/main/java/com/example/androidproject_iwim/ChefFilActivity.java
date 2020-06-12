package com.example.androidproject_iwim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChefFilActivity extends AppCompatActivity {

    Button Ajempl;
    Button gestPro;
    Button gestetud;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_fil);
        Ajempl = findViewById(R.id.deux);
        gestPro = findViewById(R.id.gerer_profs_chef_fil_button);
        gestetud = findViewById(R.id.trois);


        Ajempl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), deuxtroisA.class));
            }
        });
        gestPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ListActivty.class));
            }
        });
        gestetud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ListActivtyet.class));
            }
        });

    }
}
