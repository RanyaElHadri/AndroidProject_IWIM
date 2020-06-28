package com.example.androidproject_iwim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EspaceProfesseurActivity extends AppCompatActivity {


    Button prof, chef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espace_professeur);
        prof =findViewById(R.id.professeur_button);
        chef =findViewById(R.id.chef_de_filiere_button);
        prof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(EspaceProfesseurActivity.this, SingInProf.class);
                startActivity(intent);
            }
        });
        chef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(EspaceProfesseurActivity.this, SingInProf.class);
                startActivity(intent);

            }
        });
    }
}
