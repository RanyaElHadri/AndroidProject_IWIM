package com.example.androidproject_iwim;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidproject_iwim.models.Event;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class ListeEventsActivity extends AppCompatActivity {

    private RecyclerView mEventList;

    private DatabaseReference mDatabase;

    private Button mHome;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_events);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Event");

        mHome = (Button) findViewById(R.id.homeicon);

        mEventList = (RecyclerView) findViewById(R.id.event_list);
        mEventList.setHasFixedSize(true);
        mEventList.setLayoutManager(new LinearLayoutManager(this));

        mHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeActivityIntent = new Intent(ListeEventsActivity.this, EspaceEtudiantActivity.class);
                startActivity(homeActivityIntent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Event,EventViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Event, EventViewHolder>(
                Event.class,
                R.layout.activity_event_item,
                EventViewHolder.class,
                mDatabase
        ) {
            @Override
            protected void populateViewHolder(EventViewHolder viewHolder, Event model, int position) {

                viewHolder.setTitle(model.getTitleEvent());
                viewHolder.setDesc(model.getDescEvent());
                viewHolder.setImage(getApplicationContext(),model.getImageEvent());
            }
        };

        mEventList.setAdapter(firebaseRecyclerAdapter);

    }

    public static class EventViewHolder extends RecyclerView.ViewHolder {

        View mView;

        public EventViewHolder(@NonNull View itemView) {
            super(itemView);

            mView = itemView;
        }

        public void setTitle(String title){

            TextView event_title = (TextView) mView.findViewById(R.id.event_title);
            event_title.setText(title);

        }

        public void setDesc(String desc){

            TextView event_desc = (TextView) mView.findViewById(R.id.event_text);
            event_desc.setText(desc);

        }

        public void setImage(Context ctx , String image){
            ImageView event_image = (ImageView) mView.findViewById(R.id.EventImage);
            Picasso.with(ctx).load(image).into(event_image);
            //Picasso.with(ctx).setLoggingEnabled(true);

            //Glide.with(ctx).load(image).into(event_image);
        }

    }
}
