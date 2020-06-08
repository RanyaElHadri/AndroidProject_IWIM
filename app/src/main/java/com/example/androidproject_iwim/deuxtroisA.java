package com.example.androidproject_iwim;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;



public class deuxtroisA extends AppCompatActivity {
Button deux;
Button trois;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deuxtroisempl);
        deux = findViewById(R.id.deux);
        trois =findViewById(R.id.trois);


        deux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), cheffilupl.class));
            }
        });

        trois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), cheffilupl.class));
            }
        });


    }
}

