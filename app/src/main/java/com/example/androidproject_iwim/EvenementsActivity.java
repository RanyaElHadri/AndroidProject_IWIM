package com.example.androidproject_iwim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EvenementsActivity extends AppCompatActivity {

    private TextView mEvenemetsActivity;
    private Button mAfficherEvenements;
    private Button mCreerEvenemet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evenements);

        mEvenemetsActivity = (TextView) findViewById(R.id.text_evenements);
        mAfficherEvenements = (Button) findViewById(R.id.afficher_evenements_button);
        mCreerEvenemet = (Button) findViewById(R.id.creer_un_evenement_button);

        mCreerEvenemet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent neweventActivityIntent = new Intent(EvenementsActivity.this, NewEventActivity.class);
                startActivity(neweventActivityIntent);
            }
        });

        mAfficherEvenements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listeevenetsActivityIntent = new Intent(EvenementsActivity.this, ListeEventsActivity.class);
                startActivity(listeevenetsActivityIntent);
            }
        });

    }
}
