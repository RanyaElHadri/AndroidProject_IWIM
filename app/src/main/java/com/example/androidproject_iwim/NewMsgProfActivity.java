package com.example.androidproject_iwim;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class NewMsgProfActivity extends AppCompatActivity {

    private EditText mMsgText;
    private Button mPosterBtn;

    private ProgressDialog mProgress;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_msg_prof);

        mMsgText = (EditText) findViewById(R.id.msg_space);
        mPosterBtn = (Button) findViewById(R.id.poster);

        mProgress = new ProgressDialog(this);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Message");

        mPosterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPosting();
            }
        });
    }

    private void startPosting(){

        mProgress.setMessage("Création du message en cours ...");

        final String text_val = mMsgText.getText().toString().trim();
        final long date_val = new Date().getTime();
        if (!TextUtils.isEmpty(text_val)){

            mProgress.show();

            DatabaseReference newMsg = mDatabase.push();

            newMsg.child("textMsg").setValue(text_val);
            newMsg.child("dateMsg").setValue(date_val);

            mProgress.dismiss();

            startActivity(new Intent(NewMsgProfActivity.this,ListesMsgsProfMsgsActivity.class));

        }

    }

}