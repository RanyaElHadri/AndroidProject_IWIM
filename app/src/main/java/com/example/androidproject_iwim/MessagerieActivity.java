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

        mMessagerieActivity = (TextView) findViewById(R.id.text_messagerie);
        mEnvoyerUnMessage = (Button) findViewById(R.id.envoyer_un_message_button);
        mConsulterLesMessages = (Button) findViewById(R.id.consulter_les_messages_button);

        mEnvoyerUnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newMessageActivityIntent = new Intent(MessagerieActivity.this, NewMessageActivity.class);
                startActivity(newMessageActivityIntent);
            }
        });

        mConsulterLesMessages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listeMsgsActivityIntent = new Intent(MessagerieActivity.this, ListeMsgsActivity.class);
                startActivity(listeMsgsActivityIntent);
            }
        });

    }
}
