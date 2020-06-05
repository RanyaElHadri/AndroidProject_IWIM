package com.example.androidproject_iwim;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MessagerieProfActivity extends AppCompatActivity {

    private TextView mMessagerieActivityProf;
    private Button mEnvoyerUnMessageProf;
    private Button mConsulterLesMessagesProf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messagerie_prof);

        mMessagerieActivityProf = (TextView) findViewById(R.id.text_messagerie_prof);
        mEnvoyerUnMessageProf = (Button) findViewById(R.id.envoyer_un_message_prof_button);
        mConsulterLesMessagesProf = (Button) findViewById(R.id.consulter_les_messages_prof_button);

        mEnvoyerUnMessageProf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newMessageActivityIntent = new Intent(MessagerieProfActivity.this, NewMsgProfActivity.class);
                startActivity(newMessageActivityIntent);
            }
        });

        mConsulterLesMessagesProf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listeMsgsActivityIntent = new Intent(MessagerieProfActivity.this, ListeMsgsActivity.class);
                startActivity(listeMsgsActivityIntent);
            }
        });
    }
}
