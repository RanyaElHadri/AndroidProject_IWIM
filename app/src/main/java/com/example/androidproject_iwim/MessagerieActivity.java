package com.example.androidproject_iwim;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MessagerieActivity extends AppCompatActivity {

    private TextView mMessagerieActivity;
    private Button mEnvoyerUnMessage;
    private Button mConsulterLesMessages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messagerie);

        mMessagerieActivity = (TextView) findViewById(R.id.text_messagerie_prof);
        mEnvoyerUnMessage = (Button) findViewById(R.id.envoyer_un_message_prof_button);
        mConsulterLesMessages = (Button) findViewById(R.id.consulter_les_messages_prof_button);

        mEnvoyerUnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newMessageProfActivityIntent = new Intent(MessagerieActivity.this, NewMessageActivity.class);
                startActivity(newMessageProfActivityIntent);
            }
        });

        mConsulterLesMessages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listeMsgsProfActivityIntent = new Intent(MessagerieActivity.this, ListeMsgsActivity.class);
                startActivity(listeMsgsProfActivityIntent);
            }
        });

    }
}
