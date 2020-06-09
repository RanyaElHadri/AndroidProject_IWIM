package com.example.androidproject_iwim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProfActivity extends AppCompatActivity {

    private Button mMessagerie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prof);

        mMessagerie = (Button) findViewById(R.id.messagerie_button);

        mMessagerie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent messagerieActivityIntent = new Intent(ProfActivity.this, MessagerieProfActivity.class);
                startActivity(messagerieActivityIntent);
            }
        });
    }
}
