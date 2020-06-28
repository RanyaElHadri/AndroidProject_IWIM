package com.example.androidproject_iwim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class studentOrProf extends AppCompatActivity {

    Button student, prof;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_or_prof);
        student =findViewById(R.id.a2_button);
        prof =findViewById(R.id.a3_button);
        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(studentOrProf.this, EtudiantOuDelegue.class);
                startActivity(intent);
            }
        });
        prof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(studentOrProf.this, EspaceProfesseurActivity.class);
                startActivity(intent);

            }
        });
    }
}
