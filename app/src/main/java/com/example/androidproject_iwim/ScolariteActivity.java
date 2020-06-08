package com.example.androidproject_iwim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ScolariteActivity extends AppCompatActivity {
    public Button consulter_matieres,consulter_emploie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scolarite);
        consulter_matieres= findViewById(R.id.consulter_les_matieres_button);
        consulter_emploie=findViewById(R.id.afficher_lemploi_button);


        consulter_emploie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScolariteActivity.this, EmploiDuTempsActivity.class);
                startActivity(intent);
            }
        });

        consulter_matieres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScolariteActivity.this, listeMatieres.class);
                startActivity(intent);
            }
        });
    }


}
