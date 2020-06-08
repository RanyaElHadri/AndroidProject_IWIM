package com.example.androidproject_iwim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidproject_iwim.models.Event;
import com.example.androidproject_iwim.models.matiere;
import com.firebase.ui.database.FirebaseRecyclerAdapter;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import io.paperdb.Paper;

public class listeMatieres extends AppCompatActivity {

    private RecyclerView mMatieresList;
    private TextView mMatiere;

    private DatabaseReference mDatabase;

    private Button mHome;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_matieres);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("matieres");

        mHome = (Button) findViewById(R.id.homeicon);
        mMatiere=findViewById(R.id.nom_matiere);

        mMatieresList = (RecyclerView) findViewById(R.id.matieres_list);
        mMatieresList.setHasFixedSize(true);
        mMatieresList.setLayoutManager(new LinearLayoutManager(this));

        mHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeActivityIntent = new Intent(listeMatieres.this, EspaceEtudiantActivity.class);
                startActivity(homeActivityIntent);
            }
        });
         /*mMatiere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeActivityIntent = new Intent(listeMatieres.this, DocMatiere.class);
                startActivity(homeActivityIntent);
            }
        });*/



    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<matiere, listeMatieres.EventViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<matiere, listeMatieres.EventViewHolder>(
                matiere.class,
                R.layout.matieres_item,
                listeMatieres.EventViewHolder.class,
                mDatabase
        ) {
            @Override
            protected void populateViewHolder(listeMatieres.EventViewHolder viewHolder, final matiere model, int position) {

                viewHolder.setTitle(model.getTitreMatiere());
                viewHolder.setProf(model.getProfMatiere());
                viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(listeMatieres.this, veiw_pdf_files.class);
                        intent.putExtra("pid", model.getPid());
                        intent.putExtra("name", model.getTitreMatiere());
                        //intent.putExtra("pid", Key);
                       // intent.putExtra("cat", catcat);

                        startActivity(intent);
                    }
                });


            }
        };

        mMatieresList.setAdapter(firebaseRecyclerAdapter);


    }

    public static class EventViewHolder extends RecyclerView.ViewHolder {

        View mView;

        public EventViewHolder(@NonNull View itemView) {
            super(itemView);

            mView = itemView;
        }

        public void setTitle(String title){

            TextView titre_matiere = (TextView) mView.findViewById(R.id.nom_matiere);
            titre_matiere.setText(title);

        }

        public void setProf(String desc){

            TextView prof_matiere = (TextView) mView.findViewById(R.id.prof_matiere);
            prof_matiere.setText(desc);

        }


    }



}
