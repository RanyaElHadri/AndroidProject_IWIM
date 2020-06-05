package com.example.androidproject_iwim;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidproject_iwim.models.Message;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ListeMsgsActivity extends AppCompatActivity {

    private RecyclerView mMsgList;

    private DatabaseReference mDatabase;

    private Button mHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_msgs);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Message");

        mHome = (Button) findViewById(R.id.homeicon);

        mMsgList = (RecyclerView) findViewById(R.id.msg_list);
        mMsgList.setHasFixedSize(true);
        mMsgList.setLayoutManager(new LinearLayoutManager(this));

        mHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeActivityIntent = new Intent(ListeMsgsActivity.this, EspaceEtudiantActivity.class);
                startActivity(homeActivityIntent);
            }
        });
    }

    protected void onStart(){

        super.onStart();

        FirebaseRecyclerAdapter<Message,MsgViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Message,MsgViewHolder>(
                Message.class,
                R.layout.activity_message_item,
                MsgViewHolder.class,
                mDatabase
        ) {
            @Override
            protected void populateViewHolder(MsgViewHolder viewHolder, Message model, int position) {

                viewHolder.setText(model.getTextMsg());
                viewHolder.setDate(model.getDateMsg());
            }
        };

        mMsgList.setAdapter(firebaseRecyclerAdapter);

    }

    public static class MsgViewHolder extends RecyclerView.ViewHolder{

        View mView;

        public MsgViewHolder(@Nullable View itemView){
            super(itemView);

            mView = itemView;
        }

        public void setDate(long a){

            TextView msg_date = (TextView) mView.findViewById(R.id.msg_date);
            msg_date.setText(DateFormat.format("dd-MM-yyyy (HH:mm:ss)", a));

        }

        public void setText(String b){

            TextView msg_texte = (TextView) mView.findViewById(R.id.message_texte);
            msg_texte.setText(b);

        }

    }

}
