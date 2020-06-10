package com.example.androidproject_iwim;

import android.content.Context;
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
        public void OnItemLongClick(View view, int position) {

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
