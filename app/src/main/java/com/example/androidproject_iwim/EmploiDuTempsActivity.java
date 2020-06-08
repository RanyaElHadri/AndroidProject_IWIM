package com.example.androidproject_iwim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EmploiDuTempsActivity extends AppCompatActivity {
    Button a2_button,a3_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emploi_du_temps);
        a2_button=findViewById(R.id.a2_button);
        a3_button=findViewById(R.id.a3_button);
        a2_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(EmploiDuTempsActivity.this, Emploi2a.class);
                startActivity(intent);
            }
        });
        a3_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(EmploiDuTempsActivity.this, Emploi3a.class);
                startActivity(intent);

            }
        });
    }
}
