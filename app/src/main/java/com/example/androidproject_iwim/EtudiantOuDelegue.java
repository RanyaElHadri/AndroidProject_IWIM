package com.example.androidproject_iwim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EtudiantOuDelegue extends AppCompatActivity {

    Button student, delegue, prof;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etudiant_ou_delegue);
        student =findViewById(R.id.a2_button);
        delegue =findViewById(R.id.a3_button);



        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(EtudiantOuDelegue.this, SignInActivity.class);
                startActivity(intent);
            }
        });
        delegue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(EtudiantOuDelegue.this, SignInDelegue.class);
                startActivity(intent);

            }
        });

    }
}
