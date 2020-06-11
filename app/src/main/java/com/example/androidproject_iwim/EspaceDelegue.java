package com.example.androidproject_iwim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EspaceDelegue extends AppCompatActivity {

    private TextView mEspaceEtudiant;
    private Button mMessagerie;
    private Button mEvenemets;
    private Button mScolarite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espace_delegue);

        mEspaceEtudiant = (TextView) findViewById(R.id.text_espace_etudiant);
        mMessagerie = (Button) findViewById(R.id.messagerie_button);
        mEvenemets = (Button) findViewById(R.id.evenements_button);
        mScolarite = (Button) findViewById(R.id.scolarite_button);

        mMessagerie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent messagerieActivityIntent = new Intent(EspaceDelegue.this, MessagerieDActivity.class);
                startActivity(messagerieActivityIntent);
            }
        });

        mEvenemets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent evenementsActivityIntent = new Intent(EspaceDelegue.this, EvenementsDActivity.class);
                startActivity(evenementsActivityIntent);
            }
        });

        mScolarite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scolariteActivityIntent = new Intent(EspaceDelegue.this, ScolariteActivity.class);
                startActivity(scolariteActivityIntent);
            }
        });

    }
}
