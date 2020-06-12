package com.example.androidproject_iwim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ListActivtyet extends AppCompatActivity {

    List<com.example.androidproject_iwim.Modelet> modelList = new ArrayList<>();

    RecyclerView mRecyclerView;

    Button mAdd;

    RecyclerView.LayoutManager layoutManager;
    FirebaseFirestore db;

    CustomAdapteret adapter;
    ProgressDialog pd;


    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listet);
//       setHasOptionsMenu(true);


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
                startActivity(new Intent(ListActivtyet.this,ajoutEtud.class));
                finish();
            }
        });


    }

    private void showData() {
        pd.setTitle("Loading Data...");

        pd.show();


        db.collection("Etudiants")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        modelList.clear();
                        pd.dismiss();

                        for (DocumentSnapshot doc : task.getResult()) {
                            com.example.androidproject_iwim.Modelet model = new com.example.androidproject_iwim.Modelet(doc.getString("id"),
                                    doc.getString("no"),
                                    doc.getString("emai"),
                                    doc.getString("numte"),
                                    doc.getString("matier"),
                                    doc.getString("nbreheur")    );



                            modelList.add(model);
                        }
                        adapter = new CustomAdapteret(ListActivtyet.this, modelList);
                        mRecyclerView.setAdapter(adapter);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        pd.dismiss();
                        Toast.makeText(ListActivtyet.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });


    }

    public void deleteData(int index){

        pd.setTitle("Deleting Data...");

        pd.show();

        db.collection("Etudiants").document(modelList.get(index).getId())
                .delete()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(ListActivtyet.this,"Deleted...", Toast.LENGTH_SHORT).show();
                        showData();

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        pd.dismiss();
                        Toast.makeText(ListActivtyet.this,e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

    }
    private void searchData(String query) {

//set title of progressbar
        pd.setTitle("Searching...");
        //show progress bar when user click save button
        pd.show();
        db.collection("Etudiants").whereEqualTo("search",query.toLowerCase())
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        modelList.clear();
                        pd.dismiss();
                        for (DocumentSnapshot doc : task.getResult()) {
                            com.example.androidproject_iwim.Modelet model = new com.example.androidproject_iwim.Modelet(doc.getString("id"),
                                    doc.getString("nom"),
                                    doc.getString("emai"),
                                    doc.getString("numte"),
                                    doc.getString("matier"),
                                    doc.getString("nbreheur")


                            );
                            modelList.add(model);
                        }
                        adapter = new CustomAdapteret(ListActivtyet.this, modelList);
                        mRecyclerView.setAdapter(adapter);




                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        pd.dismiss();
                        Toast.makeText(ListActivtyet.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });
    }

    //menu


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflating menu_main.xml
/* MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.menu_main, menu);
    return true; */

        getMenuInflater().inflate(R.menu.menu_et,menu);
        MenuItem item = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener()

                                          {


                                              @Override
                                              public boolean onQueryTextSubmit(String query) {
                                                  //called when we press search button entered in searchview as paramater


                                                  searchData(query); //function call with string

                                                  return false;
                                              }

                                              @Override
                                              public boolean onQueryTextChange(String newText) {
                                                  //called as when we type even a signle letter
                                                  return false;
                                              }
                                          }

        );


        return super.onCreateOptionsMenu(menu);
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//handle other menu item clicks here

        if(item.getItemId()== R.id.action_setting)
        {
            Toast.makeText(this,"Setting", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);

    }
}


