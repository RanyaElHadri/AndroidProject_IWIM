package com.example.androidproject_iwim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Emploi3a extends AppCompatActivity {
    TextView date,desc;
    ImageView calender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emploi3a);

        date=findViewById(R.id.date);
        desc=findViewById(R.id.desc);
        calender=findViewById(R.id.img);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(Emploi3a.this, PdfEmploi3a.class);
                intent.putExtra("pid", "3a");

                startActivity(intent);
            }
        });
        calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Emploi3a.this, PdfEmploi3a.class);
                intent.putExtra("pid", "3a");
                startActivity(intent);

            }
        });
        desc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Emploi3a.this, PdfEmploi3a.class);
                intent.putExtra("pid", "3a");
                startActivity(intent);
            }
        });
    }
}
