package com.example.androidproject_iwim;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<ViewHolder> {

    ListActivty listActivty;
    List<com.example.androidproject_iwim.Model> modelList;
    Context context;


    public CustomAdapter(ListActivty listActivty, List<com.example.androidproject_iwim.Model> modelList) {
        this.listActivty = listActivty;
        this.modelList = modelList;

    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.model_layout, viewGroup, false);


        //View itemView = LayoutInflater.from( viewG)

    ViewHolder viewHolder = new ViewHolder(itemView);

    viewHolder.setOnClickLinstener(new ViewHolder.ClickListener() {
        @Override
        public void onItemClick(View view, int position) {

            String nom = modelList.get(position).getNom();
            String email = modelList.get(position).getEmail();
            String matiere = modelList.get(position).getMatiere();
            String numTel = modelList.get(position).getNumtel();
            String nbreHeures = modelList.get(position).getNbreheur();
            Toast.makeText(listActivty,nom+"\n"+email+"\n"+matiere+"\n"+numTel+"\n"+nbreHeures,Toast.LENGTH_SHORT).show();





        }

        @Override
        public void OnItemLongClick(View view, final int position) {

            AlertDialog.Builder builder = new AlertDialog.Builder(listActivty);
            String[] options = {"Update", "Delete"} ;
            builder.setItems(options, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (which==0){
                        String id = modelList.get(position).getId();
                        String nom = modelList.get(position).getNom();
                        String email = modelList.get(position).getEmail();
                        String matiere = modelList.get(position).getMatiere();
                        String numTel = modelList.get(position).getNumtel();
                        String nbreHeures = modelList.get(position).getNbreheur();

                        Intent intent = new  Intent(listActivty,ajoutProf.class);
                        intent.putExtra("pit", id);
                        intent.putExtra("pnom",nom );
                        intent.putExtra("pemail", email);
                        intent.putExtra("pmatiere", matiere);
                        intent.putExtra("pnumTel", numTel);
                        intent.putExtra("pnbreHeures", nbreHeures);

                        listActivty.startActivity(intent);


                    }
                    if (which==1){
                        //delete is clicked
                        listActivty.deleteData(position);

                    }
                }
            }).create().show();


        }
    });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.mnom.setText(modelList.get(position).getNom());
        viewHolder.memail.setText(modelList.get(position).getEmail());
        viewHolder.mmatiere.setText(modelList.get(position).getMatiere());
        viewHolder.mnumtel.setText(modelList.get(position).getNumtel());
        viewHolder.mnbreheures.setText(modelList.get(position).getNbreheur());



    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }
}
