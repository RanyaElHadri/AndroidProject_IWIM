package com.example.androidproject_iwim;

import android.annotation.SuppressLint;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.annotation.NonNull;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBar.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity.*;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ajoutEtud extends AppCompatActivity {
    //views
    EditText mnom, memail, mmatiere, mnumtel,mnbreheures;
    Button mSavebut,mListeBtn;
    ProgressDialog pd;
    FirebaseFirestore db;
    String pit, pemail, pnom, pnumtel,pnbreheures,pmatiere;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_etud);

   /*     ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Add Data");*/

        mnom= findViewById(R.id.nomt);
        memail = findViewById(R.id.email);
        mmatiere = findViewById(R.id.matiere);
        mnumtel= findViewById(R.id.numtel);
        mnbreheures= findViewById(R.id.nbreheures);
        mSavebut =findViewById(R.id.saveBtn);
        mListeBtn = findViewById(R.id.listBtn);





        pd=  new ProgressDialog(this);
        db = FirebaseFirestore.getInstance();

        final Bundle bundle = getIntent().getExtras();

        if (bundle!= null) {
            //update data
            //  actionBar.setTitle("Update Data");
//update data
            mSavebut.setText("Update");

            //get data
            pit = bundle.getString("pit");
            pnom = bundle.getString("pnom");
            pemail = bundle.getString("pemail");
            pmatiere = bundle.getString("pmatiere");
            pnumtel = bundle.getString("pnumTel");
            pnbreheures = bundle.getString("pnbreHeures");
//set data
            mnom.setText(pnom);
            memail.setText(pemail);
            mmatiere.setText(pmatiere);
            mnumtel.setText(pnumtel);
            mnbreheures.setText(pnbreheures);



        } else {
            // new data

            mSavebut.setText("Save");
        }


        //  getSupportActionBar().setTitle("");

        mSavebut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle1 = getIntent().getExtras();
                if(bundle!=null){
                    //updating
                    //input data
                    String id = pit;
                    String no = mnom.getText().toString().trim();
                    String emai = memail.getText().toString().trim();
                    String matier = mmatiere.getText().toString().trim();
                    String numte = mnumtel.getText().toString().trim();
                    String nbreheur = mnbreheures.getText().toString().trim();
                    //fonction call to upload cata
                    uploadData(id,no, emai, matier, numte, nbreheur);

                }
                else {
                    // adding new
                    //input data
                    String no = mnom.getText().toString().trim();
                    String emai = memail.getText().toString().trim();
                    String matier = mmatiere.getText().toString().trim();
                    String numte = mnumtel.getText().toString().trim();
                    String nbreheur = mnbreheures.getText().toString().trim();
                    //fonction call to upload cata
                    uploadData(no, emai, matier, numte, nbreheur);
                }
            }
        });


        mListeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ajoutEtud.this, ListActivtyet.class);
                startActivity(intent);
            }
        });





    }

    private void uploadData(String id, String no, String emai, String matier, String numte, String nbreheur) {

        pd.setTitle("Updating Data...");
        pd.show();

        db.collection("Etudiants").document(id)
                .update("no",no,"search",no.toLowerCase(),"emai",emai,"matier",matier,"numte",numte,"nbreheur",nbreheur)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        pd.dismiss();
                        Toast.makeText(ajoutEtud.this, "Updated...", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        pd.dismiss();
                        Toast.makeText(ajoutEtud.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });


    }

    private void uploadData(String no, String emai, String matier, String numte, String nbreheur) {
        //set title of progressbar
        pd.setTitle("Adding Data to Firestore");
        //show progress bar when user click save button
        pd.show();
        //random id for each data to be stored
        String id = UUID.randomUUID().toString();

        Map<String, Object> doc = new HashMap<>();
        doc.put("id", id); //id of data
        doc.put("no", no);
        doc.put("search", no.toLowerCase());
        doc.put("emai", emai);
        doc.put("matier", matier);
        doc.put("numte", numte);

        doc.put("nbreheur", nbreheur);
        db.collection("Etudiants").document(id).set(doc)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        //this will be called when data is added successfully
                        pd.dismiss();
                        Toast.makeText(ajoutEtud.this, "Uploaded...", Toast.LENGTH_SHORT).show();
                    }


                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //this will be called if there is any error while uploading
                        pd.dismiss();
                        //get and show error message
                        Toast.makeText(ajoutEtud.this,e.getMessage(),Toast.LENGTH_SHORT).show();

                    }
                });

    }



    //menu


}

