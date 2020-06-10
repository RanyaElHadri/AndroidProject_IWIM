package com.example.androidproject_iwim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ListActivty extends AppCompatActivity {

    List<com.example.androidproject_iwim.Model> modelList = new ArrayList<>();

    RecyclerView mRecyclerView;

    Button mAdd;

    RecyclerView.LayoutManager layoutManager;
    FirebaseFirestore db;

    CustomAdapter adapter;
    ProgressDialog pd;


    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        db = FirebaseFirestore.getInstance();

        mRecyclerView = findViewById(R.id.recycler_view);





        mAdd =findViewById(R.id.addBtn);

        mRecyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        pd = new ProgressDialog(this);


        showData();

        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListActivty.this,ajoutProf.class));
           finish();
            }
        });


    }

    private void showData() {
        pd.setTitle("Loading Data...");

        pd.show();


        db.collection("Professeur")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        pd.dismiss();

                        for (DocumentSnapshot doc : task.getResult()) {
                            com.example.androidproject_iwim.Model model = new com.example.androidproject_iwim.Model(doc.getString("id"),
                                    doc.getString("nom"),
                                    doc.getString("emai"),
                                    doc.getString("numte"),
                                    doc.getString("matier"),
                                    doc.getString("nbreheur")


                            );
                            modelList.add(model);
                        }
                        adapter = new CustomAdapter(ListActivty.this, modelList);
                        mRecyclerView.setAdapter(adapter);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        pd.dismiss();
                        Toast.makeText(ListActivty.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });


    }


}
